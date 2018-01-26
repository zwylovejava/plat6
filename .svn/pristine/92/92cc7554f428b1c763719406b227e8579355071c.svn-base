package net.northking.cloudplatform.controller;

import net.northking.cloudplatform.assist.RedisUtil;
import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.constants.ErrorConstants;
import net.northking.cloudplatform.constants.SuccessConstants;
import net.northking.cloudplatform.dao.user.CltUserMapper;
import net.northking.cloudplatform.domain.project.CltProject;
import net.northking.cloudplatform.domain.project.CltProjectUserInfo;
import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.domain.user.CltUser;
import net.northking.cloudplatform.domain.user.CltUserAndLogin;
import net.northking.cloudplatform.domain.user.CltUserLogin;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.feign.user.UserFeignClient;
import net.northking.cloudplatform.query.project.CltProjectTeamQuery;
import net.northking.cloudplatform.query.project.ProjectQuery;
import net.northking.cloudplatform.query.user.UserAndLoginQuery;
import net.northking.cloudplatform.result.ResultCode;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.utils.BeanUtil;
import net.northking.cloudplatform.utils.CltUtils;
import net.northking.cloudplatform.utils.PageUtil;
import net.northking.cloudplatform.utils.ParamVerifyUtil;


import net.northking.cloudplatform.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @Title:
 * @Description: 项目管理controller类
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-11-28 10:40
 * @UpdateUser:
 * @Version:0.1
 */

@RestController
public class ProjectController {

     //注入service
    @Autowired
    private ProjectService projectService;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    private CltUserMapper cltUserMapper;

    @Autowired
    private UserFeignClient userFeignClient;


    //日志
    private final static Logger logger = LoggerFactory.getLogger(ProjectController.class);
    /**
     * 项目列表权限控制
     * @param
     * @return
     * @throws Exception
     */
    /**
     * 项目列表权限控制
     * @param
     * @return
     * @throws Exception
     */
    @PostMapping("/cltProjectListInfo")
    public ResultInfo<List<CltProject>> CltProjectListInfo(@RequestBody ProjectQuery projectQuery) throws Exception {

        String isAdmin = "N"; //默认用户进来不为超级管理员

        List<CltProject>  projectList = new ArrayList<CltProject>();

        //必输项校验   userId
        init(projectQuery,"Q");

        //获取用户超级管理员字段标志 （redis获取用户数据）
        CltUserLogin cltUserLogin = (CltUserLogin) redisUtil.get(projectQuery.getAccess_token());

        logger.info("\n\n\n\nCltUserLogin:"+cltUserLogin.toString());

        if(cltUserLogin!=null){

            //根据用户id查询用户详情表
            CltUser cltUser=cltUserMapper.selectByPrimaryKey(cltUserLogin.getUserId());

            //设置客户id
            projectQuery.setCustId(cltUser.getCustId());

            //如果是超级管理员 改变字段值 IS_SUPER Y-超级管理员  N -非超级管理员
            if("Y".equals(cltUserLogin.getIsSuper())){
                isAdmin = "Y" ;
            }

            //如果为超级管理员查询所有的项目列表
            if("Y".equals(isAdmin)){

                logger.info("***********************1111111111111111");
                projectList =  projectService.findAllProject(projectQuery.getCustId());
                //如果不为超级管理查询所属项目列表
            }else{
                logger.info("***********************222222222222222222222222222222");
                projectList =  projectService.findProjectByUserId(cltUserLogin.getUserId());
            }

        }

        return new ResultInfo<>(ResultCode.SUCCESS.code(), SuccessConstants.QUERY_PROJECT_LIST_SUCCESS, projectList);
    }



    /**
     * 	根据项目ID查询项目详情
     * @param
     * @return
     */
    @PostMapping("/queryProjectInfoByProId")
    public ResultInfo< CltProject> queryProjectInfoByProId(@RequestBody ProjectQuery projectQuery) throws Exception {

        //参数校验
        init(projectQuery,"queryProjectInfoByProId");

        CltProject cltProject=new CltProject();

        BeanUtil.copyProperties(projectQuery, cltProject);

       CltProject result= projectService.queryProjectInfoByProId(cltProject);

        return new ResultInfo< >(ResultCode.SUCCESS ,SuccessConstants.QUERY_CLT_PROJECT_INFO_BY_PRO_ID_SUCCESS,result);
    }

