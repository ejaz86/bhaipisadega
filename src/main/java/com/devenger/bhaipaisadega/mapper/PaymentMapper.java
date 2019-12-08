package com.devenger.bhaipaisadega.mapper;

import java.math.BigDecimal;

import javax.validation.Valid;

import com.devenger.bhaipaisadega.dto.LendRequest;
import com.devenger.bhaipaisadega.dto.PaymentRequest;
import com.devenger.bhaipaisadega.model.Payment;

public class PaymentMapper {

	public static Payment mapRequest(PaymentRequest request,BigDecimal interestAmount) {
		Payment payment = new Payment();
		payment.setAmount(request.getAmount());
		payment.setFromUserId(request.getFromUserId());
		payment.setLendId(request.getLendId());
		payment.setLoanId(request.getLoanId());
		payment.setPaymentChannel(request.getPaymentChannel());
		payment.setToUserId(request.getToUserId());
		payment.setInterestAmount(interestAmount);
		payment.setTransactionReferenceId(request.getTransactionReferenceId());
		return payment;
	}

	public static Payment mapFromLendRequest(@Valid LendRequest request, Long lendId) {
		Payment payment = new Payment();
		payment.setAmount(request.getLendAmount());
		payment.setFromUserId(request.getLendUserId());
		payment.setLendId(lendId);
		payment.setPaymentChannel(request.getPaymentChannel());
		payment.setToUserId(request.getLoanUserId());
		payment.setTransactionReferenceId(request.getTransactionReferenceId());
		return payment;
	}
}
