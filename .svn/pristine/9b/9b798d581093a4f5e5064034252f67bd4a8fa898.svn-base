package net.northking.cloudplatform.service.impl;

import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.ir.annotations.Ignore;
import net.northking.cloudplatform.assist.RedisUtil;
import net.northking.cloudplatform.constants.ErrorConstants;
import net.northking.cloudplatform.constants.MQConstants;
import net.northking.cloudplatform.dao.testexecute.*;
import net.northking.cloudplatform.domain.project.CltCustomer;
import net.northking.cloudplatform.domain.project.CltProject;
import net.northking.cloudplatform.domain.testexecute.*;
import net.northking.cloudplatform.dto.rabbitmq.CltBatchMQDTO;
import net.northking.cloudplatform.dto.testexecute.*;
import net.northking.cloudplatform.enums.CltBatchStatus;
import net.northking.cloudplatform.enums.CltJobStatus;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.feign.customer.CustomerFeignClient;
import net.northking.cloudplatform.feign.project.ProjectFeignClient;
import net.northking.cloudplatform.query.cust.CustomerQuery;
import net.northking.cloudplatform.query.project.ProjectQuery;
import net.northking.cloudplatform.query.testexecute.BatchQuery;
import net.northking.cloudplatform.result.ResultCode;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.sender.FanoutSender;
import net.northking.cloudplatform.service.BatchService;
import net.northking.cloudplatform.service.TestCaseService;
import net.northking.cloudplatform.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Title:
 * @Description: 批次表业务逻辑层实现类
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-12-26 17:43
 * @UpdateUser:
 * @Version:0.1
 */

@Service
public class BatchServiceImpl implements BatchService{

    @Autowired
    private CltBatchMapper cltBatchMapper;

    @Autowired
    private CltRoundMapper cltRoundMapper;

    @Autowired
    private CltPlanMapper cltPlanMapper;
    @Autowired
    private CltBatchMapper mapper;
    @Autowired
    private CltCaseSetMapper caseSetMapper;
    @Autowired
    private CltCaseSetRelMapper relMapper;
    @Autowired
    private TestCaseService testCaseService;
    @Autowired
    private CltTestCaseMapper testCaseMapper;
    @Autowired
    private CltTestCaseStepMapper testCaseStepMapper;
    @Autowired
    private CltTestStepDataMapper cltTestStepDataMapper;
    @Autowired
    private CltAppAnalyseMapper appAnalyseMapper;
    @Autowired
    private CltAppBizParamMapper appBizParamMapper;
    @Autowired
    private CltJobMapper cltJobMapper;
//   @Autowired
//    private CltCaseItemSetupService cltCaseItemSetupService;
    @Autowired
    private CltCaseItemSetupMapper cltCaseItemSetupMapper;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private ProjectFeignClient projectFeign;
    @Autowired
    private CustomerFeignClient customerFeign;

    private Logger logger = LoggerFactory.getLogger(BatchServiceImpl.class);

    @Value("${ftpfile.path}")
    private String userPath;
    @Value("${ftpserver.ip}")
    private String ftpIp;
    @Value("${ftpserver.port}")
    private String ftpPort;
    @Value("${ftpUser.name}")
    private String name;
    @Value("${ftpUser.password}")
    private String password;
    @Autowired
    private FanoutSender sender;

    //根据批次ID查询批次详情(包括伦次详情和计划详情)
    @Override
    public CltBatch queryBatchByBatchId(BatchQuery batchQuery) {
        try {

            //批次ID
            String batchId = batchQuery.getBatchId();
            //首先根据批次ID查询批次的详细信息
            CltBatch cltBatch = cltBatchMapper.selectByPrimaryKey(batchId);
            //再根据伦次ID查询伦次的详细信息
            if (cltBatch != null) {
                String roundId = cltBatch.getRoundId();
                CltRound cltRound = cltRoundMapper.selectByPrimaryKey(roundId);
                if (cltRound != null) {
                    String planId = cltRound.getPlanId();
                    CltPlan cltPlan = cltPlanMapper.selectByPrimaryKey(planId);
                    cltBatch.setCltRound(cltRound);
                    cltBatch.setCltPlan(cltPlan);
                    return cltBatch;
                }
            }
            return null;
        } catch (Exception e) {
            logger.error("queryBatchByBatchId", e);
            throw new GlobalException(ErrorConstants.QUERY_CLT_BATCH_BY_BATCHID_ERROR_CODE, ErrorConstants.QUERY_CLT_BATCH_BY_BATCHID_ERROR_MESSAGE);
        }
    }

