package com.comwave.rulepoc.vo;

public class Pocru15Vo {

	private String customerDiversion; // 客戶分流
	private String blacklistLabel; // 黑名單標籤
	private Double thresholdDBRAmount = 0.0; // DBR門檻額度
	private Double noDebtAmount = 0.0; // 聯徵無擔負債
	private Double thresholdMonthlyAmount = 0.0; // 月付比門檻額度
	private Double loanApplicationAmount = 0.0; // 申貸金額

	private String ruleId; // 規則ID
	private String ruleName; // 規則描述
	private String resultLevel; // ResultLevel
	private String devCode; // Dev_code

	private java.lang.String sourceCode;

	public Pocru15Vo() {
	}

	public Pocru15Vo(String customerDiversion, String blacklistLabel,
			Double thresholdDBRAmount, Double noDebtAmount,
			Double thresholdMonthlyAmount, Double loanApplicationAmount) {
		this.customerDiversion = customerDiversion;
		this.blacklistLabel = blacklistLabel;
		this.thresholdDBRAmount = thresholdDBRAmount;
		this.noDebtAmount = noDebtAmount;
		this.thresholdMonthlyAmount = thresholdMonthlyAmount;
		this.loanApplicationAmount = loanApplicationAmount;
	}

	public String getCustomerDiversion() {
		return customerDiversion;
	}

	public void setCustomerDiversion(String customerDiversion) {
		this.customerDiversion = customerDiversion;
	}

	public String getBlacklistLabel() {
		return blacklistLabel;
	}

	public void setBlacklistLabel(String blacklistLabel) {
		this.blacklistLabel = blacklistLabel;
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

	public Double getLoanApplicationAmount() {
		return loanApplicationAmount;
	}

	public void setLoanApplicationAmount(Double loanApplicationAmount) {
		this.loanApplicationAmount = loanApplicationAmount;
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

	public String getResultLevel() {
		return resultLevel;
	}

	public void setResultLevel(String resultLevel) {
		this.resultLevel = resultLevel;
	}

	public String getDevCode() {
		return devCode;
	}

	public void setDevCode(String devCode) {
		this.devCode = devCode;
	}

	public boolean obtainResultLevel(String str) {
		if (resultLevel == null) {
			resultLevel = str;
		} else if (resultLevel.contains(str)) {
			return true;
		} else {
			resultLevel = resultLevel.concat(",").concat(str);
		}
		return true;
	}

	public boolean obtainDevCode(String str) {
		if (devCode == null) {
			devCode = str;
		} else if (devCode.contains(str)) {
			return true;
		} else {
			devCode = devCode.concat(",").concat(str);
		}
		return true;
	}

	public java.lang.String getSourceCode() {
		return this.sourceCode;
	}

	public void setSourceCode(java.lang.String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public Pocru15Vo(java.lang.String customerDiversion,
			java.lang.String blacklistLabel,
			java.lang.Double thresholdDBRAmount, java.lang.Double noDebtAmount,
			java.lang.Double thresholdMonthlyAmount,
			java.lang.Double loanApplicationAmount, java.lang.String ruleId,
			java.lang.String ruleName, java.lang.String resultLevel,
			java.lang.String devCode, java.lang.String sourceCode) {
		this.customerDiversion = customerDiversion;
		this.blacklistLabel = blacklistLabel;
		this.thresholdDBRAmount = thresholdDBRAmount;
		this.noDebtAmount = noDebtAmount;
		this.thresholdMonthlyAmount = thresholdMonthlyAmount;
		this.loanApplicationAmount = loanApplicationAmount;
		this.ruleId = ruleId;
		this.ruleName = ruleName;
		this.resultLevel = resultLevel;
		this.devCode = devCode;
		this.sourceCode = sourceCode;
	}
}
