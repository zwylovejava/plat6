package net.northking.cloudplatform.dto.testexecute;

import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.domain.testexecute.CltCaseItemSetup;
import net.northking.cloudplatform.domain.testexecute.CltTestCase;

import java.util.List;

public class TestCaseColum {
    private List<CltCaseItemSetup> cltCaseItemSetupList;
    private List<CltTestCase> cltTestCases;
    private Page<CltTestCase> page;
    public List<CltCaseItemSetup> getCltCaseItemSetupList() {
        return cltCaseItemSetupList;
    }

    public void setCltCaseItemSetupList(List<CltCaseItemSetup> cltCaseItemSetupList) {
        this.cltCaseItemSetupList = cltCaseItemSetupList;
    }

    public List<CltTestCase> getCltTestCases() {
        return cltTestCases;
    }

    public void setCltTestCases(List<CltTestCase> cltTestCases) {
        this.cltTestCases = cltTestCases;
    }

    public Page<CltTestCase> getPage() {
        return page;
    }

    public void setPage(Page<CltTestCase> page) {
        this.page = page;
    }
}
