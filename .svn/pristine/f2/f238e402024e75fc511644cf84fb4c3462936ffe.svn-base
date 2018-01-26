package net.northking.cloudplatform.service;

import net.northking.cloudplatform.dao.base.BaseService;
import net.northking.cloudplatform.domain.testexecute.CltCaseSet;
import net.northking.cloudplatform.domain.testexecute.CltCaseSetExample;
import net.northking.cloudplatform.domain.testexecute.CltTestCase;
import net.northking.cloudplatform.domain.testexecute.CltTestCaseExample;
import net.northking.cloudplatform.dto.testexecute.TestCaseColum;
import net.northking.cloudplatform.query.testexecute.TestCaseQuery;
import net.northking.cloudplatform.query.testexecute.TestCaseSetQuery;

import java.util.List;
import java.util.Map;

public interface TestCaseService extends BaseService<CltCaseSet,CltCaseSetExample,String> {
    List<CltCaseSet> queryTestCaseSetById(TestCaseSetQuery testCaseSetQuery);

    TestCaseColum queryTestCaseById(TestCaseSetQuery testCaseSetQuery);

    CltTestCase queryTestCaseInfoById(TestCaseQuery testCaseQuery);
}
