package com.devenger.bhaipaisadega.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devenger.bhaipaisadega.dto.PaymentRequest;
import com.devenger.bhaipaisadega.mapper.PaymentMapper;
import com.devenger.bhaipaisadega.model.Loan;
import com.devenger.bhaipaisadega.model.Payment;
import com.devenger.bhaipaisadega.repository.LoanRepository;
import com.devenger.bhaipaisadega.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private LoanRepository loanRepository;

	public Payment createPayment(PaymentRequest request) {
		Loan loan = loanRepository.findByLoanId(request.getLoanId());
		BigDecimal interestAmount = loan.getLoanAmount().multiply(loan.getInterestRate())
				.multiply(BigDecimal.valueOf(loan.getTotalEmi()).divide(BigDecimal.valueOf(12)))
				.divide(BigDecimal.valueOf(100));
		loan.setBalanceAmount(loan.getBalanceAmount().subtract(request.getAmount().subtract(interestAmount)));
		loan.setCompletedEmi(loan.getCompletedEmi()+1l);
		loanRepository.save(loan);
		Payment payment = paymentRepository.save(PaymentMapper.mapRequest(request,interestAmount));
		return payment;
	}

	public List<Payment> getPaymentByLoanId(Long loanId) {
		return paymentRepository.findByLoanIdOrderByCreatedAtDesc(loanId);
	}

	public List<Payment> getPaymentByLendId(Long lendId) {
		return paymentRepository.findByLendIdOrderByCreatedAtDesc(lendId);
	}
}
