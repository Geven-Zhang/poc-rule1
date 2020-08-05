package com.comwave.rulepoc.vo;

public class Pocru13Vo {

    /**
     * 輸入參數
     */
    private String collateralCounties; //擔保品縣市

    /**
     * 輸出參數
     */
    private String ruleId; // 規則ID
    private String ruleName; // 規則描述
    private String customerDiversion;    //客戶分流

    public Pocru13Vo() {
        super();
    }

    public Pocru13Vo(String collateralCounties) {
        this.collateralCounties = collateralCounties;
    }

    public String getCollateralCounties() {
        return collateralCounties;
    }

    public void setCollateralCounties(String collateralCounties) {
        this.collateralCounties = collateralCounties;
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

    public String getCustomerDiversion() {
        return customerDiversion;
    }

    public void setCustomerDiversion(String customerDiversion) {
        this.customerDiversion = customerDiversion;
    }

    @Override
    public String toString() {
        return "Pocru13Vo{" +
                "collateralCounties='" + collateralCounties + '\'' +
                ", ruleId='" + ruleId + '\'' +
                ", ruleName='" + ruleName + '\'' +
                ", customerDiversion='" + customerDiversion + '\'' +
                '}';
    }
}
