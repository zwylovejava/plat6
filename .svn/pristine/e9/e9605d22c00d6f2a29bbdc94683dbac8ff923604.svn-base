package net.northking.cloudplatform.service;

import net.northking.cloudplatform.domain.project.CltProject;
import net.northking.cloudplatform.domain.project.CltProjectUserInfo;
import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.query.project.CltProjectTeamQuery;
import net.northking.cloudplatform.query.project.ProjectQuery;


import java.util.List;
import java.util.Map;

/**
 * @Title:
 * @Description: 项目管理service接口
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-11-28 10:42
 * @UpdateUser:
 * @Version:0.1
 */
public interface ProjectService{

    /**
     * 项目列表权限控制
     * @param
     * @return
     */
    List<CltProject> CltProjectListInfo();

    // 根据项目ID查询项目详情
    CltProject queryProjectInfoByProId(CltProject cltProject);

    //根据角色ID查询出项目空间左侧菜单   管理员
    List<CltFunc> getFuncListByAdminRoleId(Map<String, Object> paramDataMap);

    //根据项目ID和用户ID查询出项目空间左侧菜单   普通用户
    List<CltFunc> getFuncListByProIdAndUserId(Map<String, Object> paramDataMap);


    //添加项目
    Integer saveProject(ProjectQuery projectQuery)throws Exception;

    //查询所有的项目

    List<CltProject>   findAllProject(String custId)throws Exception;

     //编辑项目的信息

    Integer updateCltProject(ProjectQuery projectQuery)throws Exception;


    //启用和禁用的功能
    Integer disEnableproject(CltProject cltProject)throws Exception;


    //根据用户角色查询项目列表

    List<CltProject> findProjectByUserId(String userId)throws Exception;


    //查询项目下所有的用户与角色
    List<CltProjectUserInfo> queryUserAndRoleByProId(CltProjectTeamQuery cltProjectTeamQuery);

    //查询客户下的所有项目
    List<CltProject> queryCltProjectByCustId( ProjectQuery projectQuery);
}