    /**
     * 查询项目下用户的功能菜单
     * @param projectQuery
     * @return
     */
    @PostMapping("/queryFuncListByProAndUserId")
    public ResultInfo<List<CltFunc>> queryFuncListByProAndUserId(@RequestBody ProjectQuery projectQuery) throws Exception {

        List<CltFunc>  funcList = new ArrayList<CltFunc>();

        List<CltFunc>  resultFuncList = new ArrayList<CltFunc>();

        //校验参数 parentFuncId  不能为空

        init(projectQuery,"queryFuncListByProAndUserId");

        String  adminRoleId = "";

        String  isAdmin = "N";

        Map<String,Object> paramDataMap  = new HashMap<String,Object>();

        //获取resdis中的数据信息
        CltUserLogin cltUserLogin = (CltUserLogin) redisUtil.get(projectQuery.getAccess_token());

        logger.info("\n\n\ncltUserLogin;"+cltUserLogin);

        if(cltUserLogin!=null){

            //如果是超级管理员 改变字段值 IS_SUPER Y-超级管理员  N -非超级管理员
            if("Y".equals(cltUserLogin.getIsSuper())){
                isAdmin = "Y" ;
            }

            //组装数据
            paramDataMap.put("roleId",adminRoleId);
            paramDataMap.put("userId",cltUserLogin.getUserId());
            paramDataMap.put("proId",projectQuery.getProId());

            if("Y".equals(isAdmin)){
                funcList =  projectService.getFuncListByAdminRoleId(paramDataMap);
            }else{

                funcList = projectService.getFuncListByProIdAndUserId(paramDataMap);
            }
        }
        if(funcList!=null){

            resultFuncList =getItemInfo(funcList,projectQuery.getParentFuncId().toString());
        }


       return new ResultInfo<>(ResultCode.SUCCESS ,SuccessConstants.QUERY_FUNC_LIST_BY_PRO_AND_USER_ID_SUCCESS, resultFuncList);
    }



    //保存项目
    @PostMapping("/saveProject")
    public ResultInfo<Integer> saveProject(@RequestBody @Validated ProjectQuery projectQuery)throws Exception{

        logger.info("\n saveProject start paramData" + projectQuery.toString());

        //funcCode:-0界面新增 ;-1数据同步(MQ数据同步)
            String funcCode=projectQuery.getFuncCode();
        if(StringUtils.isEmpty(funcCode)){

            throw new GlobalException(ResultCode.INVALID_PARAM.code(),"funcCode不能为空!");

        }

         if(funcCode.equals("0")) {
             //获取用户超级管理员字段标志 （redis获取用户数据）
             CltUserLogin cltUserLogin = (CltUserLogin) redisUtil.get(projectQuery.getAccess_token());

             //根据用户的id查询用户表
             if (cltUserLogin != null) {
                 UserAndLoginQuery userAndLoginQuery = new UserAndLoginQuery();
                 userAndLoginQuery.setUserId(cltUserLogin.getUserId());
                 ResultInfo<CltUserAndLogin> resultInfo = userFeignClient.queryUserInfoByUserId(userAndLoginQuery);
                 CltUserAndLogin cltUserAndLogin = resultInfo.getResultData();
                 String custId = cltUserAndLogin.getCustId();
                 //获取超级管理员对应的客户id
                 projectQuery.setCustId(custId);
                 projectQuery.setCreateUser(cltUserAndLogin.getUserId());
             }

         }
        //参数校验
        Date testPlanStartTime = projectQuery.getTestPlanStartTime();
        Date testPlanEndTime = projectQuery.getTestPlanEndTime();

        if(testPlanEndTime.getTime()<testPlanStartTime.getTime()){
            throw new GlobalException(ResultCode.INVALID_PARAM.code(),"项目的结束时间不能早于开始时间");

        }
        Integer result= projectService.saveProject(projectQuery);

        logger.info("endSaveProject end paramData" );

        return new ResultInfo<>(ResultCode.SUCCESS, SuccessConstants.ADD_CLT_PROJECT_INFO_SUCCESS,result);

    }



      //编辑项目
    @PostMapping("/updateProject")
     public ResultInfo<Integer> updateProject(@RequestBody  @Validated  ProjectQuery projectQuery)throws Exception{

        logger.info("updateProject start paramData" + projectQuery.toString());

        CltUserLogin cltUserLogin = (CltUserLogin) redisUtil.get(projectQuery.getAccess_token());

        //根据用户的id查询用户表
        if(cltUserLogin!=null){
            projectQuery.setUpdateUser(cltUserLogin.getUserId());
        }

        //判空
        init(projectQuery,"updateProject");


        Integer result=projectService.updateCltProject(projectQuery);

        logger.info("updateProject end paramData" );

        return  new ResultInfo<>(ResultCode.SUCCESS,SuccessConstants.UPDATE_CLT_PROJECT_INFO_SUCCESS,result);

    }

    //启用/禁用
    @PostMapping("/disEnableproject")
    public ResultInfo<Integer> disEnableproject(@RequestBody ProjectQuery projectQuery)throws Exception{

        logger.info("disEnableproject start paramData" + projectQuery.toString());

        //判空
        init(projectQuery,"disEnableproject");

        CltProject cltProject=new CltProject();

        BeanUtil.copyProperties(projectQuery,cltProject);

        Integer result=projectService.disEnableproject(cltProject);

        if(result==0){
            throw new GlobalException(ResultCode.INVALID_PARAM.code(),"启用的项目不存在!");
        }
        logger.info("disEnableproject end paramData" );

        return  new ResultInfo<>(ResultCode.SUCCESS,SuccessConstants.UPDATE_PROJECT_STATUS_SUCCESS,result);

    }


