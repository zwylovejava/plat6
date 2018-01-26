package net.northking.cloudplatform.query.user;



import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.common.PageQuery;
import net.northking.cloudplatform.domain.user.CltOrg;
import net.northking.cloudplatform.domain.user.CltUserAndLogin;

import java.util.Date;

/**
 * Created by HBH on 2017/11/10.
 */
public class OrgQuery extends PageQuery<OrgQuery> {

    private String funCode;

    public String getFunCode() {
        return funCode;
    }

    public void setFunCode(String funCode) {
        this.funCode = funCode;
    }

    private CltOrg cltOrg;

    public CltOrg getCltOrg() {
        return cltOrg;
    }

    public void setCltOrg(CltOrg cltOrg) {
        this.cltOrg = cltOrg;
    }

    private Page<CltUserAndLogin> userList;

    public Page<CltUserAndLogin> getUserList() {
        return userList;
    }

    public void setUserList(Page<CltUserAndLogin> userList) {
        this.userList = userList;
    }


    private String orgId;
    private String parentOrgId;

    @Override
    public String toString() {
        return "OrgQuery{" +
                "funCode='" + funCode + '\'' +
                ", cltOrg=" + cltOrg +
                ", userList=" + userList +
                ", orgId='" + orgId + '\'' +
                ", parentOrgId='" + parentOrgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", custId='" + custId + '\'' +
                ", orgSeq=" + orgSeq +
                ", orgDesc='" + orgDesc + '\'' +
                ", createUser='" + createUser + '\'' +
                ", createDate=" + createDate +
                ", updateUser='" + updateUser + '\'' +
                ", updateDate=" + updateDate +
                ", isLeaf='" + isLeaf + '\'' +
                ", orgLevel=" + orgLevel +
                ", orgGradation='" + orgGradation + '\'' +
                ", managerName='" + managerName + '\'' +
                ", managerEmail='" + managerEmail + '\'' +
                ", managerPhone='" + managerPhone + '\'' +
                ", expands='" + expands + '\'' +
                '}';
    }

    private String orgName;
    private String custId;
    private Integer orgSeq;
    private String orgDesc;
    private String createUser;
    private Date createDate;
    private String updateUser;
    private Date updateDate;
    private String isLeaf;
    private Integer orgLevel;
    private String orgGradation;
    private String managerName;

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    private String managerEmail;

    private String managerPhone;
    private String expands;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId == null ? null : parentOrgId.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public Integer getOrgSeq() {
        return orgSeq;
    }

    public void setOrgSeq(Integer orgSeq) {
        this.orgSeq = orgSeq;
    }

    public String getOrgDesc() {
        return orgDesc;
    }

    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc == null ? null : orgDesc.trim();
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

    public String getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf == null ? null : isLeaf.trim();
    }

    public Integer getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(Integer orgLevel) {
        this.orgLevel = orgLevel;
    }

    public String getOrgGradation() {
        return orgGradation;
    }

    public void setOrgGradation(String orgGradation) {
        this.orgGradation = orgGradation == null ? null : orgGradation.trim();
    }

    public String getExpands() {
        return expands;
    }

    public void setExpands(String expands) {
        this.expands = expands == null ? null : expands.trim();
    }
}