package net.northking.cloudplatform.feign.user;

import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.domain.user.CltFuncRole;
import net.northking.cloudplatform.query.user.FuncRoleQuery;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by HBH on 2017/11/10.
 */
@FeignClient(name = "cloudplatform-gateway")
public interface FuncRoleFeignClient {
    //批量添加功能角色
    @RequestMapping(value = "/user/addFuncRoles", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<Integer> addFuncRoles(@RequestBody FuncRoleQuery funcRoleQuery);

   //根据角色ID查询所属功能列表
    @RequestMapping(value = "/user/queryFuncListByRoleId", method =RequestMethod.POST ,consumes="application/json")
    ResultInfo<Page<CltFuncRole>> queryFuncListByRoleId(@RequestBody FuncRoleQuery funcRoleQuery);

    //批量删除功能角色
    @RequestMapping(value = "/user/deleteFuncRoleByfunRoleIds", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<String> deleteFuncRoleByfunRoleIds(@RequestBody FuncRoleQuery funcRoleQuery);


}
