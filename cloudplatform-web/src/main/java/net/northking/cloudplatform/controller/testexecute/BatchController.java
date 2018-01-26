package net.northking.cloudplatform.controller.testexecute;

import net.northking.cloudplatform.domain.testexecute.CltBatch;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.query.testexecute.BatchQuery;
import net.northking.cloudplatform.result.ResultCode;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.testexecute.BatchService;
import net.northking.cloudplatform.utils.CltUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title:
 * @Description: 批次表web层控制类
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-12-26 18:00
 * @UpdateUser:
 * @Version:0.1
 */

@RestController
public class BatchController {

    @Autowired
    private BatchService batchService;


    //根据批次ID查询批次详情(包括伦次详情和计划详情)
    @PostMapping("/queryBatchByBatchId")
    public ResultInfo<CltBatch> queryBatchByBatchId(@RequestBody BatchQuery batchQuery) throws Exception {

        CltUtils.printStartInfo(batchQuery, "Controller queryBatchByBatchId");

        String batchId=batchQuery.getBatchId();

        if(StringUtils.isEmpty(batchId)){
            throw new GlobalException(ResultCode.INVALID_PARAM.code(),"batchId为空!");
        }
        long startTime = System.currentTimeMillis();

        //调用微服务controller接口
        ResultInfo<CltBatch> result  = batchService.queryBatchByBatchId(batchQuery);

        CltUtils.printEndInfo(result, "Controller queryCltJobByRoleId", startTime);

        return  result;

    }


}
