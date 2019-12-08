package com.devenger.bhaipaisadega.service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.devenger.bhaipaisadega.dto.DashboardResponse;
import com.devenger.bhaipaisadega.model.Loan;
import com.devenger.bhaipaisadega.model.User;
import com.devenger.bhaipaisadega.repository.LoanRepository;
import com.devenger.bhaipaisadega.repository.UserRepository;

@Service
public class LoanService {

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private UserRepository userRepository;

	// public Loan createLoan(LoanRequest request) {
	// Loan loan = loanRepository.save(LoanMapper.mapRequest(request));
	// return loan;
	// }

	public List<Loan> getLoansByUserId(Long userId) {
		List<Loan> loans = loanRepository.findByLoanUserIdOrderByCreatedDateDesc(userId);
		Set<Long> userIds = loans.stream().map(Loan::getLendUserId).collect(Collectors.toSet());
		userIds.add(userId);
		return addUserDetails(loans, userIds);
	}

	private List<Loan> addUserDetails(List<Loan> loans, Set<Long> userIds) {
		Map<Long, User> userMap = userRepository.findAllById(userIds).stream()
				.collect(Collectors.toMap(User::getUserId, Function.identity()));
		for (Loan loan : loans) {
			loan.setLoanUser(userMap.get(loan.getLoanUserId()));
			loan.setLendUser(userMap.get(loan.getLendUserId()));
		}
		return loans;
	}

	public Loan getLoanById(Long loanId) {
		Loan loan = loanRepository.findByLoanId(loanId);
		return addUsers(loan);
	}

	private Loan addUsers(Loan loan) {
		Set<Long> userIds = new HashSet<>();
		userIds.add(loan.getLendUserId());
		userIds.add(loan.getLoanUserId());
		Map<Long, User> userMap = userRepository.findAllById(userIds).stream()
				.collect(Collectors.toMap(User::getUserId, Function.identity()));
		loan.setLoanUser(userMap.get(loan.getLoanUserId()));
		loan.setLendUser(userMap.get(loan.getLendUserId()));
		return loan;
	}

	public DashboardResponse getLoanReportByUserId(Long userId) {
		DashboardResponse response = new DashboardResponse();
		List<Object[]> result = loanRepository.getLoanReport(userId);
		BigDecimal totalLoanAmount = loanRepository.getTotalLoanAmount(userId);
		if (totalLoanAmount != null) {
			response.setTotalLoanAmount(totalLoanAmount);
		}
		if (!CollectionUtils.isEmpty(result)) {
			if (result.get(0)[0] != null && result.get(0)[1] != null) {
				BigDecimal paidAmount = ((BigDecimal) result.get(0)[0]).subtract((BigDecimal) result.get(0)[1]);
				response.setPaidInterest(paidAmount);
				response.setPaidInterest((BigDecimal) result.get(0)[1]);
			}
		}
		return response;
	}
}
