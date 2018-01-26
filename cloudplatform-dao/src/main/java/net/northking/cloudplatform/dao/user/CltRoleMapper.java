package net.northking.cloudplatform.dao.user;


import net.northking.cloudplatform.dao.base.BaseDao;
import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.domain.user.CltRole;
import net.northking.cloudplatform.domain.user.CltRoleExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CltRoleMapper  extends BaseDao<CltRole, CltRoleExample, String> {

    //查询所有角色(包括管理员角色)
    List<CltRole>  selectAllRole();

    //查询所有角色(不包括管理员角色)
    List<CltRole>  queryAllCltRoleIsNotSuper();

    CltRole selectRoleIdByRoleCode(@Param("roleCode") String roleCode);

    List<CltFunc> queryFuncRoleId(String roleId);
}