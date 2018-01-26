package net.northking.cloudplatform.dao.testexecute;

import net.northking.cloudplatform.dao.base.BaseDao;
import net.northking.cloudplatform.domain.testexecute.CltCaseSet;
import net.northking.cloudplatform.domain.testexecute.CltCaseSetExample;
import net.northking.cloudplatform.domain.testexecute.CltTestCase;
import net.northking.cloudplatform.query.testexecute.TestCaseSetQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CltCaseSetMapper extends BaseDao<CltCaseSet,CltCaseSetExample,String> {

    List<CltCaseSet> queryTestCaseSetById(TestCaseSetQuery testCaseSetQuery);
    CltCaseSet queryTestCaseSetByCaseId(String caseId);

}