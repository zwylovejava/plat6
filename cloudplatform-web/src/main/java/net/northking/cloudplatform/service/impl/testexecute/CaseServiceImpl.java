package net.northking.cloudplatform.service.impl.testexecute;


import net.northking.cloudplatform.Utils.ServiceUtil;
import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.constants.ErrorConstants;
import net.northking.cloudplatform.domain.testexecute.CltCaseSet;
import net.northking.cloudplatform.domain.testexecute.CltTestCase;
import net.northking.cloudplatform.dto.testexecute.TestCaseColum;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.feign.testexecute.TestCaseFeignClient;
import net.northking.cloudplatform.query.testexecute.TestCaseQuery;
import net.northking.cloudplatform.query.testexecute.TestCaseSetQuery;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.testexecute.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * Crea Administrator on 2017/12/21 0021.
 */
@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    TestCaseFeignClient testCaseFeignClient;

    @Override
    public ResultInfo<Page<CltCaseSet>> queryCltCaseSetByBatchId(TestCaseSetQuery testCaseSetQuery) throws Exception {
        ResultInfo<Page<CltCaseSet>>  resultInfo = null;

        try{
            //调用数据库
            resultInfo =  testCaseFeignClient.queryTestCaseSetById(testCaseSetQuery);

        }catch (Exception e){

            throw new GlobalException(ErrorConstants.CLT_WEB_TESTEXECUTE_ERROR_CODE,ErrorConstants.CLT_WEB_TESTEXECUTE_ERROR_MESSAGE);

        }

        //如果返回为异常信息则抛出异常
        ServiceUtil.throwServiceException(resultInfo);

        return resultInfo;
    }

    @Override
    public ResultInfo<TestCaseColum> queryCltCaseIdByCaseSetId(TestCaseSetQuery testCaseSetQuery) throws Exception {
        ResultInfo<TestCaseColum> mapResultInfo=null;

        try{

            //调用数据库
            mapResultInfo = testCaseFeignClient.queryTestCaseById(testCaseSetQuery);

        }catch (Exception e){

            throw new GlobalException(ErrorConstants.CLT_WEB_TESTEXECUTE_ERROR_CODE,ErrorConstants.CLT_WEB_TESTEXECUTE_ERROR_MESSAGE);

  }

        //如果返回为异常信息则抛出异常
        ServiceUtil.throwServiceException(mapResultInfo);

        return mapResultInfo;
    }

    @Override
    public ResultInfo<CltTestCase> queryTestCaseInfoById(TestCaseQuery testCaseQuery)throws Exception  {
        ResultInfo<CltTestCase>  resultInfo = null;

        try{
            //调用数据库
            resultInfo =  testCaseFeignClient.queryTestCaseInfoById(testCaseQuery);

        }catch (Exception e){

            throw new GlobalException(ErrorConstants.CLT_WEB_TESTEXECUTE_ERROR_CODE,ErrorConstants.CLT_WEB_TESTEXECUTE_ERROR_MESSAGE);

        }

        //如果返回为异常信息则抛出异常
        ServiceUtil.throwServiceException(resultInfo);

        return resultInfo;
    }
}
