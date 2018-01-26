package net.northking.cloudplatform.controller;

import net.northking.cloudplatform.assist.RedisUtil;
import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.constants.SuccessConstants;
import net.northking.cloudplatform.domain.testbug.CltTestBug;
import net.northking.cloudplatform.domain.user.CltUserLogin;
import net.northking.cloudplatform.query.testbug.TestBugQuery;
import net.northking.cloudplatform.result.ResultCode;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.TestBugService;
import net.northking.cloudplatform.utils.CltUtils;
import net.northking.cloudplatform.utils.ParamVerifyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Title:
 * @Description: CltBug控制层
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-12-25 13:38
 * @UpdateUser:
 * @Version:0.1
 */

@RestController
public class TestBugController {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    private TestBugService testBugService;


    //日志
    private final static Logger logger = LoggerFactory.getLogger(TestBugController.class);

    //添加缺陷信息
    @PostMapping("/addTestBug")
    public ResultInfo<Integer> addTestBug(@RequestBody @Validated TestBugQuery testBugQuery) throws Exception {

        logger.info(" addTestBug start paramData" + testBugQuery.toString());


       CltUserLogin cltUserLogin = (CltUserLogin) redisUtil.get(testBugQuery.getAccess_token());

        if(cltUserLogin!=null){

            testBugQuery.setCreateUser(cltUserLogin.getUserId());
        }

       Integer result = testBugService.addTestBug(testBugQuery);

        logger.info(" addTestBug end paramData");

        return  new ResultInfo<>(ResultCode.SUCCESS, SuccessConstants.ADD_CLT_TEST_BUG_INFO_SUCCESS, result);

    }

    //查询缺陷列表
    @PostMapping("/queryAllTestBugs")
    public ResultInfo<Page<CltTestBug>> queryAllTestBugs(@RequestBody  TestBugQuery testBugQuery) throws Exception {

        logger.info(" queryAllTestBugs start paramData" + testBugQuery.toString());

        Page<CltTestBug> page =testBugService.queryTestBugList(testBugQuery);

        logger.info(" queryAllTestBugs end paramData");

        return new ResultInfo<>(ResultCode.SUCCESS.code(),  SuccessConstants.QUERY_TEST_BUG_LIST_SUCCESS, page);

    }
    //根据caseId查询缺陷列表
    @PostMapping("/queryTestBugByCaseId")
    public ResultInfo<List<CltTestBug>> queryTestBugByCaseId(@RequestBody  TestBugQuery testBugQuery) throws Exception {

        logger.info(" queryTestBugByCaseId start paramData" + testBugQuery.toString());

        init(testBugQuery,"queryTestBugByCaseId");

        List<CltTestBug> testBugs = testBugService.queryTestBugByCaseId(testBugQuery);

        logger.info(" queryTestBugByCaseId end paramData");

        return new ResultInfo<>(ResultCode.SUCCESS.code(),  SuccessConstants.QUERY_TEST_BUG_LIST_SUCCESS, testBugs);

    }
    //查询缺陷的详细信息
    @PostMapping("/queryBugByBugId")
    public ResultInfo<CltTestBug> queryBugByBugId(@RequestBody TestBugQuery testBugQuery) throws Exception {

        logger.info(" queryBugByBugId start paramData" + testBugQuery.toString());

        //对参数进行校验
        init(testBugQuery, "queryBugByBugId");

        CltTestBug cltTestBug = testBugService.queryBugByBugId(testBugQuery.getBugId());

        logger.info(" queryBugByBugId end paramData");

        return new ResultInfo<>(ResultCode.SUCCESS.code(),SuccessConstants.QUERY_TEST_BUG_INFO_SUCCESS, cltTestBug);


    }

    //根据StepId和caseId判断缺陷是否已添加
    @PostMapping("/queryTestBugBycaseID")
    public ResultInfo<List<CltTestBug>> queryTestBugById(@RequestBody TestBugQuery testBugQuery) throws Exception {
        logger.info(" queryTestBugById start paramData" + testBugQuery.toString());
        init(testBugQuery, "queryTestBugById");
        List<CltTestBug> cltTestBug= testBugService.queryTestBugById(testBugQuery);
        logger.info(" queryBugByBugId end paramData");
        return new ResultInfo<>(ResultCode.SUCCESS,cltTestBug);
    }

    //根据批次ID查询缺陷列表
    @PostMapping("/queryTestBugByBathId")
    public ResultInfo<List<CltTestBug>> queryTestBugByBathId(@RequestBody TestBugQuery testBugQuery) throws Exception {
        logger.info(" queryTestBugByBathId start paramData" + testBugQuery.toString());
        init(testBugQuery,"queryTestBugByBathId");
        List<CltTestBug> testBugList = testBugService.queryTestBugByBathId(testBugQuery);
        logger.info(" queryTestBugByBathId end paramData");
        return new ResultInfo<>(ResultCode.SUCCESS,testBugList);
    }


    //参数校验的方法

    public static void init(TestBugQuery testBugQuery, String funcCode) throws Exception {



        Map<String, Object> dataMap = CltUtils.beanToMap(testBugQuery);

        if ("queryBugByBugId".equals(funcCode)) {
            ParamVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "bugId");
        }else if("queryTestBugById".equalsIgnoreCase(funcCode)){
            ParamVerifyUtil.checkNullOrEmpty(dataMap,logger,"caseId","stepId");

        }else if("queryTestBugByBathId".equalsIgnoreCase(funcCode)){
            ParamVerifyUtil.checkNullOrEmpty(dataMap,logger,"batchId");
        }else if("queryTestBugByCaseId".equalsIgnoreCase(funcCode)){
            ParamVerifyUtil.checkNullOrEmpty(dataMap,logger,"caseId");
        }

    }

    }
