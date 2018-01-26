package net.northking.cloudplatform.feign.user;



import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.result.ResultInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by HBH on 2017/11/10.
 */
@FeignClient(name = "cloudplatform-gateway")
public interface FuncFeignClient {

   //查询功能列表
    @RequestMapping(value = "/user/queryCltFunc", method =RequestMethod.POST ,consumes="application/json")
    ResultInfo<List<CltFunc>> queryCltFuncList();

}
