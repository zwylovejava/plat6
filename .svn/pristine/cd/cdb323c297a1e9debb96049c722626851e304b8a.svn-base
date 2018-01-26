package net.northking.cloudplatform.service.impl.user;

import net.northking.cloudplatform.Utils.ServiceUtil;
import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.constants.ErrorConstants;
import net.northking.cloudplatform.controller.user.RoleController;
import net.northking.cloudplatform.domain.user.CltRole;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.feign.user.RoleFeignClient;
import net.northking.cloudplatform.query.user.RoleQuery;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.user.RoleService;
import net.northking.cloudplatform.utils.CltUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
@Service
public class RoleServiceImpl implements RoleService,Serializable {

    private final static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    RoleFeignClient  roleFeignClient;

    @Override
    public ResultInfo<CltRole> queryCltRoleByRoleCode(RoleQuery roleQuery) throws Exception {

        CltUtils.printStartInfo(roleQuery, "queryCltRoleByRoleCode");

        ResultInfo<CltRole> result = null;

        long startTime = System.currentTimeMillis();

        try {
            //调用微服务接口
            result = roleFeignClient.queryRoleByRoleCode(roleQuery);

        } catch (Exception e) {

            e.printStackTrace();

            throw new GlobalException(ErrorConstants.CLT_WEB_USER_ERROR_CODE, ErrorConstants.CLT_WEB_USER_ERROR_MESSAGE);

        }

        ServiceUtil.throwServiceException(result);

        CltUtils.printEndInfo(result, "queryCltRoleByRoleCode", startTime);

        return result;
    }

    @Override
    public ResultInfo<Integer> addCltRoleInfo(RoleQuery roleQuery) throws Exception {

        CltUtils.printStartInfo(roleQuery, "addCltRoleInfo");

        long startTime = System.currentTimeMillis();

        ResultInfo<Integer> result = null;

        try {
            //调用微服务接口
            result = roleFeignClient.addCltRoleInfo(roleQuery);

        } catch (Exception e) {

            logger.error("addCltRoleInfo", e);

            throw new GlobalException(ErrorConstants.CLT_WEB_USER_ERROR_CODE, ErrorConstants.CLT_WEB_USER_ERROR_MESSAGE);

        }

        ServiceUtil.throwServiceException(result);

        CltUtils.printEndInfo(result, "addCltRoleInfo", startTime);

        return result;
    }

    @Override
    public ResultInfo<Page<CltRole>> queryAllCltRolesList(RoleQuery roleQuery) throws Exception {

        logger.info("\n*********************************** queryAllCltRolesList invoke  start******************************\n");

        long startTime = System.currentTimeMillis();

        ResultInfo<Page<CltRole>> result = null;

        try {
            //调用微服务接口
            result = roleFeignClient.queryAllRoleList(roleQuery);

        } catch (Exception e) {

            logger.error("queryAllCltRolesList", e);

            throw new GlobalException(ErrorConstants.CLT_WEB_USER_ERROR_CODE, ErrorConstants.CLT_WEB_USER_ERROR_MESSAGE);

        }

        ServiceUtil.throwServiceException(result);

        CltUtils.printEndInfo(result, "queryAllCltRolesList", startTime);

        return result;
    }

    @Override
    public ResultInfo<Integer> updateCltRoleInfo(RoleQuery roleQuery) throws Exception {
        CltUtils.printStartInfo(roleQuery, "updateCltRoleInfo");

        long startTime = System.currentTimeMillis();

        ResultInfo<Integer> result = null;

        try {
            //调用微服务接口
            result = roleFeignClient.updateCltRoleInfo(roleQuery);

        } catch (Exception e) {

            logger.error("updateCltRoleInfo", e);

            throw new GlobalException(ErrorConstants.CLT_WEB_USER_ERROR_CODE, ErrorConstants.CLT_WEB_USER_ERROR_MESSAGE);

        }

        ServiceUtil.throwServiceException(result);

        CltUtils.printEndInfo(result, "updateCltRoleInfo", startTime);

        return result;

    }

    @Override
    public ResultInfo<CltRole> queryCltRoleByRoleId(RoleQuery roleQuery) throws Exception {

        CltUtils.printStartInfo(roleQuery, "queryCltRoleByRoleId");

        long startTime = System.currentTimeMillis();

        ResultInfo<CltRole> result = null;

        try {
            //调用微服务接口
            result = roleFeignClient.queryCltRoleByRoleId(roleQuery);

        } catch (Exception e) {

            logger.error("queryCltRoleByRoleId", e);

            throw new GlobalException(ErrorConstants.CLT_WEB_USER_ERROR_CODE, ErrorConstants.CLT_WEB_USER_ERROR_MESSAGE);

        }

        ServiceUtil.throwServiceException(result);

        CltUtils.printEndInfo(result, "queryCltRoleByRoleId", startTime);

        return result;
    }

    @Override
    public ResultInfo<String> deleteCltRoleInfo(RoleQuery roleQuery) throws Exception {

        CltUtils.printStartInfo(roleQuery, "deleteCltRoleInfo");

        long startTime = System.currentTimeMillis();

        ResultInfo<String> result = null;

        try {
            //调用微服务接口
            result = roleFeignClient.deleteRolesByRoleIds(roleQuery);

        } catch (Exception e) {

            logger.error("deleteCltRoleInfo", e);

            throw new GlobalException(ErrorConstants.CLT_WEB_USER_ERROR_CODE, ErrorConstants.CLT_WEB_USER_ERROR_MESSAGE);

        }

        ServiceUtil.throwServiceException(result);

        CltUtils.printEndInfo(result, "deleteCltRoleInfo", startTime);

        return result;
    }

    @Override
    public ResultInfo<Object> importRoleExcelInfo(RoleQuery roleQuery) {

        CltUtils.printStartInfo(roleQuery, "importRoleExcelInfo");

        long startTime = System.currentTimeMillis();

        ResultInfo<Object> result = null;

        try {
            //调用微服务接口
            result = roleFeignClient.importRoleExcelInfo(roleQuery);

        } catch (Exception e) {

            logger.error("importRoleExcelInfo", e);

            throw new GlobalException(ErrorConstants.CLT_WEB_USER_ERROR_CODE, ErrorConstants.CLT_WEB_USER_ERROR_MESSAGE);

        }

        CltUtils.printEndInfo(result, "importRoleExcelInfo", startTime);

        return result;
    }


    @Override
    public ResultInfo<List<CltRole>> queryAllCltRolesListWithoutSuper(RoleQuery roleQuery) throws Exception {

        CltUtils.printStartInfo(roleQuery, "queryAllCltRolesListWithoutSuper");

        long startTime = System.currentTimeMillis();

        ResultInfo<List<CltRole>> result = null;

        try {
            //调用微服务接口
            result = roleFeignClient.queryAllCltRoleIsNotSuper();

        } catch (Exception e) {

            logger.error("queryAllCltRolesListWithoutSuper", e);

            throw new GlobalException(ErrorConstants.CLT_WEB_USER_ERROR_CODE, ErrorConstants.CLT_WEB_USER_ERROR_MESSAGE);

        }

        ServiceUtil.throwServiceException(result);

        CltUtils.printEndInfo(result, "queryAllCltRolesListWithoutSuper", startTime);

        return result;
    }
}
