package net.northking.cloudplatform.query.testexecute;

import net.northking.cloudplatform.common.PageQuery;
import net.northking.cloudplatform.domain.testexecute.CltPlan;
import net.northking.cloudplatform.domain.testexecute.CltRound;

import java.util.Date;

/**
 * @Title:
 * @Description: 用于批次表封装参数
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-12-26 16:58
 * @UpdateUser:
 * @Version:0.1
 */


public class BatchQuery extends PageQuery<BatchQuery>{
    private String batchId;

    private String batchName;

    private String roundId;

    private Date startDate;

    private Date endDate;

    private String status;

    private Integer orderSeq;

    private Integer priority;

    private String memo;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private String logicDel;

    private String testManager;

    private CltRound cltRound;

    private CltPlan cltPlan;

    private String indexSet;

    public String getIndexSet() {
        return indexSet;
    }

    public void setIndexSet(String indexSet) {
        this.indexSet = indexSet == null ? null : indexSet.trim();
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId == null ? null : batchId.trim();
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName == null ? null : batchName.trim();
    }

    public String getRoundId() {
        return roundId;
    }

    public void setRoundId(String roundId) {
        this.roundId = roundId == null ? null : roundId.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(Integer orderSeq) {
        this.orderSeq = orderSeq;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getLogicDel() {
        return logicDel;
    }

    public void setLogicDel(String logicDel) {
        this.logicDel = logicDel == null ? null : logicDel.trim();
    }

    public String getTestManager() {
        return testManager;
    }

    public void setTestManager(String testManager) {
        this.testManager = testManager == null ? null : testManager.trim();
    }

    public CltRound getCltRound() {
        return cltRound;
    }

    public void setCltRound(CltRound cltRound) {
        this.cltRound = cltRound;
    }

    public CltPlan getCltPlan() {
        return cltPlan;
    }

    public void setCltPlan(CltPlan cltPlan) {
        this.cltPlan = cltPlan;
    }
}