package com.devenger.bhaipaisadega.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class LoanRequest {

	@NotNull
	private Long loanUserId;
	@NotNull
	private BigDecimal loadAmount;
	private BigDecimal balanceAmount;
	@NotNull
	private Long totalEmi;
	private Long completedEmi;
	private LocalDate nextEmiDate;
	@NotNull
	private Long lendUserId;
	private Long lendId;
	@NotNull
	private BigDecimal interestRate;

	public Long getLoanUserId() {
		return loanUserId;
	}

	public void setLoanUserId(Long loanUserId) {
		this.loanUserId = loanUserId;
	}

	public BigDecimal getLoadAmount() {
		return loadAmount;
	}

	public void setLoadAmount(BigDecimal loadAmount) {
		this.loadAmount = loadAmount;
	}

	public BigDecimal getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(BigDecimal balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public Long getTotalEmi() {
		return totalEmi;
	}

	public void setTotalEmi(Long totalEmi) {
		this.totalEmi = totalEmi;
	}

	public Long getCompletedEmi() {
		return completedEmi;
	}

	public void setCompletedEmi(Long completedEmi) {
		this.completedEmi = completedEmi;
	}

	public LocalDate getNextEmiDate() {
		return nextEmiDate;
	}

	public void setNextEmiDate(LocalDate nextEmiDate) {
		this.nextEmiDate = nextEmiDate;
	}

	public Long getLendUserId() {
		return lendUserId;
	}

	public void setLendUserId(Long lendUserId) {
		this.lendUserId = lendUserId;
	}

	public Long getLendId() {
		return lendId;
	}

	public void setLendId(Long lendId) {
		this.lendId = lendId;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}
}
