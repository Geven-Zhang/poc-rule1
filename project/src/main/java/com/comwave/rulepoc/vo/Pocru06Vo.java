package com.comwave.rulepoc.vo;

public class Pocru06Vo {

    private Double thresholdDBRAmount = 0.0;  //DBR門檻額度
    private Double noDebtAmount = 0.0;  //聯徵無擔負債
    private Double loanQuotaAmount = 0.0;  //申貸額度
    private Double guaranteedQuotaAmount = 0.0;  //有擔額度
    private String resultLevel;    //ResultLevel

    private String ruleId;  //規則ID
    private String ruleName;    //規則描述
    private Double quota;    //額度
    private String nuclearDecision;    //核決

    public Pocru06Vo() {
    }

    public Pocru06Vo(Double thresholdDBRAmount, Double noDebtAmount, Double loanQuotaAmount, Double guaranteedQuotaAmount, String resultLevel) {
        this.thresholdDBRAmount = thresholdDBRAmount;
        this.noDebtAmount = noDebtAmount;
        this.loanQuotaAmount = loanQuotaAmount;
        this.guaranteedQuotaAmount = guaranteedQuotaAmount;
        this.resultLevel = resultLevel;
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

    public Double getLoanQuotaAmount() {
        return loanQuotaAmount;
    }

    public void setLoanQuotaAmount(Double loanQuotaAmount) {
        this.loanQuotaAmount = loanQuotaAmount;
    }

    public Double getGuaranteedQuotaAmount() {
        return guaranteedQuotaAmount;
    }

    public void setGuaranteedQuotaAmount(Double guaranteedQuotaAmount) {
        this.guaranteedQuotaAmount = guaranteedQuotaAmount;
    }

    public String getResultLevel() {
        return resultLevel;
    }

    public void setResultLevel(String resultLevel) {
        this.resultLevel = resultLevel;
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

    public String getNuclearDecision() {
        return nuclearDecision;
    }

    public void setNuclearDecision(String nuclearDecision) {
        this.nuclearDecision = nuclearDecision;
    }

    /**
     * 無擔額度
     * 如果申貸額度>有擔額度，無擔額度=min(DBR門檻額度-聯徵無擔負債,申貸額度-有擔額度)，其餘為0
     * @param pocru06Vo
     * @return
     */
    public boolean noBurdenAmount(Pocru06Vo pocru06Vo) {
        Double res = 0.0;
        if(pocru06Vo.getLoanQuotaAmount() > pocru06Vo.getGuaranteedQuotaAmount()){
            //DBR門檻額度-聯徵無擔負債
            Double amount1=pocru06Vo.getThresholdDBRAmount()-pocru06Vo.getNoDebtAmount();
            //申貸額度-有擔額度
            Double amount2=pocru06Vo.getLoanQuotaAmount()-pocru06Vo.getGuaranteedQuotaAmount();
            res = amount1>amount2?amount2:amount1;
        }else {
            res=0.0;
        }
        pocru06Vo.setQuota((double) (Math.round(res*100)/100.0)); //小數點后保留兩位
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
        if(pocru06Vo.getResultLevel().contains("Referral")){
            pocru06Vo.setNuclearDecision("Referral");
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

    @Override
    public String toString() {
        return "Pocru06Vo{" +
                "thresholdDBRAmount=" + thresholdDBRAmount +
                ", noDebtAmount=" + noDebtAmount +
                ", loanQuotaAmount=" + loanQuotaAmount +
                ", guaranteedQuotaAmount=" + guaranteedQuotaAmount +
                ", resultLevel='" + resultLevel + '\'' +"\n"+
                ", ruleId='" + ruleId + '\'' +
                ", ruleName='" + ruleName + '\'' +
                ", quota=" + quota +
                ", nuclearDecision='" + nuclearDecision + '\'' +
                '}';
    }
}
