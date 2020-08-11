package com.comwave.rulepoc.vo;

import java.math.BigDecimal;

public class Pocru10Vo {

    /**
     * 輸入參數
     */
    private int dbr;  //DBR門檻值
    private Double yearIncome; //年收入


    /**
     * 輸出參數
     */
    private String ruleId; // 規則ID
    private String ruleName; // 規則描述
    private Double dbrAmount; //DBR門檻額度

    public Pocru10Vo() {
        super();
    }

    public Pocru10Vo(int dbr, Double yearIncome, String ruleId, String ruleName, Double dbrAmount) {
        this.dbr = dbr;
        this.yearIncome = yearIncome;
        this.ruleId = ruleId;
        this.ruleName = ruleName;
        this.dbrAmount = dbrAmount;
    }

    public int getDbr() {
        return dbr;
    }

    public void setDbr(int dbr) {
        this.dbr = dbr;
    }

    public Double getYearIncome() {
        return yearIncome;
    }

    public void setYearIncome(Double yearIncome) {
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

    public Double getDbrAmount() {
        return dbrAmount;
    }

    public void setDbrAmount(Double dbrAmount) {
        this.dbrAmount = dbrAmount;
    }

    @Override
    public String toString() {
        return "Pocru10Vo{" +
                "dbr=" + dbr +
                ", yearIncome='" + yearIncome + '\'' +
                ", ruleId='" + ruleId + '\'' +
                ", ruleName='" + ruleName + '\'' +
                ", dbrAmount=" + dbrAmount +
                '}';
    }

    public Boolean calDBRAmount(Pocru10Vo pocru10Vo) {
        this.setDbrAmount(new BigDecimal(getDbr()*getYearIncome()/12).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
        return true;
    }
}
