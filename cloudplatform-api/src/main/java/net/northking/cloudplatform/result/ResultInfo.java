package net.northking.cloudplatform.result;

import java.io.Serializable;

/**
 * @Title: 结果信息类
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/11/14
 * @UpdateUser:
 * @Version:0.1
 */
public class ResultInfo<T>  implements Serializable {
    private String resultCode;
    private String resultMsg;
    private T resultData;

    public ResultInfo(ResultCode success, ResultInfo<T> resultInfo) {

    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", resultData=" + resultData +
                '}';
    }

    public ResultInfo(){
        this(ResultCode.SUCCESS, "success");
    }
    public ResultInfo(String resultCode, String resultMsg, T data) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.resultData = data;
    }

    public ResultInfo(ResultCode resultCode, String message, T data) {
        this.resultCode = resultCode.code();
        this.resultMsg = message;
        this.resultData = data;
    }

    public ResultInfo(ResultCode resultCode, String message) {
        this.resultCode = resultCode.code();
        this.resultMsg = message;
    }

    public ResultInfo(String resultCode, String message) {
        this.resultCode = resultCode;
        this.resultMsg = message;
    }

    public ResultInfo(ResultCode resultCode) {
        this.resultCode = resultCode.code();
        this.resultMsg = resultCode.msg();
    }


    public ResultInfo(ResultCode resultCode, T data) {
        this.resultCode = resultCode.code();
        this.resultMsg = resultCode.msg();
        this.resultData = data;
    }


    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public T getResultData() {
        return resultData;
    }

    public void setResultData(T resultData) {
        this.resultData = resultData;
    }
}
