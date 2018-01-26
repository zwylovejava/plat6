package net.northking.cloudplatform.feign.user;


import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.domain.testcase.User;
import net.northking.cloudplatform.query.user.UserQuery;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Title:
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/11/4
 * @UpdateUser:
 * @Version:0.1
 */
@FeignClient(name = "cloudplatform-gateway")
public interface TestUserFeignClient {
    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<Page<User>> readUserInfo(@RequestBody UserQuery userQuery);
}
