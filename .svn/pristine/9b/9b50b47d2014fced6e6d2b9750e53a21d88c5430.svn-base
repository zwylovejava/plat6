package net.northking.cloudplatform.query.dictionary;

import net.northking.cloudplatform.common.PageQuery;
import org.hibernate.validator.constraints.NotEmpty;


/**
 * @Title:
 * @Description: 数据字典封装参数的类
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-12-28 9:09
 * @UpdateUser:
 * @Version:0.1
 */


public class DictionaryItemQuery extends PageQuery<DictionaryItemQuery> {
    private String itemId;

    private Integer orderSeq;
    @NotEmpty(message = "字典条目名称不能为空")
    private String itemName;
    @NotEmpty(message = "字典条目值不能为空")
    private String itemValue;
    @NotEmpty(message = "字典类型不能为空")
    private String typeId;

    private String typeCode;

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    //用于批量操作
    private String[] itemIds;

    public String[] getItemIds() {
        return itemIds;
    }

    public void setItemIds(String[] itemIds) {
        this.itemIds = itemIds;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
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
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue == null ? null : itemValue.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }
}
