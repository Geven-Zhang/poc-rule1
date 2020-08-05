package com.comwave.rulepoc.vo;

public class Pocru09Vo {

    private String financialLabel;    //理財戶標籤
    private String devCode;    //Dev_code

    private String ruleId;  //規則ID
    private String ruleName;    //規則描述
    private String dispatchQueue;    //派案queue

    public Pocru09Vo() {
    }

    public Pocru09Vo(String financialLabel, String devCode) {
        this.financialLabel = financialLabel;
        this.devCode = devCode;
    }

    public String getFinancialLabel() {
        return financialLabel;
    }

    public void setFinancialLabel(String financialLabel) {
        this.financialLabel = financialLabel;
    }

    public String getDevCode() {
        return devCode == null ? "" : devCode;
    }

    public void setDevCode(String devCode) {
        this.devCode = devCode;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getDispatchQueue() {
        return dispatchQueue;
    }

    public void setDispatchQueue(String dispatchQueue) {
        this.dispatchQueue = dispatchQueue;
    }

    @Override
    public String toString() {
        return "Pocru09Vo{" +
                "financialLabel='" + financialLabel + '\'' +
                ", devCode='" + devCode + '\'' +
                ", ruleId='" + ruleId + '\'' +
                ", ruleName='" + ruleName + '\'' +
                ", dispatchQueue='" + dispatchQueue + '\'' +
                '}';
    }
}
