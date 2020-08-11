package com.comwave.rulepoc.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Pocru08Vo {

    private String applyDate;    //進件日期
    private String discountStartDate;    //優惠起日
    private String discountEndDate;    //優惠迄日
    private Double discountAccountFee = 0.0;  //優惠帳管費
    private Double basicAccountFee = 0.0;  //基礎帳管費

    private String ruleId;  //規則ID
    private String ruleName;    //規則描述
    private Double accountFee;    //帳管費

    public Pocru08Vo() {
    }

    public Pocru08Vo(String applyDate, String discountStartDate, String discountEndDate, Double discountAccountFee, Double basicAccountFee) {
        this.applyDate = applyDate;
        this.discountStartDate = discountStartDate;
        this.discountEndDate = discountEndDate;
        this.discountAccountFee = discountAccountFee;
        this.basicAccountFee = basicAccountFee;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
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

    public Double getDiscountAccountFee() {
        return discountAccountFee;
    }

    public void setDiscountAccountFee(Double discountAccountFee) {
        this.discountAccountFee = discountAccountFee;
    }

    public Double getBasicAccountFee() {
        return basicAccountFee;
    }

    public void setBasicAccountFee(Double basicAccountFee) {
        this.basicAccountFee = basicAccountFee;
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

    public Double getAccountFee() {
        return accountFee;
    }

    public void setAccountFee(Double accountFee) {
        this.accountFee = accountFee;
    }

    public boolean obtainAccountFee(Pocru08Vo pocru08Vo, Double d) {
        pocru08Vo.setAccountFee((double) (Math.round(d * 100) / 100.0));    //額度小數點后保留兩位
        return true;
    }

    /**
     * endDate-startDate
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static String timeInterval(String startDate, String endDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // 創建日期格式
        Calendar c1 = Calendar.getInstance(); // 創建日期對象
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(sdf.parse(startDate));
            c2.setTime(sdf.parse(endDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int years = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR); // 計算年度差
        int month = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);// 計算月度差
        int day = c2.get(Calendar.DAY_OF_MONTH) - c1.get(Calendar.DAY_OF_MONTH);// 計算日數差
        int result = 0;
        if (month < 0) { // 月度差小於0
            result = years - 1;
        }
        if (month == 0) { // 月度差等於0
            if (day < 0) { // 日數差小於0
                result = years - 1;
            }
            if (day >= 0) { // 日數差大於等於0
                result = years;
            }
        }
        if (month > 0) { // 月度差大於0
            result = years;
        }

        String falgs = result >= 0 ? "true" : "false";
        return falgs;  //考慮到日
    }

    /**
     * 判斷優惠起日’小於等於‘當進件日期
     *
     * @param pocru08Vo
     * @return
     */
    public boolean obtainDiscountStartDate(Pocru08Vo pocru08Vo) {
        boolean falgs = (timeInterval(pocru08Vo.getDiscountStartDate(), pocru08Vo.getApplyDate()) == "true") ? true : false;
        return falgs;
    }

    /**
     * 判斷當進件日期’小於等於‘優惠迄日’
     *
     * @param pocru08Vo
     * @return
     */
    public boolean obtainDiscountEndDate(Pocru08Vo pocru08Vo) {
        boolean falgs = (timeInterval(pocru08Vo.getApplyDate(), pocru08Vo.getDiscountEndDate()) == "true") ? true : false;
        return falgs;
    }


}
