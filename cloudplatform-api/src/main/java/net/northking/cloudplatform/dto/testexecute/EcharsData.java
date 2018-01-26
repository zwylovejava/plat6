package net.northking.cloudplatform.dto.testexecute;

import java.util.*;

public class EcharsData {
    private List<String> listDate = new ArrayList<>();
    //已完成
    private List<Integer> successNum = new ArrayList<>();

    //缺陷数
    private List<Integer> bugSize = new ArrayList<>();

    //终止数量
    private List<Integer> overNum = new ArrayList<>();

    //未决解缺陷数
    private List<Integer> unSloveNum = new ArrayList<>();

    public List<String> getListDate() {
        return listDate;
    }

    public void setListDate(List<String> listDate) {
        this.listDate = listDate;
    }

    public List<Integer> getSuccessNum() {
        return successNum;
    }

    public void setSuccessNum(List<Integer> successNum) {
        this.successNum = successNum;
    }

    public List<Integer> getBugSize() {
        return bugSize;
    }

    public void setBugSize(List<Integer> bugSize) {
        this.bugSize = bugSize;
    }

    public List<Integer> getOverNum() {
        return overNum;
    }

    public void setOverNum(List<Integer> overNum) {
        this.overNum = overNum;
    }

    public List<Integer> getUnSloveNum() {
        return unSloveNum;
    }

    public void setUnSloveNum(List<Integer> unSloveNum) {
        this.unSloveNum = unSloveNum;
    }
}
