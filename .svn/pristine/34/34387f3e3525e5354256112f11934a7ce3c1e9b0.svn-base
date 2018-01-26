package net.northking.cloudplatform.feign.auth;


import net.northking.cloudplatform.domain.user.CltUserLogin;
import net.northking.cloudplatform.dto.auth.AuthToken;
import net.northking.cloudplatform.dto.auth.Authority;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Title: 用户登录认证
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/11/27
 * @UpdateUser:
 * @Version:0.1
 */
@FeignClient(name = "cloudplatform-gateway")
public interface AuthTokenFeign {

    @RequestMapping(value = "/uaa/oauth/token", method = RequestMethod.POST)
    AuthToken authLogin(@RequestParam(name = "grant_type", required = true) String grant_type,
                        @RequestParam(name = "username", required = true) String username,
                        @RequestParam(name = "password", required = true) String password,
                        @RequestHeader(name = "Authorization") String authorization);

    @RequestMapping(value = "/uaa/getLoginUser", method = RequestMethod.POST)
    CltUserLogin getLoginUser(@RequestParam(name = "access_token", required = true) String access_token);

    @RequestMapping(value = "/uaa/userFuncs", method = RequestMethod.POST)
    ResultInfo<Authority> getUserFuncList(@RequestHeader(name = "Authorization", required = true) String authorization, @RequestParam(name = "parentFuncId") String parentFuncId);
}
