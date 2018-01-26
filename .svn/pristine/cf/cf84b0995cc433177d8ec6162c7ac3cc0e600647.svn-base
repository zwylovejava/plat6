package net.northking.cloudplatform.dao.user;


import net.northking.cloudplatform.dao.base.BaseDao;
import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.domain.user.CltFuncRole;
import net.northking.cloudplatform.domain.user.CltFuncRoleExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CltFuncRoleMapper extends BaseDao<CltFuncRole, CltFuncRoleExample, String> {

    List<CltFunc> selectByRoleId(String roleId);
    //根据角色ID查询所有功能信息
    List<CltFunc> queryFuncListByRoleId(String roleId);
    //根据角色id删除多个功能信息
    int deleteFuncListByRoleIds(String roleId);
}