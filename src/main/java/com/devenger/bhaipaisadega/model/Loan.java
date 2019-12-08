package com.devenger.bhaipaisadega.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.devenger.bhaipaisadega.model.enums.Status;

@Entity
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loanId;
	private Long loanUserId;
	private BigDecimal loanAmount;
	private BigDecimal balanceAmount;
	private Long totalEmi;
	private Long completedEmi = 0L;
	private LocalDate nextEmiDate;
	private Long lendUserId;
	private Long lendId;
	private BigDecimal interestRate;
	private LocalDate createdDate;
	@Enumerated(EnumType.STRING)
	private Status status = Status.ACTIVE;
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Transient
	private User lendUser;

	@Transient
	private User loanUser;

	@PrePersist
	public void prePersist() {
		this.createdDate = LocalDate.now();
		this.nextEmiDate = LocalDate.now().plusMonths(1);
	}

	public User getLendUser() {
		return lendUser;
	}

	public void setLendUser(User lendUser) {
		this.lendUser = lendUser;
	}

	public User getLoanUser() {
		return loanUser;
	}

	public void setLoanUser(User loanUser) {
		this.loanUser = loanUser;
	}

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loadAmount) {
		this.loanAmount = loadAmount;
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
		if(completedEmi == this.totalEmi) {
			this.status = Status.COMPLETED;
		}
		this.completedEmi = completedEmi;
	}

	public LocalDate getNextEmiDate() {
		return nextEmiDate;
	}

	public void setNextEmiDate(LocalDate nextEmiDate) {
		this.nextEmiDate = nextEmiDate;
	}

	public Long getLoanUserId() {
		return loanUserId;
	}

	public void setLoanUserId(Long loanUserId) {
		this.loanUserId = loanUserId;
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

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

}
