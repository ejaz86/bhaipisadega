package com.devenger.bhaipaisadega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devenger.bhaipaisadega.dto.PaymentRequest;
import com.devenger.bhaipaisadega.model.Payment;
import com.devenger.bhaipaisadega.service.PaymentService;

@RestController
@RequestMapping(value = "payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@GetMapping(value = "loan/{loanId}")
	public List<Payment> getLoanPayments(@PathVariable(value = "loanId") Long loanId) {
		return paymentService.getPaymentByLoanId(loanId);
	}

	@GetMapping(value = "lend/{lendId}")
	public List<Payment> getLendPayments(@PathVariable(value = "lendId") Long lendId) {
		return paymentService.getPaymentByLendId(lendId);
	}
	
	@PostMapping
	public Payment createPayment(@RequestBody PaymentRequest request) {
		return paymentService.createPayment(request);
	}
}
