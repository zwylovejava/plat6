package net.northking.cloudplatform.feign.user;


import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.domain.user.CltOrg;
import net.northking.cloudplatform.query.user.OrgQuery;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by HBH on 2017/11/10.
 */
@FeignClient(name = "cloudplatform-gateway")

public interface OrgFeignClient {
    //添加机构
    @RequestMapping(value = "/user/addCltOrg", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<CltOrg> addCltOrgInfo(@RequestBody OrgQuery orgQuery);

    //条件查询机构
    @RequestMapping(value = "/user/queryCltOrg", method = RequestMethod.POST, consumes="application/json")
     ResultInfo<Page<CltOrg>> queryCltOrgInfo(@RequestBody OrgQuery orgQuery);

    //条件查询机构
    @RequestMapping(value = "/user/queryCltOrgByOrgId", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<CltOrg> queryCltOrgInfoByOrgId(@RequestBody OrgQuery orgQuery);


    @RequestMapping(value = "/user/deleteCltOrg", method =RequestMethod.POST, consumes="application/json")
     ResultInfo<Integer> deleteCltOrgInfo(@RequestBody OrgQuery orgQuery);

     //根据ID更新机构
    @RequestMapping(value = "/user/updateCltOrg",method = RequestMethod.POST, consumes="application/json")
     ResultInfo<Integer> updateCltOrgInfo(@RequestBody OrgQuery orgQuery);

     //根据父机构ID和客户ID更新机构
    @RequestMapping(value = "/user/updateCltOrgByParentorgIdAndCustId",method = RequestMethod.POST, consumes="application/json")
     ResultInfo<Integer> updateCltOrgByParentorgIdAndCustId(@RequestBody OrgQuery orgQuery);

    //根据客户ID和parentOrgId删除机构信息
    @RequestMapping(value = "/user/delteCltOrgByParentorgIdAndCustId",method = RequestMethod.POST, consumes="application/json")
     ResultInfo<Integer> delteCltOrgByParentorgIdAndCustId(@RequestBody OrgQuery orgQuery);


}
