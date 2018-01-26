package net.northking.cloudplatform.service.impl.testexecute;
import net.northking.cloudplatform.Utils.ServiceUtil;
import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.constants.ErrorConstants;
import net.northking.cloudplatform.domain.testexecute.CltTestCase;
import net.northking.cloudplatform.dto.testexecute.JobPlan;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.feign.testexecute.TestExecuteFeignClient;
import net.northking.cloudplatform.query.testexecute.TestTeamQuery;
import net.northking.cloudplatform.query.user.UserLoginQuery;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.testexecute.TestExecuteService;
import net.northking.cloudplatform.utils.CltUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Administrator on 2017/12/20 0020.
 */
@Service
public class TestExecuteServiceImpl implements TestExecuteService {
    @Autowired
    private TestExecuteFeignClient testExecuteFeignClient;


    @Override
    public ResultInfo<CltTestCase> loginGetTestCase( UserLoginQuery userLoginQuery) throws Exception {

        CltUtils.printStartInfo(userLoginQuery, "serviceImpl loginGetTestCase");

        long startTime = System.currentTimeMillis();

        ResultInfo<CltTestCase> resultInfo = null;

        try {
            //调用微服务接口
            resultInfo = testExecuteFeignClient.loginGetTestCase(userLoginQuery);

        } catch (Exception e) {

            e.printStackTrace();

            throw new GlobalException(ErrorConstants.CLT_WEB_TESTEXECUTE_ERROR_CODE, ErrorConstants.CLT_WEB_TESTEXECUTE_ERROR_MESSAGE);

        }

        ServiceUtil.throwServiceException(resultInfo);


        CltUtils.printEndInfo(resultInfo, "serviceImpl loginGetTestCase", startTime);

        return resultInfo;
    }
}
