package net.northking.cloudplatform.controller.testexecute;

import net.northking.cloudplatform.assist.RedisUtil;
import net.northking.cloudplatform.domain.testbug.CltTestBug;
import net.northking.cloudplatform.domain.testexecute.CltTestCase;
import net.northking.cloudplatform.domain.user.CltUserLogin;
import net.northking.cloudplatform.feign.testexecute.JobFeignClient;
import net.northking.cloudplatform.feign.testexecute.TestExecuteFeignClient;
import net.northking.cloudplatform.query.testexecute.JobQuery;
import net.northking.cloudplatform.query.user.UserLoginQuery;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.testexecute.TestExecuteService;
import net.northking.cloudplatform.utils.CltUtils;
import net.northking.cloudplatform.utils.ParamVerifyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Title: 测试执行处理类
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/12/27
 * @UpdateUser:
 * @Version:0.1
 */
@RestController
public class TestExecuteController {

    private final static Logger logger = LoggerFactory.getLogger(TestExecuteController.class);

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    TestExecuteService testExecuteService;


    /**
     * 根据userId从队列获取用例
     * @param userLoginQuery
     * @return
     * @throws Exception
     */
    @PostMapping("/loginGetTestCase")
    public ResultInfo<CltTestCase> loginGetTestCase(@RequestBody UserLoginQuery userLoginQuery) throws Exception {

        Object ob = redisUtil.get(userLoginQuery.getAccess_token());

        if(null != ob) {

            CltUserLogin userLogin = (CltUserLogin)ob;

            userLoginQuery.setUserId(userLogin.getUserId());
        }

        ResultInfo<CltTestCase> resultInfo = testExecuteService.loginGetTestCase(userLoginQuery);

        return resultInfo;
    }


}
