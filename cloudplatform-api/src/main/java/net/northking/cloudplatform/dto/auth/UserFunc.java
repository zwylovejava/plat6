package net.northking.cloudplatform.dto.auth;

import java.util.List;
import java.util.Map;

/**
 * @Title:　用户权限
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/11/27
 * @UpdateUser:
 * @Version:0.1
 */
public class UserFunc {

    /**
     * 权限名称
     */

    private String  funcId;

    private String funcCode;

    private String funcName;

    private String parentFuncId;

    private Integer funcSeq;

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public Integer getFuncSeq() {
        return funcSeq;
    }

    public void setFuncSeq(Integer funcSeq) {
        this.funcSeq = funcSeq;
    }

    public String getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getFuncDesc() {
        return funcDesc;
    }

    public void setFuncDesc(String funcDesc) {
        this.funcDesc = funcDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFuncAuth() {
        return funcAuth;
    }

    public void setFuncAuth(String funcAuth) {
        this.funcAuth = funcAuth;
    }

    public String getFuncPathName() {
        return funcPathName;
    }

    public void setFuncPathName(String funcPathName) {
        this.funcPathName = funcPathName;
    }

    public String getFuncPathId() {
        return funcPathId;
    }

    public void setFuncPathId(String funcPathId) {
        this.funcPathId = funcPathId;
    }

    private String isLeaf;

    private String funcDesc;

    private String status;

    private String funcAuth;

    private String  funcPathName;
    private String  funcPathId;

    public List<Map<String, Object>> getSonFuncMap() {
        return sonFuncMap;
    }

    public void setSonFuncMap(List<Map<String, Object>> sonFuncMap) {
        this.sonFuncMap = sonFuncMap;
    }

    private List<Map<String,Object>> sonFuncMap;

    public String getParentFuncId() {
        return parentFuncId;
    }

    public void setParentFuncId(String parentFuncId) {
        this.parentFuncId = parentFuncId;
    }

    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }

    @Override
    public String toString() {
        return "UserFunc{" +
                "funcId='" + funcId + '\'' +
                ", funcCode='" + funcCode + '\'' +
                ", funcName='" + funcName + '\'' +
                ", parentFuncId='" + parentFuncId + '\'' +
                ", funcSeq=" + funcSeq +
                ", isLeaf='" + isLeaf + '\'' +
                ", funcDesc='" + funcDesc + '\'' +
                ", status='" + status + '\'' +
                ", funcAuth='" + funcAuth + '\'' +
                ", funcPathName='" + funcPathName + '\'' +
                ", funcPathId='" + funcPathId + '\'' +
                ", sonFuncMap=" + sonFuncMap +
                ", funcUrl='" + funcUrl + '\'' +
                ", funcType=" + funcType +
                '}';
    }

    /**
     * 权限URL
     */
    private String funcUrl;

    /**
     * 菜单类型，1为左部菜单，２为头部菜单
     */
    private Integer funcType;

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getFuncUrl() {
        return funcUrl;
    }

    public void setFuncUrl(String funcUrl) {
        this.funcUrl = funcUrl;
    }

    public Integer getFuncType() {
        return funcType;
    }

    public void setFuncType(Integer funcType) {
        this.funcType = funcType;
    }
}
