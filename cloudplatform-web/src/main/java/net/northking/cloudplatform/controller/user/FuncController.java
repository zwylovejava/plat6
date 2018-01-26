package net.northking.cloudplatform.controller.user;
import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.query.user.FuncRoleQuery;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.user.FuncService;
import net.northking.cloudplatform.utils.CltUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 功能信息操作
 * @author suny
 * @Created  2017-11-20
 */
@RestController
public class FuncController {

    private final static Logger logger = LoggerFactory.getLogger(FuncController.class);

    //注入CltFuncRoleFeignClient
    @Autowired
    private FuncService funcService;

    //查询功能列表(全部查询)
    @PostMapping("/queryCltFuncList")
    public ResultInfo<List<CltFunc>> queryCltFuncList(@RequestBody FuncRoleQuery funcRoleQuery) throws Exception {

        CltUtils.printStartInfo(funcRoleQuery, "queryCltFuncList");

        long startTime = System.currentTimeMillis();

        //参数校验

        //调用微服务controller接口
        ResultInfo<List<CltFunc>> result  = funcService.queryCltFuncList(funcRoleQuery);

        CltUtils.printEndInfo(result, "queryCltFuncList", startTime);

        return  result;

    }

}
