package net.northking.cloudplatform.controller;

import net.northking.cloudplatform.domain.testexecute.CltBatch;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.query.testexecute.BatchQuery;
import net.northking.cloudplatform.result.ResultCode;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.BatchService;
import net.northking.cloudplatform.utils.PageUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title:
 * @Description: 批次表控制层
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-12-26 17:44
 * @UpdateUser:
 * @Version:0.1
 */

@RestController
public class BatchController {

   //注入service
    @Autowired
    private BatchService batchService;

    //日志
    private final static Logger logger = LoggerFactory.getLogger(JobController.class);


    //根据批次ID查询批次详情(包括伦次详情和计划详情)
    @PostMapping("/queryBatchByBatchId")
    public ResultInfo<CltBatch> queryBatchByBatchId(@RequestBody BatchQuery batchQuery){


        logger.info("queryBatchByBatchId start paramData");

        String batchId=batchQuery.getBatchId();
        if(StringUtils.isEmpty(batchId)){
            throw new GlobalException(ResultCode.INVALID_PARAM.code(),"batchId为空!");
        }

        PageUtil.startPage(batchQuery);

        CltBatch cltBatch   = batchService.queryBatchByBatchId(batchQuery);

        logger.info("queryBatchByBatchId end paramData");

        return new ResultInfo<>(ResultCode.SUCCESS,"查询批次详情成功!",cltBatch);
    }


    /**
     * 同步批次数据
     * @param batchQuery
     */
    @PostMapping("/receiveBatchId")
    public void receiveBatchId(@RequestBody BatchQuery batchQuery){
        logger.info("receiveBatchId start paramData");
        try {
            batchService.receiveBatch(batchQuery.getBatchId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("receiveBatchId end paramData");
    }

    /**
     * 撤回批次
     * @param batchQuery
     */
    @PostMapping("/canCelBatchId")
    public void canCelBatchId(@RequestBody BatchQuery batchQuery){
        logger.info("canCelBatchId start paramData");

        try {
            batchService.canCelBatchById(batchQuery.getBatchId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("canCelBatchId end paramData");
    }
}
