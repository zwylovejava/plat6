package net.northking.cloudplatform.query.user;

import com.fasterxml.jackson.annotation.JsonFormat;

import net.northking.cloudplatform.common.PageQuery;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import java.util.Arrays;
import java.util.Date;

/**
 * @Title:
 * @Description: 用户封装登录表和用户详情表的参数
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-11-17 11:02
 * @UpdateUser:
 * @Version:0.1
 */

public class UserAndLoginQuery extends PageQuery<UserAndLoginQuery> {

    //需要批量处理的用户id数组
    private String[] userIds;
    private String userId;
    @NotEmpty(message = "用户类型不能为空!")
    private String userType;
    @NotEmpty(message = "登录名不能为空!")
    private String loginNo;
    @NotEmpty(message = "中文名称不能为空!")
    private String userChnName;

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    private String funcCode;

    private String loginPwd;

    private String pwdStatus;

    private Integer pwdErrNum;

    private String status;

    private String custId;

    private String orgId;
    //机构名
    private String orgName;
    @NotEmpty(message = "性别不能为空!")
    private String gender;

    private String nationality;

    private String idType;

    private String idNo;

    private String marriage;

    private String politics;

    private String familyCountyId;
    @Email(message = "邮箱格式有误!请重新输入!")
    private String email;
    @NotEmpty(message = "电话号码不能为空!")
    @Pattern(regexp ="^1[3-9]\\d{9}$",message = "手机格式有误!请重新输入")
    private String cellPhone;

    private String address;
    @JsonFormat(pattern = "yyyy-MM-dd") // 取出
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 获取
    private Date birthday;

    private String graduatedSchool;

    private String graduatedDate;

    private String graduatedSpecialty;

    private String eduCode;

    private String skillsCertificate;

    private String specialty;

    private String workStatus;

    private String createUser;

    private String roleCode;

    //判断是否为测试主管
    private String isTestManager;

    public String getIsTestManager() {
        return isTestManager;
    }

    public void setIsTestManager(String isTestManager) {
        this.isTestManager = isTestManager;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @JsonFormat(pattern = "yyyy-MM-dd") // 取出
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 获取
    private Date createDate;

    private String updateUser;
    @JsonFormat(pattern = "yyyy-MM-dd") // 取出
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 获取
    private Date updateDate;

    private String isSuper;

    public String getIsSuper() {
        return isSuper;
    }

    public void setIsSuper(String isSuper) {
        this.isSuper = isSuper;
    }

    private String expands;

    public String[] getUserIds() {
        return userIds;
    }

    public void setUserIds(String[] userIds) {
        this.userIds = userIds;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getPwdStatus() {
        return pwdStatus;
    }

    public void setPwdStatus(String pwdStatus) {
        this.pwdStatus = pwdStatus;
    }

    public Integer getPwdErrNum() {
        return pwdErrNum;
    }

    public void setPwdErrNum(Integer pwdErrNum) {
        this.pwdErrNum = pwdErrNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getFamilyCountyId() {
        return familyCountyId;
    }

    public void setFamilyCountyId(String familyCountyId) {
        this.familyCountyId = familyCountyId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGraduatedSchool() {
        return graduatedSchool;
    }

    public void setGraduatedSchool(String graduatedSchool) {
        this.graduatedSchool = graduatedSchool;
    }

    public String getGraduatedDate() {
        return graduatedDate;
    }

    public void setGraduatedDate(String graduatedDate) {
        this.graduatedDate = graduatedDate;
    }

    public String getGraduatedSpecialty() {
        return graduatedSpecialty;
    }

    public void setGraduatedSpecialty(String graduatedSpecialty) {
        this.graduatedSpecialty = graduatedSpecialty;
    }

    public String getEduCode() {
        return eduCode;
    }

    public void setEduCode(String eduCode) {
        this.eduCode = eduCode;
    }

    public String getSkillsCertificate() {
        return skillsCertificate;
    }

    public void setSkillsCertificate(String skillsCertificate) {
        this.skillsCertificate = skillsCertificate;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
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

    public String getExpands() {
        return expands;
    }

    public void setExpands(String expands) {
        this.expands = expands;
    }

    @Override
    public String toString() {
        return "UserAndLoginQuery{" +
                "userIds=" + Arrays.toString(userIds) +
                ", userId='" + userId + '\'' +
                ", userType='" + userType + '\'' +
                ", loginNo='" + loginNo + '\'' +
                ", userChnName='" + userChnName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", pwdStatus='" + pwdStatus + '\'' +
                ", pwdErrNum=" + pwdErrNum +
                ", status='" + status + '\'' +
                ", custId='" + custId + '\'' +
                ", orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                ", idType='" + idType + '\'' +
                ", idNo='" + idNo + '\'' +
                ", marriage='" + marriage + '\'' +
                ", politics='" + politics + '\'' +
                ", familyCountyId='" + familyCountyId + '\'' +
                ", email='" + email + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", graduatedSchool='" + graduatedSchool + '\'' +
                ", graduatedDate='" + graduatedDate + '\'' +
                ", graduatedSpecialty='" + graduatedSpecialty + '\'' +
                ", eduCode='" + eduCode + '\'' +
                ", skillsCertificate='" + skillsCertificate + '\'' +
                ", specialty='" + specialty + '\'' +
                ", workStatus='" + workStatus + '\'' +
                ", createUser='" + createUser + '\'' +
                ", createDate=" + createDate +
                ", updateUser='" + updateUser + '\'' +
                ", updateDate=" + updateDate +
                ", expands='" + expands + '\'' +
                '}';
    }


}









