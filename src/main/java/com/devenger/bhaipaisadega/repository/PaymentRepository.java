package com.devenger.bhaipaisadega.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devenger.bhaipaisadega.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

	List<Payment> findByLoanIdOrderByCreatedAtDesc(Long loanId);

	List<Payment> findByLendIdOrderByCreatedAtDesc(Long lendId);

}
