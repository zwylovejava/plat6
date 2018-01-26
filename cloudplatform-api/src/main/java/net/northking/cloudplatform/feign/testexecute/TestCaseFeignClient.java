package net.northking.cloudplatform.feign.testexecute;

import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.domain.testexecute.CltCaseSet;
import net.northking.cloudplatform.domain.testexecute.CltTestCase;
import net.northking.cloudplatform.dto.testexecute.TestCaseColum;
import net.northking.cloudplatform.query.testexecute.TestCaseQuery;
import net.northking.cloudplatform.query.testexecute.TestCaseSetQuery;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@FeignClient(name = "cloudplatform-gateway")
public interface TestCaseFeignClient {
    //根据批次ID查询用例集信息
    @RequestMapping(value = "/testexecute/queryTestCaseSetById", method = RequestMethod.POST, consumes="application/json")
     ResultInfo<Page<CltCaseSet>> queryTestCaseSetById(@RequestBody TestCaseSetQuery testCaseSetQuery) throws Exception;
    //根据用例集ID查询用例列表
    @RequestMapping(value = "/testexecute/queryTestCaseById", method = RequestMethod.POST, consumes="application/json")
    public ResultInfo<TestCaseColum> queryTestCaseById(@RequestBody TestCaseSetQuery testCaseSetQuery);

    //根据用例ID查询用例详情
    @RequestMapping(value = "/testexecute/queryTestCaseInfoById", method = RequestMethod.POST, consumes="application/json")
    public ResultInfo<CltTestCase> queryTestCaseInfoById(@RequestBody TestCaseQuery testCaseQuery);
}
