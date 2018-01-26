package net.northking.cloudplatform.controller;

import net.northking.cloudplatform.assist.RedisUtil;
import net.northking.cloudplatform.common.Page;
import net.northking.cloudplatform.constants.ErrorConstants;
import net.northking.cloudplatform.constants.SuccessConstants;
import net.northking.cloudplatform.dao.user.CltUserMapper;
import net.northking.cloudplatform.domain.user.CltFunc;
import net.northking.cloudplatform.domain.user.CltUser;
import net.northking.cloudplatform.domain.user.CltUserAndLogin;
import net.northking.cloudplatform.domain.user.CltUserLogin;
import net.northking.cloudplatform.exception.GlobalException;
import net.northking.cloudplatform.query.user.*;
import net.northking.cloudplatform.result.ResultCode;
import net.northking.cloudplatform.result.ResultInfo;
import net.northking.cloudplatform.service.FuncService;
import net.northking.cloudplatform.service.UserService;

import net.northking.cloudplatform.utils.*;
import net.northking.cloudplatform.utils.jwt.QQSendEmail;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.mail.MessagingException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by HBH on 2017/11/10.
 */
@RestController
@RefreshScope
public class UserController {
    //注入CltUserService
    @Autowired
    private UserService userService;

    @Autowired
    private FuncService funcService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private CltUserMapper cltUserMapper;

    //日志
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    /**===================================================================================================================*/

    //添加用户
    @PostMapping("/saveUser")
    public ResultInfo<CltUserAndLogin> saveCltUser(@RequestBody @Validated UserAndLoginQuery userAndLoginQuery)throws Exception{

        logger.info(" saveUser start paramData" + userAndLoginQuery.toString());

        //0 - 新增客户来源（云平台管理）   1-新增机构来源（客户管理）
        String funcCode=userAndLoginQuery.getFuncCode();

        CltUserLogin cltUserLogin = (CltUserLogin) redisUtil.get(userAndLoginQuery.getAccess_token());

        if (cltUserLogin != null) {
            CltUser cltUser = cltUserMapper.selectByPrimaryKey(cltUserLogin.getUserId());
            String custId = cltUser.getCustId();
            userAndLoginQuery.setCreateUser(cltUserLogin.getUserId());
            if(StringUtils.isNotEmpty(funcCode)) {
                if(funcCode.equals("1")){
                    userAndLoginQuery.setCustId(custId);
                }

            }

        }

        //对参数进行验证
        init(userAndLoginQuery, "saveUser");

        CltUserAndLogin result=userService.saveUser(userAndLoginQuery);

        logger.info(" saveUser end paramData" );

        return  new ResultInfo<CltUserAndLogin>(ResultCode.SUCCESS, SuccessConstants.ADD_USER_INFO_SUCCESS,result);


    }
    /**===================================================================================================================*/

    //查询用户列表(查询除管理员之外的所有用户)
    @PostMapping("/pageUser")
    public ResultInfo<Page<CltUserAndLogin>>pageUser(@RequestBody UserAndLoginQuery userAndLoginQuery)throws Exception{

        logger.info(" pageUser start paramData" + userAndLoginQuery.toString());
        //设置客户号:只能查询当前客户下的所有用户(其他客户的用户不能显示)
        CltUserLogin cltUserLogin = (CltUserLogin) redisUtil.get(userAndLoginQuery.getAccess_token());
        if(cltUserLogin!=null) {
            CltUser cltUser = cltUserMapper.selectByPrimaryKey(cltUserLogin.getUserId());
            String custId = cltUser.getCustId();
            userAndLoginQuery.setCustId(custId);
        }

        Page<CltUserAndLogin> page = userService.queryUserList(userAndLoginQuery);

        logger.info(" pageUser end paramData" );

        return  new ResultInfo<>(ResultCode.SUCCESS.code(),SuccessConstants.QUERY_USER_LIST_INFO_SUCCESS, page);

    }

