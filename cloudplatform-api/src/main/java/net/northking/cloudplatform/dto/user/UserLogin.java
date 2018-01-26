package net.northking.cloudplatform.dto.user;

/**
 * Created by Administrator on 2017/11/27 0027.
 */
public class UserLogin {

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getBase64Code() {
        return base64Code;
    }

    public void setBase64Code(String base64Code) {
        this.base64Code = base64Code;
    }

    private  String  codeId;
    private  String base64Code;



}
