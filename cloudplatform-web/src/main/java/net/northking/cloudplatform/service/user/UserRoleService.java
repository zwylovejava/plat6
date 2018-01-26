package net.northking.cloudplatform.service.user;

import net.northking.cloudplatform.query.user.UserRoleQuery;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
public interface UserRoleService {

    //批量新增用户角色
    ResultInfo<Integer> addUserRoles(List<UserRoleQuery> userRoleQueryList)throws Exception ;

    //批量删除用户角色
    ResultInfo<String>   deleteUserRoles(UserRoleQuery userRoleQuery)throws Exception;

    //单个删除用户角色
    ResultInfo<Integer> deleteUserRoleByUserIdAndRoleId(UserRoleQuery userRoleQuery)throws Exception;

    //修改用户角色信息
    ResultInfo<Integer> updateUserRoleInfo(UserRoleQuery userRoleQuery)throws Exception;

}