    //查询已经启用的用户的列表
    @PostMapping("/queryUserListEnable")
    public ResultInfo<Page<CltUserAndLogin>>queryUserListEnable(@RequestBody UserAndLoginQuery userAndLoginQuery)throws Exception{

        logger.info(" queryUserListEnable start paramData" + userAndLoginQuery.toString());

        //设置客户号:只能查询当前客户下的所有用户(其他客户的用户不能显示)
        CltUserLogin cltUserLogin = (CltUserLogin) redisUtil.get(userAndLoginQuery.getAccess_token());
        if(cltUserLogin!=null) {
            CltUser cltUser = cltUserMapper.selectByPrimaryKey(cltUserLogin.getUserId());
            String custId = cltUser.getCustId();
            userAndLoginQuery.setCustId(custId);
        }
        Page<CltUserAndLogin> page = userService.queryUserListEnable(userAndLoginQuery);

        logger.info(" queryUserListEnable end paramData" );

        return  new ResultInfo<>(ResultCode.SUCCESS.code(), SuccessConstants.QUERY_ENABLE_USER_LIST_INFO_SUCCESS, page);

    }

    /**===================================================================================================================*/

    //查询用户的详细信息(包括用户的登录信息和用户的详细信息)
    @PostMapping("/findById")
    public ResultInfo<CltUserAndLogin> queryUserInfoByUserId(@RequestBody UserAndLoginQuery userAndLoginQuery)throws Exception{

        logger.info(" queryUserInfoByUserId start paramData" + userAndLoginQuery.toString());

        //对参数进行校验
        init(userAndLoginQuery, "queryUserInfoByUserId");

        CltUserAndLogin user = userService.findUserById(userAndLoginQuery.getUserId());

        logger.info(" queryUserInfoByUserId end paramData");

        return  new ResultInfo<>(ResultCode.SUCCESS.code(), SuccessConstants.QUERY_USER_INFO_BY_USER_ID_SUCCESS, user);


    }
    /**===================================================================================================================*/
    //编辑用户详细信息
    @PostMapping("/updateUser")
    public ResultInfo<Integer> updateCltUser( @RequestBody @Validated  UserAndLoginQuery userAndLoginQuery)throws Exception{

        logger.info(" updateUser start paramData" + userAndLoginQuery.toString());

        CltUserLogin cltUserLogin = (CltUserLogin) redisUtil.get(userAndLoginQuery.getAccess_token());

        if(cltUserLogin!=null){
            userAndLoginQuery.setUpdateUser(cltUserLogin.getUserId());
        }
        //对参数进行验证
        init(userAndLoginQuery, "updateUser");


        Integer result=userService.updateUser(userAndLoginQuery);

        logger.info(" pageUser end paramData" );

        return new ResultInfo<Integer>(ResultCode.SUCCESS, SuccessConstants.UPDATE_USER_INFO_BY_USER_ID_SUCCESS,result);


    }
    /**===================================================================================================================*/

    //用户的启用/禁用
    @PostMapping(value = "/disEnableUser")
    public ResultInfo<Integer> disEnableUser(@RequestBody  UserAndLoginQuery userAndLoginQuery)throws Exception{

        logger.info(" disEnableUser start paramData" + userAndLoginQuery.toString());

        //对参数进行校验
        init(userAndLoginQuery, "disEnableUser");

        //设置更新人
        CltUserLogin cltUserLogin = (CltUserLogin) redisUtil.get(userAndLoginQuery.getAccess_token());

        if(cltUserLogin!=null){
            userAndLoginQuery.setUpdateUser(cltUserLogin.getUserId());
        }

        CltUserLogin user= new CltUserLogin();
        //复制属性值给user
        BeanUtil.copyProperties(userAndLoginQuery,user);

        Integer result=userService.EnableDisableUser(user);

        logger.info(" disEnableUser end paramData" );

        return new ResultInfo<Integer>(ResultCode.SUCCESS, SuccessConstants.UPDATE_USER_STATUS_BY_USER_ID_AND_STATUS_SUCCESS,result);

    }


