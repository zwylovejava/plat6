package net.northking.cloudplatform.query.user;

import java.util.Arrays;

public class CreateTeam {
    private String projectId;

    private String[] userIds;

    private String[] roleIds;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
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

    @Override
    public String toString() {
        return "CreateTeam{" +
                "projectId='" + projectId + '\'' +
                ", userIds=" + Arrays.toString(userIds) +
                ", roleIds=" + Arrays.toString(roleIds) +
                '}';
    }
}
