package net.northking.cloudplatform.domain.testexecute;

import java.util.Date;

public class CltTestStepExecute {
    private String stepExecuteId;

    private String executeId;

    private String caseId;

    private String stepId;

    private String executeStatus;

    private String actualResult;

    private String executeResult;

    private String createUser;

    private Date createDate;

    private Date updateTime;

    public String getStepExecuteId() {
        return stepExecuteId;
    }

    public void setStepExecuteId(String stepExecuteId) {
        this.stepExecuteId = stepExecuteId == null ? null : stepExecuteId.trim();
    }

    public String getExecuteId() {
        return executeId;
    }

    public void setExecuteId(String executeId) {
        this.executeId = executeId == null ? null : executeId.trim();
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId == null ? null : caseId.trim();
    }

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId == null ? null : stepId.trim();
    }

    public String getExecuteStatus() {
        return executeStatus;
    }

    public void setExecuteStatus(String executeStatus) {
        this.executeStatus = executeStatus == null ? null : executeStatus.trim();
    }

    public String getActualResult() {
        return actualResult;
    }

    public void setActualResult(String actualResult) {
        this.actualResult = actualResult == null ? null : actualResult.trim();
    }

    public String getExecuteResult() {
        return executeResult;
    }

    public void setExecuteResult(String executeResult) {
        this.executeResult = executeResult == null ? null : executeResult.trim();
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}