    /**===================================================================================================================*/

    //检查用户登录号的唯一性
    @PostMapping("/checkUserLoginNo")
    public ResultInfo<Boolean> checkUserLoginNo(@RequestBody UserAndLoginQuery userAndLoginQuery)throws Exception{

        //参数校验
        init(userAndLoginQuery,"checkLoginNo");

        Boolean result=userService.checkUserLoginNo(userAndLoginQuery.getLoginNo());

        if(result==true){
            return new ResultInfo<>(ResultCode.SUCCESS,SuccessConstants.CHECK_USER_LOGING_NUM_SUCCESS,result);

        }else{
            return new ResultInfo<>(ResultCode.SUCCESS,"用户名:"+userAndLoginQuery.getLoginNo()+"已经存在",result);
        }


    }
    /**===================================================================================================================*/


    //根据机构id查询用户列表
    @PostMapping("/queryUserListByOrgId")
    public ResultInfo<Page<CltUserAndLogin>> queryUserListByOrgId(@RequestBody UserAndLoginQuery userAndLoginQuery)throws Exception{

        logger.info(" queryUserListByOrgId start paramData" + userAndLoginQuery.toString());

        String accessToken = userAndLoginQuery.getAccess_token();

        if (org.apache.commons.lang.StringUtils.isEmpty(accessToken)){
            throw new GlobalException(ResultCode.INVALID_PARAM.code(),"access_token不能为空!");
        }
        //设置客户号:只能查询当前客户下的所有用户(其他客户的用户不能显示)
        CltUserLogin cltUserLogin = (CltUserLogin) redisUtil.get(accessToken);
        if(cltUserLogin!=null) {
            CltUser cltUser = cltUserMapper.selectByPrimaryKey(cltUserLogin.getUserId());
            String custId = cltUser.getCustId();
            userAndLoginQuery.setCustId(custId);
        }


        Page<CltUserAndLogin> page = userService.queryUserListByOrgId(userAndLoginQuery);

        logger.info(" queryUserListByOrgId end paramData");

        return  new ResultInfo<>(ResultCode.SUCCESS.code(), SuccessConstants.QUERY_USER_LIST_BY_ORG_ID_SUCCESS, page);


    }


    //批量删除用户
    @PostMapping("/deleteUsersByUserIds")
    public ResultInfo<String> deleteUsersByUserIds(@RequestBody UserAndLoginQuery userAndLoginQuery)throws Exception{

        logger.info(" findByOrgId start paramData" + userAndLoginQuery.toString());

        //参数校验
        init(userAndLoginQuery,"deleteUsersByUserIds");

        String msg = userService.deleteUsersBatch(userAndLoginQuery);

        logger.info(" findByOrgId end paramData");

        return new ResultInfo<String>(ResultCode.SUCCESS ,SuccessConstants.DELETE_USER_BATCH_BY_USER_IDS_SUCCESS,msg);
    }


    //根据用户修改机构的id
    @PostMapping("/updateOrgIdByUserIds")
    public ResultInfo<String> updateOrgIdByUserIds(@RequestBody UserAndLoginQuery userAndLoginQuery)throws Exception{

        logger.info(" updateOrgIdByUserIds start paramData" + userAndLoginQuery.toString());

        //参数校验
        init(userAndLoginQuery,"updateOrgIdByUserIds");

        String msg = userService.updateOrgIdByUserIds(userAndLoginQuery);

        logger.info(" updateOrgIdByUserIds end paramData");

        return new ResultInfo<String>(ResultCode.SUCCESS ,SuccessConstants.UPDATE_ORG_BY_USER_IDS_SUCCESS,msg);
    }


