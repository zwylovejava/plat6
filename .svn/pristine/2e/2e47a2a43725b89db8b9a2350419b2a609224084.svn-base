package net.northking.cloudplatform.service.testexecute;
import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.domain.testexecute.CltCaseSet;
import net.northking.cloudplatform.domain.testexecute.CltTestCase;
import net.northking.cloudplatform.dto.testexecute.TestCaseColum;
import net.northking.cloudplatform.query.testexecute.TestCaseQuery;
import net.northking.cloudplatform.query.testexecute.TestCaseSetQuery;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
public interface CaseService {


    //根据批次ID查询出用例集
    ResultInfo<Page<CltCaseSet>> queryCltCaseSetByBatchId(TestCaseSetQuery testCaseSetQuery)throws Exception;

    //根据用例集ID查询出所有用例信息
    ResultInfo<TestCaseColum> queryCltCaseIdByCaseSetId(TestCaseSetQuery testCaseSetQuery)throws Exception;

    //根据用例ID查询用例详情
    ResultInfo<CltTestCase> queryTestCaseInfoById(@RequestBody TestCaseQuery testCaseQuery)throws Exception;
}
