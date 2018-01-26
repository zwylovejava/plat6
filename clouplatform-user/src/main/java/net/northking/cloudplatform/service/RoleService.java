package net.northking.cloudplatform.service;



import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.dao.base.BaseService;
import net.northking.cloudplatform.domain.user.CltRole;
import net.northking.cloudplatform.domain.user.CltRoleExample;
import net.northking.cloudplatform.query.user.RoleQuery;

import java.util.List;

/**
 * Created by laodeng on 2017/11/21.
 */
public interface RoleService  extends BaseService<CltRole, CltRoleExample, String> {

    /**
     * 增加角色
     * @param cltRole
     * @return
     */
    Integer addCltRoleInfo(CltRole cltRole);





    /**
     * 更新角色信息
     * @param cltRole
     * @return
     */
    Integer updateCltRoleInfo(CltRole cltRole);


    /**
     * 导入角色execl
     */
    void importRoleExcelInfo(RoleQuery roleQuery);

    /**
     * 查询项目下的业务角色和所有的公共角色
     * @return
     */
    List<CltRole> queryCltRolesInfo(RoleQuery roleQuery) throws Exception;


    //查询所有角色列表(包括角色对用的功能列表/包括管理员的角色)
      Page<CltRole> queryAllCltRole(RoleQuery roleQuery) throws Exception;


    //查询除管理员角色的所有的用户的列表
    List<CltRole> queryAllCltRoleIsNotSuper() throws Exception;
    /**
     * 通过角色id查询角色信息
     * @param roleQuery
     * @return
     */
    CltRole selectCltRoleByRoleId(RoleQuery roleQuery);


    /**
     * 批量删除角色
     * @param roleQuery
     * @return
     */
    String deleteRolesByRoleIds(RoleQuery roleQuery);


    /**
     *
     * 通过角色代码查询角色
     *
     * */

    CltRole selectRoleIdByRoleCode(String roleCode)throws Exception;


}
