package com.comwave.rulepoc.vo;

public class Pocru06Vo {

    private String customerDiversion;    //客戶分流
    private Double appraisalAmount = 0.0;  //鑑價金額
    private Double thresholdDBRAmount = 0.0;  //DBR門檻額度
    private Double noDebtAmount = 0.0;  //聯徵無擔負債
    private Double thresholdMonthlyAmount = 0.0;  //月付比門檻額度
    private String resultLevel;    //ResultLevel

    private String ruleId;  //規則ID
    private String ruleName;    //規則描述
    private Double quota;    //額度
    private String nuclearDecision;    //核決

    public Pocru06Vo() {
    }

    public Pocru06Vo(String customerDiversion, Double appraisalAmount, Double thresholdDBRAmount, Double noDebtAmount, Double thresholdMonthlyAmount, String resultLevel) {
        this.customerDiversion = customerDiversion;
        this.appraisalAmount = appraisalAmount;
        this.thresholdDBRAmount = thresholdDBRAmount;
        this.noDebtAmount = noDebtAmount;
        this.thresholdMonthlyAmount = thresholdMonthlyAmount;
        this.resultLevel = resultLevel;
    }

    public String getCustomerDiversion() {
        return customerDiversion;
    }

    public void setCustomerDiversion(String customerDiversion) {
        this.customerDiversion = customerDiversion;
    }

    public Double getAppraisalAmount() {
        return appraisalAmount;
    }

    public void setAppraisalAmount(Double appraisalAmount) {
        this.appraisalAmount = appraisalAmount;
    }

    public Double getThresholdDBRAmount() {
        return thresholdDBRAmount;
    }

    public void setThresholdDBRAmount(Double thresholdDBRAmount) {
        this.thresholdDBRAmount = thresholdDBRAmount;
    }

    public Double getNoDebtAmount() {
        return noDebtAmount;
    }

    public void setNoDebtAmount(Double noDebtAmount) {
        this.noDebtAmount = noDebtAmount;
    }

    public Double getThresholdMonthlyAmount() {
        return thresholdMonthlyAmount;
    }

    public void setThresholdMonthlyAmount(Double thresholdMonthlyAmount) {
        this.thresholdMonthlyAmount = thresholdMonthlyAmount;
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

    public Double getQuota() {
        return quota;
    }

    public void setQuota(Double quota) {
        this.quota = quota;
    }

    public String getResultLevel() {
        return resultLevel;
    }

    public void setResultLevel(String resultLevel) {
        this.resultLevel = resultLevel;
    }

    public String getNuclearDecision() {
        return nuclearDecision;
    }

    public void setNuclearDecision(String nuclearDecision) {
        this.nuclearDecision = nuclearDecision;
    }

    /**
     * 經由” 計算DBR”分流的案件，額度=DBR門檻額度-聯徵無擔負債
     * @param pocru06Vo
     * @return
     */
    public boolean dbrAmount(Pocru06Vo pocru06Vo) {
        Double res = pocru06Vo.getThresholdDBRAmount() - pocru06Vo.getNoDebtAmount();
        pocru06Vo.setQuota((double) (Math.round(res*100)/100.0)); //額度保留兩位
        return true;
    }

    /**
     * 經由” 計算月付比”分流的案件，額度=min(月付比門檻額度,鑑價金額*0.8)
     * @param pocru06Vo
     * @return
     */
    public boolean MonthlyAmount(Pocru06Vo pocru06Vo) {
        Double res = (pocru06Vo.getThresholdMonthlyAmount() < (pocru06Vo.getAppraisalAmount() * 0.8)) ?
                pocru06Vo.getThresholdMonthlyAmount() : (pocru06Vo.getAppraisalAmount() * 0.8);
        pocru06Vo.setQuota((double) (Math.round(res*100)/100.0)); //額度保留兩位
        return true;
    }

    /**
     * 計算核決
     * @param pocru06Vo
     * @return
     */
    public boolean obtainNuclearDecision(Pocru06Vo pocru06Vo){
        if(pocru06Vo.getResultLevel().length() == 0 || pocru06Vo.getResultLevel() == null){
            pocru06Vo.setNuclearDecision("AutoApprove");
        }
        if(pocru06Vo.getResultLevel().contains("CO1")){
            pocru06Vo.setNuclearDecision("CO1");
        }
        if(pocru06Vo.getResultLevel().contains("SCO")){
            pocru06Vo.setNuclearDecision("SCO");
        }
        if(pocru06Vo.getResultLevel().contains("AutoReject")){
            pocru06Vo.setNuclearDecision("AutoReject");
        }
        return true;
    }

}
