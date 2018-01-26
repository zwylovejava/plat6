package net.northking.cloudplatform.feign.testexecute;


import net.northking.cloudplatform.domain.testexecute.CltTestTeam;
import net.northking.cloudplatform.query.testexecute.TestTeamQuery;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Title:
 * @Description: 测试团队Feign客户端
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-12-20 11:44
 * @UpdateUser:
 * @Version:0.1
 */
@FeignClient(name = "cloudplatform-gateway")
public interface TestTeamFeignClient {
    //创建测试团队
    @RequestMapping(value = "/testexecute/createTestTeam", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<Integer> createTestTeam(@RequestBody TestTeamQuery testTeamQuery );


    //查询任务下的用户ids
    @RequestMapping(value = "/testexecute/queryUserIdsByJobId", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<List<CltTestTeam>> queryUserIdsByJobId(@RequestBody TestTeamQuery testTeamQuery );



    //批量删除测试团队表
    @RequestMapping(value = "/testexecute/delteTestTeamBatch", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<Integer> delteTestTeamBatch(@RequestBody TestTeamQuery testTeamQuery );


    //移除测试团队下的人
    @RequestMapping(value = "/testexecute/deleteTestTeamByJobIdAndUserIds", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<Integer> deleteTestTeamByJobIdAndUserId(@RequestBody TestTeamQuery testTeamQuery);

}
