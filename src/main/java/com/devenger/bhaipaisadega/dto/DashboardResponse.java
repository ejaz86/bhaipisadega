package com.devenger.bhaipaisadega.dto;

import java.math.BigDecimal;

public class DashboardResponse {

	private BigDecimal totalLoanAmount = BigDecimal.ZERO;
	private BigDecimal paidAmount = BigDecimal.ZERO;
	private BigDecimal paidInterest = BigDecimal.ZERO;
	private BigDecimal totalLendAmount = BigDecimal.ZERO;
	private BigDecimal receivedAmount = BigDecimal.ZERO;
	private BigDecimal totalProfit = BigDecimal.ZERO;

	public BigDecimal getTotalLoanAmount() {
		return totalLoanAmount;
	}

	public void setTotalLoanAmount(BigDecimal totalLoanAmount) {
		this.totalLoanAmount = totalLoanAmount;
	}

	public BigDecimal getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(BigDecimal paidAmount) {
		this.paidAmount = paidAmount;
	}

	public BigDecimal getPaidInterest() {
		return paidInterest;
	}

	public void setPaidInterest(BigDecimal paidInterest) {
		this.paidInterest = paidInterest;
	}

	public BigDecimal getTotalLendAmount() {
		return totalLendAmount;
	}

	public void setTotalLendAmount(BigDecimal totalLendAmount) {
		this.totalLendAmount = totalLendAmount;
	}

	public BigDecimal getReceivedAmount() {
		return receivedAmount;
	}

	public void setReceivedAmount(BigDecimal receivedAmount) {
		this.receivedAmount = receivedAmount;
	}

	public BigDecimal getTotalProfit() {
		return totalProfit;
	}

	public void setTotalProfit(BigDecimal totalProfit) {
		this.totalProfit = totalProfit;
	}

}
