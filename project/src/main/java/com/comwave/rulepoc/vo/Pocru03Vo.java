package com.comwave.rulepoc.vo;

public class Pocru03Vo {

    /**
     * 輸入參數
     */
    private double aum; //aum
    private double noBurdenDebt; //聯徵無擔負債
    private double yearIncome;  //年收入

    /**
     * 輸出參數
     */
    private String ruleId; // 規則ID
    private String ruleName; // 規則描述
    private int dbr = 0; //DBR門檻值

    public Pocru03Vo(){
    }

    public Pocru03Vo(double aum, double noBurdenDebt, double yearIncome) {
        this.aum = aum;
        this.noBurdenDebt = noBurdenDebt;
        this.yearIncome = yearIncome;
    }

    public double getAum() {
        return aum;
    }

    public void setAum(double aum) {
        this.aum = aum;
    }

    public double getNoBurdenDebt() {
        return noBurdenDebt;
    }

    public void setNoBurdenDebt(double noBurdenDebt) {
        this.noBurdenDebt = noBurdenDebt;
    }

    public double getYearIncome() {
        return yearIncome;
    }

    public void setYearIncome(double yearIncome) {
        this.yearIncome = yearIncome;
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

    public int getDbr() {
        return dbr;
    }

    public void setDbr(int dbr) {
        this.dbr = dbr;
    }

    public double getAumSubtractNoBurdenDebt(Pocru03Vo pocru03Vo){
        return pocru03Vo.getAum()-pocru03Vo.getNoBurdenDebt();
    }

    @Override
    public String toString(){
        return "Pocru03Vo{" +
                "aum=" + aum +
                ", noBurdenDebt=" + noBurdenDebt +
                ", yearIncome=" + yearIncome +
                ", ruleId='" + ruleId + '\'' +
                ", ruleName='" + ruleName + '\'' +
                ", dbr=" + dbr +
                '}';
    }
}
