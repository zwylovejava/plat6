package net.northking.cloudplatform.service;


import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.dao.base.BaseService;
import net.northking.cloudplatform.domain.user.CltOrg;
import net.northking.cloudplatform.domain.user.CltOrgExample;
import net.northking.cloudplatform.query.user.OrgQuery;

/**
 * @Title: 机构逻辑类
 * @Description:
 * @Company: Northking
 * @Author: suny
 * @CreateDate: 2017/11/11
 * @UpdateUser:
 * @Version:0.1
 */
public interface OrgService extends BaseService<CltOrg, CltOrgExample, String> {
    /**
     * 查询机构  客户号  父机构ID
     * @param cltOrg
     * @return
     **/
    Page<CltOrg> queryCltOrg(CltOrg cltOrg)throws Exception;

    /**
     * 添加机构
     * @param cltOrg
     */
    CltOrg addCltOrg(CltOrg cltOrg)throws Exception;
    /**
     * 更新机构
     * @param cltOrg
     */
    Integer updateCltOrg(CltOrg cltOrg)throws Exception;
    /**
     * 删除机构
     * @param cltOrg
     */
    Integer deleteCltOrg(CltOrg cltOrg)throws Exception;

    /**
     * 根据机构号查询机构信息
     * @param orgId
     * @return
     **/
    CltOrg queryCltOrgByOrgId(String orgId)throws Exception;


    //根据客户ID和parentOrgId更新机构信息
    Integer updateCltOrgByParentorgIdAndCustId(CltOrg cltOrg)throws Exception;

    //根据客户ID和parentOrgId删除机构信息
    Integer delteCltOrgByParentorgIdAndCustId(OrgQuery orgQuery)throws Exception;


}
