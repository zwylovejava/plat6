package net.northking.cloudplatform.dto.testexecute;

public class StepDataInfo {
    private String value; //赋值
    private String  type;  // 类型 输入|输出
    private String code; //  要素
    private String 	name; // 要素名称
    private String memo; // 要素说明
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
