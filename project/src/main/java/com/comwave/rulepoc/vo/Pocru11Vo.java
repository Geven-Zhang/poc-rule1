package com.comwave.rulepoc.vo;

public class Pocru11Vo {

    /**
     * 輸入參數
     */
    private String financialAccountTag;  //理財戶標籤

    /**
     * 輸出參數
     */
    private String ruleId; // 規則ID
    private String ruleName; // 規則描述
    private Double guaranteedRate; //擔保利率
    private Double unguaranteedRate; //無擔保利率
    private Double basicAccountFee; //基礎帳管費
    private Double discountAccountFee; //優惠帳管費
    private String discountStartDate; //優惠起日
    private String discountEndDate; //優惠迄日

    public Pocru11Vo() {
        super();
    }

    public Pocru11Vo(String financialAccountTag, String ruleId, String ruleName, Double guaranteedRate, Double unguaranteedRate, Double basicAccountFee, Double discountAccountFee, String discountStartDate, String discountEndDate) {
        this.financialAccountTag = financialAccountTag;
        this.ruleId = ruleId;
        this.ruleName = ruleName;
        this.guaranteedRate = guaranteedRate;
        this.unguaranteedRate = unguaranteedRate;
        this.basicAccountFee = basicAccountFee;
        this.discountAccountFee = discountAccountFee;
        this.discountStartDate = discountStartDate;
        this.discountEndDate = discountEndDate;
    }

    public String getFinancialAccountTag() {
        return financialAccountTag;
    }

    public void setFinancialAccountTag(String financialAccountTag) {
        this.financialAccountTag = financialAccountTag;
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

    public Double getGuaranteedRate() {
        return guaranteedRate;
    }

    public void setGuaranteedRate(Double guaranteedRate) {
        this.guaranteedRate = guaranteedRate;
    }

    public Double getUnguaranteedRate() {
        return unguaranteedRate;
    }

    public void setUnguaranteedRate(Double unguaranteedRate) {
        this.unguaranteedRate = unguaranteedRate;
    }

    public Double getBasicAccountFee() {
        return basicAccountFee;
    }

    public void setBasicAccountFee(Double basicAccountFee) {
        this.basicAccountFee = basicAccountFee;
    }

    public Double getDiscountAccountFee() {
        return discountAccountFee;
    }

    public void setDiscountAccountFee(Double discountAccountFee) {
        this.discountAccountFee = discountAccountFee;
    }

    public String getDiscountStartDate() {
        return discountStartDate;
    }

    public void setDiscountStartDate(String discountStartDate) {
        this.discountStartDate = discountStartDate;
    }

    public String getDiscountEndDate() {
        return discountEndDate;
    }

    public void setDiscountEndDate(String discountEndDate) {
        this.discountEndDate = discountEndDate;
    }

    @Override
    public String toString() {
        return "Pocru11Vo{" +
                "financialAccountTag='" + financialAccountTag + '\'' +
                ", ruleId='" + ruleId + '\'' +
                ", ruleName='" + ruleName + '\'' +
                ", guaranteedRate=" + guaranteedRate +
                ", unguaranteedRate=" + unguaranteedRate +
                ", basicAccountFee=" + basicAccountFee +
                ", discountAccountFee=" + discountAccountFee +
                ", discountStartDate='" + discountStartDate + '\'' +
                ", discountEndDate='" + discountEndDate + '\'' +
                '}';
    }
}
