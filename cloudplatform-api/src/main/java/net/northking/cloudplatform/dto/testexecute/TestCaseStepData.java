package net.northking.cloudplatform.dto.testexecute;

import java.util.List;

public class TestCaseStepData {
    private String caseId;
    private String stepId;
    private String message;
    private Integer maxIdx;
    private String stepExecuteId;
    private String stepName;
    private String Code;
    private List<StepDataInfo> stepDataInfoList;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getStepId() {
        return stepId;
    }

    public void setStepId(String stepId) {
        this.stepId = stepId;
    }

    public List<StepDataInfo> getStepDataInfoList() {
        return stepDataInfoList;
    }

    public void setStepDataInfoList(List<StepDataInfo> stepDataInfoList) {
        this.stepDataInfoList = stepDataInfoList;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getMaxIdx() {
        return maxIdx;
    }

    public void setMaxIdx(Integer maxIdx) {
        this.maxIdx = maxIdx;
    }

    public String getStepExecuteId() {
        return stepExecuteId;
    }

    public void setStepExecuteId(String stepExecuteId) {
        this.stepExecuteId = stepExecuteId;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }
}