    //根据角色Code查询用户列表
    @PostMapping("/queryUserListByRoleCode")
    public ResultInfo<Page<CltUserAndLogin>>queryUserListByRoleCode(@RequestBody UserAndLoginQuery userAndLoginQuery)throws Exception{

        logger.info(" queryUserListByRoleCode start paramData" + userAndLoginQuery.toString());

        //参数校验
        init(userAndLoginQuery,"queryUserListByRoleCode");

        Page<CltUserAndLogin> page = userService.queryUserListByRoleCode(userAndLoginQuery);

        logger.info(" queryUserListByRoleCode end paramData" );

        return  new ResultInfo<>(ResultCode.SUCCESS.code(), SuccessConstants.QUERY_USER_LIST_BY_ROLE_CODE_SUCCESS, page);

    }



    //根据用户类型查询用户列表
    @PostMapping("/queryUserListByUserType")
    public ResultInfo<Page<CltUserAndLogin>>queryUserListByUserType(@RequestBody UserAndLoginQuery userAndLoginQuery)throws Exception{

        logger.info(" queryUserListByUserType start paramData" + userAndLoginQuery.toString());

        //设置客户号:只能查询当前客户下的所有用户(其他客户的用户不能显示)
        CltUserLogin cltUserLogin = (CltUserLogin) redisUtil.get(userAndLoginQuery.getAccess_token());
        if(cltUserLogin!=null) {
            CltUser cltUser = cltUserMapper.selectByPrimaryKey(cltUserLogin.getUserId());
            String custId = cltUser.getCustId();
            userAndLoginQuery.setCustId(custId);
        }

        //参数校验
        init(userAndLoginQuery,"queryUserListByUserType");

        Page<CltUserAndLogin> page = userService.queryUserListByUserType(userAndLoginQuery);

        logger.info(" queryUserListByUserType end paramData" );

        return  new ResultInfo<>(ResultCode.SUCCESS.code(), SuccessConstants.QUERY_USER_LIST_BY_USER_TYPE_SUCCESS, page);

    }


    //发送邮件给客户管理员
    @PostMapping("/sentEmailToCustomerManager")
    public  ResultInfo<String> sentEmailToCustomerManager(@RequestBody  UserAndLoginQuery userAndLoginQuery)throws Exception{

        logger.info(" sentEmailToCustomerManager start paramData" + userAndLoginQuery.toString());

        //获取超级管理员的用户信息
        CltUserLogin cltUserLogin = (CltUserLogin) redisUtil.get(userAndLoginQuery.getAccess_token());

        //发送人的邮件地址
        String sentEmail=null;

        if(cltUserLogin!=null){

            //根据用户的id查询用户的详细信息
            CltUser cltUser=userService.findCltUserById(cltUserLogin.getUserId());

            sentEmail=cltUser.getEmail();

        }


        //校验参数
       init(userAndLoginQuery,"sentEamilToCustManager");

       //根据用户id查询用户
        CltUserAndLogin cltUserAndLogin=userService.findUserById(userAndLoginQuery.getUserId());

        try{
            //获取收件人的邮箱地址
            String receiveEmail=cltUserAndLogin.getEmail();

            //发送的内容
            String content="<p>尊敬的:"+cltUserAndLogin.getUserChnName()+"您好!</p><br/>"+"<p>  欢迎使用京北方云测管理平台，系统已为您创建管理员用户信息，请查收。</p><br/>"+"<p>  用户登录名:"+cltUserAndLogin.getUserChnName()+"</p></br>"+"<p>  用户密码:"+cltUserAndLogin.getLoginPwd()+"</p></br>";

            MailUtil.setAddress(sentEmail,receiveEmail,"",content);

            MailUtil.send("smtp.163.com" ,"hbh_2015@163.com"  ,"r0010400880099");

            logger.info(" sentEmailToCustomerManager end paramData" );

            return new ResultInfo<>(ResultCode.SUCCESS.code(),"发送邮件成功!");

        }catch (Exception e){

            throw new GlobalException(ResultCode.EXCEPTION.code(),"发送邮件失败");

        }



    }


