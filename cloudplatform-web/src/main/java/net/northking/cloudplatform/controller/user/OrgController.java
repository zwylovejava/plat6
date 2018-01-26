package net.northking.cloudplatform.controller.user;



import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.constants.ErrorConstants;
import net.northking.cloudplatform.domain.user.CltOrg;
import net.northking.cloudplatform.domain.user.CltUserAndLogin;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.feign.user.OrgFeignClient;
import net.northking.cloudplatform.feign.user.UserFeignClient;
import net.northking.cloudplatform.query.user.OrgQuery;
import net.northking.cloudplatform.query.user.UserAndLoginQuery;
import net.northking.cloudplatform.result.ResultCode;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.user.OrgService;
import net.northking.cloudplatform.service.user.UserService;
import net.northking.cloudplatform.utils.BeanUtil;
import net.northking.cloudplatform.utils.CltUtils;
import net.northking.cloudplatform.utils.ParamVerifyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 机构信息操作
 * @author suny
 * @Created  2017-11-20
 */
@RestController
//@RequestMapping("/cltOrg")
public class OrgController {

    private final static Logger logger = LoggerFactory.getLogger(OrgController.class);

    @Autowired
    OrgService orgService;

    @Autowired
    UserService userService;

    /***
     * 新增机构信息
     * @param orgQuery    必传项;orgName orgSeq orgLevel parentOrgId
     * @return
     * @throws Exception
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    @PostMapping("/addCltOrgInfo")
    public ResultInfo<CltOrg> addCltOrgInfo(@RequestBody OrgQuery orgQuery) throws Exception {

        CltUtils.printStartInfo(orgQuery, "addCltOrgInfo");

        long startTime = System.currentTimeMillis();

        orgQuery.setFunCode("1");

        //参数校验
        init(orgQuery, "A");

        //调用接口服务
        ResultInfo<CltOrg> result = orgService.addCltOrgInfo(orgQuery);

        CltUtils.printEndInfo(result, "addCltOrgInfo", startTime);

        return  result;
    }

    /**
     * 删除机构信息
     * @param orgQuery   必传项:orgId  isLeaf
     * @return
     * @throws Exception
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    @PostMapping ("/deleteCltOrgInfo")
    public ResultInfo<Integer> deleteCltOrgInfo(@RequestBody OrgQuery orgQuery) throws Exception {

        CltUtils.printStartInfo(orgQuery, "deleteCltOrgInfo");

        long startTime = System.currentTimeMillis();

        //参数校验
        init(orgQuery, "D");

        //调用接口
        ResultInfo<Integer> result = orgService.deleteCltOrgInfo(orgQuery);

        CltUtils.printEndInfo(result, "deleteCltOrgInfo", startTime);

        return result;

    }

    /**
     * 根据客户号、父机构ID查询结构信息  (客户号 后台Redis获取登录柜员的客户号)  必传项:无
     * @param orgQuery
     * @return
     * @throws Exception
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    @PostMapping("/queryCltOrgInfo")
    //@PreAuthorize("hasAuthority('query-demo')")
    public ResultInfo<Page<CltOrg>> readUserInfo(@RequestBody OrgQuery orgQuery) throws Exception {

        CltUtils.printStartInfo(orgQuery, "queryCltOrgInfo");

        long startTime = System.currentTimeMillis();

        ResultInfo<Page<CltOrg>> result = orgService.readUserInfo(orgQuery);

        CltUtils.printEndInfo(result, "queryCltOrgInfo", startTime);

        return result;
    }


    /**
     * 根据机构ID查询机构信息和用户列表   必传项:orgId  funCode
     * @param orgQuery
     * @return
     * @throws Exception
     */
    @PostMapping("/queryCltOrgOrUserByOrgId")
    public ResultInfo<OrgQuery> queryCltOrgOrUserByOrgId(@RequestBody OrgQuery orgQuery) throws Exception {

        CltUtils.printStartInfo(orgQuery, "queryCltOrgOrUserByOrgId");

        long startTime = System.currentTimeMillis();

        //根据机构id查询机构详细信息
        ResultInfo<CltOrg> resultOrg = null;
        //用户信息查询
        ResultInfo<Page<CltUserAndLogin>> resultUser = null;

        String funCode = orgQuery.getFunCode();

        init(orgQuery,"Q_U");

        //组装查询用户列表请求
        UserAndLoginQuery userAndLoginQuery = new UserAndLoginQuery();
        userAndLoginQuery.setAccess_token(orgQuery.getAccess_token());
        userAndLoginQuery.setOrgId(orgQuery.getOrgId());

        //功能号 = 1  查询机构详细信息 和  机构下用户列表信息
        if ("1".equals(funCode)){
            //查询机构详情
            resultOrg = orgService.queryCltOrgInfoByOrgId(orgQuery);
            //查询机构下用户列表
            resultUser = userService.queryLikeUserListByOrgId(userAndLoginQuery);
            //组装返回数据
            orgQuery.setUserList(resultUser.getResultData());
            orgQuery.setCltOrg(resultOrg.getResultData());

            //功能号=2  查询机构下用户列表信息
        }else if("2".equals(funCode)){
            //查询机构下用户列表
            resultUser = userService.queryLikeUserListByOrgId(userAndLoginQuery);
            orgQuery.setUserList(resultUser.getResultData());

            //功能号=3 查询机构详细信息
        }else if ("3".equals(funCode)){
            //根据机构id查询机构详细信息
            resultOrg = orgService.queryCltOrgInfoByOrgId(orgQuery);
            orgQuery.setCltOrg(resultOrg.getResultData());

        }else{
            throw new GlobalException(ErrorConstants.QUERY_IS_LEVEL_ERROR_CODE,ErrorConstants.QUERY_IS_LEVEL_ERROR_MESSAGE);
        }

        CltUtils.printEndInfo(orgQuery, "queryCltOrgOrUserByOrgId", startTime);

        return  new ResultInfo<OrgQuery>(ResultCode.SUCCESS,orgQuery);
    }

