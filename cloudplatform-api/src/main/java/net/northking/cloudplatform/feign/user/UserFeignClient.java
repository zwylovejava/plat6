package net.northking.cloudplatform.feign.user;


import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.domain.user.CltUserAndLogin;
import net.northking.cloudplatform.domain.user.CltUserLogin;
import net.northking.cloudplatform.query.user.UserAndLoginQuery;
import net.northking.cloudplatform.query.user.UserLoginQuery;
import net.northking.cloudplatform.query.user.UserUpdatePwd;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by HBH on 2017/11/10.
 */
@FeignClient(name = "cloudplatform-gateway")
public interface UserFeignClient {
    //添加用户
    @RequestMapping(value = "/user/saveUser", method = RequestMethod.POST, consumes="application/json")
  ResultInfo<CltUserAndLogin> saveUser(@RequestBody UserAndLoginQuery userAndLoginQuery);

    //分页条件查询用户列表
    @RequestMapping(value = "/user/pageUser", method = RequestMethod.POST, consumes="application/json")
  ResultInfo<Page<CltUserAndLogin>> queryAllUserList(@RequestBody UserAndLoginQuery userAndLoginQuery);

    //查询已经启用的用户的列表
    @RequestMapping(value = "/user/queryUserListEnable", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<Page<CltUserAndLogin>> queryUserListEnable(@RequestBody UserAndLoginQuery userAndLoginQuery);


    //编辑用户详细信息
    @RequestMapping(value = "/user/updateUser",method = RequestMethod.POST,consumes="application/json")
    ResultInfo<Integer> updateCluUser(@RequestBody UserAndLoginQuery userAndLoginQuery);

    //查询用户的详细信息
    @RequestMapping(value = "/user/findById", method = RequestMethod.POST, consumes="application/json")
   ResultInfo<CltUserAndLogin> queryUserInfoByUserId(@RequestBody UserAndLoginQuery userAndLoginQuery);

    //用户的启用/禁用

    @RequestMapping(value = "/user/disEnableUser", method = RequestMethod.POST, consumes="application/json")
   ResultInfo<Integer> disEnableUser(@RequestBody UserAndLoginQuery userAndLoginQuery);
    //用户登录
    @RequestMapping(value = "/user/login",method = RequestMethod.POST,consumes = "application/json")
    ResultInfo<CltUserLogin> userLogin(@RequestBody UserLoginQuery userLoginQuery);
    //生成验证码
    @RequestMapping(value = "/user/getValiImage",method = RequestMethod.GET)
    void getValiImage();
    //校验验证码
    @RequestMapping(value = "/user/valiCode",method = RequestMethod.POST)
    ResultInfo<String> valiCode(@RequestBody UserLoginQuery userLoginQuery);

    //密码修改
    @RequestMapping(value = "/user/updatePassword",method = RequestMethod.POST,consumes = "application/json")
    ResultInfo<String> updatePassword(@RequestBody @Validated UserUpdatePwd userUpdatePwd);
    //密码重置
    @RequestMapping(value = "/user/resetPassword",method = RequestMethod.POST,consumes = "application/json")
    ResultInfo<String> resetPassword(@RequestBody UserLoginQuery userLoginQuery);

    //根据用户id查询出用户拥有的模块信息
    @RequestMapping(value = "/user/findFunc/{userId}",method = RequestMethod.GET)
    List<CltFunc> findByUserId(@PathVariable("userId") String userId);

    //批量修改用户的机构id
    @RequestMapping(value = "/user/updateOrgIdByUserIds",method = RequestMethod.POST,consumes = "application/json")
    ResultInfo<String> updateOrgIdByUserIds(@RequestBody UserAndLoginQuery userAndLoginQuery);

    //批量删除用户
    @RequestMapping(value = "/user/deleteUsersByUserIds",method = RequestMethod.POST,consumes = "application/json")
    ResultInfo<String> deleteUsersByUserIds(@RequestBody UserAndLoginQuery userAndLoginQuery);

    //根据角色代码查询用户列表
    @RequestMapping(value = "/user/queryUserListByRoleCode",method = RequestMethod.POST,consumes = "application/json")
    ResultInfo<Page<CltUserAndLogin>> queryUserListByRoleCode(@RequestBody UserAndLoginQuery userAndLoginQuery);

    //根据用户类型查询用户列表
    @RequestMapping(value = "/user/queryUserListByUserType",method = RequestMethod.POST,consumes = "application/json")
    ResultInfo<Page<CltUserAndLogin>> queryUserListByUserType(@RequestBody UserAndLoginQuery userAndLoginQuery);


    //根据机构ID查询用户列表
    @RequestMapping(value = "/user/queryUserListByOrgId",method = RequestMethod.POST,consumes = "application/json")
    ResultInfo<Page<CltUserAndLogin>> queryUserListByOrgId(@RequestBody UserAndLoginQuery userAndLoginQuery);

    //根据登录号更新用户登录信息
    @RequestMapping(value = "/user/updateCltUserLoginByLoginNo",method = RequestMethod.POST,consumes = "application/json")
    ResultInfo<Integer> updateCltUserLoginByLoginNo(@RequestBody UserAndLoginQuery userAndLoginQuery);

    //根据登录号查询用户登录信息
    @RequestMapping(value = "/user/queryCltUserLoginByLoginNo",method = RequestMethod.POST,consumes = "application/json")
    ResultInfo<CltUserLogin> queryCltUserLoginByLoginNo(@RequestBody UserAndLoginQuery userAndLoginQuery);

    //查询用户登录号的唯一性
    @RequestMapping(value = "/user/checkUserLoginNo",method = RequestMethod.POST,consumes = "application/json")
    ResultInfo<Boolean> checkUserLoginNo(@RequestBody UserAndLoginQuery userAndLoginQuery);



}
