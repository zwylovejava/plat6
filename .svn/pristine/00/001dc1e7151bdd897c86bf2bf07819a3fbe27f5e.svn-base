package net.northking.cloudplatform.result;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Title: 错误代码枚举类
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/11/13
 * @UpdateUser:
 * @Version:0.1
 */
public enum ResultCode {
    SUCCESS("CLT000000000","正常"),
    INVALID_PARAM("CLT000000001", "参数错误"),
    EXCEPTION("CLT000000002", "系统异常"),
    ACCESSDENIED("CLT000000003", "不允许访问"),
    REPEATCOMMIT("CLT000000004", "请不要重复提交！"),
    NOJOB("CLT000000005", "已经没有任务！");

    private String code;
    private String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String code() {
        return code;
    }

    public String msg() {
        return msg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("code", code)
                .append("msg", msg)
                .toString();
    }
}