   //根据登录号修改登录表的信息
    @PostMapping(value = "/updateCltUserLoginByLoginNo")
    public ResultInfo<Integer> updateCltUserLoginByLoginNo(@RequestBody  UserAndLoginQuery userAndLoginQuery)throws Exception{

        logger.info(" updateCltUserLoginByLoginNo start paramData" + userAndLoginQuery.toString());

        CltUserLogin cltUserLogin = (CltUserLogin) redisUtil.get(userAndLoginQuery.getAccess_token());

        if(cltUserLogin!=null){
            userAndLoginQuery.setUpdateUser(cltUserLogin.getUserId());
        }

        //对参数进行校验
        init(userAndLoginQuery, "updateCltUserLoginByLoginNo");

        Integer result=userService.updateCltUserLoginByLoginNo(userAndLoginQuery);

        logger.info(" updateCltUserLoginByLoginNo end paramData" );

        return new ResultInfo<>(ResultCode.SUCCESS, "更新成功!",result);

    }

   //根据登录号查询用户登录信息
    @PostMapping(value = "/queryCltUserLoginByLoginNo")
    public ResultInfo<CltUserLogin> queryCltUserLoginByLoginNo(@RequestBody  UserAndLoginQuery userAndLoginQuery)throws Exception{

        logger.info(" queryCltUserLoginByLoginNo start paramData" + userAndLoginQuery.toString());

        //对参数进行校验
        init(userAndLoginQuery, "queryCltUserLoginByLoginNo");

        CltUserLogin result=userService.queryCltUserLoginByLoginNo(userAndLoginQuery);

        logger.info(" queryCltUserLoginByLoginNo end paramData" );

        return new ResultInfo<>(ResultCode.SUCCESS, "查询成功!",result);

    }



    /**==============================================================================*/

    //参数校验的方法

