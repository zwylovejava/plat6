package net.northking.cloudplatform.feign.testexecute;


import net.northking.cloudplatform.domain.testexecute.CltTestCase;
import net.northking.cloudplatform.query.testexecute.JobQuery;
import net.northking.cloudplatform.query.user.UserLoginQuery;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Title: 测试执行Feign客户端
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/12/27
 * @UpdateUser:
 * @Version:0.1
 */
@FeignClient(name = "cloudplatform-gateway")
public interface TestExecuteFeignClient {
    //根据userId从队列获取用例
    @RequestMapping(value = "/testexecute/loginGetTestCase", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<CltTestCase> loginGetTestCase(@RequestBody UserLoginQuery userLoginQuery);
}
