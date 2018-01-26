package net.northking.cloudplatform.dto.auth;



import net.northking.cloudplatform.domain.user.CltFunc;

import java.util.List;

/**
 * @Title: 权限DTO
 * @Description:
 * @Company: Northking
 * @Author: chuangsheng.huang
 * @CreateDate: 2017/11/27
 * @UpdateUser:
 * @Version:0.1
 */
public class Authority {

    private List<UserFunc> funcs;

    public List<UserFunc> getLeftFuncList() {
        return leftFuncList;
    }

    public void setLeftFuncList(List<UserFunc> leftFuncList) {
        this.leftFuncList = leftFuncList;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "funcs=" + funcs +
                ", topFuncList=" + topFuncList +
                ", leftFuncList=" + leftFuncList +
                '}';
    }

    public List<CltFunc> getTopFuncList() {
        return topFuncList;
    }

    public void setTopFuncList(List<CltFunc> topFuncList) {
        this.topFuncList = topFuncList;
    }

    private  List<CltFunc> topFuncList;

    private  List<UserFunc>  leftFuncList;

    public List<UserFunc> getFuncs() {
        return funcs;
    }

    public void setFuncs(List<UserFunc> funcs) {
        this.funcs = funcs;
    }
}
