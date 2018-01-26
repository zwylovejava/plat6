package net.northking.cloudplatform.controller;

import net.northking.cloudplatform.constants.SuccessConstants;
import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.result.ResultCode;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.FuncService;
import net.northking.cloudplatform.utils.CltUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能信息控制层
 * Created by Administrator on 2017/11/16 0016.
 */
@RestController
public class FuncController {

    @Autowired
    private FuncService funcService;

    private final static Logger logger = LoggerFactory.getLogger(FuncController.class);


    //查询功能列表
    @PostMapping("/queryCltFunc")
    public ResultInfo<List<CltFunc>> queryCltFunc()throws Exception{

        logger.info("\n*********************************** queryCltFunc invoke  start******************************\n");

        long startTime = System.currentTimeMillis();

        List<CltFunc> resultFuncList = null;

        List<CltFunc> funcList = null;

        //参数校验
        //init(cltFuncRole, "Q");

        //调用数据库
        funcList = funcService.queryCltFunc();

        if(funcList!=null){
            //组装left列表数据 （树状）
            resultFuncList = getItemInfo(funcList);
        }

        CltUtils.printEndInfo(resultFuncList, "queryCltFunc", startTime);

        return new ResultInfo<List<CltFunc>>(ResultCode.SUCCESS, SuccessConstants.QUERY_FUNC_LIST_SUCCESS,resultFuncList );

    }

    //组装funcList数据（树状数据）
    public static List<CltFunc> getItemInfo(List<CltFunc> authorityList )throws Exception{

        List<CltFunc>  rusult = new ArrayList<CltFunc>();

        for (int i=0;i<authorityList.size();i++){

            CltFunc userFunc = (CltFunc)authorityList.get(i);

            Map map = CltUtils.beanToMap(userFunc);

            String  parentFuncId= (String)map.get("parentFuncId");

            Integer  funcType  = (Integer) map.get("funcType");

            if (null!=parentFuncId&&"0".equals(parentFuncId)){

                Map  orgInfoMap1 = new HashMap();

                orgInfoMap1.putAll(map);

                getSonTree(orgInfoMap1, authorityList);

                CltUtils.mapToBean(orgInfoMap1,userFunc);

                rusult.add(userFunc);
            }
        }

        return  rusult;
    }
    //递归方法
    private static Map<String,Object> getSonTree(Map<String,Object> parentCltOrgMap,List<CltFunc> itemList){

        List<Map<String,Object>> sonList = new ArrayList<Map<String,Object>>();

        Map<String, Object> sonMap;

        for(CltFunc item : itemList){

            if((parentCltOrgMap.get("funcId").toString().equals(item.getParentFuncId().toString()))){

                sonMap = new HashMap<String, Object>();

                sonMap = CltUtils.beanToMap(item);

                sonList.add(sonMap);

                getSonTree(sonMap,itemList);
            }
        }
        parentCltOrgMap.put("sonFuncMap", sonList);

        return parentCltOrgMap;
    }



}
