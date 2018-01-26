package net.northking.cloudplatform.domain.user;

public class CltFuncRole {


    private String funcRoleId;

    private String roleId;

    private String funcId;

    private String funcName;

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    private String roleName;

    public String getFuncRoleId() {
        return funcRoleId;
    }

    public void setFuncRoleId(String funcRoleId) {
        this.funcRoleId = funcRoleId == null ? null : funcRoleId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId == null ? null : funcId.trim();
    }
}