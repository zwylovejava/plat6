package net.northking.cloudplatform.dto.testexecute;

import java.util.Date;

public class JobPlan {
    private String custemName; //客户名称

    private String custemCode;

    private String projectName;//项目名称

    private String projectId;

    private String jobName;//批次名称

    private String jobId;//任务ID

    private String status;//任务状态

    private Date startDate;//任务接收时间

    private Date createDate;//预计开始时间

    private Date endDate;//预计结束时间

    private String priority;//优先级

    private String batchId;//批次ID

    private Integer bugSize;//缺陷数量

    public Integer getTestTeamCount() {
        return testTeamCount;
    }

    public void setTestTeamCount(Integer testTeamCount) {
        this.testTeamCount = testTeamCount;
    }

    private Integer testTeamCount;//团队成员数

    private String managerId;

    private String planName;

    private String roundName;

    private String managerName; //测试主管名字

    public String getCustemName() {
        return custemName;
    }

    public void setCustemName(String custemName) {
        this.custemName = custemName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getRoundName() {
        return roundName;
    }

    public void setRoundName(String roundName) {
        this.roundName = roundName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getCustemCode() {
        return custemCode;
    }

    public void setCustemCode(String custemCode) {
        this.custemCode = custemCode;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Integer getBugSize() {
        return bugSize;
    }

    public void setBugSize(Integer bugSize) {
        this.bugSize = bugSize;
    }
}
