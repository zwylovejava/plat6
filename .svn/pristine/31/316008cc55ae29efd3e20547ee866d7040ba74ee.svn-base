package net.northking.cloudplatform.dao.project;

import net.northking.cloudplatform.domain.project.CltCustomer;
import net.northking.cloudplatform.domain.project.CltCustomerExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface CltCustomerMapper {
    int countByExample(CltCustomerExample example);

    int deleteByExample(CltCustomerExample example);

    int deleteByPrimaryKey(String custId);

    int insert(CltCustomer record);

    int insertSelective(CltCustomer record);

    List<CltCustomer> selectByExample(CltCustomerExample example);

    CltCustomer selectByPrimaryKey(String custId);

    int updateByExampleSelective(@Param("record") CltCustomer record, @Param("example") CltCustomerExample example);

    int updateByExample(@Param("record") CltCustomer record, @Param("example") CltCustomerExample example);

    int updateByPrimaryKeySelective(CltCustomer record);

    int updateByPrimaryKey(CltCustomer record);
  //根据客户简称查询记录数
    int countCustomerByCustCode(String custCode);
    //根据客户简称查询客户详情
    CltCustomer queryCustomerByCustCode(String custCode);


}