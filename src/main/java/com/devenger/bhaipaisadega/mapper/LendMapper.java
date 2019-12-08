package com.devenger.bhaipaisadega.mapper;

import com.devenger.bhaipaisadega.dto.LendRequest;
import com.devenger.bhaipaisadega.model.Lend;

public class LendMapper {

	public static Lend mapRequest(LendRequest request, Long loanId) {
		Lend lend = new Lend();
		lend.setInterestRate(request.getInterestRate());
		lend.setLendAmount(request.getLendAmount());
		lend.setLendUserId(request.getLendUserId());
		lend.setLoanUserId(request.getLoanUserId());
		lend.setLoanId(loanId);
		return lend;
	}
}
