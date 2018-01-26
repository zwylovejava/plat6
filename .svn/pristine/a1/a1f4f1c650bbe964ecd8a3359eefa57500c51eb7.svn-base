package net.northking.cloudplatform.service.testexecute;

import net.northking.cloudplatform.domain.testexecute.CltBatch;
import net.northking.cloudplatform.query.testexecute.BatchQuery;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Title:
 * @Description: 批次表web层业务逻辑层
 * @Company: Northking
 * @Author: HBH
 * @CreateDate: 2017-12-26 18:02
 * @UpdateUser:
 * @Version:0.1
 */


public interface BatchService {

    //根据批次ID查询批次
    ResultInfo<CltBatch> queryBatchByBatchId(@RequestBody BatchQuery batchQuery)throws Exception;

}
