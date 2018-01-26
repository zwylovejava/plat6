package net.northking.cloudplatform.service;


import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.dao.base.BaseService;
import net.northking.cloudplatform.domain.user.CltUserRole;
import net.northking.cloudplatform.domain.user.CltUserRoleExample;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.query.user.UserRoleQuery;

import java.util.List;

/**
 * @Title: 用户角色关联逻辑类
 * @Description:
 * @Company: Northking
 * @Author: suny
 * @CreateDate: 2017/11/14
 * @UpdateUser:
 * @Version:0.1
 */
public interface UserRoleService extends BaseService<CltUserRole, CltUserRoleExample, String> {

    /**
     * 用户角色关联
     * @param cltUserRole
     */
    String addUserRole(CltUserRole cltUserRole) throws GlobalException;

    /**
     * 删除用户角色关联
     * @param userRoleId
     */
    Integer deleteUserRole(String userRoleId) throws GlobalException;

    /**
     * 根据用户编号查询所有的角色信息
     * @param userId
     * @return
     **/
    Page<CltUserRole> queryByUserId(String userId)throws Exception;


    /**批量删除用户角色表*/
    String deleteUserRoleByUserRoleIds(UserRoleQuery userRoleQuery)throws Exception;



    /**批量增加用户角色表*/
    Integer addUserRoles(List<UserRoleQuery> userRoleQueries)throws Exception;

    /**根据用户ID和角色ID删除用户角色表*/

    Integer deleteByRoleIdAndUserId(UserRoleQuery userRoleQuery)throws Exception;


    /**更新用户角色表*/
    Integer updateUserRoles(UserRoleQuery userRoleQuery)throws Exception;


}
