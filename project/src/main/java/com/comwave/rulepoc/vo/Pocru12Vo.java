package com.comwave.rulepoc.vo;

public class Pocru12Vo {

    /**
     * 輸入參數
     */
    private int monthlyPayment;  //月付比門檻值
    private Double yearIncome;  //年收入
    private Double guaranteedRate;  //擔保利率

    /**
     * 輸出參數
     */
    private String ruleId; // 規則ID
    private String ruleName; // 規則描述
    private Double thresholdMonthlyAmount; //月付比門檻額度
    private Double thresholdMonthlyAmountFee; //月付比門檻回推每月應攤還本息金額
    private Double avgAmortizationRate; //平均攤還率

    public Pocru12Vo() {
    }

    public Pocru12Vo(int monthlyPayment, Double yearIncome, Double guaranteedRate) {
        this.monthlyPayment = monthlyPayment;
        this.yearIncome = yearIncome;
        this.guaranteedRate = guaranteedRate;
    }

    public int getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(int monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public Double getYearIncome() {
        return yearIncome;
    }

    public void setYearIncome(Double yearIncome) {
        this.yearIncome = yearIncome;
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

    public Double getThresholdMonthlyAmount() {
        return thresholdMonthlyAmount;
    }

    public void setThresholdMonthlyAmount(Double thresholdMonthlyAmount) {
        this.thresholdMonthlyAmount = thresholdMonthlyAmount;
    }

    public Double getThresholdMonthlyAmountFee() {
        return thresholdMonthlyAmountFee;
    }

    public void setThresholdMonthlyAmountFee(Double thresholdMonthlyAmountFee) {
        this.thresholdMonthlyAmountFee = thresholdMonthlyAmountFee;
    }

    public Double getAvgAmortizationRate() {
        return avgAmortizationRate;
    }

    public void setAvgAmortizationRate(Double avgAmortizationRate) {
        this.avgAmortizationRate = avgAmortizationRate;
    }

    /**
     * 计算a的b次方
     *
     * @param a
     * @param b
     * @return
     */
    public static Double power(Double a, int b) {
        Double power = 1.0;
        for (int i = 0; i < b; i++)
            power *= a;
        return power;
    }

    /**
     * 月付比門檻額度公式
     *
     * @param pocru12Vo
     * @return
     */
    public Boolean obtainThresholdMonthlyAmount(Pocru12Vo pocru12Vo) {
        //月付比門檻回推每月應攤還本息金額=月付比門檻值*年收入/12
        Double thresholdMonthlyAmountFee = getMonthlyPayment() * 0.01 * getYearIncome() / 12.0;
        thresholdMonthlyAmountFee = (double) (Math.round(thresholdMonthlyAmountFee * 100) / 100.0); //小數點后保留兩位
        pocru12Vo.setThresholdMonthlyAmountFee(thresholdMonthlyAmountFee);

        //平均攤還率={[〖(1+擔保利率/12)〗^360]*擔保利率/12}/{[〖(1+擔保利率/12)〗^360]-1}
        Double guaranteedRate1 = pocru12Vo.getGuaranteedRate() * 0.01;

        Double avgAmortizationRate =
                (power((1 + guaranteedRate1 / 12.0), 360) * guaranteedRate1 / 12.0) / (power((1 + guaranteedRate1 / 12.0), 360) - 1);
        avgAmortizationRate = (double) (Math.round(avgAmortizationRate * 1000000) / 1000000.0); //小數點后保留六位
        pocru12Vo.setAvgAmortizationRate(avgAmortizationRate);

        // 月付比門檻額度=月付比門檻回推每月應攤還本息金額/平均攤還率
        Double thresholdMonthlyAmount = thresholdMonthlyAmountFee / avgAmortizationRate;
        pocru12Vo.setThresholdMonthlyAmount((double) (Math.round(thresholdMonthlyAmount * 100) / 100.0)); //小數點后保留兩位
        return true;
    }


}
