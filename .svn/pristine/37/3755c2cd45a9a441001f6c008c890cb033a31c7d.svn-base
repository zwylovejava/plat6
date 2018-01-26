package net.northking.cloudplatform.feign.user;


import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.domain.user.CltUserAndLogin;
import net.northking.cloudplatform.domain.user.CltUserLogin;
import net.northking.cloudplatform.query.user.CltUserLoginQuery;
import net.northking.cloudplatform.query.user.UserAndLoginQuery;
import net.northking.cloudplatform.query.user.UserLoginQuery;
import net.northking.cloudplatform.query.user.UserUpdatePwd;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by HBH on 2017/11/10.
 */
@FeignClient(name = "cloudplatform-gateway")
public interface UserLoginFeignClient {

    //校验验证码
    @RequestMapping(value = "/user/valiCode",method = RequestMethod.POST,consumes = "application/json")
    ResultInfo<String> valiCode(@RequestBody UserLoginQuery userLoginQuery)throws Exception;


    //分页条件查询用户列表
    @RequestMapping(value = "/user/pageUser", method = RequestMethod.POST, consumes="application/json")
    public ResultInfo<Page<CltUserAndLogin>> readUserInfo(@RequestBody UserAndLoginQuery userAndLoginQuery);

    //编辑用户详细信息
    @RequestMapping(value = "/user/updateUser",method = RequestMethod.POST,consumes="application/json")
    public ResultInfo<Integer> updateCluUser(@RequestBody UserAndLoginQuery userAndLoginQuery);

    //查询用户的详细信息
    @RequestMapping(value = "/user/findById", method = RequestMethod.POST, consumes="application/json")
    public ResultInfo<CltUserAndLogin> findById(@RequestBody UserAndLoginQuery userAndLoginQuery);

    //用户的启用/禁用

    @RequestMapping(value = "/user/disEnableUser", method = RequestMethod.POST, consumes="application/json")
    public ResultInfo<Integer> disEnableUser(@RequestBody UserAndLoginQuery userAndLoginQuery);
    //用户登录
    @RequestMapping(value = "/user/login",method = RequestMethod.POST,consumes = "application/json")
    ResultInfo<CltUserLogin> userLogin(@RequestBody UserLoginQuery userLoginQuery);

    //密码修改
    @RequestMapping(value = "/user/updatePassword",method = RequestMethod.PUT)
    ResultInfo<String> updatePassword(@RequestBody UserUpdatePwd userUpdatePwd);
    //密码重置
    @RequestMapping(value = "/user/resetPassword",method = RequestMethod.POST)
    ResultInfo<String> resetPassword(@RequestBody UserLoginQuery userLoginQuery);

    //根据用户id查询出用户拥有的模块信息
    @RequestMapping(value = "/user/findFunc/{userId}",method = RequestMethod.GET)
    List<CltFunc> findByUserId(@PathVariable("userId") String userId);

    //根据用户登录号查用户信息带权限
    @RequestMapping(value = "/user/findOneWithRolesByLoginNo/{username}",method = RequestMethod.GET, consumes="application/json")
    CltUserLogin findOneWithRolesByLoginNo(@PathVariable("username") String username);

    //根据用户ID查询登陆表信息
    @RequestMapping(value = "/user/queryUserLoginById",method = RequestMethod.POST,consumes="application/json")
    CltUserLogin queryUserLoginById(@RequestBody CltUserLoginQuery cltUserLoginQuery);

}
