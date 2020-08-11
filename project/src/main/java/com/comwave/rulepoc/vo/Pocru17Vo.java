package com.comwave.rulepoc.vo;

public class Pocru17Vo {

    private String collateralCounties; //擔保品縣市
    private Double appraisalAmount = 0.0;  //鑑價金額
    private Double thresholdMonthlyAmount = 0.0;  //月付比門檻額度

    private String ruleId;  //規則ID
    private String ruleName;    //規則描述
    private Double guaranteeAmount;    //有擔額度

    public Pocru17Vo() {
    }

    public Pocru17Vo(String collateralCounties, Double appraisalAmount, Double thresholdMonthlyAmount) {
        this.collateralCounties = collateralCounties;
        this.appraisalAmount = appraisalAmount;
        this.thresholdMonthlyAmount = thresholdMonthlyAmount;
    }

    public String getCollateralCounties() {
        return collateralCounties;
    }

    public void setCollateralCounties(String collateralCounties) {
        this.collateralCounties = collateralCounties;
    }

    public Double getAppraisalAmount() {
        return appraisalAmount;
    }

    public void setAppraisalAmount(Double appraisalAmount) {
        this.appraisalAmount = appraisalAmount;
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

    public Double getGuaranteeAmount() {
        return guaranteeAmount;
    }

    public void setGuaranteeAmount(Double guaranteeAmount) {
        this.guaranteeAmount = guaranteeAmount;
    }

    /**
     * 有擔額度=min(月付比門檻額度,鑑價金額*0.8)
     * @param pocru17Vo
     * @return
     */
    public boolean MonthlyAmount(Pocru17Vo pocru17Vo) {
        Double res = (pocru17Vo.getThresholdMonthlyAmount() < (pocru17Vo.getAppraisalAmount() * 0.8)) ?
                pocru17Vo.getThresholdMonthlyAmount() : (pocru17Vo.getAppraisalAmount() * 0.8);
        pocru17Vo.setGuaranteeAmount((double) (Math.round(res*100)/100.0)); //小數點后保留兩位
        return true;
    }

    public boolean MonthlyAmountUnsecured(Pocru17Vo pocru17Vo) {
        pocru17Vo.setGuaranteeAmount(0.0);
        return true;
    }


    @Override
    public String toString() {
        return "Pocru13Vo{" +
                "collateralCounties='" + collateralCounties + '\'' +
                ", appraisalAmount=" + appraisalAmount +
                ", thresholdMonthlyAmount=" + thresholdMonthlyAmount +
                ", ruleId='" + ruleId + '\'' +
                ", ruleName='" + ruleName + '\'' +
                ", guaranteeAmount=" + guaranteeAmount +
                '}';
    }
}
