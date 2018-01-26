package net.northking.cloudplatform.controller;

import net.northking.cloudplatform.dao.user.CltFuncMapper;
import net.northking.cloudplatform.domain.user.CltFunc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private CltFuncMapper cltFuncMapper;

    @RequestMapping("/value")
    public List<CltFunc> getFuncList() {
        List<CltFunc> listFuc = new ArrayList<>();
        List<CltFunc> cltFuncs = cltFuncMapper.selectAllFuncInfo();
        for (CltFunc cltFunc : cltFuncs) {
            if ("0".equals(cltFunc.getParentFuncId())) {
                CltFunc treeList = getTree(cltFunc, cltFuncs);
                listFuc.add(treeList);
            }
        }
        return listFuc;
    }

    public CltFunc getTree(CltFunc cltFunc, List<CltFunc> funcList) {
        List<CltFunc> listFunc = new ArrayList<>();
        for (CltFunc clt : funcList) {
            if (clt.getParentFuncId().equalsIgnoreCase(cltFunc.getFuncId())) {
                listFunc.add(clt);
                getTree(clt, funcList);
            }
        }
        cltFunc.setFuncList(listFunc);
        return cltFunc;

    }
}
