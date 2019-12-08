package com.devenger.bhaipaisadega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devenger.bhaipaisadega.model.Loan;
import com.devenger.bhaipaisadega.service.LoanService;

@RestController
@RequestMapping(value = "loan")
public class LoanController {

	@Autowired
	private LoanService loanService;

//	@PostMapping
//	public Loan createLoan(@RequestBody @Valid LoanRequest request) {
//		return loanService.createLoan(request);
//	}

	@GetMapping(value = "user/{userId}")
	public List<Loan> getLoansByUserId(@PathVariable(value = "userId") Long userId) {
		return loanService.getLoansByUserId(userId);
	}

	@GetMapping(value = "{loanId}")
	public Loan getLoanById(@PathVariable(value = "loanId") Long loanId) {
		return loanService.getLoanById(loanId);
	}
}
