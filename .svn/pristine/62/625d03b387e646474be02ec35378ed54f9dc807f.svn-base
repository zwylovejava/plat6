package net.northking.cloudplatform.feign.testexecute;


import net.northking.cloudplatform.domain.testexecute.CltBatch;
import net.northking.cloudplatform.query.testexecute.BatchQuery;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Title:
 * @Description: 批次表Feign客户端
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-12-26 17:50
 * @UpdateUser:
 * @Version:0.1
 */
@FeignClient(name = "cloudplatform-gateway")
public interface BatchFeignClient {
    //根据批次ID查询批次详情(包括伦次详情和计划详情)
    @RequestMapping(value="/testexecute/queryBatchByBatchId", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<CltBatch> queryBatchByBatchId(@RequestBody BatchQuery batchQuery);

}
