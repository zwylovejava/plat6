package net.northking.cloudplatform.domain.user;

import java.util.List;

public class CltFunc {
    private String funcId;
    private CltFunc cltFunc;
    public List<CltFunc> getSonFuncMap() {
        return sonFuncMap;
    }

    public List<CltFunc> getFuncList() {
        return funcList;
    }

    public void setFuncList(List<CltFunc> funcList) {
        this.funcList = funcList;
    }

    private List<CltFunc> funcList;

    public void setSonFuncMap(List<CltFunc> sonFuncMap) {
        this.sonFuncMap = sonFuncMap;
    }

    private List<CltFunc>  sonFuncMap;

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    private String funcCode;

    private String funcName;

    private String parentFuncId;

    private Integer funcSeq;

    private String isLeaf;

    private String funcDesc;

    private String funcUrl;

    private String status;

    private Integer funcType;

    private String funcAuth;

    private String  funcPathName;
    private String  funcPathId;

    public String getFuncPathId() {
        return funcPathId;
    }

    public void setFuncPathId(String funcPathId) {
        this.funcPathId = funcPathId;
    }

    public String getFuncPathName() {
        return funcPathName;
    }

    public void setFuncPathName(String funcPathName) {
        this.funcPathName = funcPathName;
    }


    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId == null ? null : funcId.trim();
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName == null ? null : funcName.trim();
    }

    public String getParentFuncId() {
        return parentFuncId;
    }

    public void setParentFuncId(String parentFuncId) {
        this.parentFuncId = parentFuncId == null ? null : parentFuncId.trim();
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
        this.isLeaf = isLeaf == null ? null : isLeaf.trim();
    }

    public String getFuncDesc() {
        return funcDesc;
    }

    public void setFuncDesc(String funcDesc) {
        this.funcDesc = funcDesc == null ? null : funcDesc.trim();
    }

    public String getFuncUrl() {
        return funcUrl;
    }

    public void setFuncUrl(String funcUrl) {
        this.funcUrl = funcUrl == null ? null : funcUrl.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getFuncType() {
        return funcType;
    }

    public void setFuncType(Integer funcType) {
        this.funcType = funcType;
    }

    public String getFuncAuth() {
        return funcAuth;
    }

    public void setFuncAuth(String funcAuth) {
        this.funcAuth = funcAuth;
    }

    public CltFunc getCltFunc() {
        return cltFunc;
    }

    public void setCltFunc(CltFunc cltFunc) {
        this.cltFunc = cltFunc;
    }
}