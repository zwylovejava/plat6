package net.northking.cloudplatform.service;

import net.northking.cloudplatform.domain.testexecute.CltBatch;
import net.northking.cloudplatform.query.testexecute.BatchQuery;

/**
 * @Title:
 * @Description: 批次表业表业务逻辑层
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-12-26 17:41
 * @UpdateUser:
 * @Version:0.1
 */
public interface BatchService {

    /**
     * @Author:HBH
     * @Description:  根据批次ID查询批次详情(包括伦次详情和计划详情)
     * @Date:16:50 2017/12/26
     * @param1:
     * @param2:
     * @return:
     */

    CltBatch queryBatchByBatchId(BatchQuery batchQuery);

    void receiveBatch(String path) throws Exception;


    boolean canCelBatchById(String batchId)throws Exception;
}
