package net.northking.cloudplatform.feign.testexecute;

import net.northking.cloudplatform.domain.testexecute.CltAttach;
import net.northking.cloudplatform.query.testexecute.CltAttachQuery;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Title:
 * @Description: 附件表Feign客户端
 * @Company: Northking
 * @Author: ZW
 * @CreateDate: 2017-12-27 10:50
 * @UpdateUser:
 * @Version:0.1
 */
@FeignClient(name = "cloudplatform-gateway")
public interface AttachFeignClient {

    //查询附件
    @RequestMapping(value="/testexecute/pageAttachs", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<List<CltAttach>> findCltAttach(@RequestBody CltAttachQuery query);

    //添加附件
    @RequestMapping(value="/testexecute/addAttach", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<Integer> addCltAttach(@RequestBody CltAttachQuery query);

    //删除附件
    @RequestMapping(value="/testexecute/deleteAttach", method = RequestMethod.POST, consumes="application/json")
    ResultInfo<Integer> delCltAttach(@RequestBody CltAttachQuery query);
}
