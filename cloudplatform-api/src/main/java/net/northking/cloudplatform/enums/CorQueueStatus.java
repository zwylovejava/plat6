package net.northking.cloudplatform.enums;

import org.apache.commons.lang.builder.ToStringBuilder;

//create by zwy
public enum CorQueueStatus {
    //状态： 1-准备就绪；3-处理中；4-提交；10-已完成
    READY("1","准备就绪"),
    EXECING("3", "处理中"),
    SUBMIT("4", "提交"),
    COMPLETE("10", "已完成");

    private String code;
    private String msg;

    CorQueueStatus(String code, String msg) {
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
