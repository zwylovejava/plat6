package net.northking.cloudplatform.dto.testexecute;

public class TestBugParam {
    //String currentStepId,String caseId,String code,String stepExecuteId
    private String currentStepId;
    private String caseId;
    private String code;
    private String stepExecuteId;
    private String name;

    public String getCurrentStepId() {
        return currentStepId;
    }

    public void setCurrentStepId(String currentStepId) {
        this.currentStepId = currentStepId;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStepExecuteId() {
        return stepExecuteId;
    }

    public void setStepExecuteId(String stepExecuteId) {
        this.stepExecuteId = stepExecuteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
