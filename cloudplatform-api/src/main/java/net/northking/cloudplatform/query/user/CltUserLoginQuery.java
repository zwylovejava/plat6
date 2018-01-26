package net.northking.cloudplatform.query.user;

import net.northking.cloudplatform.common.PageQuery;
import net.northking.cloudplatform.domain.user.CltRole;

import java.util.Date;
import java.util.List;

public class CltUserLoginQuery extends PageQuery<CltUserLoginQuery> {
    private String userId;

    private String userType;

    private String loginNo;

    private String userChnName;

    private String loginPwd;

    private String pwdStatus;

    private Integer pwdErrNum;

    private Date updateDate;

    private String status;

    private String isSuper;

    private List<CltRole> roles;

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "CltUserLogin{" +
                "userId='" + userId + '\'' +
                ", userType='" + userType + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", userChnName='" + userChnName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", pwdStatus='" + pwdStatus + '\'' +
                ", pwdErrNum=" + pwdErrNum +
                ", updateDate=" + updateDate +
                ", status='" + status + '\'' +
                ", isSuper='" + isSuper + '\'' +
                ", roles=" + roles +
                '}';
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getLoginNo() {
        return loginNo;
    }

    public void setLoginNo(String loginNo) {
        this.loginNo = loginNo == null ? null : loginNo.trim();
    }

    public String getUserChnName() {
        return userChnName;
    }

    public void setUserChnName(String userChnName) {
        this.userChnName = userChnName == null ? null : userChnName.trim();
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();
    }

    public String getPwdStatus() {
        return pwdStatus;
    }

    public void setPwdStatus(String pwdStatus) {
        this.pwdStatus = pwdStatus == null ? null : pwdStatus.trim();
    }

    public Integer getPwdErrNum() {
        return pwdErrNum;
    }

    public void setPwdErrNum(Integer pwdErrNum) {
        this.pwdErrNum = pwdErrNum;
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

    public List<CltRole> getRoles() {
        return roles;
    }

    public void setRoles(List<CltRole> roles) {
        this.roles = roles;
    }

    public String getIsSuper() {
        return isSuper;
    }

    public void setIsSuper(String isSuper) {
        this.isSuper = isSuper;
    }
}
