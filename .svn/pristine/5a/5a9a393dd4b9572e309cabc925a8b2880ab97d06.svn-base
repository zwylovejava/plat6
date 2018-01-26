package net.northking.cloudplatform.service.customer;

import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.domain.project.CltCustomer;
import net.northking.cloudplatform.query.cust.CustomerQuery;
import net.northking.cloudplatform.result.ResultInfo;

import java.util.List;


/**
 * Created by Administrator on 2017/12/20 0020.
 */
public interface CustomerService {
     //新增客户信息
     ResultInfo<CltCustomer> addCltCustInfo(CustomerQuery customerQuery) throws Exception;
     //修改客户信息
     ResultInfo<Integer> updateCustomerInfo(CustomerQuery customerQuery) throws Exception;
     //客户ID查询出客户原始信息
     ResultInfo<CltCustomer> queryCustomerByCustId(CustomerQuery customerQuery) throws Exception;
     //查询所有客户
     ResultInfo<Page<CltCustomer>>  queryAllCustomersInfo(CustomerQuery customerQuery) throws Exception;
     //根据客户简称查询客户记录
     ResultInfo<Integer> countCustomerByCustCode(CustomerQuery customerQuery) throws Exception;
     //根据客户号查询出客户信息
     ResultInfo<CltCustomer> queryCustomerByCustCode(CustomerQuery customerQuery) throws Exception;
     //根据客户ID删除客户信息
     ResultInfo<Integer> deleteCustomerByCustId(CustomerQuery customerQuery) throws Exception;

     //批量启用/禁用客户
     ResultInfo<Integer> disEnableBatchCustomerByCustId(CustomerQuery customerQuery) throws Exception;

}