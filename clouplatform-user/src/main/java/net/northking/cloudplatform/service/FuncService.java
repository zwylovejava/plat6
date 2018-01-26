package net.northking.cloudplatform.service;



import net.northking.cloudplatform.dao.base.BaseService;
import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.domain.user.CltFuncExample;

import java.util.List;

/**
 * @Title: 功能逻辑类
 * @Description:
 * @Company: Northking
 * @Author: suny
 * @CreateDate: 2017/11/11
 * @UpdateUser:
 * @Version:0.1
 */
public interface FuncService extends BaseService<CltFunc, CltFuncExample, String> {
    /**
     * 查询功能列表
     * @param
     * @return
     **/
    List<CltFunc> queryCltFunc()throws Exception;

    List<CltFunc> fingFuncByUserId(String userId);



}
