package net.northking.cloudplatform.query.project;




import net.northking.cloudplatform.common.PageQuery;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by laodeng on 2017/11/28.
 */
public class CltProjectTeamQuery extends PageQuery<CltProjectTeamQuery> {

    private String teamId;

    private String teamName;

    private String proId;

    private String userId;

    private String roleId;

    private String[] userIds;

    private String[] roleIds;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private String loginNo;

    private String userChnName;

    private String roleName;


    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String[] getUserIds() {
        return userIds;
    }

    public void setUserIds(String[] userIds) {
        this.userIds = userIds;
    }

    public String[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String[] roleIds) {
        this.roleIds = roleIds;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
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
        this.updateUser = updateUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getLoginNo() {
        return loginNo;
    }

    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo;
    }

    public String getUserChnName() {
        return userChnName;
    }

    public void setUserChnName(String userChnName) {
        this.userChnName = userChnName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "CltProjectTeamQuery{" +
                "teamId='" + teamId + '\'' +
                ", teamName='" + teamName + '\'' +
                ", proId='" + proId + '\'' +
                ", userId='" + userId + '\'' +
                ", roleId='" + roleId + '\'' +
                ", userIds=" + Arrays.toString(userIds) +
                ", roleIds=" + Arrays.toString(roleIds) +
                ", createUser='" + createUser + '\'' +
                ", createDate=" + createDate +
                ", updateUser='" + updateUser + '\'' +
                ", updateDate=" + updateDate +
                ", loginNo='" + loginNo + '\'' +
                ", userChnName='" + userChnName + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
