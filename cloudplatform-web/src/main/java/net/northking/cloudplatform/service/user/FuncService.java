package net.northking.cloudplatform.service.user;
import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.query.user.FuncRoleQuery;
import net.northking.cloudplatform.result.ResultInfo;
import java.util.List;

/**
 * Created by Administrator on 2017/12/20 0020.
 */
public interface FuncService {

    //查询功能列表(全部查询)
    ResultInfo<List<CltFunc>> queryCltFuncList(FuncRoleQuery funcRoleQuery) throws Exception;

}