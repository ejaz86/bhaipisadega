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
public class Lend {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lendId;
	private Long lendUserId;
	private BigDecimal lendAmount;
	private Long loanUserId;
	private Long loanId;
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
	@PrePersist
	public void prePersist() {
		this.createdDate = LocalDate.now();
	}

	@Transient
	private User lendUser;

	@Transient
	private User loanUser;

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

	public Long getLendId() {
		return lendId;
	}

	public void setLendId(Long lendId) {
		this.lendId = lendId;
	}

	public BigDecimal getLendAmount() {
		return lendAmount;
	}

	public void setLendAmount(BigDecimal lendAmount) {
		this.lendAmount = lendAmount;
	}

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

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
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

	public void setCreatedDate(LocalDate createAt) {
		this.createdDate = createAt;
	}

}
