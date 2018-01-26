package net.northking.cloudplatform.enums;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Title: 任务表
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/12/26
 * @UpdateUser:
 * @Version:0.1
 */
public enum CltJobStatus {
    INIT("1","未执行"),
    GENJOB("2", "生成任务中"),
    EXECUTEING("3", "执行中"),
    COMPLETE("4", "已完成");

    private String code;
    private String msg;

    CltJobStatus(String code, String msg) {
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
