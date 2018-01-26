package net.northking.cloudplatform.controller;


import net.northking.cloudplatform.domain.testexecute.CltTestStepData;
import net.northking.cloudplatform.dto.testexecute.TestCaseStepData;
import net.northking.cloudplatform.result.ResultCode;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.TestCaseStepService;
import net.northking.cloudplatform.domain.testexecute.CltTestCaseStep;
import net.northking.cloudplatform.domain.testexecute.CltTestCaseStepExample;
import net.northking.cloudplatform.query.testexecute.TestCaseStepQuery;

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

@RestController
public class TestCaseStepController {
    @Autowired
    private TestCaseStepService testCaseStepService;
    private Logger logger = LoggerFactory.getLogger(getClass());
  //根据测试用例查询测试步骤
    @PostMapping("/queryTestCaseStepByCaseId")
    public List<CltTestCaseStep> queryTestCaseStepByCaseId(@RequestBody TestCaseStepQuery testCaseStepQuery) throws Exception {
        logger.info("queryTestCaseStepByCaseId start param:"+testCaseStepQuery);
        //校验参数
        init(testCaseStepQuery,"A");
        CltTestCaseStepExample cltTestCaseStepExample = new CltTestCaseStepExample();
        CltTestCaseStepExample.Criteria criteria = cltTestCaseStepExample.createCriteria();
        criteria.andCaseIdEqualTo(testCaseStepQuery.getCaseId());
        List<CltTestCaseStep> list = testCaseStepService.findList(cltTestCaseStepExample);
        logger.info(" queryTestCaseStepByCaseId end paramData"+"");
        return list;
    }
    //根据caseId和测试步骤顺序号保存测试数据
    @PostMapping("/quryStepDataByCaseId")
    public ResultInfo<TestCaseStepData> quryStepDataByCaseId(@RequestBody TestCaseStepQuery testCaseStepQuery) throws Exception{
       // long startTime = System.currentTimeMillis();
        logger.info("queryTestCaseStepByCaseId start param:"+testCaseStepQuery);
        //先判断caseId和idx是否为空
        //校验参数
        init(testCaseStepQuery,"A");
        if(testCaseStepQuery.getIdx()>1){
            init(testCaseStepQuery,"B");
        }

        TestCaseStepData testCaseStepData = testCaseStepService.quryStepDataByCaseId(testCaseStepQuery);

        logger.info("queryTestCaseStepByCaseId end param:"+testCaseStepData);
        long endTime = System.currentTimeMillis();
       // System.out.println("<<<<<<<<<<<<<>>>>>>>>>>>>>"+(endTime-startTime)+"");
        if(ResultCode.NOJOB.code().equals(testCaseStepData.getCode())){

            return new ResultInfo<TestCaseStepData>(ResultCode.NOJOB,testCaseStepData);
        }
        return new ResultInfo<TestCaseStepData>(ResultCode.SUCCESS,testCaseStepData);

    }

    /**
     * @Author:HBH
     * @Description: 检验参数的方法
     * @Date:19:17 2017/12/19
     * @param1:
     * @param2:
     * @return:
     */
    public void init(TestCaseStepQuery testCaseStepQuery, String funcCode) throws Exception {

        ParamVerifyUtil paramVerifyUtil = new ParamVerifyUtil();

        Map<String, Object> dataMap = CltUtils.beanToMap(testCaseStepQuery);

        if ("A".equals(funcCode)) {

            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "caseId","idx");
        }else if("B".equals(funcCode)){
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "executeStatus");
        }

    }

}
