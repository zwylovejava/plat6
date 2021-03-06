package net.northking.cloudplatform.service.impl.testbug;


import net.northking.cloudplatform.Utils.ServiceUtil;
import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.constants.ErrorConstants;
import net.northking.cloudplatform.domain.testbug.CltTestBug;
import net.northking.cloudplatform.domain.user.CltUserAndLogin;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.feign.testbug.TestBugFeignClient;
import net.northking.cloudplatform.feign.user.UserFeignClient;
import net.northking.cloudplatform.query.testbug.TestBugQuery;
import net.northking.cloudplatform.query.user.UserAndLoginQuery;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.testbug.TestBugService;
import net.northking.cloudplatform.utils.CltUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/1/3 0003.
 */

@Service
public class TestBugServiceImpl implements  TestBugService{

    @Autowired
    private TestBugFeignClient testBugFeignClient;

    @Autowired
    UserFeignClient userFeignClient;

    private final static Logger logger = LoggerFactory.getLogger(TestBugServiceImpl.class);
    //添加缺陷信息
    @Override
    public ResultInfo<Integer> addTestBug(TestBugQuery testBugQuery) throws Exception {
        ResultInfo<Integer>  resultInfo = null;

        try{
            //调用数据库
            resultInfo =  testBugFeignClient.addTestBug(testBugQuery);

        }catch (Exception e){

            throw new GlobalException(ErrorConstants.ADD_TEST_BUG_ERROR_CODE,ErrorConstants.ADD_TEST_BUG_ERROR_ERROR_MESSAGE);

        }

        //如果返回为异常信息则抛出异常
        ServiceUtil.throwServiceException(resultInfo);

        return resultInfo;
    }

    //缺陷信息列表
    @Override
    public ResultInfo<Page<CltTestBug>> queryAllTestBugs(TestBugQuery testBugQuery) throws Exception {

        CltUtils.printStartInfo(testBugQuery, "serviceImpl queryAllTestBugs");

        long startTime = System.currentTimeMillis();

        ResultInfo<Page<CltTestBug>> resultInfo = null;
        try {
            resultInfo = testBugFeignClient.queryAllTestBugs(testBugQuery);
            if (resultInfo.getResultData().getList() != null && resultInfo.getResultCode().equals("CLT000000000")) {
                List<CltTestBug> list = resultInfo.getResultData().getList();
                for (CltTestBug cltTestBug :list) {

                    UserAndLoginQuery userAndLoginQuery = new UserAndLoginQuery();

                    userAndLoginQuery.setUserId(cltTestBug.getCreateUser());

                    ResultInfo<CltUserAndLogin> cltUserAndLoginResultinfo = userFeignClient.queryUserInfoByUserId(userAndLoginQuery);

                    if (cltUserAndLoginResultinfo != null && cltUserAndLoginResultinfo.getResultData()!=null&&cltUserAndLoginResultinfo.getResultCode().equals("CLT000000000")) {
                        String userChnName = cltUserAndLoginResultinfo.getResultData().getUserChnName();
                        cltTestBug.setUserChnName(userChnName);
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();

            throw new GlobalException(ErrorConstants.QUERY_TEST_BUG_LIST_ERROR_CODE, ErrorConstants.QUERY_TEST_BUG_LIST_ERROR_MESSAGE);
        }

        ServiceUtil.throwServiceException(resultInfo);

        CltUtils.printEndInfo(resultInfo, "serviceImpl queryAllTestBugs", startTime);

        return resultInfo;
    }

    //缺陷信息详情
    @Override
    public ResultInfo<CltTestBug> queryBugByBugId(TestBugQuery testBugQuery) throws Exception {
        CltUtils.printStartInfo(testBugQuery, "serviceImpl queryBugByBugId");

        long startTime = System.currentTimeMillis();

        ResultInfo<CltTestBug> resultInfo  = null;

        try {
            //调用微服务接口
            resultInfo = testBugFeignClient.queryBugByBugId(testBugQuery);

            if(resultInfo!=null && resultInfo.getResultCode().equals("CLT000000000")){
                UserAndLoginQuery userAndLoginQuery=new UserAndLoginQuery();
                userAndLoginQuery.setUserId(resultInfo.getResultData().getCreateUser());
                ResultInfo<CltUserAndLogin> cltUserAndLoginResultinfo= userFeignClient.queryUserInfoByUserId(userAndLoginQuery);
                if(cltUserAndLoginResultinfo!=null && cltUserAndLoginResultinfo.getResultCode().equals("CLT000000000")){
                    String userChnName = cltUserAndLoginResultinfo.getResultData().getUserChnName();

                    resultInfo.getResultData().setUserChnName(userChnName);

                    return resultInfo;

                }

            }

        } catch (Exception e) {

            e.printStackTrace();

            throw new GlobalException(ErrorConstants.QUERY_TEST_BUG_BY_BUGID_ERROR_CODE,ErrorConstants.QUERY_TEST_BUG_BY_BUGID_ERROR_MESSAGE);

        }

        ServiceUtil.throwServiceException(resultInfo);

        CltUtils.printEndInfo(resultInfo, "serviceImpl queryBugByBugId", startTime);

        return resultInfo;
    }

}
