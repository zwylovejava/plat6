package net.northking.cloudplatform.service.impl;


import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.dao.base.BaseServiceImpl;
import net.northking.cloudplatform.dao.testexecute.*;
import net.northking.cloudplatform.domain.testexecute.*;

import net.northking.cloudplatform.domain.user.CltUserAndLogin;
import net.northking.cloudplatform.domain.user.CltUserLogin;
import net.northking.cloudplatform.dto.testexecute.TestCaseColum;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.feign.user.UserFeignClient;
import net.northking.cloudplatform.feign.user.UserLoginFeignClient;
import net.northking.cloudplatform.query.testexecute.TestCaseQuery;
import net.northking.cloudplatform.query.testexecute.TestCaseSetQuery;
import net.northking.cloudplatform.query.user.CltUserLoginQuery;
import net.northking.cloudplatform.query.user.UserAndLoginQuery;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.TestCaseService;
import net.northking.cloudplatform.utils.PageUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TestCaseServcieImpl extends BaseServiceImpl<CltCaseSet,CltCaseSetExample,String>implements TestCaseService {
    @Autowired
    private CltCaseSetMapper cltCaseSetMapper;
    @Autowired
    private CltTestCaseMapper cltTestCaseMapper;
    @Autowired
    private CltTestCaseStepMapper cltTestCaseStepMapper;
    @Autowired
    private CltAppFuncMapper cltAppFuncMapper;
    @Autowired
    private CltTestStepDataMapper cltTestStepDataMapper;

    @Autowired
    private CltCaseItemSetupMapper cltCaseItemSetupMapper;

    @Autowired
    private CltCaseExecuteMapper cltCaseExecuteMapper;

    @Autowired
    private UserLoginFeignClient userLoginFeignClient;

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public List<CltCaseSet> queryTestCaseSetById(TestCaseSetQuery testCaseSetQuery) {
        List<CltCaseSet> listCaseSet=null;
        try {
             listCaseSet = cltCaseSetMapper.queryTestCaseSetById(testCaseSetQuery);

        }catch (Exception e){
            logger.error("查询用例集失败",e);
            logger.info("查询用例集失败");
        }


        return listCaseSet;
    }

    @Override
    public TestCaseColum  queryTestCaseById(TestCaseSetQuery testCaseSetQuery) {
        List<CltTestCase> cltTestCaseList=null;
        TestCaseColum testCaseColum = new TestCaseColum();
        try{
            PageUtil.startPage(testCaseSetQuery);
            cltTestCaseList = cltTestCaseMapper.queryTestCaseById(testCaseSetQuery);

            Page<CltTestCase> page = new Page<>(cltTestCaseList);
            //根据用例集id询执行状态
            CltCaseExecuteExample cltCaseExecuteExample =new CltCaseExecuteExample();
            CltCaseExecuteExample.Criteria criteria1 = cltCaseExecuteExample.createCriteria();
            criteria1.andCaseSetIdEqualTo(testCaseSetQuery.getCaseSetId());
            PageUtil.startPage(testCaseSetQuery);
            List<CltCaseExecute> cltCaseExecutes = cltCaseExecuteMapper.selectByExample(cltCaseExecuteExample);
            //根据用户ID查询姓名
            CltUserLoginQuery userAndLoginQuery = new CltUserLoginQuery();
            for(CltCaseExecute cltCaseExecute: cltCaseExecutes){
                String userId = cltCaseExecute.getReceiveUser();
                if(!StringUtils.isEmpty(userId)){
                    userAndLoginQuery.setUserId(userId);
                    CltUserLogin cltUserLogin = userLoginFeignClient.queryUserLoginById(userAndLoginQuery);
                    if(cltUserLogin!=null){
                        String userChnName = cltUserLogin.getUserChnName();
                        cltCaseExecute.setReceiveUser(userChnName);
                    }
                }
            }


            for(CltTestCase cltTestCase:cltTestCaseList){
                for(CltCaseExecute cltCaseExecute:cltCaseExecutes){
                    if(cltTestCase.getId().equals(cltCaseExecute.getCaseId())){
                        cltTestCase.setReceiveUser(cltCaseExecute.getReceiveUser());
                        cltTestCase.setResultStatus(cltCaseExecute.getResultStatus());
                    }
                }
                if(StringUtils.isEmpty(cltTestCase.getReceiveUser())){
                    cltTestCase.setReceiveUser("0");
                }
                if(StringUtils.isEmpty(cltTestCase.getResultStatus())){
                    cltTestCase.setResultStatus("-1");
                }
            }


            List<CltCaseItemSetup> collect=null;
            if(cltTestCaseList!=null&&cltTestCaseList.size()>0){
                String projId = cltTestCaseList.get(0).getProjId();
                //根据proId查询出列名
                CltCaseItemSetupExample cltCaseItemSetupExample = new CltCaseItemSetupExample();
                CltCaseItemSetupExample.Criteria criteria = cltCaseItemSetupExample.createCriteria();
                criteria.andProIdEqualTo(projId);
                List<CltCaseItemSetup> cltCaseItemSetups = cltCaseItemSetupMapper.selectByExample(cltCaseItemSetupExample);
                 collect = cltCaseItemSetups.stream().
                        filter(clt -> !"step".equals(clt.getColumnName())).
                        collect(Collectors.toList());
            }
            CltCaseItemSetup cltCaseItemSetup = new CltCaseItemSetup();
            cltCaseItemSetup.setColumnName("receiveUser");
            cltCaseItemSetup.setLabelName("接收人");

            collect.add(cltCaseItemSetup);
            CltCaseItemSetup cltCaseSetup = new CltCaseItemSetup();
            cltCaseSetup.setColumnName("resultStatus");
            cltCaseSetup.setLabelName("执行状态");
            collect.add(cltCaseSetup);
            testCaseColum.setCltTestCases(cltTestCaseList);
            testCaseColum.setCltCaseItemSetupList(collect);
            testCaseColum.setPage(page);




        }catch (Exception e){
            logger.error("查询用例失败",e);
            logger.info("查询用例失败");
            throw new GlobalException("没有查询到用例信息",e.getMessage());
        }

        return testCaseColum;
    }

    @Override
    public CltTestCase queryTestCaseInfoById(TestCaseQuery testCaseQuery) {
        CltTestCase cltTestCase = cltTestCaseMapper.selectByPrimaryKey(testCaseQuery.getId());
        if(cltTestCase!=null){
            CltTestCaseStepExample cltTestCaseStepExample = new CltTestCaseStepExample();
            CltTestCaseStepExample.Criteria criteria = cltTestCaseStepExample.createCriteria();
            criteria.andCaseIdEqualTo(testCaseQuery.getId());

            List<CltTestCaseStep> cltTestCaseSteps = cltTestCaseStepMapper.selectByExample(cltTestCaseStepExample);
            List<CltAppFunc> lisAppFunc = new ArrayList<>();
            for(CltTestCaseStep cltTestCaseStep:cltTestCaseSteps){
                String transId = cltTestCaseStep.getTransId();
                CltAppFunc cltAppFunc = cltAppFuncMapper.selectByPrimaryKey(transId);
                //根据transId和CaseId从查询出stepData
                if(cltAppFunc!=null){
                    List<CltTestStepData> cltTestStepData = cltTestStepDataMapper.queryTestStepDataBytsId(transId, testCaseQuery.getId());
                    cltAppFunc.setCltTestStepData(cltTestStepData);
                    lisAppFunc.add(cltAppFunc);
                }
            }
            cltTestCase.setCltAppFunc(lisAppFunc);
        }

        return cltTestCase;
    }
}
