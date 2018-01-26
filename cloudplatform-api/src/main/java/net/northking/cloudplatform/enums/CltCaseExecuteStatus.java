package net.northking.cloudplatform.enums;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Title: 用例执行流程表
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/12/26
 * @UpdateUser:
 * @Version:0.1
 */
public enum CltCaseExecuteStatus {
    INIT("0","初始化（已领取，待办）"),
    COMPLETE("1", "已完成");

    private String code;
    private String msg;

    CltCaseExecuteStatus(String code, String msg) {
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
