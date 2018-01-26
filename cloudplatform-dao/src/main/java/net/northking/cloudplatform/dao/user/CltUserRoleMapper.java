package net.northking.cloudplatform.dao.user;


import net.northking.cloudplatform.dao.base.BaseDao;
import net.northking.cloudplatform.domain.user.CltUserRole;
import net.northking.cloudplatform.domain.user.CltUserRoleExample;
import net.northking.cloudplatform.dto.auth.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component

public interface CltUserRoleMapper  extends BaseDao<CltUserRole, CltUserRoleExample, String> {

    List<CltUserRole> selectByUserId(String userId);

    int  deleteByRoleIdAndUserId(@Param("roleId") String roleId, @Param("userId") String userId);

    CltUserRole selectByRoleIdAndUserId(@Param("roleId") String roleId, @Param("userId") String userId);

    int countByRoleAndUserId(@Param("roleId") String roleId, @Param("userId") String userId);
    CltUserRole queryByRoleAndUserId(@Param("roleId") String roleId, @Param("userId") String userId);

    List<CltUserRole> queryUserRoleByRoleId(@Param("roleId") String roleId);
    //根据用户id删除多个角色信息
    int deleteRoleListByUserId(String userId);


}