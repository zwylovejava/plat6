package net.northking.cloudplatform.dto.testexecute;

/**
 * @Title: workItem数据
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/12/27
 * @UpdateUser:
 * @Version:0.1
 */
public class WorkItemData {
    private String jobId;
    private String entityId;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }
}
