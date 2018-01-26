package net.northking.cloudplatform.controller;


import net.northking.cloudplatform.assist.RedisUtil;
import net.northking.cloudplatform.dao.user.CltFuncMapper;
import net.northking.cloudplatform.dao.user.CltUserLoginMapper;
import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.domain.user.CltUserLogin;
import net.northking.cloudplatform.dto.auth.Authority;
import net.northking.cloudplatform.dto.auth.UserFunc;
import net.northking.cloudplatform.result.ResultCode;
import net.northking.cloudplatform.result.ResultInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chuangsheng.huang on 2017/11/25.
 */
@RestController
public class UserController {

    @Autowired
    private CltUserLoginMapper cltUserLoginMapper;

    @Autowired
    private CltFuncMapper cltFuncMapper;

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/user")
    public Principal user(Principal user, HttpServletRequest request){
        if(request.getHeader("Authorization") != null) {
            String token = StringUtils.substringAfter(request.getHeader("Authorization").trim().toLowerCase(), "bearer").trim();
            String access_token = "access:" + StringUtils.substringAfter(request.getHeader("Authorization").trim().toLowerCase(), "bearer").trim();
            redisUtil.setExpire(access_token, 3600*12l);

            //if(redisUtil.get(token) == null) {
                CltUserLogin userLogin = cltUserLoginMapper.findOneWithRolesByLoginNo(user.getName());
                if (userLogin != null) {
                    redisUtil.set(token, userLogin, 3600*12l);
                }
            //}
        }

        return user;
    }

    @PostMapping("/getLoginUser")
    public CltUserLogin getLoginUser(Principal user){
        CltUserLogin userLogin = cltUserLoginMapper.findOneWithRolesByLoginNo(user.getName());
        return userLogin;
    }

    @PostMapping("/userFuncs")
    public ResultInfo<Authority> userFuncs(Principal user, HttpServletRequest request){
        Authority authority = new Authority();
        List<UserFunc> userFuncs = new ArrayList<UserFunc>();
        CltUserLogin userLogin = cltUserLoginMapper.findOneWithRolesByLoginNo(user.getName());
        if(userLogin!=null) {
            String token = StringUtils.substringAfter(request.getHeader("Authorization").trim().toLowerCase(), "bearer").trim();
            redisUtil.set(token, userLogin, 3600*12l);
            List<CltFunc> cltFuncList = null; //cltFuncMapper.fingFuncByUserId(userLogin.getUserId());
            String parentFuncId = request.getParameter("parentFuncId");
            if(StringUtils.isEmpty(parentFuncId)){
                cltFuncList = cltFuncMapper.fingFuncByUserId(userLogin.getUserId());
            }else{
                cltFuncList = cltFuncMapper.fingFuncByUserIdAndParent(userLogin.getUserId(), parentFuncId);
                if(cltFuncList!=null){

                    for (int i = 0; i <cltFuncList.size() ; i++) {
                        CltFunc cltFunc = (CltFunc)cltFuncList.get(i);
                        if ("N".equals(cltFunc.getIsLeaf())){

                            List<CltFunc>  cltFuncs = new ArrayList<CltFunc>();
                            cltFuncs = cltFuncMapper.fingFuncByUserIdAndParent(userLogin.getUserId(), cltFunc.getFuncId());
                            cltFuncList.addAll(cltFuncs);
                        }
                    }
                }

            }

            for (CltFunc cltFunc : cltFuncList) {
                UserFunc userFunc = new UserFunc();
                userFunc.setFuncId(cltFunc.getFuncId());
                userFunc.setFuncName(cltFunc.getFuncName());
                userFunc.setFuncAuth(cltFunc.getFuncAuth());
                userFunc.setFuncType(cltFunc.getFuncType());
                userFunc.setIsLeaf(cltFunc.getIsLeaf());
                userFunc.setParentFuncId(cltFunc.getParentFuncId());
                userFunc.setFuncPathId(cltFunc.getFuncPathId());
                userFunc.setFuncPathName(cltFunc.getFuncPathName());
                userFunc.setFuncSeq(cltFunc.getFuncSeq());
                userFunc.setFuncUrl(cltFunc.getFuncUrl());
                userFuncs.add(userFunc);
            }

            /*for (CltRole cltRole : userLogin.getRoles()) {
                UserRole userRole = new UserRole();
                userRole.setRoleName(cltRole.getRoleName());
                userRole.setRoleDesc(cltRole.getRoleCode());
                if(cltRole.getFuncs() != null) {
                    for (CltFunc cltFunc : cltRole.getFuncs()) {
                        UserFunc userFunc = new UserFunc();
                        userFunc.setFuncName(cltFunc.getFuncName());
                        userFunc.setFuncUrl(cltFunc.getFuncUrl());
                        userFunc.setFuncType(cltFunc.getFuncType());
                        userFunc.setFuncId(cltFunc.getFuncId());
                        userFunc.setParentFuncId(cltFunc.getParentFuncId());
                        userFuncs.add(userFunc);
                    }
                }
            }*/
        }
        authority.setFuncs(userFuncs);
        return new ResultInfo<Authority>(ResultCode.SUCCESS, authority);
    }
}
