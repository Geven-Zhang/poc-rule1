package com.comwave.rulepoc.vo;

public class Pocru04Vo {

    /**
     * 輸入參數
     */
    private String collateralCounties; //擔保品縣市
    private double totalDebt;  //聯徵總負債

    /**
     * 輸出參數
     */
    private String ruleId; // 規則ID
    private String ruleName; // 規則描述
    private int monthlyPayment = 0; //月付比門檻值

    public Pocru04Vo(){
    }

    public Pocru04Vo(String collateralCounties, double totalDebt) {
        this.collateralCounties = collateralCounties;
        this.totalDebt = totalDebt;
    }

    public String getCollateralCounties() {
        return collateralCounties;
    }

    public void setCollateralCounties(String collateralCounties) {
        this.collateralCounties = collateralCounties;
    }

    public double getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(double totalDebt) {
        this.totalDebt = totalDebt;
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

    public int getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(int monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public String toString(){
        return "Pocru04Vo{" +
                "collateralCounties='" + collateralCounties + '\'' +
                ", totalDebt=" + totalDebt +
                ", ruleId='" + ruleId + '\'' +
                ", ruleName='" + ruleName + '\'' +
                ", monthlyPayment=" + monthlyPayment +
                '}';
    }
}
