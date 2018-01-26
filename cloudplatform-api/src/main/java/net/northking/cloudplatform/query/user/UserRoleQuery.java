package net.northking.cloudplatform.query.user;

import net.northking.cloudplatform.common.PageQuery;

public class UserRoleQuery extends PageQuery<OrgQuery> {

    //批量操作
    private  String [] userRoleIds;

    private String userRoleId;

    private String roleId;

    private String userId;

    private  String []roleIds;

     //用于更新
    private String roleIdDB;

    //用于更新
    private String  userIdDB;

    private String funcCode;

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public String getUserIdDB() {
        return userIdDB;
    }

    public void setUserIdDB(String userIdDB) {
        this.userIdDB = userIdDB;
    }

    public String[] getUserRoleIds() {
        return userRoleIds;
    }

    public void setRoleIds(String[] roleIds) {
        this.roleIds = roleIds;
    }

    public String[] getRoleIds() {
        return roleIds;
    }

    public void setUserRoleIds(String[] userRoleIds) {
        this.userRoleIds = userRoleIds;
    }

    public String getRoleIdDB() {
        return roleIdDB;
    }

    public void setRoleIdDB(String roleIdDB) {
        this.roleIdDB = roleIdDB;
    }

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId == null ? null : userRoleId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}