package net.northking.cloudplatform.controller;

import net.northking.cloudplatform.assist.RedisUtil;
import net.northking.cloudplatform.domain.testexecute.CltTestTeam;
import net.northking.cloudplatform.domain.user.CltUserLogin;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.query.testexecute.TestTeamQuery;
import net.northking.cloudplatform.result.ResultCode;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.TestTeamService;
import net.northking.cloudplatform.utils.CltUtils;
import net.northking.cloudplatform.utils.ParamVerifyUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Title:
 * @Description: CltTestTeam控制层
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-12-20 11:37
 * @UpdateUser:
 * @Version:0.1
 */

@RestController
public class TestTeamController {

  //注入service

    @Autowired
    private TestTeamService testTeamService;
    @Autowired
    private RedisUtil redisUtil;

    //日志
    private final static Logger logger = LoggerFactory.getLogger(JobController.class);

    /**
     * @Author:HBH
     * @Description: 创建测试团队
     * @Date:11:39 2017/12/20
     * @param1:
     * @param2:
     * @return:
     */

    @PostMapping("/createTestTeam")
    public ResultInfo<Integer> createTestTeam(@RequestBody TestTeamQuery testTeamQuery ) throws Exception {

        logger.info(" createTestTeam start paramData" + testTeamQuery.toString());

        //参数校验

          init(testTeamQuery,"A");
           String[] userIds=testTeamQuery.getUserIds();


           for(int i=0;i<userIds.length;i++){
               if(userIds.length<1){
                   throw new GlobalException(ResultCode.INVALID_PARAM.code(),"要添加的userId的个数不能小于1");
               }

               String userId=userIds[i];
               if(StringUtils.isEmpty(userId)){
                   throw new GlobalException(ResultCode.INVALID_PARAM.code(),"要添加的userId不能为空");

               }

           }

        CltUserLogin cltUserLogin = (CltUserLogin) redisUtil.get(testTeamQuery.getAccess_token());
        //创建者
        testTeamQuery.setCreateUser(cltUserLogin.getUserId());

        Integer result = testTeamService.creatTestTeam(testTeamQuery);

        logger.info(" createTestTeam end paramData");

        return  new ResultInfo<Integer>(ResultCode.SUCCESS, result);

    }


    //移除测试团队下的人
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
        Integer result =  testTeamService.deleteTestTeamByJobIdAndUserId(testTeamQuery);
        return new ResultInfo<>(ResultCode.SUCCESS, result);
    }





    /**
     * @Author:HBH
     * @Description: 查询任务下的用户Ids
     * @Date:15:24 2017/12/21
     * @param1:
     * @param2:
     * @return:
     */
    @PostMapping("/queryUserIdsByJobId")
    public ResultInfo<List<CltTestTeam>> queryUserIdsByJobId(@RequestBody TestTeamQuery testTeamQuery ) throws Exception {

        logger.info(" queryUserIdsByJobId start paramData" + testTeamQuery.toString());

        //参数检验
        init(testTeamQuery,"Q");

        List<CltTestTeam> result = testTeamService.queryUserIdsByJobId(testTeamQuery);

        logger.info("queryUserIdsByJobId end paramData");

        return  new ResultInfo<>(ResultCode.SUCCESS, "查询任务下的用户Ids成功!", result);

    }


    /**
     * @Author:HBH
     * @Description: 批量删除测试团队表
     * @Date:16:30 2017/12/21
     * @param1:
     * @param2:
     * @return:
     */

    @PostMapping("/delteTestTeamBatch")
    public ResultInfo<Integer> delteTestTeamBatch(@RequestBody TestTeamQuery testTeamQuery ) throws Exception {

        logger.info(" delteTestTeamBatch start paramData" + testTeamQuery.toString());

        String[] teamIds=testTeamQuery.getTeamIds();
        //参数检验
        if (teamIds.length == 0) {
            throw new GlobalException(ResultCode.INVALID_PARAM.code(), "teamId个数不能为零");
        }
        for (int i = 0; i < teamIds.length; i++) {
            String teamId = teamIds[i];
            if ("".equals(teamId) || teamId == null) {
                throw new GlobalException(ResultCode.INVALID_PARAM.code(), "teamId不能为空");
            }
        }

        Integer result = testTeamService.delteTestTeamBatch(testTeamQuery);

        logger.info("delteTestTeamBatch end paramData");

        return  new ResultInfo<>(ResultCode.SUCCESS, "批量删除测试团队表成功!", result);

    }




    //参数校验的方法
    public static void init(TestTeamQuery testTeamQuery, String funcCode) throws Exception {

        ParamVerifyUtil paramVerifyUtil = new ParamVerifyUtil();

        Map<String, Object> dataMap = CltUtils.beanToMap(testTeamQuery);

        if ("A".equals(funcCode)) {

            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "jobId","userIds");
        } else if ("Q".equals(funcCode)) {

            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "jobId");
        }
    }

}






