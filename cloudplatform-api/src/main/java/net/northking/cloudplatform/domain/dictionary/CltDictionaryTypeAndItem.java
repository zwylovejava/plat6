package net.northking.cloudplatform.domain.dictionary;

/**
 * @Title:
 * @Description: 字典类型和字典明细综合表
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-12-12 11:52
 * @UpdateUser:
 * @Version:0.1
 */


public class CltDictionaryTypeAndItem {

    private String typeId;

    private String typeCode;

    private String status;

    private String typeName;

    private String itemId;

    private Integer orderSeq;

    private String itemName;

    private String itemValue;

    private String typeScope;

    public String getTypeScope() {
        return typeScope;
    }

    public void setTypeScope(String typeScope) {
        this.typeScope = typeScope;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Integer getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(Integer orderSeq) {
        this.orderSeq = orderSeq;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }
}
