package net.northking.cloudplatform.domain.testexecute;

import java.util.Date;

public class CltCaseSet {
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
        this.caseSetId = caseSetId == null ? null : caseSetId.trim();
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId == null ? null : batchId.trim();
    }

    public String getIndexSeq() {
        return indexSeq;
    }

    public void setIndexSeq(String indexSeq) {
        this.indexSeq = indexSeq == null ? null : indexSeq.trim();
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
        this.logicDel = logicDel == null ? null : logicDel.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}