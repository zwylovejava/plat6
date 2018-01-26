package net.northking.cloudplatform.query.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.northking.cloudplatform.common.PageQuery;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by HBH on 2017/11/10.
 */
public class UserQuery extends PageQuery<UserQuery> {

    private String userId;
    @NotEmpty(message = "客户不能为空!")
    private String custId;

    private String orgId;
    @NotEmpty(message = "性别不能为空!")
    private String gender;
    @NotEmpty(message = "民族不能为空!")
    private String nationality;
    @NotEmpty(message = "证件类型不能为空!")
    private String idType;
    @NotEmpty(message = "证件号码不能为空!")
    private String idNo;

    private String marriage;

    private String politics;

    private String familyCountyId;
    @Email(message = "邮箱格式有误!请重新输入!")
    private String email;
    @NotEmpty(message = "电话号码不能为空!")
    @Pattern(regexp ="^1[3-9]\\d{9}$",message = "手机格式有误!请重新输入")
    private String cellPhone;
    @NotEmpty(message = "地址不能为空!")
    private String address;
    @JsonFormat(pattern = "yyyy-MM-dd") // 取出
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 获取
    private Date birthday;
    @NotEmpty(message = "毕业院校不能为空!")
    private String graduatedSchool;
    @NotEmpty(message = "毕业时间不能为空!")
    private String graduatedDate;
    @NotEmpty(message = "毕业专业不能为空!")
    private String graduatedSpecialty;
    @NotEmpty(message = "学历不能为空!")
    private String eduCode;
    @NotEmpty(message = "专业特长不能为空!")
    private String skillsCertificate;

    private String specialty;

    private String workStatus;

    private String createUser;
    @JsonFormat(pattern = "yyyy-MM-dd") // 取出
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 获取
    private Date createDate;

    private String updateUser;
    @JsonFormat(pattern = "yyyy-MM-dd") // 取出
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 获取
    private Date updateDate;

    private String expands;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage == null ? null : marriage.trim();
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics == null ? null : politics.trim();
    }

    public String getFamilyCountyId() {
        return familyCountyId;
    }

    public void setFamilyCountyId(String familyCountyId) {
        this.familyCountyId = familyCountyId == null ? null : familyCountyId.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone == null ? null : cellPhone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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
        this.graduatedSchool = graduatedSchool == null ? null : graduatedSchool.trim();
    }

    public String getGraduatedDate() {
        return graduatedDate;
    }

    public void setGraduatedDate(String graduatedDate) {
        this.graduatedDate = graduatedDate == null ? null : graduatedDate.trim();
    }

    public String getGraduatedSpecialty() {
        return graduatedSpecialty;
    }

    public void setGraduatedSpecialty(String graduatedSpecialty) {
        this.graduatedSpecialty = graduatedSpecialty == null ? null : graduatedSpecialty.trim();
    }

    public String getEduCode() {
        return eduCode;
    }

    public void setEduCode(String eduCode) {
        this.eduCode = eduCode == null ? null : eduCode.trim();
    }

    public String getSkillsCertificate() {
        return skillsCertificate;
    }

    public void setSkillsCertificate(String skillsCertificate) {
        this.skillsCertificate = skillsCertificate == null ? null : skillsCertificate.trim();
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty == null ? null : specialty.trim();
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus == null ? null : workStatus.trim();
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

    public String getExpands() {
        return expands;
    }

    public void setExpands(String expands) {
        this.expands = expands == null ? null : expands.trim();
    }
}