package net.northking.cloudplatform.query.testexecute;

import net.northking.cloudplatform.common.PageQuery;

import java.util.Date;

public class TestCaseSetQuery  extends PageQuery<TestCaseSetQuery> {
    private String caseSetId;

    private String batchId;

    private String indexSeq;

    private Integer caseNum;

    private String logicDel;

    private String createUser;

    private Date createDate;

    public String getCaseSetId() {
        return caseSetId;
    }

    public void setCaseSetId(String caseSetId) {
        this.caseSetId = caseSetId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getIndexSeq() {
        return indexSeq;
    }

    public void setIndexSeq(String indexSeq) {
        this.indexSeq = indexSeq;
    }

    public Integer getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(Integer caseNum) {
        this.caseNum = caseNum;
    }

    public String getLogicDel() {
        return logicDel;
    }

    public void setLogicDel(String logicDel) {
        this.logicDel = logicDel;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "TestCaseSetQuery{" +
                "caseSetId='" + caseSetId + '\'' +
                ", batchId='" + batchId + '\'' +
                ", indexSeq='" + indexSeq + '\'' +
                ", caseNum=" + caseNum +
                ", logicDel='" + logicDel + '\'' +
                ", createUser='" + createUser + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
