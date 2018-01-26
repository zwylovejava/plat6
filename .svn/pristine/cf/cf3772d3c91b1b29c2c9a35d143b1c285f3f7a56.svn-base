package net.northking.cloudplatform.dto.testexecute;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CltBatchDTO {
    private String batchId;

    private String batchName;

    private String roundId;

    private CltRoundDTO cltRoundDTO;

    @JsonFormat(pattern = "yyyy-MM-dd") // 取出
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 获取
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd") // 取出
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 获取
    private Date endDate;

    private String status;

    private Integer orderSeq;

    private Integer priority;

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

    private CltProjectDTO projectDTO;

    private String indexSet;

    public CltRoundDTO getCltRoundDTO() {
        return cltRoundDTO;
    }

    public void setCltRoundDTO(CltRoundDTO cltRoundDTO) {
        this.cltRoundDTO = cltRoundDTO;
    }

    public String getIndexSet() {
        return indexSet;
    }

    public void setIndexSet(String indexSet) {
        this.indexSet = indexSet == null ? null : indexSet.trim();
    }

    private List<CltCaseSetDTO> caseSets=new ArrayList<>();

    public CltProjectDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(CltProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }

    public List<CltCaseSetDTO> getCaseSets() {
        return caseSets;
    }

    public void setCaseSets(List<CltCaseSetDTO> caseSets) {
        this.caseSets = caseSets;
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
}