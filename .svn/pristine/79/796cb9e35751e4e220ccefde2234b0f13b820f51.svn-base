package net.northking.cloudplatform.controller.testexecute;

import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.domain.testexecute.CltCaseSet;
import net.northking.cloudplatform.domain.testexecute.CltTestCase;
import net.northking.cloudplatform.dto.testexecute.TestCaseColum;
import net.northking.cloudplatform.query.testexecute.TestCaseQuery;
import net.northking.cloudplatform.query.testexecute.TestCaseSetQuery;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.testexecute.CaseService;
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

/**
 * @Title:
 * @Description:用例控制层
 * @Company: Northking
 * @Author: suny
 * @CreateDate: 2017-12-07 17:04
 * @UpdateUser:
 * @Version:0.1
 */
@RestController
public class TestCaseController {
    private final static Logger logger = LoggerFactory.getLogger(TestCaseController.class);

    @Autowired
    CaseService caseService;

    //根据批次ID查询出用例集
    @PostMapping("/queryCltCaseSetByBatchId")
    public ResultInfo<Page<CltCaseSet>> queryCltCaseSetByBatchId(@RequestBody TestCaseSetQuery testCaseSetQuery) throws Exception {

        CltUtils.printStartInfo(testCaseSetQuery, "Controller queryCltCaseSetByBatchId");

        long startTime = System.currentTimeMillis();

        //参数校验
        init(testCaseSetQuery,"B");

        //调用微服务controller接口
        ResultInfo<Page<CltCaseSet>> result  = caseService.queryCltCaseSetByBatchId(testCaseSetQuery);

        CltUtils.printEndInfo(result, " Controller queryCltCaseSetByBatchId", startTime);

        return  result;

    }

    //根据用例集ID查询出用例列表
    @PostMapping("/queryCltCaseListByCaseSetId")
    public  ResultInfo<TestCaseColum> queryCltCaseListByCaseSetId(@RequestBody TestCaseSetQuery testCaseSetQuery) throws Exception {

        CltUtils.printStartInfo(testCaseSetQuery, "Controller queryCltCaseListByCaseSetId");

        long startTime = System.currentTimeMillis();

        //参数校验
        init(testCaseSetQuery,"C");

        //调用微服务controller接口
        ResultInfo<TestCaseColum> result  = caseService.queryCltCaseIdByCaseSetId(testCaseSetQuery);

        CltUtils.printEndInfo(result, " Controller queryCltCaseListByCaseSetId", startTime);

        return  result;

    }

    //根据用例ID查询用例详情
    @PostMapping("/queryTestCaseInfoById")
    public ResultInfo<CltTestCase> queryTestCaseInfoById(@RequestBody TestCaseQuery testCaseQuery)throws Exception{
        CltUtils.printStartInfo(testCaseQuery, "Controller queryCltCaseListByCaseSetId");

        long startTime = System.currentTimeMillis();


        //调用微服务controller接口
        ResultInfo<CltTestCase> result  = caseService.queryTestCaseInfoById(testCaseQuery);

        CltUtils.printEndInfo(result, " Controller queryCltCaseListByCaseSetId", startTime);

        return  result;
    }
    //参数校验的方法
    public static void init(TestCaseSetQuery testCaseSetQuery, String funcCode) throws Exception {

        ParamVerifyUtil paramVerifyUtil = new ParamVerifyUtil();

        Map<String,Object> dataMap = CltUtils.beanToMap(testCaseSetQuery);

        if ("B".equals(funcCode)) {
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "batchId");


        }else if ("C".equals(funcCode)) {
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "caseSetId");
        }
    }
}
