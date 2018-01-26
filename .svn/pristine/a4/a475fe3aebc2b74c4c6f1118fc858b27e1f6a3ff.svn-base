package net.northking.cloudplatform.service.impl.testexecute;

import net.northking.cloudplatform.Utils.ServiceUtil;
import net.northking.cloudplatform.constants.ErrorConstants;
import net.northking.cloudplatform.domain.testexecute.CltBatch;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.feign.testexecute.BatchFeignClient;
import net.northking.cloudplatform.query.testexecute.BatchQuery;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.testexecute.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title:
 * @Description: 批次表web层业务逻辑层实现类
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-12-26 18:04
 * @UpdateUser:
 * @Version:0.1
 */

@Service
public class BatchServiceImpl implements BatchService{


    @Autowired
    private BatchFeignClient batchFeignClient;

    //根据批次ID查询批次详情(包括伦次详情和计划详情)
    @Override
    public ResultInfo<CltBatch> queryBatchByBatchId(BatchQuery batchQuery) throws Exception {
        ResultInfo<CltBatch> resultInfo = null;

        try {
            //调用数据库
            resultInfo = batchFeignClient.queryBatchByBatchId(batchQuery);

        } catch (Exception e) {

            throw new GlobalException(ErrorConstants.CLT_WEB_TESTEXECUTE_ERROR_CODE, ErrorConstants.CLT_WEB_TESTEXECUTE_ERROR_MESSAGE);

        }
        //如果返回为异常信息则抛出异常
        ServiceUtil.throwServiceException(resultInfo);

        return resultInfo;
    }


}