    public static void init(UserAndLoginQuery userAndLoginQuery, String funcCode) throws Exception {

        ParamVerifyUtil paramVerifyUtil = new ParamVerifyUtil();

        Map<String,Object> dataMap = CltUtils.beanToMap(userAndLoginQuery);


        if ("saveUser".equals(funcCode)) {

            //判断用户的类型
            String userType=userAndLoginQuery.getUserType();
            //如果用户类型为平台用户,有些字段是必填字段
            if("1".equals(userType)){
                paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                        "custId","idType", "idNo", "address", "graduatedSchool", "graduatedDate", "graduatedSpecialty", "eduCode","specialty");
            }

        }else if("updateUser".equals(funcCode)){

            //判断用户的类型
            String userType=userAndLoginQuery.getUserType();

            //如果用户类型为平台用户,有些字段是必填字段
            if("1".equals(userType)){
                paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                        "userId","idType", "idNo", "address", "graduatedSchool", "graduatedDate", "graduatedSpecialty", "eduCode","specialty");

            }else{
                if("".equals(userAndLoginQuery.getUserId())|| userAndLoginQuery.getUserId()==null){
                    throw new GlobalException(ErrorConstants.CLT_SYS_PARAM_ERROR_CODE,"userId"+ErrorConstants.CLT_SYS_PARAM_ERROR_MESSAGE);
                }
            }

        }else if ("queryUserInfoByUserId".equals(funcCode)){
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "userId");

        }else if("disEnableUser".equals(funcCode)){
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "userId");
            //判断用户的状态
            String status=userAndLoginQuery.getStatus();
            if("".equals(status) || status==null || !status.matches("[23]")){

                throw new GlobalException(ErrorConstants.USESTATUS_PARAM_NOTNULL_ERROR_CODEUSER_ERROR_CODE,ErrorConstants.USESTATUS_PARAM_NOTNULL_ERROR_CODEUSER_ERROR_MESSAGE);
            }

        }else if("checkLoginNo".equals(funcCode)){
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "loginNo");
        }else if("sentEamilToCustManager".equals(funcCode)){
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "userId");

        }else if("queryUserListByRoleCode".equals(funcCode)){
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "roleCode");
        }else if("deleteUsersByUserIds".equals(funcCode)){
            String[] ids = userAndLoginQuery.getUserIds();
            if(ids.length == 0 ){
                throw new GlobalException(ResultCode.INVALID_PARAM.code() , "要删除的用户个数不能为零");
            }
            for (int i = 0; i < ids.length; i++) {
                String userId = ids[i];
                if ("".equals(userId) || userId == null) {
                    throw new GlobalException(ResultCode.INVALID_PARAM.code(), "用户id不能为空");
                }
            }

        }else if("updateOrgIdByUserIds".equals(funcCode)){

            String[] userIds = userAndLoginQuery.getUserIds();

            if(userIds.length == 0){

                throw new GlobalException(ResultCode.INVALID_PARAM.code() , "要修改的用户个数不能为零");
            }
            for (int i = 0; i < userIds.length; i++) {
                String userId = userIds[i];
                if ("".equals(userId) || userId == null) {
                    throw new GlobalException(ResultCode.INVALID_PARAM.code(), "用户id不能为空");
                }
            }

        }else if("updateCltUserLoginByLoginNo".equals(funcCode)) {
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "loginNo");
        } else if("queryCltUserLoginByLoginNo".equals(funcCode)) {
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "loginNo");

        } else if("queryUserListByUserType".equals(funcCode)) {
            paramVerifyUtil.checkNullOrEmpty(dataMap, logger,
                    "userType");
        }
    }

    //生成验证码到前台
    @GetMapping("/getValiImage")
    public ResultInfo<ImageCode> getValiImage() throws IOException {
        String codeId = UUIDUtil.getUUID();
        ImageCode imageCode = new ImageCode();
        imageCode.setCodeID(codeId);
        VerifyCode vc = new VerifyCode();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        vc.drawImage(outputStream);
        BASE64Encoder encoder = new BASE64Encoder();
        String en = encoder.encode(outputStream.toByteArray());
        //System.out.println(en);
        imageCode.setBase64Code(en);
        String code = vc.getCode();
        redisUtil.set(codeId,code,1800l);
        vc=null;
        return  new ResultInfo<>(ResultCode.SUCCESS.code(),ResultCode.SUCCESS.msg(),imageCode);
    }
    //校验验证码是否正确
    @PostMapping("/valiCode")
    public ResultInfo<String> valiCode(@RequestBody UserLoginQuery userLoginQuery){
        if("".equals(userLoginQuery.getCode())){
            throw new GlobalException(ResultCode.INVALID_PARAM.code(),"验证码不能为空");
        }
        String codeId = userLoginQuery.getCodeId();
        String msg = (String)redisUtil.get(codeId);
        //String msg = (String)request.getSession().getAttribute("code");
        if(!userLoginQuery.getCode().equalsIgnoreCase(msg)){
            throw new GlobalException(ResultCode.INVALID_PARAM.code(),"验证码错误");
        }

        return new ResultInfo<>();
    }
    //密码修改
    @PostMapping("/updatePassword")
    public ResultInfo<String> updatePassword(@RequestBody @Validated UserUpdatePwd userUpdatePwd){

        logger.info("updatePassword start paramData" + userUpdatePwd.toString());

        //判断前后密码是否一致
        if(!userUpdatePwd.getNewPwd().equals(userUpdatePwd.getConfirmPwd())){
            throw new GlobalException(ResultCode.INVALID_PARAM.code(),"前后密码不一致");
        }
        //判断新密码的格式是否正确
        String regex="^(?=.*[0-9])(?=.*[a-zA-Z])(.{6,20})$";
        if(!userUpdatePwd.getNewPwd().matches(regex)){
            throw new GlobalException(ResultCode.INVALID_PARAM.code(),"必须6-20位包含字母和数字");
        }
        //判断输入的用户名和密码是否正确
       // CltUserLogin uerLogin = userService.login(userUpdatePwd.getLoginNo(),userUpdatePwd.getLoginPwd());
        //更新密码

        String access_token = null;
        CltUserLogin cltUserLogin=null;
        try {
            access_token = userUpdatePwd.getAccess_token();
            cltUserLogin = (CltUserLogin) redisUtil.get(access_token);
        } catch (Exception e) {
            logger.info("redis缓存报错",e);
        }
        userService.updatePassword(cltUserLogin.getUserId(),userUpdatePwd.getNewPwd());
        logger.info("updatePassword end");
        return new ResultInfo<>(ResultCode.SUCCESS.code(),"密码修改成功");
    }

    //密码重置
    @PostMapping("/resetPassword")
    public ResultInfo<String> resetPassword(@RequestBody UserLoginQuery userLoginQuery){
        logger.info("resetPassword start paramData" + userLoginQuery.toString());
        userService.resetPassword(userLoginQuery.getLoginNo(),userLoginQuery.getEmail(),userLoginQuery.getUserChnName());
        logger.info("resetPassword end");
        return new ResultInfo<>(ResultCode.SUCCESS.code(),"密码重置成功");
    }
    //根据用户id查询出用户拥有的模块信息
    @GetMapping("/findFunc/{userId}")
    public List<CltFunc> findByUserId(@PathVariable("userId")  String userId){

        logger.info(" findByUserId start paramData" + userId);
        return funcService.fingFuncByUserId(userId);
    }
    //申请重置密码
    @PostMapping("/applyBackPwd")
    public void applyBackPwd(@RequestBody UserLoginQuery userLoginQuery){
        logger.info(" findByUserId start paramData" + userLoginQuery.toString());
        if(userLoginQuery==null){
            throw new GlobalException(ResultCode.INVALID_PARAM.code(),"请填写信息发送");
        }
        if(StringUtils.isEmpty(userLoginQuery.getEmail())){
            throw new GlobalException(ResultCode.INVALID_PARAM.code(),"请填写邮箱");
        }
        if(StringUtils.isEmpty(userLoginQuery.getLoginNo())){
            throw new GlobalException(ResultCode.INVALID_PARAM.code(),"请填写登录名");
        }
        if(StringUtils.isEmpty(userLoginQuery.getUserChnName())){
            throw new GlobalException(ResultCode.INVALID_PARAM.code(),"请填写用户姓名");
        }
        String content = "<p>邮箱:"+userLoginQuery.getEmail()+"</p><br/>"+"<p>登录名:"+userLoginQuery.getLoginNo()+"</p><br/>"+"<p>用户姓名:"+userLoginQuery.getUserChnName()+"</p>";
        try {
            QQSendEmail.sendMessage("申请找回密码",content,"zwylovejava@163.com");
        } catch (MessagingException e) {
            logger.error(e.getMessage());
            throw new GlobalException(ResultCode.INVALID_PARAM.code(),"发送邮件失败");
        }


    }

    //根据用户登录号查用户信息带权限
    @GetMapping("/findOneWithRolesByLoginNo/{username}")
    public CltUserLogin findOneWithRolesByLoginNo(@PathVariable("username")  String username) throws Exception{

        logger.info(" findOneWithRolesByLoginNo start paramData" + username);
        return userService.findOneWithRolesByLoginNo(username);
    }

    //根据用户ID查询登陆表信息
    @PostMapping("/queryUserLoginById")
    public CltUserLogin queryUserLoginById(@RequestBody CltUserLoginQuery cltUserLoginQuery){
        CltUserLogin cltUserLogin =  userService.queryUserLoginById(cltUserLoginQuery);
        return  cltUserLogin;
    }

}

