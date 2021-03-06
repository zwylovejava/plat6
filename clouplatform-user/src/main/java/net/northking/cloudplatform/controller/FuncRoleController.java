package net.northking.cloudplatform.controller;

import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.constants.SuccessConstants;
import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.domain.user.CltFuncRole;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.query.user.FuncRoleQuery;
import net.northking.cloudplatform.result.ResultCode;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.FuncRoleService;
import net.northking.cloudplatform.utils.BeanUtil;
import net.northking.cloudplatform.utils.CltUtils;
import net.northking.cloudplatform.utils.ParamVerifyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 功能角色信息控制层
 * Created by Administrator on 2017/11/16 0016.
 */
@RestController
public class   FuncRoleController {

    @Autowired
    private FuncRoleService funcRoleService;

    private final static Logger logger = LoggerFactory.getLogger(FuncRoleController.class);

     //批量删除功能角色表
    @PostMapping("/deleteFuncRoleByfunRoleIds")
    public ResultInfo<String> deleteFuncRoleByfunRoleIds(@RequestBody FuncRoleQuery funcRoleQuery)throws Exception{

        logger.info(" deleteFuncRoleByfunRoleIds start paramData" + funcRoleQuery.toString());

        //参数校验
        init(funcRoleQuery,"deleteFuncRoleByfunRoleIds");

        String msg = funcRoleService.deleteFuncRoleByfunRoleIds(funcRoleQuery);

        logger.info(" deleteFuncRoleByfunRoleIds end paramData");

        return new ResultInfo<>(ResultCode.SUCCESS , SuccessConstants.DELETE_CLT_ROLE_FUNC_BATCH_BY_ROLE_FUNC_IDS_SUCCESS,msg);
    }


    //批量添加功能角色表
    @PostMapping("/addFuncRoles")
    public ResultInfo<Integer>addFuncRoles(@RequestBody FuncRoleQuery funcRoleQuery) throws Exception {

        logger.info(" addFuncRoles start paramData" + funcRoleQuery.toString());

        //参数校验
        //init(funcRoleQuery,"addFuncRoles");

        Integer result=funcRoleService.addFuncRoles(funcRoleQuery);

        logger.info(" addFuncRoles end paramData");

        return new ResultInfo<>(ResultCode.SUCCESS ,SuccessConstants.ADD_CLT_ROLE_FUNC_BATCH_BY_ROLE_FUNC_IDS_SUCCESS,result);

    }

    //根据角色ID查询所属功能
    @PostMapping("/queryFuncListByRoleId")
    public ResultInfo<Page<CltFunc>>  queryFuncListByRoleId(@RequestBody FuncRoleQuery funcRoleQuery)throws Exception{

        CltUtils.printStartInfo(funcRoleQuery, "queryFuncListByRoleId");

        long startTime = System.currentTimeMillis();

        CltFuncRole cltFuncRole = new CltFuncRole();

        BeanUtil.copyProperties(funcRoleQuery, cltFuncRole);

        //参数校验
        init(funcRoleQuery, "queryFuncListByRoleId");

        //调用数据库
        Page<CltFunc> page = funcRoleService.queryByRoleId(funcRoleQuery.getRoleId());

        CltUtils.printEndInfo(page, "queryFuncListByRoleId", startTime);

        return new ResultInfo<>(ResultCode.SUCCESS,SuccessConstants.QUERY_FUNC_LIST_BY_ROLE_ID_SUCCESS, page);

    }



    //参数检验的方法
    public static void init( FuncRoleQuery funcRoleQuery, String funcCode) throws Exception {

        ParamVerifyUtil paramVerifyUtil = new ParamVerifyUtil();

        Map<String,Object> dataMap = CltUtils.beanToMap(funcRoleQuery);

        if ("deleteFuncRoleByfunRoleIds".equals(funcCode)) {
            String[] ids = funcRoleQuery.getFuncRoleIds();

            if(ids.length == 0 ){
                throw new GlobalException(ResultCode.INVALID_PARAM.code() , "要删除的个数不能为零");
            }
            for (int i = 0; i < ids.length; i++) {
                String funcRoleId = ids[i];
                if ("".equals(funcRoleId) || funcRoleId == null) {
                    throw new GlobalException(ResultCode.INVALID_PARAM.code(), "funcRoleId不能为空");
                }
            }


        } else if ("addFuncRoles".equals(funcCode)) {

            if(funcRoleQuery.getRoleId()==null ||"".equals(funcRoleQuery.getRoleId())){

                throw new GlobalException(ResultCode.INVALID_PARAM.code() , "roleId不能为空");
            }

            String[] ids = funcRoleQuery.getFuncIds();

            if(ids.length == 0 ){
                throw new GlobalException(ResultCode.INVALID_PARAM.code() , "funcId个数不能为零");
            }

            for (int i = 0; i < ids.length; i++) {
                String funcId = ids[i];
                if ("".equals(funcId) || funcId == null) {
                    throw new GlobalException(ResultCode.INVALID_PARAM.code(), "funcId不能为空");
                }
            }
        }else if ("queryFuncByRoleId".equals(funcCode)) {

            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,

                    "roleId");

        }
    }


}