    /**
     * 云平台读取ftp服务器上的目录文件，再将数据插入到数据库中
     * @throws Exception
     */
    @Override
    public void receiveBatch(String path) throws Exception {
        FtpHelper ftpHelper=null;
        ResultInfo<CltProject> cltProjectResultInfo1=null;
        CltTestCaseDTOList cltTestCaseDTOList = null;//存储传过来的用例文件数据
        ResultInfo<Integer> addProjectInfo = null;
        CltBatchDTO cltBatchDTO = null;//存储传过来的批次文件数据
        CustomerQuery customerQuery=null;
        List<String> testcasePath=new ArrayList<>();//重新保存ftp上用例文件的路径
        try {
            //下载目录文件
             ftpHelper = FtpHelper.getInstance();
            boolean login = ftpHelper.login(ftpIp, Integer.parseInt(ftpPort),name,password);
            if (login) {//如果登录了
                //获取该ftp上该批次目录的所有文件路径
                List<String> ftpFiles = ftpHelper.listFile(path);
//                System.out.println("该目录下的文件个数为："+ftpFiles.size());
                for (int i = 0; i <ftpFiles.size() ; i++) {
                    if(ftpFiles.get(i).indexOf("batch")>0){
                        String json = ftpHelper.downloadFileFromFtp(ftpFiles.get(i));
                        cltBatchDTO = JSONObject.parseObject(json, CltBatchDTO.class);
                    }else if(ftpFiles.get(i).indexOf("testcase")>0){
                        testcasePath.add(ftpFiles.get(i));//仅仅保存了ftp服务器上用例文件的路径
                 }
                }
            }
            if (cltBatchDTO == null) {
                throw new Exception("批次不能为空");
            }
            List<CltCaseSetDTO> caseSets = cltBatchDTO.getCaseSets();//客户端传来的用例集数据
            CltProjectDTO projectDTO1 = cltBatchDTO.getProjectDTO();//客户端传来的项目数据
            CltRoundDTO cltRoundDTO = cltBatchDTO.getCltRoundDTO();//客户端传来的轮次数据
            if(projectDTO1==null){
                throw new Exception("项目不能为空");
            }
            if (cltRoundDTO==null){
                throw new Exception("轮次不能为空");
            }
            CltPlanDTO cltPlanDTO = cltRoundDTO.getCltPlanDTO();//客户端传来的计划数据
            if(cltPlanDTO==null){
                throw new Exception("计划不能为空");
            }
            CltCustomerDTO cltCustomerDTO = projectDTO1.getCltCustomerDTO();
            if(cltCustomerDTO==null){
                throw new Exception("客户不能为空");
            }
            List<CltCaseItemSetupDTO> cltCaseItemSetupDTOS = projectDTO1.getCltCaseItemSetupDTOS();
            if (cltCustomerDTO != null) {
                if(StringUtils.isEmpty(cltCustomerDTO.getCustCode())||StringUtils.isEmpty(cltCustomerDTO.getCustId())){
                    throw new Exception("客户端同步过来的顾客code或者id不能为空");
                }
                ResultInfo<CltCustomer> cltCustomerResultInfo2 = null;
                 customerQuery = new CustomerQuery();
                customerQuery.setCustId(cltCustomerDTO.getCustId());//暂时使用Id
                customerQuery.setCustCode(cltCustomerDTO.getCustCode());
                ResultInfo<CltCustomer> cltCustomerResultInfo = customerFeign.queryCustomerByCustCode(customerQuery);
                if(cltCustomerResultInfo.getResultData()==null){
                    logger.info("客户端同步过来的顾客的code在云平台不存在,说明之前没实现客户同步");
                    throw new Exception("客户端同步过来的顾客的code在云平台不存在,说明之前没实现客户同步");
                }
                ResultInfo<CltCustomer> cltCustomerResultInfo1 = customerFeign.queryByCustId(customerQuery);
                CltCustomer data = cltCustomerResultInfo1.getResultData();
                if(data==null){
                    //客户不存在，那应该报错，因为数据就是云平台同步到客户端
                    throw new Exception("云平台没有该客户");
                }
                /*if (data == null) {
                    BeanUtil.copyProperties(cltCustomerDTO, customerQuery);
                    cltCustomerResultInfo2 = customerFeign.addCustomer(customerQuery);//这里失败了，因为两个应用的客户表不一致
                }*/
                if (data!=null) {//原则上客户一定会存在的，所以当存在时做以下操作,如果确保了数据同步，这里也可以改为data!=null
                    //從這裡開始正式插入数据
                    ProjectQuery projectQuery = new ProjectQuery();
                    projectQuery.setProId(projectDTO1.getProId());
                     cltProjectResultInfo1 = projectFeign.queryProjectInfoByProId(projectQuery);

                    if (cltProjectResultInfo1.getResultData() == null) {
                        BeanUtil.copyProperties(projectDTO1, projectQuery);
                        projectQuery.setFuncCode("1");//客户数据同步识别码
                        addProjectInfo = projectFeign.addProjectInfo(projectQuery);
                    }
                    if(cltProjectResultInfo1.getResultData()!=null||addProjectInfo!=null){
    //                if(true){
                        //当客户和项目都存在了，就判断计划和轮次存在不存在
                        CltPlan cltPlan = cltPlanMapper.selectByPrimaryKey(cltPlanDTO.getPlanId());
                        int i=0;
                        if(cltPlan==null){
                            cltPlan=new CltPlan();
                            BeanUtil.copyProperties(cltPlanDTO,cltPlan);
                             i = cltPlanMapper.insertSelective(cltPlan);
                        }
                        if(i>0||cltPlan!=null){
                            //当计划已经确保存在云平台了
                            CltRound cltRound = cltRoundMapper.selectByPrimaryKey(cltRoundDTO.getRoundId());
                            int n=0;
                            if(cltRound==null){
                                cltRound=new CltRound();
                                BeanUtil.copyProperties(cltRoundDTO,cltRound);
                                n = cltRoundMapper.insertSelective(cltRound);
                            }
                            if(n>0||cltRound!=null){
                                //确保轮次已经存在云平台了,才继续批次等数据的插入
                                CltBatch batch=new CltBatch();
                                BeanUtil.copyProperties(cltBatchDTO,batch);
                                CltBatch cltBatch = mapper.selectByPrimaryKey(cltBatchDTO.getBatchId());
    //                            ftpHelper.moverDirectiory(userPath,path,"backups");//实验用的，看是否能移动
                                if(cltBatch!=null){
                                    throw new GlobalException(ResultCode.INVALID_PARAM.code() , "同个批次不能发送两次");
                                }
                                int num = mapper.insertSelective(batch);
                                if (cltProjectResultInfo1.getResultData()!=null||addProjectInfo!=null) {//只有存在项目，才能继续往下进行数据插入
                                   for(String testCasePath:testcasePath){
                                       //遍历所有用例文件路径，然后再逐个去ftp服务器下载
                                       String json = ftpHelper.downloadFileFromFtp(testCasePath);
                                       cltTestCaseDTOList = JSONObject.parseObject(json,CltTestCaseDTOList.class);
                                       for (TestCaseDTO testCaseDTO : cltTestCaseDTOList.getTestCaseDTOList()) {//必须先插入用例Id，再插入步骤id
                                           List<CltTestCaseStepDTO> cltTestCaseStepDTOS = testCaseDTO.getCltTestCaseStepDTOS();
                                           CltTestCase testCase = new CltTestCase();
                                           BeanUtil.copyProperties(testCaseDTO, testCase);
                                           CltTestCase cltTestCase = testCaseMapper.selectByPrimaryKey(testCaseDTO.getId());
                                           if(cltTestCase==null){
                                               testCaseMapper.insertSelective(testCase);//用例也属于整个项目的，得判断是否存在
                                           }
                                           for (CltTestCaseStepDTO cltTestCaseStepDTO : cltTestCaseStepDTOS) {
                                               CltTestCaseStep cltTestCaseStep = new CltTestCaseStep();
                                               BeanUtil.copyProperties(cltTestCaseStepDTO, cltTestCaseStep);
                                               CltTestCaseStep cltTestCaseStep1 = testCaseStepMapper.selectByPrimaryKey(cltTestCaseStepDTO.getId());
                                               if(cltTestCaseStep1==null){
                                                   testCaseStepMapper.insertSelective(cltTestCaseStep);
                                               }else {
                                                   testCaseStepMapper.updateByPrimaryKeySelective(cltTestCaseStep);
                                               }
                                               AppAnalyseDTO appAnalyseDTO = cltTestCaseStepDTO.getAppAnalyseDTO();
                                               List<CltTestStepDataDTO> testStepDataDTOS = cltTestCaseStepDTO.getTestStepDataDTOS();
                                               for (CltTestStepDataDTO cltTestStepDataDTO : testStepDataDTOS) {
                                                   AppBizParamDTO appBizParamDTO = cltTestStepDataDTO.getAppBizParamDTO();
                                                   if (appBizParamDTO != null) {
                                                       CltAppBizParam byPrimaryKey = appBizParamMapper.selectByPrimaryKey(appBizParamDTO.getId());
                                                       CltAppBizParam appBizParam = new CltAppBizParam();
                                                       BeanUtil.copyProperties(appBizParamDTO, appBizParam);
                                                       if (byPrimaryKey == null) {
                                                           appBizParamMapper.insertSelective(appBizParam);
                                                       }else{
                                                           appBizParamMapper.updateByPrimaryKeySelective(appBizParam);
                                                       }
                                                   }
                                                   CltTestStepData cltTestStepData = new CltTestStepData();
                                                   BeanUtil.copyProperties(cltTestStepDataDTO, cltTestStepData);
                                                   CltTestStepData cltTestStepData1 = cltTestStepDataMapper.selectByPrimaryKey(cltTestStepDataDTO.getId());
                                                   if(cltTestStepData1==null) {
                                                       cltTestStepDataMapper.insertSelective(cltTestStepData);
                                                   }else{
                                                       cltTestStepDataMapper.updateByPrimaryKeySelective(cltTestStepData);
                                                   }
                                               }
                                               if (appAnalyseDTO != null) {
                                                   CltAppAnalyse analyse = new CltAppAnalyse();
                                                   BeanUtil.copyProperties(appAnalyseDTO, analyse);
                                                   CltAppAnalyse analyseQuery1 = appAnalyseMapper.selectByPrimaryKey(analyse.getId());
                                                   if (analyseQuery1 == null) {
                                                       appAnalyseMapper.insertSelective(analyse);
                                                   }else{
                                                       appAnalyseMapper.updateByPrimaryKeySelective(analyse);
                                                   }
                                               }
                                           }
                                       }
                                   }
                                    List<CltCaseSetDTO> sets = cltBatchDTO.getCaseSets();
                                    for (CltCaseSetDTO setDTO:sets ){
                                        CltCaseSetRel rel=new CltCaseSetRel();
                                        rel.setCaseSetId(setDTO.getCaseSetId());
                                        CltCaseSet cltCaseSet=new CltCaseSet();
                                        BeanUtil.copyProperties(setDTO,cltCaseSet);

                                        caseSetMapper.insertSelective(cltCaseSet);
                                        for(String id:setDTO.getTestCaseIds()){
                                            rel.setCaseSetRelId(UUIDUtil.getUUID());
                                            rel.setCaseId(id);
                                            relMapper.insertSelective(rel);
                                        }
                                    }
                                    //只有項目存在了，才會有自定索引屬性表的插入，插入前先刪除
                                    if (cltCaseItemSetupDTOS != null) {
                                        CltCaseItemSetupExample example = new CltCaseItemSetupExample();
                                        CltCaseItemSetupExample.Criteria criteria = example.createCriteria();
                                        criteria.andProIdEqualTo(projectDTO1.getProId());
                                        int index = cltCaseItemSetupMapper.deleteByExample(example);
                                        for (CltCaseItemSetupDTO setupDTO2 : cltCaseItemSetupDTOS) {
                                            CltCaseItemSetup up = new CltCaseItemSetup();
                                            BeanUtil.copyProperties(setupDTO2, up);
                                            cltCaseItemSetupMapper.insertSelective(up);
                                        }
                                    }
                                }
                                //表名最后的数据也插入完成了,再来插入任务
                                CltJob job=new CltJob();
                                job.setBatchId(cltBatchDTO.getBatchId());
                                job.setCreateDate(new Date());
                                job.setCustemCode(cltCustomerDTO.getCustCode());
                                job.setCustemName(cltCustomerDTO.getCustName());
                                if(!StringUtils.isEmpty((cltBatchDTO.getMemo()))){
                                    job.setJobDesc(cltBatchDTO.getMemo());
                                }
                                job.setJobId(UUIDUtil.getUUID());
                                job.setJobName(cltBatchDTO.getBatchName());
                                job.setProjectId(projectDTO1.getProId());
                                job.setProjectName(projectDTO1.getProName());
                                job.setStatus(CltJobStatus.INIT.code());
                                int j = cltJobMapper.insertSelective(job);
                                if(j>0){//当插入Job成功后才发送MQ通知客户端，表示已经收到数据
                                    //成功插入后就将文件目录备份到backups目录中
                                    try {
                                        ftpHelper.moverDirectiory(userPath,path,"backups");
                                    }catch (Exception e){
                                        logger.info("receiveBatch:"+e);
                                        throw new Exception("成功读取文件，但是备份时移动文件失败");
                                    }
                                    //发送MQ，同步客户端的批次的状态
                                    CltBatchMQDTO cltBatchMQDTO=new CltBatchMQDTO();
                                    cltBatchMQDTO.setSuccess(true);
                                    cltBatchMQDTO.setBatchId(path);
                                    cltBatchMQDTO.setStatus(CltBatchStatus.SEND_SUCCESS.getCode());
                                    cltBatchMQDTO.setMsg("发送成功，云平台同步批次数据完毕!");
                                    String jsonString = JSONObject.toJSONString(cltBatchMQDTO);
                                    sender.send(MQConstants.batchExchangeP,jsonString);
                                }
                            }
                        }
                    }
                }
              }
          }catch (Exception e){
            logger.info("receiveBatch"+e);
            //这里最好是将读取失败的文件直接删掉，否则移动文件过程容易出现问题
            try {
                //同步失败，发送失败MQ通知客户端
                CltBatchMQDTO cltBatchMQDTO=new CltBatchMQDTO();
                cltBatchMQDTO.setSuccess(false);
                cltBatchMQDTO.setBatchId(path);
                cltBatchMQDTO.setStatus(CltBatchStatus.SENDING.getCode());
                cltBatchMQDTO.setMsg("发送失败，云平台同步批次数据失败!");
                String jsonString = JSONObject.toJSONString(cltBatchMQDTO);
                sender.send(MQConstants.batchExchangeP,jsonString);
                boolean b = ftpHelper.removeDir(path, userPath);
            }catch (Exception e1){
                logger.info("读取文件失败后删除:"+e1);
                throw new Exception("读取文件失败后，删除文件失败");
            }
            //发送MQ通知客户端文件有问题，重新上传
            throw new GlobalException(ResultCode.INVALID_PARAM.code(), "ftp服务器上读取文件失败");
        }finally {
            if(ftpHelper!=null){
                ftpHelper.close();
            }
        }
    }

