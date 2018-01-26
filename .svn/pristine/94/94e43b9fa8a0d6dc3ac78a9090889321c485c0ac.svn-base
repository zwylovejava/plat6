package net.northking.cloudplatform.service;


import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.dao.base.BaseService;
import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.domain.user.CltFuncRole;
import net.northking.cloudplatform.domain.user.CltFuncRoleExample;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.query.user.FuncRoleQuery;

/**
 * @Title: 功能关联逻辑类
 * @Description:
 * @Company: Northking
 * @Author: suny
 * @CreateDate: 2017/11/14
 * @UpdateUser:
 * @Version:0.1
 */
public interface FuncRoleService extends BaseService<CltFuncRole, CltFuncRoleExample, String> {



     // 根据角色ID查询所有的功能信息
    Page<CltFunc> queryByRoleId(String roleId)throws Exception;

     //根据角色ID批量删除功能角色关联
    String deleteFuncRoleByfunRoleIds(FuncRoleQuery funcRoleQuery)throws Exception;

     //批量添加角色功能关系
    Integer addFuncRoles(FuncRoleQuery funcRoleQuery)throws Exception;


}
