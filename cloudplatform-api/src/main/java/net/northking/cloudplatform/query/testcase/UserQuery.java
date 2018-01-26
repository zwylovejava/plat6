package net.northking.cloudplatform.query.testcase;



import net.northking.cloudplatform.common.PageQuery;

import javax.validation.constraints.NotNull;

/**
 * @Title:
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/11/6
 * @UpdateUser:
 * @Version:0.1
 */
public class UserQuery extends PageQuery<UserQuery> {

    private String id;

    @NotNull(message = "userid not allow null")
    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}
