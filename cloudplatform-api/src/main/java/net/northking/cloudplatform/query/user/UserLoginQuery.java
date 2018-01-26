package net.northking.cloudplatform.query.user;


import net.northking.cloudplatform.common.PageQuery;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

/**
 * @Title: 用户登录信息DTO
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/11/13
 * @UpdateUser:
 * @Version:0.1
 */
public class UserLoginQuery extends PageQuery<UserLoginQuery> {
    @NotEmpty(message = "验证码不能为空")
    private String code; //验证码

    private String codeId;

    private String email;

    private String userId;

    private String userType;
    @NotEmpty(message = "登录用户名不能为空")
    private String loginNo;

    private String userChnName;
    @NotEmpty(message = "密码不能为空")
    private String loginPwd;

    private String pwdStatus;

    private Integer pwdErrNum;

    private Date updateDate;

    private String status;

    public String getUserId() {
        return userId;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null :code.trim();
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email==null?null:email.trim();
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    @Override
    public String toString() {
        return "UserLoginQuery{" +
                "code='" + code + '\'' +
                ", codeId='" + codeId + '\'' +
                ", email='" + email + '\'' +
                ", userId='" + userId + '\'' +
                ", userType='" + userType + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", userChnName='" + userChnName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", pwdStatus='" + pwdStatus + '\'' +
                ", pwdErrNum=" + pwdErrNum +
                ", updateDate=" + updateDate +
                ", status='" + status + '\'' +
                '}';
    }
}
