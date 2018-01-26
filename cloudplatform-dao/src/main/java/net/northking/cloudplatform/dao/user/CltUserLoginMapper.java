package net.northking.cloudplatform.dao.user;


import net.northking.cloudplatform.dao.base.BaseDao;
import net.northking.cloudplatform.domain.user.CltUserAndLogin;
import net.northking.cloudplatform.domain.user.CltUserLogin;
import net.northking.cloudplatform.domain.user.CltUserLoginExample;
import net.northking.cloudplatform.query.user.UserAndLoginQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CltUserLoginMapper extends BaseDao<CltUserLogin, CltUserLoginExample, String> {

    CltUserLogin findUserByPd(@Param("username") String username, @Param("pwd") String pwd);

    String selectUserIdByName(@Param("loginName") String loginName, @Param("chnName") String chnName);

    Integer updatePassword(CltUserLogin userLogin);

    CltUserLogin findUserByLoginNo(@Param("loginNo") String loginNo);

    List<CltUserAndLogin> findAll(@Param("userAndLoginQuery") UserAndLoginQuery userAndLoginQuery);

    List<CltUserAndLogin> queryUserListEnable(@Param("userAndLoginQuery")UserAndLoginQuery userAndLoginQuery);

    CltUserAndLogin findUserById(String userId);
    //根据机构Id查询查询用户列表
    List<CltUserAndLogin>findUserByOrgId(@Param("userAndLoginQuery") UserAndLoginQuery userAndLoginQuery);

     CltUserLogin findOneWithRolesByLoginNo(String loginNo);

    //CltUserLogin findOneWithRolesAndFuncsByLoginNo(String loginNo);


    //根据项目id查询用户详情
    List<CltUserLogin> queryUserLoginByProId(String proId);

    //根据项目id获取测试经理的详细信息
    UserAndLoginQuery queryTestManagerInfo(String proId);


   //根据角色代码查询用户列表
    List<CltUserAndLogin> queryUserListByRoleCode(@Param("userAndLoginQuery")  UserAndLoginQuery userAndLoginQuery);

    //根据用户类型查询用户列表
    List<CltUserAndLogin> queryUserListByUserType(@Param("userAndLoginQuery")  UserAndLoginQuery userAndLoginQuery);

  //根据用户登录号修改用户的登录信息
    int updateUserLoginByLoginNo(CltUserLogin cltUserLogin);

    //根据登录号查询用户登录信息
    CltUserLogin queryCltUserLoginByLoginNo(String loginNo);


}