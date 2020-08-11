package com.comwave.rulepoc.vo;

public class Pocru01Vo {

    private String industryCode;   //行業代碼
    private String careerCode;     //職業代碼

    private String ruleId;  //規則ID
    private String ruleName;    //規則描述
    private double estimateYearIncome = 0;    //年收入預估

    public Pocru01Vo(){
    }

    public Pocru01Vo(String industryCode, String careerCode) {
        this.industryCode = industryCode;
        this.careerCode = careerCode;
    }

    public String getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    public String getCareerCode() {
        return careerCode;
    }

    public void setCareerCode(String careerCode) {
        this.careerCode = careerCode;
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

    public double getEstimateYearIncome() {
        return estimateYearIncome;
    }

    public void setEstimateYearIncome(double estimateYearIncome) {
        this.estimateYearIncome = estimateYearIncome;
    }

    @Override
    public String toString(){
        return "Pocru01Vo{" +
                "industryCode=" + industryCode + '\'' +
                ", careerCode=" + careerCode + '\'' +
                ", ruleId='" + ruleId + '\'' +
                ", ruleName='" + ruleName + '\'' +
                ", estimateYearIncome=" + estimateYearIncome +
                '}';
    }
}
