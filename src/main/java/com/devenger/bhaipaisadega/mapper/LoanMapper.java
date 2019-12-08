package com.devenger.bhaipaisadega.mapper;

import com.devenger.bhaipaisadega.dto.LendRequest;
import com.devenger.bhaipaisadega.dto.LoanRequest;
import com.devenger.bhaipaisadega.model.Loan;

public class LoanMapper {

	public static Loan mapRequest(LoanRequest request) {
		Loan loan = new Loan();
		loan.setInterestRate(request.getInterestRate());
		loan.setTotalEmi(request.getTotalEmi());
		loan.setLoanAmount(request.getLoadAmount());
		loan.setBalanceAmount(request.getLoadAmount());
		loan.setLoanUserId(request.getLoanUserId());
		loan.setLendUserId(request.getLendUserId());
		return loan;
	}

	public static Loan mapLendRequest(LendRequest request) {
		Loan loan = new Loan();
		loan.setInterestRate(request.getInterestRate());
		loan.setTotalEmi(request.getTotalEmi());
		loan.setLoanAmount(request.getLendAmount());
		loan.setBalanceAmount(request.getLendAmount());
		loan.setLoanUserId(request.getLoanUserId());
		loan.setLendUserId(request.getLendUserId());
		return loan;
	}
}