    /***
     * 根据机构ID修改机构信息
     * @param orgQuery
     * @return
     * @throws Exception
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    @PostMapping("/updateCltOrgInfo")
    public ResultInfo<Integer> updateCltOrgInfo(@RequestBody OrgQuery orgQuery) throws Exception {

        CltUtils.printStartInfo(orgQuery, "updateCltOrgInfo");

        long startTime = System.currentTimeMillis();

        //参数校验
        init(orgQuery, "U");

        ResultInfo<Integer> result = orgService.updateCltOrgInfo(orgQuery);

        CltUtils.printEndInfo(result, "updateCltOrgInfo", startTime);

        return result;
    }

    //根据机构id查询机构详细信息
    @PostMapping("/queryCltOrgInfoByOrgId")
    public ResultInfo<CltOrg> queryCltOrgInfoByOrgId(OrgQuery orgQuery) throws Exception {

        CltUtils.printStartInfo(orgQuery, "queryCltOrgInfoByOrgId");

        long startTime = System.currentTimeMillis();

        ResultInfo<CltOrg> result = orgService.queryCltOrgInfoByOrgId(orgQuery);

        CltUtils.printEndInfo(result, "queryCltOrgInfoByOrgId", startTime);

        return result;
    }



    public static void init(OrgQuery orgQuery, String funcCode) throws Exception {

        ParamVerifyUtil paramVerifyUtil = new ParamVerifyUtil();

        Map<String,Object> dataMap = CltUtils.beanToMap(orgQuery);

        if ("A".equals(funcCode)) {
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "orgName", "orgSeq", "orgLevel","parentOrgId");

        } else if ("U".equals(funcCode)) {
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "orgId");

        } else if ("D".equals(funcCode)) {
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "orgId", "isLeaf");


        }else if("Q_U".equals(funcCode)){

            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "orgId","funCode");
        }
    }


}
