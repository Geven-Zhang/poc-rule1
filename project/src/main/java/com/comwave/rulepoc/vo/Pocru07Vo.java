package com.comwave.rulepoc.vo;

public class Pocru07Vo {

    private String customerDiversion;    //客戶分流
    private Double unguaranteedRate = 0.0;  //無擔保利率
    private Double guaranteedRate = 0.0;  //擔保利率

    private String ruleId;  //規則ID
    private String ruleName;    //規則描述
    private Double rate;    //利率

    public Pocru07Vo() {
    }

    public Pocru07Vo(String customerDiversion, Double unguaranteedRate, Double guaranteedRate) {
        this.customerDiversion = customerDiversion;
        this.unguaranteedRate = unguaranteedRate;
        this.guaranteedRate = guaranteedRate;
    }

    public String getCustomerDiversion() {
        return customerDiversion;
    }

    public void setCustomerDiversion(String customerDiversion) {
        this.customerDiversion = customerDiversion;
    }

    public Double getUnguaranteedRate() {
        return unguaranteedRate;
    }

    public void setUnguaranteedRate(Double unguaranteedRate) {
        this.unguaranteedRate = unguaranteedRate;
    }

    public Double getGuaranteedRate() {
        return guaranteedRate;
    }

    public void setGuaranteedRate(Double guaranteedRate) {
        this.guaranteedRate = guaranteedRate;
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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public boolean obtainRate(Pocru07Vo pocru07Vo, Double d) {
        pocru07Vo.setRate(d);
        return true;
    }
}