    /**
     * 递归解析本地目录：目录下的所有文件
     */
    List<File> pathList=new ArrayList<>();
    public void uploadFiles(File fileSource){
        File sourceFile[] = fileSource.listFiles();
        for (int i = 0; i < sourceFile.length; i++) {
            if (sourceFile[i].exists()) {
                if (sourceFile[i].isDirectory()) {
                    this.uploadFiles(sourceFile[i]);
                }else{
                    pathList.add(sourceFile[i]);
                }
            }
        }
    }


    /**
     * 撤回批次
     * @param batchId
     * @throws Exception
     */
    @Override
    public boolean canCelBatchById(String batchId) throws Exception {
        FtpHelper ftpHelper=null;
        CltBatchMQDTO cltBatchMQDTO=new CltBatchMQDTO();
        cltBatchMQDTO.setBatchId(batchId);
        cltBatchMQDTO.setStatus(CltBatchStatus.CANCEL.getCode());
        cltBatchMQDTO.setSuccess(false);
        cltBatchMQDTO.setMsg("撤回批次失败");
        try {
            CltBatch cltBatch = mapper.selectByPrimaryKey(batchId);
            if(cltBatch==null){
                //这时可以考虑直接发送MQ通知客户端已撤回了
                cltBatchMQDTO.setMsg("成功撤回批次");
                cltBatchMQDTO.setSuccess(true);
                String jsonString = JSONObject.toJSONString(cltBatchMQDTO);
                sender.send(MQConstants.batchExchangeP,jsonString);
                return true;
            }
            if(Integer.parseInt(CltBatchStatus.MANAGER.getCode())>Integer.parseInt(cltBatch.getStatus())){
                //如果该批次存在并且还未分配主管，则可以撤销,先删除用例集以及关系表
                CltCaseSetExample setExample=new CltCaseSetExample();
                CltCaseSetExample.Criteria criteria = setExample.createCriteria();
                criteria.andBatchIdEqualTo(cltBatch.getBatchId());
                List<CltCaseSet> cltCaseSets = caseSetMapper.selectByExample(setExample);
                List<String> setsId=new ArrayList<>();
                for(CltCaseSet set:cltCaseSets){
                    CltCaseSetRelExample relExample=new CltCaseSetRelExample();
                    CltCaseSetRelExample.Criteria relCriteria = relExample.createCriteria();
                    relCriteria.andCaseSetIdEqualTo(set.getCaseSetId());
                    relMapper.deleteByExample(relExample);
                    setsId.add(set.getCaseSetId());
                }
                //删除完所有用例集和用例的关系表后再删除用例集
                setExample.clear();
                criteria=setExample.createCriteria();
                if(setsId.size()>0){
                    criteria.andCaseSetIdIn(setsId);
                    caseSetMapper.deleteByExample(setExample);
                }
                //删除JOB任务
                CltJobExample jobExample=new CltJobExample();
                CltJobExample.Criteria jobCriteria = jobExample.createCriteria();
                jobCriteria.andBatchIdEqualTo(batchId);
                List<CltJob> cltJobs = cltJobMapper.selectByExample(jobExample);
                if(cltJobs.size()==1){
                    //因为任务和批次之间的关系是一对一
                    CltJob cltJob = cltJobs.get(0);
                    if(CltJobStatus.INIT.code().equals(cltJob.getStatus())){
                        cltJobMapper.deleteByPrimaryKey(cltJob.getJobId());
                    }
                }
                //再删除批次
                int index = mapper.deleteByPrimaryKey(batchId);
                if(index>0){
                    cltBatchMQDTO.setMsg("成功撤回批次");
                    cltBatchMQDTO.setSuccess(true);
                    String jsonString = JSONObject.toJSONString(cltBatchMQDTO);
                    //如果批次删除成功，说明backups里面有批次文件，也要删除
                    ftpHelper = FtpHelper.getInstance();
                    boolean login = ftpHelper.login(ftpIp, Integer.parseInt(ftpPort),name,password);
                    if (login) {//如果登录了
                        boolean b = ftpHelper.removeDir("backups/" + batchId, userPath);
                        if (b) {
                            sender.send(MQConstants.batchExchangeP, jsonString);
                        }
                    }
                }else{
                   throw new Exception("批次删除失败："+batchId);
                }
              }else{
                //说明该批次的状态已经分配主管之后了，不允许在撤回
                cltBatchMQDTO.setMsg("撤回批次失败，该批次处于："+cltBatch.getStatus());
                throw new Exception("批次删除失败："+batchId);
            }
            }catch (Exception e){
                logger.info("canCelBatchById:"+e);
                String jsonString = JSONObject.toJSONString(cltBatchMQDTO);
                sender.send(MQConstants.batchExchangeP,jsonString);
                throw new Exception(e);
            }finally {
                if(ftpHelper!=null){
                    ftpHelper.close();
                }
        }
          return true;
    }
}
