package net.northking.cloudplatform.controller.testexecute;


import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.constants.CommonConstants;
import net.northking.cloudplatform.domain.user.CltRole;
import net.northking.cloudplatform.domain.user.CltUserAndLogin;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.query.testexecute.TestTeamQuery;
import net.northking.cloudplatform.query.user.RoleQuery;
import net.northking.cloudplatform.query.user.UserRoleQuery;
import net.northking.cloudplatform.result.ResultCode;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.testexecute.TestTeamService;
import net.northking.cloudplatform.service.user.RoleService;
import net.northking.cloudplatform.service.user.UserRoleService;
import net.northking.cloudplatform.utils.CltUtils;
import net.northking.cloudplatform.utils.ParamVerifyUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Title:
 * @Description:测试团队控制层
 * @Company: Northking
 * @Author: suny
 * @CreateDate: 2017-12-07 17:04
 * @UpdateUser:
 * @Version:0.1
 */
@RestController
public class TestTeamContrller {
    @Autowired
    TestTeamService testTeamService;

    @Autowired
    RoleService roleService;

    @Autowired
    UserRoleService userRoleService;

    private final static Logger logger = LoggerFactory.getLogger(JobController.class);

    //批量增加/修改/删除测试团队信息
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    @PostMapping("/addCltTestTeams")
    public ResultInfo<Integer> addCltTestTeams(@RequestBody TestTeamQuery testTeamQuery) throws Exception {

        CltUtils.printStartInfo(testTeamQuery, "Controller addCltTestTeams");

        long startTime = System.currentTimeMillis();

        String userIds[] = testTeamQuery.getUserIds();

        List<UserRoleQuery> userRoleQueryList = new ArrayList<UserRoleQuery>();

        //根据角色CODE查询角色信息
        RoleQuery roleQuery = new RoleQuery();
        roleQuery.setRoleCode(CommonConstants.ROLE_TESTER);
        roleQuery.setAccess_token(testTeamQuery.getAccess_token());
        ResultInfo<CltRole> roleResultInfo = roleService.queryCltRoleByRoleCode(roleQuery);

        //新增用户角色
        for (int i = 0; i <userIds.length ; i++) {
            String userId = userIds[i];
            UserRoleQuery userRoleQuery = new UserRoleQuery();
            userRoleQuery.setUserId(userId);
            userRoleQuery.setRoleId(roleResultInfo.getResultData().getRoleId());
            userRoleQuery.setAccess_token(testTeamQuery.getAccess_token());
            userRoleQueryList.add(userRoleQuery);
        }
        userRoleService.addUserRoles(userRoleQueryList);

        //新增测试团队信息
        testTeamService.addTestTeam(testTeamQuery);

        CltUtils.printEndInfo(roleResultInfo, " Controller addCltTestTeams", startTime);

        return  new ResultInfo<>(ResultCode.SUCCESS,1);

    }

    //根据任务ID查询出所有用户列表
    @PostMapping("/queryUserListByJobId")
    public ResultInfo<Page<CltUserAndLogin>> queryUserListByJobId(@RequestBody TestTeamQuery testTeamQuery) throws Exception {

        CltUtils.printStartInfo(testTeamQuery, "Controller queryUserListByJobId");

        long startTime = System.currentTimeMillis();

        //必输项校验
        init(testTeamQuery,"Q_JOBID");

        //调用微服务controller接口
        Page<CltUserAndLogin> cltUserAndLoginPage  = testTeamService.queryUserListByJobId(testTeamQuery);

        CltUtils.printEndInfo(cltUserAndLoginPage, " Controller queryUserListByJobId", startTime);

        return  new ResultInfo<Page<CltUserAndLogin>>(ResultCode.SUCCESS,cltUserAndLoginPage);

    }

    //移除测试团队下的人
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    @PostMapping("/deleteTestTeamByJobIdAndUserIds")
    public ResultInfo<Integer> deleteTestTeamByJobIdAndUserId(@RequestBody TestTeamQuery testTeamQuery) throws Exception {
        logger.info(" deleteTestTeamByJobIdAndUserIds start paramData" + testTeamQuery.toString());

        //参数校验

        init(testTeamQuery,"A");
        String[] userIds=testTeamQuery.getUserIds();


        for(int i=0;i<userIds.length;i++){
            if(userIds.length<1){
                throw new GlobalException(ResultCode.INVALID_PARAM.code(),"请勾选要移除的用户");
            }

            String userId=userIds[i];
            if(StringUtils.isEmpty(userId)){
                throw new GlobalException(ResultCode.INVALID_PARAM.code(),"请勾选要移除的用户");

            }
        }
        ResultInfo<Integer> resultInfo = testTeamService.deleteTestTeamByJobIdAndUserId(testTeamQuery);
        return resultInfo;
    }


    //参数校验的方法
    public static void init(TestTeamQuery testTeamQuery, String funcCode) throws Exception {

        ParamVerifyUtil paramVerifyUtil = new ParamVerifyUtil();

        Map<String,Object> dataMap = CltUtils.beanToMap(testTeamQuery);

        if ("U_ManagerId".equals(funcCode)) {
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "jobId","managerId");

        }else if("Q_JOBID".equals(funcCode)){

            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "jobId");
        }else if("A".equals(funcCode)){
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "jobId","userIds");
        }
    }
}
