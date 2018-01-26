package net.northking.cloudplatform.service.impl.testexecute;


import net.northking.cloudplatform.Utils.ServiceUtil;
import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.constants.ErrorConstants;
import net.northking.cloudplatform.domain.testexecute.CltTestTeam;
import net.northking.cloudplatform.domain.user.CltUserAndLogin;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.feign.testexecute.TestTeamFeignClient;
import net.northking.cloudplatform.feign.user.UserFeignClient;
import net.northking.cloudplatform.query.testexecute.TestTeamQuery;
import net.northking.cloudplatform.query.user.UserAndLoginQuery;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.testexecute.TestTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
@Service
public class TestTeamServiceImpl implements TestTeamService {

    @Autowired
    TestTeamFeignClient testTeamFeignClient;

    @Autowired
    UserFeignClient userFeignClient;

    @Autowired
    TestTeamService testTeamService;

    @Override
    public ResultInfo<Integer> addTestTeam(TestTeamQuery testTeamQuery) throws Exception {

        ResultInfo<Integer>  resultInfo = null;

        try{
            //调用数据库
            resultInfo =  testTeamFeignClient.createTestTeam(testTeamQuery);

        }catch (Exception e){

            throw new GlobalException(ErrorConstants.CLT_WEB_TESTEXECUTE_ERROR_CODE,ErrorConstants.CLT_WEB_TESTEXECUTE_ERROR_MESSAGE);

        }

        //如果返回为异常信息则抛出异常
        ServiceUtil.throwServiceException(resultInfo);

        return resultInfo;
    }


    //根据任务ID查询出用户列表
    @Override
    public Page<CltUserAndLogin> queryUserListByJobId(TestTeamQuery testTeamQuery) throws Exception {

        List<CltUserAndLogin> cltUserAndLoginList = new ArrayList<CltUserAndLogin>();

        ResultInfo<CltUserAndLogin>  cltUserAndLoginResultInfo = null;

        UserAndLoginQuery  userAndLoginQuery = new UserAndLoginQuery();

        ResultInfo<List<CltTestTeam>>  queryUserIdList = testTeamService.queryUserIdsByJobId(testTeamQuery);

        if(queryUserIdList!=null){

            List<CltTestTeam>  userIdList = queryUserIdList.getResultData();

            if(userIdList!=null){

                for (int i=0;i<userIdList.size();i++){

                    CltTestTeam cltTestTeam = (CltTestTeam)userIdList.get(i);

                    String  userId  =(String)cltTestTeam.getUserId();

                    if(!"".equals(userId)){

                        userAndLoginQuery.setUserId(userId);

                        cltUserAndLoginResultInfo = userFeignClient.queryUserInfoByUserId(userAndLoginQuery);

                        CltUserAndLogin cltUserAndLogin = (CltUserAndLogin) cltUserAndLoginResultInfo.getResultData();

                        if(cltUserAndLogin!=null){
                            cltUserAndLoginList.add(cltUserAndLogin);
                        }

                    }

                }
            }

        }

        return new Page<CltUserAndLogin>(cltUserAndLoginList);
    }

    @Override
    public ResultInfo<List<CltTestTeam>> queryUserIdsByJobId(TestTeamQuery testTeamQuery) throws Exception {

        ResultInfo<List<CltTestTeam>>  resultInfo = null;

        try{
            //调用数据库
            resultInfo =  testTeamFeignClient.queryUserIdsByJobId(testTeamQuery);

        }catch (Exception e){

            throw new GlobalException(ErrorConstants.CLT_WEB_TESTEXECUTE_ERROR_CODE,ErrorConstants.CLT_WEB_TESTEXECUTE_ERROR_MESSAGE);

        }

        //如果返回为异常信息则抛出异常
        ServiceUtil.throwServiceException(resultInfo);

        return resultInfo;
    }

    @Override
    public ResultInfo<Integer> deleteTestTeamByJobIdAndUserId(TestTeamQuery testTeamQuery) {
       ResultInfo<Integer> resultInfo=null;

        try {
            resultInfo = testTeamFeignClient.deleteTestTeamByJobIdAndUserId(testTeamQuery);
        } catch (Exception e) {
            throw new GlobalException(ErrorConstants.CREAT_CLT_TEST_TEAM_DELETE_USERS_ERROR_CODE,ErrorConstants.CREAT_CLT_TEST_TEAM_DELETE_USERS_ERROR_MESSAGE);
        }

        return resultInfo;
    }

}
