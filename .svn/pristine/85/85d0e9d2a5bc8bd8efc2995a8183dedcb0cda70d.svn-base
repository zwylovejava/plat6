package net.northking.cloudplatform.dao.user;


import net.northking.cloudplatform.dao.base.BaseDao;
import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.domain.user.CltFuncExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CltFuncMapper extends BaseDao<CltFunc, CltFuncExample, String> {

    //根据用户id查询出用户拥有的模块信息
    List<CltFunc> fingFuncByUserId(String userId);

    //根据用户id查询出用户拥有的模块信息
    List<CltFunc> fingFuncByUserIdAndParent(@Param("userId") String userId, @Param("parentFuncId") String parentFuncId);

    List<CltFunc> selectByRoleId(String roled);

    //根据用户id查询功能信息
    List<CltFunc> selectFuncByUserId(String userId);

    List<CltFunc> selectAllFuncInfo();

    //查询项目下用户的功能菜单
    List<CltFunc> queryFuncListByAdminRoleId(@Param("roleId") String roleId);

    //查询项目下用户的功能菜单
    List<CltFunc> queryFuncListByProIdAndUserId(@Param("userId") String userId, @Param("proId") String proId);

}