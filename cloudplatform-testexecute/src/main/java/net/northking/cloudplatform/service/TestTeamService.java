package net.northking.cloudplatform.service;

import net.northking.cloudplatform.domain.testexecute.CltTestTeam;
import net.northking.cloudplatform.query.testexecute.TestTeamQuery;

import java.util.List;

/**
 * @Title:
 * @Description: CltTestTeamService接口
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-12-20 10:43
 * @UpdateUser:
 * @Version:0.1
 */
public interface TestTeamService {
    /**
     * @Author:HBH
     * @Description: 组建测试团队
     * @Date:10:44 2017/12/20
     * @param1:
     * @param2:
     * @return:
     */
    Integer creatTestTeam(TestTeamQuery testTeamQuery)throws Exception;


    /**
     * @Author:HBH
     * @Description: 查询任务下的所有用户
     * @Date:14:49 2017/12/21
     * @param1:
     * @param2:
     * @return:
     */
     List<CltTestTeam> queryUserIdsByJobId(TestTeamQuery testTeamQuery)throws Exception;

     /**
      * @Author:HBH
      * @Description: 批量删除测试团队表
      * @Date:16:21 2017/12/21
      * @param1:
      * @param2:
      * @return:
      */
     Integer delteTestTeamBatch(TestTeamQuery testTeamQuery)throws Exception;


    Integer deleteTestTeamByJobIdAndUserId(TestTeamQuery testTeamQuery)throws Exception;
}
