package net.northking.cloudplatform.service.impl.user;
import net.northking.cloudplatform.Utils.ServiceUtil;
import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.constants.ErrorConstants;
import net.northking.cloudplatform.controller.user.FuncRoleController;
import net.northking.cloudplatform.domain.user.CltFuncRole;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.feign.user.FuncRoleFeignClient;
import net.northking.cloudplatform.query.user.FuncRoleQuery;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.user.FuncRoleService;
import net.northking.cloudplatform.utils.CltUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
@Service
public class FuncRoleServiceImpl implements FuncRoleService,Serializable {

    private final static Logger logger = LoggerFactory.getLogger(FuncRoleController.class);

    //注入CltFuncRoleFeignClient
    @Autowired
    private FuncRoleFeignClient funcRoleFeignClient;

    @Override
    public ResultInfo<Integer> addCltFuncRolesInfo(FuncRoleQuery funcRoleQuery) throws Exception {

        CltUtils.printStartInfo(funcRoleQuery, "addCltFuncRolesInfo");

        long startTime = System.currentTimeMillis();

        ResultInfo<Integer> result = null;

        try{

            //调用微服务controller接口
            result = funcRoleFeignClient.addFuncRoles(funcRoleQuery);

        }catch (Exception e){

            logger.error("deleteFuncRoleByfunRoleIdsInfo",e);

            throw new GlobalException(ErrorConstants.CLT_WEB_USER_ERROR_CODE,ErrorConstants.CLT_WEB_USER_ERROR_MESSAGE);

        }

        ServiceUtil.throwServiceException(result);

        CltUtils.printEndInfo(result, "addCltFuncRolesInfo", startTime);

        return  result;

    }

    @Override
    public ResultInfo<Integer> deleteFuncRoleByfunRoleIdsInfo(FuncRoleQuery funcRoleQuery) throws Exception {

        CltUtils.printStartInfo(funcRoleQuery, "deleteFuncRoleByfunRoleIdsInfo");

        long startTime = System.currentTimeMillis();

        ResultInfo<Integer> result = null;

        try{
            //调用微服务controller接口
            result = funcRoleFeignClient.addFuncRoles(funcRoleQuery);

        }catch (Exception e){

            logger.error("deleteFuncRoleByfunRoleIdsInfo",e);

            throw new GlobalException(ErrorConstants.CLT_WEB_USER_ERROR_CODE,ErrorConstants.CLT_WEB_USER_ERROR_MESSAGE);

        }

        ServiceUtil.throwServiceException(result);

        CltUtils.printEndInfo(result, "deleteFuncRoleByfunRoleIdsInfo", startTime);

        return  result;
    }

    @Override
    public ResultInfo<Page<CltFuncRole>> queryFuncListByRoleId(FuncRoleQuery funcRoleQuery) throws Exception {

        CltUtils.printStartInfo(funcRoleQuery, "queryFuncListByRoleId");

        long startTime = System.currentTimeMillis();

        ResultInfo<Page<CltFuncRole>>   result = null;

        try{

            //调用数据库
            result =  funcRoleFeignClient.queryFuncListByRoleId(funcRoleQuery);

        }catch (Exception e){

            logger.error("queryCltOrgInfoByOrgId",e);

            throw new GlobalException(ErrorConstants.CLT_WEB_USER_ERROR_CODE,ErrorConstants.CLT_WEB_USER_ERROR_MESSAGE);

        }

        ServiceUtil.throwServiceException(result);

        CltUtils.printEndInfo(result, "queryFuncListByRoleId", startTime);

        return result ;
    }
}
