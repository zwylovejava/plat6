package net.northking.cloudplatform.domain.testexecute;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CltCaseItemSetup {
    private String itemSetupId;

    private String proId;

    private String columnName;

    private String labelName;

    private String selectValue;

    private String dataType;

    private Integer orderSeq;

    private String isSupportFill;

    private String isCommon;

    private String memo;

    private String createUser;

    private CltTestCase cltTestCase;
    @JsonFormat(pattern = "yyyy-MM-dd") // 取出
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 获取
    private Date createDate;

    private String updateUser;
    @JsonFormat(pattern = "yyyy-MM-dd") // 取出
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 获取
    private Date updateDate;

    private String status;

    private String index;

    public CltCaseItemSetup() {}



    public String getItemSetupId() {
        return itemSetupId;
    }

    public void setItemSetupId(String itemSetupId) {
        this.itemSetupId = itemSetupId == null ? null : itemSetupId.trim();
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName == null ? null : labelName.trim();
    }

    public String getSelectValue() {
        return selectValue;
    }

    public void setSelectValue(String selectValue) {
        this.selectValue = selectValue == null ? null : selectValue.trim();
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    public Integer getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(Integer orderSeq) {
        this.orderSeq = orderSeq;
    }

    public String getIsSupportFill() {
        return isSupportFill;
    }

    public void setIsSupportFill(String isSupportFill) {
        this.isSupportFill = isSupportFill == null ? null : isSupportFill.trim();
    }

    public String getIsCommon() {
        return isCommon;
    }

    public void setIsCommon(String isCommon) {
        this.isCommon = isCommon == null ? null : isCommon.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public CltTestCase getCltTestCase() {
        return cltTestCase;
    }

    public void setCltTestCase(CltTestCase cltTestCase) {
        this.cltTestCase = cltTestCase;
    }

    public CltCaseItemSetup(String itemSetupId, String proId, String columnName, String labelName, String selectValue, String dataType, Integer orderSeq, String isSupportFill, String isCommon, String createUser, Date createDate) {
        this.itemSetupId = itemSetupId;
        this.proId = proId;
        this.columnName = columnName;
        this.labelName = labelName;
        this.selectValue = selectValue;
        this.dataType = dataType;
        this.orderSeq = orderSeq;
        this.isSupportFill = isSupportFill;
        this.isCommon = isCommon;
        this.createUser = createUser;
        this.createDate = createDate;
    }
}

