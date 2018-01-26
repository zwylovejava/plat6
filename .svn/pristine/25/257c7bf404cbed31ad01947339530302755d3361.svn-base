package net.northking.cloudplatform.service.user;

import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.domain.user.CltOrg;
import net.northking.cloudplatform.domain.user.CltRole;
import net.northking.cloudplatform.domain.user.CltUserAndLogin;
import net.northking.cloudplatform.query.user.OrgQuery;
import net.northking.cloudplatform.query.user.RoleQuery;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
public interface OrgService {

     ResultInfo<CltOrg> addCltOrgInfo(OrgQuery orgQuery) throws Exception;

     ResultInfo<Integer> deleteCltOrgInfo(OrgQuery orgQuery) throws Exception;

     ResultInfo<Page<CltOrg>> readUserInfo(OrgQuery orgQuery) throws Exception;

     ResultInfo<Integer> updateCltOrgInfo(OrgQuery orgQuery) throws Exception;

     ResultInfo<CltOrg> queryCltOrgInfoByOrgId(OrgQuery orgQuery) throws Exception;

     //根据父机构ID和客户号修改客户信息
     ResultInfo<Integer> updateCltOrgByParentorgIdAndCustId(OrgQuery orgQuery) throws Exception;

     //根据父机构ID和客户号删除客户信息
     ResultInfo<Integer> delteCltOrgByParentorgIdAndCustId(OrgQuery orgQuery)throws Exception;

}