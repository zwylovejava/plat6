package net.northking.cloudplatform.service.testexecute;

import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.domain.testexecute.CltTestTeam;
import net.northking.cloudplatform.domain.user.CltUserAndLogin;
import net.northking.cloudplatform.query.testexecute.TestTeamQuery;
import net.northking.cloudplatform.query.user.UserRoleQuery;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
public interface TestTeamService {

    //批量新增测试团队
    ResultInfo<Integer> addTestTeam(TestTeamQuery testTeamQuery)throws Exception ;

    //根据任务ID查询出用户详细列表（通过拿到queryUserIdsByJobId接口中的userId去查询出用户详情列表信息）
    Page<CltUserAndLogin> queryUserListByJobId(TestTeamQuery testTeamQuery)throws Exception;

    //根据任务ID查询出userIdList （CLT_TEST_TEAM）
    ResultInfo<List<CltTestTeam>> queryUserIdsByJobId(TestTeamQuery testTeamQuery )throws Exception;

    //根据任务ID何用户移除用户
    ResultInfo<Integer> deleteTestTeamByJobIdAndUserId(TestTeamQuery testTeamQuery);
}
