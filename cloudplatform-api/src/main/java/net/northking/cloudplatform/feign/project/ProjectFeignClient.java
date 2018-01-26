package net.northking.cloudplatform.feign.project;


import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.domain.project.CltProject;
import net.northking.cloudplatform.domain.project.CltProjectUserInfo;
import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.query.project.CltProjectTeamQuery;
import net.northking.cloudplatform.query.project.ProjectQuery;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by sunyan on 2017/12/5.
 */
@FeignClient(name = "cloudplatform-gateway")
public interface ProjectFeignClient {

    //查询项目列表
    @RequestMapping(value = "/project/cltProjectListInfo", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<List<CltProject>> queryProjectListByUserId(ProjectQuery projectQuery);

    //新增项目
    @RequestMapping(value = "/project/saveProject", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<Integer> addProjectInfo(@RequestBody ProjectQuery projectQuery);

    //修改项目
    @RequestMapping(value = "/project/updateProject", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<Integer> updateProjectInfo(@RequestBody ProjectQuery projectQuery);

    //删除项目
    @RequestMapping(value = "/project/deleteProject", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<Integer> deleteProjectInfo(@RequestBody ProjectQuery projectQuery);

    //查看项目详情
    @RequestMapping(value = "/project/queryProjectInfoByProId", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<CltProject> queryProjectInfoByProId(@RequestBody ProjectQuery projectQuery);

    //项目启用禁用 disEnableproject
    @RequestMapping(value = "/project/disEnableproject", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<Integer> disenableProjectInfo(@RequestBody ProjectQuery projectQuery);

    //根据用户ID查询项目下所有的功能列表
    @RequestMapping(value = "/project/queryFuncListByProAndUserId", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<List<CltFunc>> queryFuncListByProAndUserId(@RequestBody ProjectQuery projectQuery);

    //根据项目ID去查询所有用户的角色和机构
    @RequestMapping(value = "/project/queryUserAndRoleByProId", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<Page<CltProjectUserInfo>> queryUserAndRoleByProId(@RequestBody CltProjectTeamQuery cltProjectTeamQuery);

    //查询客户下的所有项目
    @RequestMapping(value = "/project/queryCltProjectByCustId", method = RequestMethod.POST, consumes="application/json")
    ResultInfo< List<CltProject>> queryCltProjectByCustId(@RequestBody ProjectQuery projectQuery);




}
