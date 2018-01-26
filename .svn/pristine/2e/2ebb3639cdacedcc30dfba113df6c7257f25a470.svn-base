package net.northking.cloudplatform.dto.testexecute;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.northking.cloudplatform.domain.user.CltUserAndLogin;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class CltProjectDTO {
    private String proId;

    private String proName;

    private String custId;

    private String testManager;

    public CltUserAndLogin getCltUserAndLogin() {
        return cltUserAndLogin;
    }

    public void setCltUserAndLogin(CltUserAndLogin cltUserAndLogin) {
        this.cltUserAndLogin = cltUserAndLogin;
    }

    private CltUserAndLogin cltUserAndLogin;

    private String proType;

    private String testType;

    @JsonFormat(pattern = "yyyy-MM-dd") // 取出
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 获取
    private Date testPlanStartTime;

    @JsonFormat(pattern = "yyyy-MM-dd") // 取出
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 获取
    private Date testPlanEndTime;

    private String proDesc;

    private String testEnvi;

    private String sysLinkAddr;

    private String needAttach;

    private String status;

    private String createUser;

    @JsonFormat(pattern = "yyyy-MM-dd") // 取出
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 获取
    private Date createDate;

    private String updateUser;

    @JsonFormat(pattern = "yyyy-MM-dd") // 取出
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 获取
    private Date updateDate;


    private CltCustomerDTO cltCustomerDTO;

    private List<CltCaseItemSetupDTO> cltCaseItemSetupDTOS;

    public String getTestManager() {
        return testManager;
    }

    public void setTestManager(String testManager) {
        this.testManager = testManager == null ? null : testManager.trim();
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType == null ? null : proType.trim();
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType == null ? null : testType.trim();
    }

    public Date getTestPlanStartTime() {
        return testPlanStartTime;
    }

    public void setTestPlanStartTime(Date testPlanStartTime) {
        this.testPlanStartTime = testPlanStartTime;
    }

    public Date getTestPlanEndTime() {
        return testPlanEndTime;
    }

    public void setTestPlanEndTime(Date testPlanEndTime) {
        this.testPlanEndTime = testPlanEndTime;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc == null ? null : proDesc.trim();
    }

    public String getTestEnvi() {
        return testEnvi;
    }

    public void setTestEnvi(String testEnvi) {
        this.testEnvi = testEnvi == null ? null : testEnvi.trim();
    }

    public String getSysLinkAddr() {
        return sysLinkAddr;
    }

    public void setSysLinkAddr(String sysLinkAddr) {
        this.sysLinkAddr = sysLinkAddr == null ? null : sysLinkAddr.trim();
    }

    public String getNeedAttach() {
        return needAttach;
    }

    public void setNeedAttach(String needAttach) {
        this.needAttach = needAttach == null ? null : needAttach.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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

    @Override
    public String toString() {
        return "CltProject{" +
                "proId='" + proId + '\'' +
                ", proName='" + proName + '\'' +
                ", custId='" + custId + '\'' +
                ", testManager='" + testManager + '\'' +
                ", cltUserAndLogin=" + cltUserAndLogin +
                ", proType='" + proType + '\'' +
                ", testType='" + testType + '\'' +
                ", testPlanStartTime=" + testPlanStartTime +
                ", testPlanEndTime=" + testPlanEndTime +
                ", proDesc='" + proDesc + '\'' +
                ", testEnvi='" + testEnvi + '\'' +
                ", sysLinkAddr='" + sysLinkAddr + '\'' +
                ", needAttach='" + needAttach + '\'' +
                ", status='" + status + '\'' +
                ", createUser='" + createUser + '\'' +
                ", createDate=" + createDate +
                ", updateUser='" + updateUser + '\'' +
                ", updateDate=" + updateDate +
                '}';
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


    public List<CltCaseItemSetupDTO> getCltCaseItemSetupDTOS() {
        return cltCaseItemSetupDTOS;
    }

    public void setCltCaseItemSetupDTOS(List<CltCaseItemSetupDTO> cltCaseItemSetupDTOS) {
        this.cltCaseItemSetupDTOS = cltCaseItemSetupDTOS;
    }

    public CltCustomerDTO getCltCustomerDTO() {
        return cltCustomerDTO;
    }

    public void setCltCustomerDTO(CltCustomerDTO cltCustomerDTO) {
        this.cltCustomerDTO = cltCustomerDTO;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }



}