package net.northking.cloudplatform.service.impl;

import com.alibaba.fastjson.JSONObject;
import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.constants.ErrorConstants;
import net.northking.cloudplatform.dao.base.BaseServiceImpl;
import net.northking.cloudplatform.dao.testexecute.*;
import net.northking.cloudplatform.domain.testcase.User;
import net.northking.cloudplatform.domain.testcase.UserExample;
import net.northking.cloudplatform.domain.testexecute.*;
import net.northking.cloudplatform.dto.testexecute.QueueData;
import net.northking.cloudplatform.dto.testexecute.WorkItemData;
import net.northking.cloudplatform.enums.CltCaseExecuteStatus;
import net.northking.cloudplatform.enums.CltExecuteStatus;
import net.northking.cloudplatform.enums.CltJobStatus;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.result.ResultCode;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.TestExecuteService;
import net.northking.cloudplatform.utils.HttpRequester;
import net.northking.cloudplatform.utils.HttpResponser;
import net.northking.cloudplatform.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * @Title: 测试执行服务类
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/12/27
 * @UpdateUser:
 * @Version:0.1
 */
@Service
public class TestExecuteServiceImpl  extends BaseServiceImpl<CltCaseExecute,CltCaseExecuteExample,String> implements TestExecuteService {

    @Autowired
    private CltTestTeamMapper cltTestTeamMapper;

    @Autowired
    private CltJobMapper cltJobMapper;

    @Autowired
    private CltTestCaseMapper cltTestCaseMapper;

    @Value("${queue.url.prefix}")
    private String urlPrefix;

    @Autowired
    private CoreWfWorkitemMapper coreWfWorkitemMapper;

    @Autowired
    private CltCaseSetMapper cltCaseSetMapper;
    /**
     * 根据userId从队列获取用例
     * @param userId
     * @return
     */
    public ResultInfo<CltTestCase> loginGetTestCase(String userId) throws Exception{
        //查看是否有未完成的任务，有的话即返回
        CltCaseExecuteExample cltCaseExecuteExample = new CltCaseExecuteExample();
        CltCaseExecuteExample.Criteria criteria1 = cltCaseExecuteExample.createCriteria();
        criteria1.andReceiveUserEqualTo(userId);
        criteria1.andStatusEqualTo(CltCaseExecuteStatus.INIT.code());
        List<CltCaseExecute> cltCaseExecutes = super.findList(cltCaseExecuteExample);
        if(cltCaseExecutes.size()>0){
            String caseId = cltCaseExecutes.get(0).getCaseId();
            CltTestCase cltTestCase = cltTestCaseMapper.selectByPrimaryKey(caseId);
            return new ResultInfo<CltTestCase>(ResultCode.SUCCESS, cltTestCase);
        }

        //没有未完成的任务才去队列拿任务
        //根据userId从组建团队获取任务
        CltTestTeamExample example = new CltTestTeamExample();
        CltTestTeamExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<CltTestTeam> testTeams = cltTestTeamMapper.selectByExample(example);

        List<CltJob> cltJobList = new ArrayList<>();
        String qses = ""; //队列名称，多个队列用英文逗号分隔
        for(CltTestTeam testTeam : testTeams){
            String jobId = testTeam.getJobId();
            CltJob cltJob = cltJobMapper.selectByPrimaryKey(jobId);
            //判断任务是否已执行状态
            if(CltJobStatus.EXECUTEING.code().equals(cltJob.getStatus())){
                cltJobList.add(cltJob);
                qses += cltJob.getJobId() + ",";
            }
        }

        if(qses.indexOf(",")>0){
            //去除最后面的,号
            qses = qses.substring(0,qses.length()-1);

            //开始队列获取任务
            String url = urlPrefix + "/WorkItemPoolCluster/CTWIPool";
            Map<String, String> params = new HashMap<>();
            params.put("qs", qses);
            params.put("user", userId);
            params.put("size", "1");
            try {
                HttpResponser responser = new HttpRequester().sendPost(url, params);
                if(responser.getCode() == 200){ //成功返回
                    String responseContent = responser.getContent();
                    QueueData queueData = JSONObject.parseObject(responseContent, QueueData.class);
                    if(queueData.getTotal() > 0){ //队列获取到数据
                        List<WorkItemData> workItemDatas = queueData.getWorkItems();
                        //获取1个用例
                        WorkItemData workItemData = workItemDatas.get(0);

                        //从队列获取的workitemId取队列名称
                        CoreWfWorkitem coreWfWorkitem = coreWfWorkitemMapper.selectByPrimaryKey(workItemData.getJobId());
                        //取队列所在的当前任务
                        CltJob currCltJob = cltJobList.get(0); //默认值
                        if(coreWfWorkitem != null) {

                            for (CltJob cltJobTemp : cltJobList) {
                                if (cltJobTemp.getJobId().equals(coreWfWorkitem.getWorkqueue())){
                                    currCltJob = cltJobTemp;
                                    break;
                                }
                            }
                        }


                        String caseId = workItemData.getEntityId();
                        CltTestCase cltTestCase = cltTestCaseMapper.selectByPrimaryKey(caseId);
                        //根据caseID查询该用例属于哪个用例集
                        CltCaseSet cltCaseSet = cltCaseSetMapper.queryTestCaseSetByCaseId(caseId);
                        //插入用例执行表
                        CltCaseExecute cltCaseExecute = new CltCaseExecute();
                        if(cltCaseSet!=null){
                            cltCaseExecute.setCaseSetId(cltCaseSet.getCaseSetId());
                        }
                        cltCaseExecute.setExecuteId(UUIDUtil.getUUID());
                        cltCaseExecute.setWorkitemId(workItemData.getJobId());
                        cltCaseExecute.setCaseId(caseId);
                        cltCaseExecute.setJobName(cltTestCase.getName());
                        cltCaseExecute.setPriority(cltTestCase.getPriority()==null?"":cltTestCase.getPriority().toString());
                        cltCaseExecute.setStatus(CltCaseExecuteStatus.INIT.code());
                        cltCaseExecute.setReceiveUser(userId);
                        cltCaseExecute.setReceiveTime(new Date());
                        cltCaseExecute.setResultStatus(CltExecuteStatus.INIT.getCode());
                        cltCaseExecute.setCustCode(currCltJob.getCustemCode());
                        cltCaseExecute.setProjectId(currCltJob.getProjectId());
                        cltCaseExecute.setBatchId(currCltJob.getBatchId());
                        super.insert(cltCaseExecute);


                        return new ResultInfo<CltTestCase>(ResultCode.SUCCESS, cltTestCase);
                    }

                }
            }catch (IOException e){
                throw new GlobalException(ErrorConstants.GET_QUEUE_ERROR_CODE, ErrorConstants.GET_QUEUE_ERROR_MESSAGE);
            }

        }

        return new ResultInfo<CltTestCase>(ResultCode.SUCCESS);
    }
}
