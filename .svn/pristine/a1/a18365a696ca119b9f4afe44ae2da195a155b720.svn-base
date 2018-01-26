package net.northking.cloudplatform.service.user;

import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.domain.user.CltFuncRole;
import net.northking.cloudplatform.query.user.FuncRoleQuery;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
public interface FuncRoleService {
     //批量添加功能角色关系
     ResultInfo<Integer> addCltFuncRolesInfo(FuncRoleQuery funcRoleQuery) throws Exception;
     //批量删除功能角色关系
     ResultInfo<Integer> deleteFuncRoleByfunRoleIdsInfo(FuncRoleQuery funcRoleQuery) throws Exception;
     //根据功能角色ID查询所属功能列表
     ResultInfo<Page<CltFuncRole>>   queryFuncListByRoleId(FuncRoleQuery funcRoleQuery) throws Exception;



}