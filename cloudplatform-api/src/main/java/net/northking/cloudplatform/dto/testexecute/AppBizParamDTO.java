package net.northking.cloudplatform.dto.testexecute;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by ZW on 2017/11/15.
 */
public class AppBizParamDTO {
    private String id;

    private String code;

    private String name;

    private String type;

    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd") // 取出
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 获取
    private Date createTime;

    private String creator;
    @JsonFormat(pattern = "yyyy-MM-dd") // 取出
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 获取
    private Date lastModifyTime;

    private String lastModifier;

    private String logicDel;

    private String enable;

    private String memo;

    private String value;
    private String proId;

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getLastModifier() {
        return lastModifier;
    }

    public void setLastModifier(String lastModifier) {
        this.lastModifier = lastModifier == null ? null : lastModifier.trim();
    }

    public String getLogicDel() {
        return logicDel;
    }

    public void setLogicDel(String logicDel) {
        this.logicDel = logicDel == null ? null : logicDel.trim();
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable == null ? null : enable.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    @Override
    public String toString() {
        return "AppBizParamDTO{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", creator='" + creator + '\'' +
                ", lastModifyTime=" + lastModifyTime +
                ", lastModifier='" + lastModifier + '\'' +
                ", logicDel='" + logicDel + '\'' +
                ", enable='" + enable + '\'' +
                ", memo='" + memo + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}