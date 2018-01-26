package net.northking.cloudplatform.service.user;
import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.domain.user.CltUser;
import net.northking.cloudplatform.domain.user.CltUserAndLogin;
import net.northking.cloudplatform.domain.user.CltUserLogin;
import net.northking.cloudplatform.query.user.UserAndLoginQuery;
import net.northking.cloudplatform.query.user.UserUpdatePwd;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
public interface UserService {

    //添加用户

    ResultInfo<CltUserAndLogin> addUserInfo (UserAndLoginQuery userAndLoginQuery)throws Exception;

    //修改用户信息
    ResultInfo<Integer> updateCltUser(UserAndLoginQuery userAndLoginQuery)throws Exception;

    //批量删除用户
    ResultInfo<String> deleteUsersByUserIds(UserAndLoginQuery userAndLoginQuery)throws Exception;

    //用户启用/禁用
    ResultInfo<Integer> disEnableUser(UserAndLoginQuery userAndLoginQuery)throws Exception;

    //查询用户详细信息  根据userId
    ResultInfo<CltUserAndLogin> queryUserInfoByUserId(UserAndLoginQuery userAndLoginQuery)throws Exception;

    //查询客户下所有用户列表  （支持模糊查询）
    ResultInfo<Page<CltUserAndLogin>> queryAllUserList(UserAndLoginQuery userAndLoginQuery)throws Exception;

    //查询机构下用户列表(管理员除外 支持模糊查询)
    ResultInfo<Page<CltUserAndLogin>> queryLikeUserListByOrgId(UserAndLoginQuery userAndLoginQuery)throws Exception;

    //查询所有测试主管列表
    ResultInfo<Page<CltUserAndLogin>> queryAllTestMangerList(UserAndLoginQuery userAndLoginQuery)throws Exception;

    //根据角色代码查询用户列表
    ResultInfo<Page<CltUserAndLogin>> queryUserByRoleCode(UserAndLoginQuery userAndLoginQuery)throws Exception;

    //查询出所有平台用户
    ResultInfo<Page<CltUserAndLogin>> queryUserByUserType(UserAndLoginQuery userAndLoginQuery)throws Exception;

    //查询用户的详细信息(从token里面拿出UserId查询)
    ResultInfo<CltUserAndLogin> queryUserByToken(UserAndLoginQuery userAndLoginQuery)throws Exception;

    //用户密码修改
    ResultInfo<String> updateUserPassword(UserUpdatePwd userUpdatePwd) throws Exception;

    //批量修改用户的机构id
    ResultInfo<String> updateOrgIdByUserIds(UserAndLoginQuery userAndLoginQuery) throws Exception;

    //根据登录号更新登录信息
    ResultInfo<Integer> updateCltUserLoginByLoginNo(UserAndLoginQuery userAndLoginQuery) throws Exception;

    //查询所有启用用户
    ResultInfo<Page<CltUserAndLogin>> queryUserListEnable(UserAndLoginQuery userAndLoginQuery)throws Exception;

    //根据登录号查询出用户信息
    ResultInfo<CltUserLogin> queryCltUserLoginByLoginNo(UserAndLoginQuery userAndLoginQuery)throws  Exception;

    //检验用户登录名是否重复
    ResultInfo<Boolean> checkUserLoginNo(UserAndLoginQuery userAndLoginQuery)throws  Exception;



}
