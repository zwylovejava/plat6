package net.northking.cloudplatform.controller;

import net.northking.cloudplatform.domain.testexecute.CltTestCase;
import net.northking.cloudplatform.query.user.UserLoginQuery;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.TestExecuteService;
import net.northking.cloudplatform.utils.CltUtils;
import net.northking.cloudplatform.utils.ParamVerifyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Title: 测试执行控制类
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
    private TestExecuteService testExecuteService;

    /**
     * 根据userId从队列获取用例
     * @param userLoginQuery
     * @return
     * @throws Exception
     */
    @PostMapping("/loginGetTestCase")
    public ResultInfo<CltTestCase> loginGetTestCase(@RequestBody UserLoginQuery userLoginQuery) throws Exception {
        //校验参数
        ParamVerifyUtil paramVerifyUtil = new ParamVerifyUtil();
        Map<String, Object> dataMap = CltUtils.beanToMap(userLoginQuery);
        paramVerifyUtil.checkNullOrEmpty(dataMap, logger,"userId");

        return testExecuteService.loginGetTestCase(userLoginQuery.getUserId());
    }



}
