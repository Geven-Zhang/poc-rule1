package com.comwave.rulepoc.vo;

import java.math.BigDecimal;

public class Pocru02Vo {

    /**
     * 輸入參數
     */
    private String isAgreeCheckMargin;  //是否客戶同意查詢保價金
    private String financialAccountTag; //理財戶標籤
    private double aum; //AUM
    private double margin;  //保價金
    private double estimateYearIncome;  //年收入預估
    private double applyYearIncome;  //申請書年收入


    /**
     * 輸出參數
     */
    private String ruleId; // 規則ID
    private String ruleName; // 規則描述
    private double yearIncome = 0; //年收入

    public Pocru02Vo(){
    }

    public Pocru02Vo(String isAgreeCheckMargin, String financialAccountTag, double aum, double margin, double estimateYearIncome, double applyYearIncome) {
        this.isAgreeCheckMargin = isAgreeCheckMargin;
        this.financialAccountTag = financialAccountTag;
        this.aum = aum;
        this.margin = margin;
        this.estimateYearIncome = estimateYearIncome;
        this.applyYearIncome = applyYearIncome;
    }

    public String getIsAgreeCheckMargin() {
        return isAgreeCheckMargin;
    }

    public void setIsAgreeCheckMargin(String isAgreeCheckMargin) {
        this.isAgreeCheckMargin = isAgreeCheckMargin;
    }

    public String getFinancialAccountTag() {
        return financialAccountTag;
    }

    public void setFinancialAccountTag(String financialAccountTag) {
        this.financialAccountTag = financialAccountTag;
    }

    public double getAum() {
        return aum;
    }

    public void setAum(double aum) {
        this.aum = aum;
    }

    public double getMargin() {
        return margin;
    }

    public void setMargin(double margin) {
        this.margin = margin;
    }

    public double getEstimateYearIncome() {
        return estimateYearIncome;
    }

    public void setEstimateYearIncome(double estimateYearIncome) {
        this.estimateYearIncome = estimateYearIncome;
    }

    public double getApplyYearIncome() {
        return applyYearIncome;
    }

    public void setApplyYearIncome(double applyYearIncome) {
        this.applyYearIncome = applyYearIncome;
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

    public double getYearIncome() {
        return yearIncome;
    }

    public void setYearIncome(double yearIncome) {
        this.yearIncome = yearIncome;
    }

    public boolean calculateYearIncomeYY(Pocru02Vo pocru02Vo){
        double margin = pocru02Vo.getMargin();
        double yearIncome =  pocru02Vo.getAum()+margin;
        pocru02Vo.setYearIncome(yearIncome);
        return true;
    }

    public boolean calculateYearIncomeYN(Pocru02Vo pocru02Vo){
         double margin = pocru02Vo.getMargin();
         double yearIncome = yearIncome = Math.max(Math.max(Math.min(pocru02Vo.getApplyYearIncome(),pocru02Vo.getEstimateYearIncome())/14,(pocru02Vo.getAum()+margin)/12),0.0)*12;
         BigDecimal bd = new BigDecimal(yearIncome);
         bd =  bd.setScale(2,BigDecimal.ROUND_HALF_UP);
         pocru02Vo.setYearIncome(bd.doubleValue());
        return true;
    }

    public boolean calculateYearIncomeNY(Pocru02Vo pocru02Vo){
        double yearIncome =  pocru02Vo.getAum()+0;
        pocru02Vo.setMargin(0);
        pocru02Vo.setYearIncome(yearIncome);
        return true;
    }

    public boolean calculateYearIncomeNN(Pocru02Vo pocru02Vo){
        pocru02Vo.setMargin(0);
        double yearIncome = Math.max(Math.max(Math.min(pocru02Vo.getApplyYearIncome(),pocru02Vo.getEstimateYearIncome())/14,(pocru02Vo.getAum()+0)/12),0.0)*12;
        BigDecimal bd = new BigDecimal(yearIncome);
        bd =  bd.setScale(2,BigDecimal.ROUND_HALF_UP);
        pocru02Vo.setYearIncome(bd.doubleValue());
        return true;
    }


    @Override
    public String toString(){
        return "Pocru02Vo{" +
                "isAgreeCheckMargin='" + isAgreeCheckMargin + '\'' +
                ", financialAccountTag='" + financialAccountTag + '\'' +
                ", aum=" + aum +
                ", margin=" + margin +
                ", estimateYearIncome=" + estimateYearIncome +
                ", applyYearIncome=" + applyYearIncome +
                ", ruleId='" + ruleId + '\'' +
                ", ruleName='" + ruleName + '\'' +
                ", yearIncome=" + yearIncome +
                '}';
    }
}
