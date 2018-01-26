package net.northking.cloudplatform.service.impl;


import net.northking.cloudplatform.dao.base.BaseServiceImpl;
import net.northking.cloudplatform.dao.user.CltFuncMapper;
import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.domain.user.CltFuncExample;
import net.northking.cloudplatform.service.CltFuncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CltFuncServiceImpl extends BaseServiceImpl<CltFunc, CltFuncExample, String> implements CltFuncService {
    @Autowired
    private CltFuncMapper cltFuncMapper;
    @Override
    public List<CltFunc> fingFuncByUserId(String userId) {
        return cltFuncMapper.fingFuncByUserId(userId);
    }
}
