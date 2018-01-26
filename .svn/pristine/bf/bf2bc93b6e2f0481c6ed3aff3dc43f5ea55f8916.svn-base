package net.northking.cloudplatform.query.dictionary;

import net.northking.cloudplatform.common.PageQuery;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Title:
 * @Description: 数据字典类型封装参数的类
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-12-28 9:11
 * @UpdateUser:
 * @Version:0.1
 */


public class DictionaryTypeQuery extends PageQuery<DictionaryTypeQuery> {

    private String typeId;
    @NotEmpty(message = "字典类型编码不能为空")
    private String typeCode;

    private String status;
    @NotEmpty(message = "字典类型名称不能为空")
    private String typeName;

    private String typeScope;

    //用于批量操作
    private String[] typeIds;

    public String[] getTypeIds() {
        return typeIds;
    }

    public void setTypeIds(String[] typeIds) {
        this.typeIds = typeIds;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getTypeScope() {
        return typeScope;
    }

    public void setTypeScope(String typeScope) {
        this.typeScope = typeScope == null ? null : typeScope.trim();
    }
}




