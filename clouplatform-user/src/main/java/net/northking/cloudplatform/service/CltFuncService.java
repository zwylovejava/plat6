package net.northking.cloudplatform.service;



import net.northking.cloudplatform.dao.base.BaseService;
import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.domain.user.CltFuncExample;

import java.util.List;

public interface CltFuncService extends BaseService<CltFunc, CltFuncExample, String> {
    List<CltFunc> fingFuncByUserId(String userId);
}
