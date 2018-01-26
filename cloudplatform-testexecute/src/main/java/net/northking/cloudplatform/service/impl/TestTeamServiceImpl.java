package net.northking.cloudplatform.service.impl;

import net.northking.cloudplatform.constants.ErrorConstants;
import net.northking.cloudplatform.dao.testexecute.CltTestTeamMapper;
import net.northking.cloudplatform.domain.testexecute.CltTestTeam;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.query.testexecute.TestTeamQuery;
import net.northking.cloudplatform.service.TestTeamService;
import net.northking.cloudplatform.utils.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Title:
 * @Description: CltTestTeam实现类
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-12-20 10:45
 * @UpdateUser:
 * @Version:0.1
 */

@Service
public class TestTeamServiceImpl implements TestTeamService{


    //日志
    private final static Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);

   //注入mapper
    @Autowired
    private CltTestTeamMapper cltTestTeamMapper;

/**
 * @Author:HBH
 * @Description: 创建测试团队
 * @Date:10:49 2017/12/20
 * @param1: TestTeamQuery
 * @param2:
 * @return:
 */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public Integer creatTestTeam(TestTeamQuery testTeamQuery)throws Exception {

        //先删除已有的数据,再添加
        //根据JobID 删除所有的userId数据（多条）
        cltTestTeamMapper.deleteUsersByJobId(testTeamQuery.getJobId());

        Integer addTestTeam=0;

        Integer count=0;

        String jobId=testTeamQuery.getJobId();

        String [] userIds=testTeamQuery.getUserIds();

        CltTestTeam cltTestTeam=new CltTestTeam();

        for (int i = 0; i < userIds.length; i++) {

            String userId = userIds[i];

            //用户ID
            cltTestTeam.setUserId(userId);
            //任务ID
            cltTestTeam.setJobId(jobId);
            //创建者
            cltTestTeam.setCreateUser(testTeamQuery.getCreateUser());

            //测试团队ID
            cltTestTeam.setTeamId(UUIDUtil.getUUID());
            //创建时间
            cltTestTeam.setCreateDate(new Date());

            //调用数据库
             try {
                 addTestTeam = cltTestTeamMapper.insertSelective(cltTestTeam);

                 if(addTestTeam==1){

                     count++;
                 }

             }catch (Exception e){

                 logger.error("creatTestTeam" , e);

                 throw new GlobalException(ErrorConstants.CREAT_CLT_TEST_TEAM_ERROR_CODE,ErrorConstants.CREAT_CLT_TEST_TEAM_ERROR_MESSAGE);
             }


        }


        return count;

    }

    /**
     * @Author:HBH
     * @Description: 根据jobId查询任务下的用户Id
     * @Date:14:58 2017/12/21
     * @param1:
     * @param2:
     * @return:
     */
    @Override
    public List<CltTestTeam> queryUserIdsByJobId(TestTeamQuery testTeamQuery) throws Exception {

        try{

            List<CltTestTeam> userIds=cltTestTeamMapper.querUserIdByJobId(testTeamQuery.getJobId());

            return userIds;
        }catch(Exception e){

            logger.error("queryUserIdsByJobId" , e);

            throw new GlobalException(ErrorConstants.QUERY_USERID_BY_JOBID_ERROR_CODE,ErrorConstants.QUERY_USERID_BY_JOBID_ERROR_MESSAGE);

        }

    }


    /**
     * @Author:HBH
     * @Description: 批量删除测试团队表
     * @Date:16:24 2017/12/21
     * @param1:
     * @param2:
     * @return:
     */
    @Override
    public Integer delteTestTeamBatch(TestTeamQuery testTeamQuery) throws Exception {

        String[] teamIds=testTeamQuery.getTeamIds();
        Integer deleteCount=0;

        try{

            for (int i=0;i<teamIds.length;i++){

                String teamId=teamIds[i];

                //调用数据库
                cltTestTeamMapper.deleteByPrimaryKey(teamId);

                deleteCount++;
            }
            return deleteCount;


        }catch(Exception e){

            logger.error("delteTestTeamBatch" , e);

            throw new GlobalException(ErrorConstants.DELETE_TEST_TEAM_BY_TEAMID_ERROR_CODE,ErrorConstants.DELETE_TEST_TEAM_BY_TEAMID_ERROR_MESSAGE);

        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public Integer deleteTestTeamByJobIdAndUserId(TestTeamQuery testTeamQuery) throws Exception {
        Integer rows= 0;
        String jobId = testTeamQuery.getJobId();
        String[] userIds = testTeamQuery.getUserIds();
        try {
            for(String userId:userIds){
               Integer row =  cltTestTeamMapper.deleteTestTeamByJobIdAndUserId(jobId,userId);
                rows+=row;

            }
        }catch (Exception e){
            rows=0;
            logger.error("deleteTestTeamByJobIdAndUserId" , e);
            throw new GlobalException(ErrorConstants.CREAT_CLT_TEST_TEAM_DELETE_USERS_ERROR_CODE,ErrorConstants.CREAT_CLT_TEST_TEAM_DELETE_USERS_ERROR_MESSAGE);

        }

        return  rows;
    }


    /**
     * @Author:HBH
     * @Description: 根据jobId和userId删除测试团队
     * @Date:15:29 2017/12/20
     * @param1:
     * @param2:
     * @return:
     */

    public Integer deleteTestTeamByJobIdAndUserId(String jobId , String  userId) throws Exception{

        Integer deteleTestTeam=0;

        try {

            //调用数据库

            deteleTestTeam=cltTestTeamMapper.deleteTestTeamByJobIdAndUserId(jobId,userId);

            return deteleTestTeam;

        }catch (Exception e){

            logger.error("deleteTestTeamByJobIdAndUserId" , e);

            throw new GlobalException(ErrorConstants.DELETE_CLT_TEST_TEAM_BY_USERANDJOBID_ERROR_CODE,ErrorConstants.DELETE_CLT_TEST_TEAM_BY_USERANDJOBID_ERROR_MESSAGE);
        }

    }

}

