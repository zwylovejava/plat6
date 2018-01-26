package net.northking.cloudplatform.service;

import net.northking.cloudplatform.dao.base.BaseService;
import net.northking.cloudplatform.domain.testexecute.CltCaseExecute;
import net.northking.cloudplatform.domain.testexecute.CltCaseExecuteExample;
import net.northking.cloudplatform.domain.testexecute.CltTestCase;
import net.northking.cloudplatform.query.user.UserLoginQuery;
import net.northking.cloudplatform.result.ResultInfo;

/**
 * @Title: 测试执行服务类
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/12/27
 * @UpdateUser:
 * @Version:0.1
 */
public interface TestExecuteService  extends BaseService<CltCaseExecute,CltCaseExecuteExample,String> {
    /**
     * 根据userId从队列获取用例
     * @param userId
     * @return
     */
    ResultInfo<CltTestCase> loginGetTestCase(String userId) throws Exception;
}
