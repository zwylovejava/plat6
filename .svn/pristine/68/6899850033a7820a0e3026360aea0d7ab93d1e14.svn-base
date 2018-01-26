package net.northking.cloudplatform.query.user;

import net.northking.cloudplatform.common.PageQuery;
import org.hibernate.validator.constraints.NotEmpty;

public class UserUpdatePwd extends PageQuery<UserUpdatePwd> {
    @NotEmpty(message =  "新密码不能为空" )
    private String newPwd;
    @NotEmpty(message =  "确认密码不能为空" )
    private String confirmPwd;

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }

    @Override
    public String toString() {
        return "UserUpdatePwd{" +
                "newPwd='" + newPwd + '\'' +
                ", confirmPwd='" + confirmPwd + '\'' +
                '}';
    }
}
