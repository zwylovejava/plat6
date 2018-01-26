package net.northking.cloudplatform.query.user;


import net.northking.cloudplatform.common.PageQuery;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * Created by laodeng on 2017/11/21.
 */
public class RoleQuery extends PageQuery<RoleQuery> {

    //批量删除的id集合
    private  String[] ids;

    private String roleCode;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    //接收服务器需要导入的excel表的地址路径
    private String filePath;

//    @NotEmpty(message = "路径不能为空")
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private String roleId;

    @NotEmpty(message = "角色名不能为空")
    private String roleName;

    private String proId;

    @NotEmpty(message = "角色级别不能为空")
    private String roleLevel;

    private String roleDesc;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private String status;

    private String isSuper;

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

    public String getIsSuper() {
        return isSuper;
    }

    public void setIsSuper(String isSuper) {
        this.isSuper = isSuper;
    }

    @Override
    public String toString() {
        return "RoleQuery{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", proId='" + proId + '\'' +
                ", roleLevel='" + roleLevel + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", createUser='" + createUser + '\'' +
                ", createDate=" + createDate +
                ", updateUser='" + updateUser + '\'' +
                ", updateDate=" + updateDate +
                ", status='" + status + '\'' +
                '}';
    }
}
