package net.northking.cloudplatform.controller;


import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.domain.testexecute.CltCaseSet;
import net.northking.cloudplatform.domain.testexecute.CltTestCase;
import net.northking.cloudplatform.dto.testexecute.TestCaseColum;
import net.northking.cloudplatform.query.testexecute.TestCaseQuery;
import net.northking.cloudplatform.query.testexecute.TestCaseSetQuery;
import net.northking.cloudplatform.result.ResultCode;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.TestCaseService;
import net.northking.cloudplatform.utils.BeanUtil;
import net.northking.cloudplatform.utils.CltUtils;
import net.northking.cloudplatform.utils.PageUtil;
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
 * create By zwy 2017/12/21
 */
@RestController
public class TestCaseController {
    @Autowired
    private TestCaseService testCaseService;

    //日志
    private final static Logger logger = LoggerFactory.getLogger(JobController.class);
    //根据批次ID查询用例集信息
    @PostMapping("/queryTestCaseSetById")
    public ResultInfo<Page<CltCaseSet>> queryTestCaseSetById(@RequestBody TestCaseSetQuery testCaseSetQuery) throws Exception {
        logger.info(" queryTestCaseSetById start paramData" + testCaseSetQuery.toString());
        PageUtil.startPage(testCaseSetQuery);
        init(testCaseSetQuery,"A");


        List<CltCaseSet> listCaseSet =  testCaseService.queryTestCaseSetById(testCaseSetQuery);


        Page<CltCaseSet> page = new Page<>(listCaseSet);

        logger.info(" queryTestCaseSetById end paramData" + testCaseSetQuery.toString());
        return new ResultInfo<Page<CltCaseSet>>(ResultCode.SUCCESS,page);
    }

    //根据用例集ID查询用例列表
    @PostMapping("/queryTestCaseById")
    public ResultInfo<TestCaseColum> queryTestCaseById(@RequestBody TestCaseSetQuery testCaseSetQuery) throws Exception {
        logger.info(" queryTestCaseById start paramData" + testCaseSetQuery.toString());
        PageUtil.startPage(testCaseSetQuery);
        init(testCaseSetQuery,"B");
        TestCaseColum  list = testCaseService.queryTestCaseById(testCaseSetQuery);

        logger.info(" queryTestCaseById end paramData" + testCaseSetQuery.toString());
        return new ResultInfo<>(ResultCode.SUCCESS,list);
    }

    //根据用例ID查询用例详情
    @PostMapping("/queryTestCaseInfoById")
    public ResultInfo<CltTestCase> queryTestCaseInfoById(@RequestBody TestCaseQuery testCaseQuery) throws Exception {
        logger.info(" queryTestCaseInfoById start paramData" + testCaseQuery.toString());
        if(StringUtils.isEmpty(testCaseQuery.getId())){

        }
        CltTestCase cltTestCase = testCaseService.queryTestCaseInfoById(testCaseQuery);
        logger.info(" queryTestCaseInfoById end paramData" + testCaseQuery.toString());
        return new ResultInfo<>(ResultCode.SUCCESS,cltTestCase);

    }








    /**
     * @Author:HBH
     * @Description: 检验参数的方法
     * @Date:19:17 2017/12/19
     * @param1:
     * @param2:
     * @return:
     */
    public static void init(TestCaseSetQuery testCaseSetQuery, String funcCode) throws Exception {

        ParamVerifyUtil paramVerifyUtil = new ParamVerifyUtil();

        Map<String, Object> dataMap = CltUtils.beanToMap(testCaseSetQuery);

        if ("A".equals(funcCode)) {

            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "batchId");
        }else if("B".equals(funcCode)){
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "caseSetId");
        }
    }

}
