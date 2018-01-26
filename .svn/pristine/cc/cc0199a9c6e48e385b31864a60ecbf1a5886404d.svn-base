package net.northking.cloudplatform.service.impl;


import net.northking.cloudplatform.dao.base.BaseServiceImpl;
import net.northking.cloudplatform.dao.user.CltFuncMapper;
import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.domain.user.CltFuncExample;
import net.northking.cloudplatform.service.FuncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncServiceImpl  extends BaseServiceImpl<CltFunc, CltFuncExample, String> implements FuncService {
    @Autowired
    private CltFuncMapper cltFuncMapper;

    @Override
    public List<CltFunc> queryCltFunc() throws Exception {
        return cltFuncMapper.selectAllFuncInfo();
    }


    @Override
    public List<CltFunc> fingFuncByUserId(String userId) {
        return cltFuncMapper.fingFuncByUserId(userId);
    }
}
