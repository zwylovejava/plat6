package net.northking.cloudplatform.controller;


import net.northking.cloudplatform.constants.SuccessConstants;
import net.northking.cloudplatform.domain.user.CltProjectTeam;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.query.project.CltProjectTeamQuery;
import net.northking.cloudplatform.result.ResultCode;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.ProjecTeamtService;
import net.northking.cloudplatform.utils.CltUtils;
import net.northking.cloudplatform.utils.ParamVerifyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;

@RestController
public class ProjectTeamController {
    @Autowired
    private ProjecTeamtService projecTeamtService;


    //日志
    private final static Logger logger = LoggerFactory.getLogger(ProjectController.class);

    //创建项目团队
    @PostMapping("/createTeam")
    public ResultInfo<Integer> createTeam(@RequestBody List<CltProjectTeamQuery> cltProjectTeamQuery)throws Exception{

        logger.info("createTeam start paramData" + cltProjectTeamQuery.toString());

        if(cltProjectTeamQuery==null||cltProjectTeamQuery.size()<=0){

            throw new GlobalException(ResultCode.INVALID_PARAM.msg(),"用户角色缺一不可");
        }

        Integer result = projecTeamtService.createTeam(cltProjectTeamQuery);

        logger.info("createTeam end paramData" );

        return new ResultInfo<>(ResultCode.SUCCESS, SuccessConstants.ADD_CLT_PROJECT_TEAM_INFO_SUCCESS,result);
    }



    //将用户移出团队
    @PostMapping("/removeUserFromPro")
    public ResultInfo<Integer> removeUserByIds( @RequestBody List<CltProjectTeamQuery> cltProjectTeamQuery)throws Exception{

        logger.info("removeUserFromPro start paramData" + cltProjectTeamQuery.toString());

        Integer result=projecTeamtService.removeUserByIds(cltProjectTeamQuery);

        logger.info("removeUserFromPro end paramData" );

        return new ResultInfo(ResultCode.SUCCESS,SuccessConstants.DELETE_CLT_PROJECT_TEAM_INFO_SUCCESS,result);
    }



    //根据用户ID,角色ID,项目ID查询团队表
    @PostMapping("/queryTeamByProIdUserIdAndRoleId")
    public ResultInfo<CltProjectTeam> queryTeamByProIdUserIdAndRoleId(@RequestBody CltProjectTeamQuery cltProjectTeamQuery)throws Exception{

        logger.info("queryTeamByProIdUserIdAndRoleId start paramData" + cltProjectTeamQuery.toString());

        //判空
        init(cltProjectTeamQuery,"Q");

        CltProjectTeam cltProjectTeam = projecTeamtService.selectByProIdAndUserIdAndRoleId(cltProjectTeamQuery);


        logger.info("queryTeamByProIdUserIdAndRoleId end paramData" );

        return  new ResultInfo<>(ResultCode.SUCCESS,SuccessConstants.QUERY_CLT_PROJECT_TEAM_INFO_BY_USER_AND_ROLE_PRO_ID_SUCCESS,cltProjectTeam);

    }


    //根据用户ID,角色ID,查询团队表记录数
    @PostMapping("/countTeamByUserIdAndRoleId")
    public ResultInfo<Integer> countTeamByUserIdAndRoleId(@RequestBody CltProjectTeamQuery cltProjectTeamQuery)throws Exception{

        logger.info("countTeamByUserIdAndRoleId start paramData" + cltProjectTeamQuery.toString());

        //判空
        init(cltProjectTeamQuery,"C");

        Integer result= projecTeamtService.countByRoleIdAndUserId(cltProjectTeamQuery);

        logger.info("countTeamByUserIdAndRoleId end paramData" );

        return  new ResultInfo<>(ResultCode.SUCCESS,SuccessConstants.COUNT_CLT_PROJECT_TEAM_INFO_BY_USER_AND_ROLE_PRO_ID_SUCCESS,result);

    }

    //参数校验的方法

    public static void init(CltProjectTeamQuery cltProjectTeamQuery, String funcCode) throws Exception {

        ParamVerifyUtil paramVerifyUtil = new ParamVerifyUtil();

        Map<String, Object> dataMap = CltUtils.beanToMap(cltProjectTeamQuery);

        if ("Q".equals(funcCode)) {

            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "proId", "userId", "roleId");
        }else if("C".equals(funcCode)){

            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                     "userId", "roleId");
        }

    }


}
