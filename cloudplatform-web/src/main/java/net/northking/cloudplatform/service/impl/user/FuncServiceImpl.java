package net.northking.cloudplatform.service.impl.user;

import net.northking.cloudplatform.Utils.ServiceUtil;
import net.northking.cloudplatform.constants.ErrorConstants;
import net.northking.cloudplatform.controller.user.FuncController;
import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.feign.user.FuncFeignClient;
import net.northking.cloudplatform.query.user.FuncRoleQuery;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.user.FuncService;
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
public class FuncServiceImpl implements FuncService,Serializable {

    private final static Logger logger = LoggerFactory.getLogger(FuncController.class);

    @Autowired
    FuncFeignClient funcFeignClient;


    @Override
    public ResultInfo<List<CltFunc>> queryCltFuncList(FuncRoleQuery funcRoleQuery) throws Exception {

        CltUtils.printStartInfo(funcRoleQuery, "queryCltFuncList");

        long startTime = System.currentTimeMillis();

        //调用微服务controller接口
        ResultInfo<List<CltFunc>> result  = null;

        try {

            //调用微服务接口
            result = funcFeignClient.queryCltFuncList();

        }catch (Exception e){

            logger.error("queryCltFuncList",e);

            throw new GlobalException(ErrorConstants.CLT_WEB_USER_ERROR_CODE,ErrorConstants.CLT_WEB_USER_ERROR_MESSAGE);

        }

        ServiceUtil.throwServiceException(result);

        CltUtils.printEndInfo(result, "queryCltFuncList", startTime);

        return  result;
    }
}
