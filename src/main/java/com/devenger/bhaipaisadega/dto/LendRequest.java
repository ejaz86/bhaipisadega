package com.devenger.bhaipaisadega.dto;

import java.math.BigDecimal;

import com.devenger.bhaipaisadega.model.enums.PaymentChannel;

public class LendRequest {

	private Long lendUserId;
	private BigDecimal lendAmount;
	private Long loanUserId;
	private BigDecimal interestRate;
	private Long totalEmi;
	private PaymentChannel paymentChannel;
	private String transactionReferenceId;

	public Long getLendUserId() {
		return lendUserId;
	}

	public void setLendUserId(Long lendUserId) {
		this.lendUserId = lendUserId;
	}

	public Long getLoanUserId() {
		return loanUserId;
	}

	public void setLoanUserId(Long loanUserId) {
		this.loanUserId = loanUserId;
	}

	public BigDecimal getLendAmount() {
		return lendAmount;
	}

	public void setLendAmount(BigDecimal lendAmount) {
		this.lendAmount = lendAmount;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	public Long getTotalEmi() {
		return totalEmi;
	}

	public void setTotalEmi(Long totalEmi) {
		this.totalEmi = totalEmi;
	}

	public PaymentChannel getPaymentChannel() {
		return paymentChannel;
	}

	public void setPaymentChannel(PaymentChannel paymentChannel) {
		this.paymentChannel = paymentChannel;
	}

	public String getTransactionReferenceId() {
		return transactionReferenceId;
	}

	public void setTransactionReferenceId(String transactionReferenceId) {
		this.transactionReferenceId = transactionReferenceId;
	}
}
