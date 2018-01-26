package net.northking.cloudplatform.exception;


import net.northking.cloudplatform.result.ResultCode;

/**
 * @Title: 全局异常
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/11/14
 * @UpdateUser:
 * @Version:0.1
 */
public class GlobalException extends RuntimeException{
    private String code;

    public GlobalException(String code, String message){
        super(message);
        this.code = code;
    }

    public GlobalException(ResultCode resultCode){
        super(resultCode.msg());
//        this.code = code;
        this.code = resultCode.code();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
