package net.northking.cloudplatform.enums;

import org.apache.commons.lang.builder.ToStringBuilder;
//create by zwy
public enum CltBatchStatus {
    //,默认为0初始状态,1为可发送（待发送）,2为发送中,3为发送成功（已接收）,
    // 4为分配主管, 5.分配测试人员，6.执行中（已压任务）
    // ,7.执行完成,8.回馈中,9.确认完成,10.撤回，11.关闭
    INIT("0","初始状态"),
    CAN_SEND("1","可发送"),
    SENDING("2","发送中"),
    SEND_SUCCESS("3","发送成功"),
    MANAGER("4","分配主管"),
    MAN_TEST("5","分配测试人员"),
    EXECUTEING("6","执行中"),
    EXECUTE_OK("7","执行完成"),
    FALLBACK("8","回馈中"),
    CONFIRM_OK("9","确认完成"),
    CANCEL("10","撤回"),
    CLOSE("11","关闭");

    private String code;

    private String msg;

    CltBatchStatus(String code,String msg){
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
