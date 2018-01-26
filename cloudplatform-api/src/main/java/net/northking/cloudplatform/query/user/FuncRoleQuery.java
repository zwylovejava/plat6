package net.northking.cloudplatform.query.user;


import net.northking.cloudplatform.common.PageQuery;

public class FuncRoleQuery extends PageQuery<FuncRoleQuery> {

    //用于批量操作
    private String [] funcRoleIds;

    public String[] getFuncRoleIds() {
        return funcRoleIds;
    }

    public void setFuncRoleIds(String[] funcRoleIds) {
        this.funcRoleIds = funcRoleIds;
    }

    private String [] funcIds;

    public String[] getFuncIds() {
        return funcIds;
    }

    public void setFuncIds(String[] funcIds) {
        this.funcIds = funcIds;
    }

    private String funcRoleId;

    private String roleId;

    private String funcId;

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

    private String  funcPathName;
    private String  funcPathId;

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


}