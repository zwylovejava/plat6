package net.northking.cloudplatform.service;


import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.dao.base.BaseService;
import net.northking.cloudplatform.domain.project.CltCustomer;
import net.northking.cloudplatform.domain.project.CltCustomerExample;
import net.northking.cloudplatform.query.cust.CustomerQuery;


/**
 * @Title:
 * @Description: 客户表service接口
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-12-05 16:22
 * @UpdateUser:
 * @Version:0.1
 */
public interface CustService  extends BaseService<CltCustomer, CltCustomerExample, String> {

    //客户的添加
      CltCustomer addCustomer(CltCustomer cltCustomer)throws Exception;

    //客户的修改
    int updateCustomer(CltCustomer cltCustomer)throws Exception;

    //客户列表
    Page<CltCustomer> queryAllCustomers(CustomerQuery customerQuery)throws Exception;

    //根据客户id查询客户详情
    CltCustomer queryByCustId(String custId)throws Exception;

    //根据客户简称查询对应的记录数

    Integer countCustomerByCustCode(String custCode)throws Exception;

    //根据客户简称查询客户详情
    CltCustomer queryCustomerByCustCode(String custCode)throws Exception;

    //批量禁用和启用
    Integer disEnableCustomer(CustomerQuery customerQuery)throws Exception;


    //根据custId删除用户
    Integer deleteCustomerByCustId(CustomerQuery customerQuery)throws Exception;



}
