package net.northking.cloudplatform.service;

import net.northking.cloudplatform.dao.base.BaseService;
import net.northking.cloudplatform.domain.testexecute.CltTestCaseStep;
import net.northking.cloudplatform.domain.testexecute.CltTestCaseStepExample;
import net.northking.cloudplatform.domain.testexecute.CltTestStepData;
import net.northking.cloudplatform.dto.testexecute.TestCaseStepData;
import net.northking.cloudplatform.query.testexecute.TestCaseStepQuery;
import net.northking.cloudplatform.result.ResultInfo;

import java.util.List;

public interface TestCaseStepService extends BaseService<CltTestCaseStep,CltTestCaseStepExample,String> {
    TestCaseStepData quryStepDataByCaseId(TestCaseStepQuery testCaseStepQuery);
}
