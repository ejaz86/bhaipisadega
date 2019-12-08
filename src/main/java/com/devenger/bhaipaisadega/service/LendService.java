package com.devenger.bhaipaisadega.service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.devenger.bhaipaisadega.dto.DashboardResponse;
import com.devenger.bhaipaisadega.dto.LendRequest;
import com.devenger.bhaipaisadega.mapper.LendMapper;
import com.devenger.bhaipaisadega.mapper.LoanMapper;
import com.devenger.bhaipaisadega.mapper.PaymentMapper;
import com.devenger.bhaipaisadega.model.Lend;
import com.devenger.bhaipaisadega.model.Loan;
import com.devenger.bhaipaisadega.model.User;
import com.devenger.bhaipaisadega.repository.LendRepository;
import com.devenger.bhaipaisadega.repository.LoanRepository;
import com.devenger.bhaipaisadega.repository.PaymentRepository;
import com.devenger.bhaipaisadega.repository.UserRepository;

@Service
public class LendService {

	@Autowired
	private LendRepository lendRepository;

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private UserRepository userRepository;

	public Lend lendMoney(@Valid LendRequest request) {
		Loan loan = loanRepository.save(LoanMapper.mapLendRequest(request));
		Lend lend = lendRepository.save(LendMapper.mapRequest(request, loan.getLoanId()));
		loan.setLendId(lend.getLendId());
		loan = loanRepository.save(loan);
		paymentRepository.save(PaymentMapper.mapFromLendRequest(request, lend.getLendId()));
		return lend;
	}

	public List<Lend> getLendByUserId(Long userId) {
		List<Lend> lendList = lendRepository.findByLendUserIdOrderByCreatedDateDesc(userId);
		Set<Long> userIds = lendList.stream().map(Lend::getLoanUserId).collect(Collectors.toSet());
		userIds.add(userId);
		return addUserDetails(lendList, userIds);
	}

	private List<Lend> addUserDetails(List<Lend> lendList, Set<Long> userIds) {
		Map<Long, User> userMap = userRepository.findAllById(userIds).stream()
				.collect(Collectors.toMap(User::getUserId, Function.identity()));
		for (Lend lend : lendList) {
			lend.setLoanUser(userMap.get(lend.getLoanUserId()));
			lend.setLendUser(userMap.get(lend.getLendUserId()));
		}
		return lendList;
	}

	public Lend getLendById(Long lendId) {
		Lend lend = lendRepository.findByLendId(lendId);
		return addUsers(lend);
	}

	private Lend addUsers(Lend lend) {
		Set<Long> userIds = new HashSet<>();
		userIds.add(lend.getLendUserId());
		userIds.add(lend.getLoanUserId());
		Map<Long, User> userMap = userRepository.findAllById(userIds).stream()
				.collect(Collectors.toMap(User::getUserId, Function.identity()));
		lend.setLoanUser(userMap.get(lend.getLoanUserId()));
		lend.setLendUser(userMap.get(lend.getLendUserId()));
		return lend;
	}

	public DashboardResponse getLendReportByUserId(Long userId,DashboardResponse response) {
		List<Object[]> result = lendRepository.getLendReport(userId);
		BigDecimal totalLendnAmount = lendRepository.getTotalLendAmount(userId);
		if (totalLendnAmount != null) {
			response.setTotalLendAmount(totalLendnAmount);
		}
		if (!CollectionUtils.isEmpty(result)) {
			if (result.get(0)[0] != null && result.get(0)[1] != null) {
				BigDecimal paidAmount = ((BigDecimal) result.get(0)[0]).subtract((BigDecimal) result.get(0)[1]);
				response.setReceivedAmount(paidAmount);
				response.setTotalProfit((BigDecimal) result.get(0)[1]);
			}
		}
		return response;
	}

}
