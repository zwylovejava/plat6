package net.northking.cloudplatform.dao.user;


import net.northking.cloudplatform.dao.base.BaseDao;
import net.northking.cloudplatform.domain.user.CltOrg;
import net.northking.cloudplatform.domain.user.CltOrgExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CltOrgMapper extends BaseDao<CltOrg, CltOrgExample, String> {

    List<CltOrg> selectByCustIdParendId(@Param("record") CltOrg record);

    //根据客户ID和parentOrgId更新机构信息
    int updateCltOrgByParentorgIdAndCustId(CltOrg cltOrg);

    //根据客户ID和parentOrgId删除机构信息
    Integer delteCltOrgByParentorgIdAndCustId(@Param("parentOrgId")String parentOrgId,@Param("custId")String custId);


}