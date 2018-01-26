package net.northking.cloudplatform.enums;

import org.apache.commons.lang.builder.ToStringBuilder;

public enum CltExecuteStatus {

    ////0为初始化,1为成功，2为失败，3为终止。用例状态和步骤状态保持一致：失败>成功
    INIT("0","初始化"),
    SUCCESS("1","成功"),
    FAIL("2","失败"),
    OVER("3","终止");

    private String code;

    private String msg;

    CltExecuteStatus(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
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
