package net.northking.cloudplatform.dto.testexecute;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CltRoundDTO {
    private String roundId;

    private String roundName;

    private String planId;

    private CltPlanDTO cltPlanDTO;

    @JsonFormat(pattern = "yyyy-MM-dd") // 取出
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 获取
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd") // 取出
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 获取
    private Date endDate;

    private Integer orderSeq;

    private String memo;

    private String createUser;

    @JsonFormat(pattern = "yyyy-MM-dd") // 取出
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 获取
    private Date createDate;

    private String updateUser;

    @JsonFormat(pattern = "yyyy-MM-dd") // 取出
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 获取
    private Date updateDate;

    private String logicDel;

    public CltPlanDTO getCltPlanDTO() {
        return cltPlanDTO;
    }

    public void setCltPlanDTO(CltPlanDTO cltPlanDTO) {
        this.cltPlanDTO = cltPlanDTO;
    }

    public String getRoundId() {
        return roundId;
    }

    public void setRoundId(String roundId) {
        this.roundId = roundId == null ? null : roundId.trim();
    }

    public String getRoundName() {
        return roundName;
    }

    public void setRoundName(String roundName) {
        this.roundName = roundName == null ? null : roundName.trim();
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
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

    public Integer getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(Integer orderSeq) {
        this.orderSeq = orderSeq;
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
}