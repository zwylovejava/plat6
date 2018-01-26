package net.northking.cloudplatform.dto.testexecute;

import java.util.List;

/**
 * @Title: 队列数据
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/12/27
 * @UpdateUser:
 * @Version:0.1
 */
public class QueueData {
    private boolean success;
    private int total;

    private List<WorkItemData> workItems;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<WorkItemData> getWorkItems() {
        return workItems;
    }

    public void setWorkItems(List<WorkItemData> workItems) {
        this.workItems = workItems;
    }
}
