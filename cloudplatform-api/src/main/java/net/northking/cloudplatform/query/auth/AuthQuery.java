package net.northking.cloudplatform.query.auth;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Title: 登录认证请求参数
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/11/27
 * @UpdateUser:
 * @Version:0.1
 */
public class AuthQuery {
    //用户名
    @NotEmpty(message = "用户名必须输入")
    private String username;
    //密码
    @NotEmpty(message = "用户密码必须输入")
    private String password;

    //验证码图片uuid
    @NotEmpty(message = "图片ID为空")
    private String imgId;

    //验证码值
    @NotEmpty(message = "验证码必须输入")
    private String imgValue;

    //access_token值
    public  String getAccess_token() {
        return access_token;
    }

    public void   setAccess_token(String access_token) {
        this.access_token = access_token;
    }
    private  String access_token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getImgValue() {
        return imgValue;
    }

    public void setImgValue(String imgValue) {
        this.imgValue = imgValue;
    }
}
