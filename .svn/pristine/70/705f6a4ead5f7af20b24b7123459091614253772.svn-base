package net.northking.cloudplatform.feign.project;


import net.northking.cloudplatform.domain.user.CltProjectTeam;
import net.northking.cloudplatform.query.project.CltProjectTeamQuery;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "cloudplatform-gateway")
public interface ProjectTeamFeignClient {

    //新增项目团队
    @RequestMapping(value = "/project/createTeam",method = RequestMethod.POST,consumes = "application/json")
    ResultInfo<Integer> createTeam(@RequestBody List<CltProjectTeamQuery> cltProjectTeamQuery);

    //移出团队
    @RequestMapping(value = "/project/removeUserFromPro",method = RequestMethod.POST,consumes = "application/json")
    ResultInfo<Integer> removeUserByIds(@RequestBody List<CltProjectTeamQuery> cltProjectTeamQuery);

    //根据项目ID,用户ID,角色ID查询团队组建表
    @RequestMapping(value = "/project/queryTeamByProIdUserIdAndRoleId",method = RequestMethod.POST,consumes = "application/json")
    ResultInfo <CltProjectTeam> queryTeamByProIdUserIdAndRoleId(@RequestBody CltProjectTeamQuery cltProjectTeamQuery);

    //根据用户ID,角色ID查询团队组建表记录数
    @RequestMapping(value = "/project/countTeamByUserIdAndRoleId",method = RequestMethod.POST,consumes = "application/json")
    ResultInfo <Integer> countTeamByUserIdAndRoleId(@RequestBody CltProjectTeamQuery cltProjectTeamQuery);




}
