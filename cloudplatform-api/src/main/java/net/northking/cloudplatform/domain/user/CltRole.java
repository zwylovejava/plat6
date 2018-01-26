package net.northking.cloudplatform.domain.user;

import net.northking.cloudplatform.common.Page;

import java.util.Date;
import java.util.List;

public class CltRole {
    private String roleId;

    public List<CltFunc> getFuncList() {
        return funcList;
    }

    public void setFuncList(List<CltFunc> funcList) {
        this.funcList = funcList;
    }

    private List<CltFunc> funcList;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    private String roleCode;

    private String roleName;

    private String proId;

    private String roleLevel;

    private String roleDesc;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private String status;

    private String isSuper;

    private List<CltFunc> funcs;

    private Integer userTotal;

    public Integer getUserTotal() {
        return userTotal;
    }

    public void setUserTotal(Integer userTotal) {
        this.userTotal = userTotal;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }

    public String getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(String roleLevel) {
        this.roleLevel = roleLevel == null ? null : roleLevel.trim();
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
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
        this.status = status == null ? null : status.trim();
    }

    public List<CltFunc> getFuncs() {
        return funcs;
    }

    public void setFuncs(List<CltFunc> funcs) {
        this.funcs = funcs;
    }

    public String getIsSuper() {
        return isSuper;
    }

    public void setIsSuper(String isSuper) {
        this.isSuper = isSuper;
    }
}