    //根据用户id查询项目列表

    @PostMapping("/findProjectByUserId")
    public ResultInfo<List<CltProject>> findProjectByUserId(@RequestBody ProjectQuery projectQuery)throws Exception{

        logger.info("findProjectByUserId start paramData" + projectQuery.toString());

        //判空
        init(projectQuery,"findProjectByUserId");

        List<CltProject> projects = projectService.findProjectByUserId(projectQuery.getUserId());

        logger.info("findProjectByUserId end paramData" );

        return new ResultInfo<>(ResultCode.SUCCESS,SuccessConstants.QUERY_PROJECT_LIST_BY_USER_ID_SUCCESS,projects);

    }

    //查询项目下所有的用户与角色
    @PostMapping("/queryUserAndRoleByProId")
    public ResultInfo<Page<CltProjectUserInfo>> queryUserAndRoleByProId(@RequestBody CltProjectTeamQuery cltProjectTeamQuery) throws Exception {


        logger.info("queryUserAndRoleByProId start paramData");
        PageUtil.startPage(cltProjectTeamQuery);

       List<CltProjectUserInfo> cltProjectUserInfos = projectService.queryUserAndRoleByProId(cltProjectTeamQuery);
       Page<CltProjectUserInfo> page = new Page<>(cltProjectUserInfos);
       return new ResultInfo<>(ResultCode.SUCCESS,SuccessConstants.QUERY_USER_ROLE_BY_PRO_ID_SUCCESS,page);
    }

    //查询客户下的所有项目
    @PostMapping("/queryCltProjectByCustId")
    public ResultInfo< List<CltProject>> queryCltProjectByCustId(@RequestBody ProjectQuery projectQuery) throws Exception {

        //参数校验
        init(projectQuery,"queryCltProjectByCustId");

        CltProject cltProject=new CltProject();

        BeanUtil.copyProperties(projectQuery, cltProject);

        List<CltProject> result=projectService.queryCltProjectByCustId(projectQuery);

        return new ResultInfo< >(ResultCode.SUCCESS ,SuccessConstants.QUERY_PROJECT_LIST_BY_CUST_ID_SUCCESS,result);
    }





    //组装funcList数据（树状数据）
    public static List<CltFunc> getItemInfo(List<CltFunc> authorityList,String reqParentFuncId )throws Exception{

        List<CltFunc>  rusult = new ArrayList<CltFunc>();

        for (int i=0;i<authorityList.size();i++){

            CltFunc userFunc = (CltFunc)authorityList.get(i);

            Map map = CltUtils.beanToMap(userFunc);

            String  parentFuncId= (String)map.get("parentFuncId");

            if((reqParentFuncId.equals(parentFuncId))){

                Map  orgInfoMap1 = new HashMap();

                orgInfoMap1.putAll(map);

                getSonTree(orgInfoMap1, authorityList);

                CltUtils.mapToBean(orgInfoMap1,userFunc);

                rusult.add(userFunc);
            }
        }

        return  rusult;
    }
    //递归方法
    private static Map<String,Object> getSonTree(Map<String,Object> parentCltOrgMap,List<CltFunc> itemList){

        List<Map<String,Object>> sonList = new ArrayList<Map<String,Object>>();

        Map<String, Object> sonMap;

        for(CltFunc item : itemList){

            if((parentCltOrgMap.get("funcId").toString().equals(item.getParentFuncId().toString()))){

                sonMap = new HashMap<String, Object>();

                sonMap = CltUtils.beanToMap(item);

                sonList.add(sonMap);

                getSonTree(sonMap,itemList);
            }
        }
        parentCltOrgMap.put("sonFuncMap", sonList);

        return parentCltOrgMap;
    }






    //参数校验的方法

    public static void init(ProjectQuery projectQuery, String funcCode) throws Exception {

        ParamVerifyUtil paramVerifyUtil = new ParamVerifyUtil();

        Map<String,Object> dataMap = CltUtils.beanToMap(projectQuery);

        if ("deleteProject".equals(funcCode)) {

            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "proId");
        }else if("queryProjectInfoByProId".equals(funcCode)){

            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "proId");
        }else if("updateProject".equals(funcCode)){
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "proId");

        }else if("disEnableproject".equals(funcCode)){
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "proId");
            //判断用户的状态
            String status=projectQuery.getStatus();
            if("".equals(status) || status==null || !status.matches("[12]")){

                throw new GlobalException(ErrorConstants.PROJECTSTATU_PARAM_NOTNULL_ERROR_CODEUSER_ERROR_CODE, ErrorConstants.PROJECTSTATU_PARAM_NOTNULL_ERROR_CODEUSER_ERROR_MESSAGE);
            }

        }else if("findProjectByUserId".equals(funcCode)){
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "userId");

        }else if ("queryFuncListByProAndUserId".equals(funcCode)){
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "parentFuncId");


        }else if ("queryCltProjectByCustId".equals(funcCode)){
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "custId");


        }

    }

}
