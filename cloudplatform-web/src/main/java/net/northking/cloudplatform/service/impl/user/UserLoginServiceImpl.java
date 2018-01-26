package net.northking.cloudplatform.service.impl.user;
import feign.FeignException;
import net.northking.cloudplatform.Utils.ServiceUtil;
import net.northking.cloudplatform.assist.RedisUtil;
import net.northking.cloudplatform.constants.ErrorConstants;
import net.northking.cloudplatform.controller.user.UserLoginController;
import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.domain.user.CltUserLogin;
import net.northking.cloudplatform.dto.auth.AuthToken;
import net.northking.cloudplatform.dto.auth.Authority;
import net.northking.cloudplatform.dto.auth.UserFunc;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.feign.auth.AuthTokenFeign;
import net.northking.cloudplatform.feign.user.UserLoginFeignClient;
import net.northking.cloudplatform.query.auth.AuthQuery;
import net.northking.cloudplatform.query.user.UserLoginQuery;
import net.northking.cloudplatform.result.ResultCode;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.user.UserLoginService;
import net.northking.cloudplatform.utils.BeanUtil;
import net.northking.cloudplatform.utils.CltUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
@Service
public class UserLoginServiceImpl implements UserLoginService{

    private final static Logger logger = LoggerFactory.getLogger(UserLoginServiceImpl.class);

    @Autowired
    UserLoginFeignClient userLoginFeignClient;

    @Autowired
    AuthTokenFeign  authTokenFeign;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public ResultInfo<String> checkVerificationCode(UserLoginQuery userLoginQuery) throws Exception {
        CltUtils.printStartInfo(userLoginQuery, "checkVerificationCode");

        long startTime = System.currentTimeMillis();

        ResultInfo<String> resultInfo = null;

        try{

            resultInfo = userLoginFeignClient.valiCode(userLoginQuery);

        }catch (Exception e){

            logger.error("checkVerificationCode",e);

            throw new GlobalException(ErrorConstants.CLT_WEB_USER_ERROR_CODE,ErrorConstants.CLT_WEB_USER_ERROR_MESSAGE);

        }

        CltUtils.printEndInfo(userLoginQuery, "checkVerificationCode", startTime);

        return resultInfo;
    }

    @Override
    public AuthToken authLogin(AuthQuery authQuery) throws Exception {

        CltUtils.printStartInfo(authQuery, "authToken");

        long startTime = System.currentTimeMillis();

        AuthToken authToken = null;

        try {

            authToken = authTokenFeign.authLogin("password", authQuery.getUsername(), authQuery.getPassword(), "Basic YW5kcm9pZDphbmRyb2lk");

            if(authToken != null) {
                CltUserLogin userLogin = authTokenFeign.getLoginUser(authToken.getAccess_token());
                if (userLogin != null) {
                    redisUtil.set(authToken.getAccess_token(), userLogin, 3600*12l);
                }
            }

        }catch (Exception e){

            logger.error("authLogin",e);
            if(StringUtils.isNotEmpty(e.getMessage())) {
                if (e.getMessage().indexOf("\"error\":\"invalid_grant\"") >= 0) {
                    throw new GlobalException(ResultCode.INVALID_PARAM.code(), "密码有误!");
                } else if (e.getMessage().indexOf("\"error\":\"unauthorized\"") >= 0) {
                    throw new GlobalException(ResultCode.INVALID_PARAM.code(), "不存在该用户名或用户被禁用!");
                }
            }
            throw new GlobalException(ErrorConstants.CLT_WEB_USER_ERROR_CODE,ErrorConstants.CLT_WEB_USER_ERROR_MESSAGE);

        }

        return authToken;
    }

    @Override
    public CltUserLogin getLoginUser(AuthToken authToken) throws Exception {

        CltUtils.printStartInfo(authToken, "authToken");

        long startTime = System.currentTimeMillis();

        CltUserLogin userLogin  = null;

        try {

            userLogin = authTokenFeign.getLoginUser(authToken.getAccess_token());

        }catch (FeignException e){

            logger.error("getLoginUser",e);

            throw new GlobalException(ErrorConstants.CLT_WEB_USER_ERROR_CODE,ErrorConstants.CLT_WEB_USER_ERROR_MESSAGE);

        }

        return userLogin;
    }

    @Override
    public ResultInfo<Authority> getUserFuncList(String authorization,String parentFuncId) throws Exception {

        CltUtils.printStartInfo(authorization, "getUserFuncList");

        long startTime = System.currentTimeMillis();

        ResultInfo<Authority> authority = null;

        try{

            //调用auth微服务接口
            authority = authTokenFeign.getUserFuncList(authorization, parentFuncId);

        }catch (Exception e){

            logger.error("getUserFuncList",e);

            throw new GlobalException(ErrorConstants.CLT_WEB_AUTH_ERROR_CODE,ErrorConstants.CLT_WEB_AUTH_ERROR_MESSAGE);

        }

        ServiceUtil.throwServiceException(authority);

        CltUtils.printEndInfo(authority, "getUserFuncList", startTime);

        return   authority;
    }
}
