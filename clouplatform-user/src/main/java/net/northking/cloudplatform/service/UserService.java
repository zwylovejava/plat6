package net.northking.cloudplatform.service;


import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.dao.base.BaseService;
import net.northking.cloudplatform.domain.user.CltUser;
import net.northking.cloudplatform.domain.user.CltUserAndLogin;
import net.northking.cloudplatform.domain.user.CltUserLogin;
import net.northking.cloudplatform.domain.user.CltUserLoginExample;
import net.northking.cloudplatform.query.user.CltUserLoginQuery;
import net.northking.cloudplatform.query.user.UserAndLoginQuery;

/**
 * Created by HBH on 2017/11/11.
 */
public interface UserService extends BaseService<CltUserLogin, CltUserLoginExample, String> {

    //查询用户列表(查询除管理员之外的所有用户)
    Page<CltUserAndLogin> queryUserList(UserAndLoginQuery userAndLoginQuery)throws Exception;

    //查询已经启用的用户的列表
    Page<CltUserAndLogin> queryUserListEnable(UserAndLoginQuery userAndLoginQuery)throws Exception;
    //查询用户的详细信息
    CltUserAndLogin findUserById(String userId)throws Exception;

    //添加一个用户
    CltUserAndLogin  saveUser(UserAndLoginQuery userAndLoginQuery)throws Exception;

    //编辑用户信息(同时更新两张表的信息)
    Integer updateUser(UserAndLoginQuery userAndLoginQuery)throws Exception;

    //用户的启用/禁用
    Integer EnableDisableUser(CltUserLogin userLogin)throws Exception;


    //根据用户表主键查询用户
    CltUser findCltUserById(String userId);


    //检查用户登录号的唯一性
    Boolean checkUserLoginNo(String loginNo)throws Exception;


    //根据机构Id查询用户
    Page<CltUserAndLogin> queryUserListByOrgId(UserAndLoginQuery userAndLoginQuery)throws Exception ;


  //批量删除用户
    String deleteUsersBatch(UserAndLoginQuery userAndLoginQuery)throws Exception;


   //根据ids批量修改机构id

    String updateOrgIdByUserIds(UserAndLoginQuery userAndLoginQuery)throws Exception;


    //根据角色代码查询用户列表

    Page<CltUserAndLogin> queryUserListByRoleCode(UserAndLoginQuery userAndLoginQuery)throws Exception;


    //根据用户类型查询用户列表

    Page<CltUserAndLogin> queryUserListByUserType(UserAndLoginQuery userAndLoginQuery)throws Exception;

    //根据登录号修改用户登录表

    Integer updateCltUserLoginByLoginNo(UserAndLoginQuery userAndLoginQuery)throws Exception;

   //根据登录号查询用户登录信息
    CltUserLogin queryCltUserLoginByLoginNo(UserAndLoginQuery userAndLoginQuery)throws Exception;




    //---------------------------------------------------



    //用户登录
    CltUserLogin login(String username, String pwd);
    //根据用户id去修改密码
    void updatePassword(String userId, String newpwd);
    //重置密码
    void resetPassword(String loginName, String email, String chnName);

    CltUserLogin findOneWithRolesByLoginNo(String loginNo)throws Exception;

    CltUserLogin queryUserLoginById(CltUserLoginQuery cltUserLoginQuery);
}
