package com.devenger.bhaipaisadega.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devenger.bhaipaisadega.model.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

	List<Loan> findByLoanUserIdOrderByCreatedDateDesc(Long userId);

	Loan findByLoanId(Long loanId);

	@Query(value="SELECT SUM(p.amount),SUM(p.interest_amount) FROM loan l, payment p WHERE l.loan_id=p.loan_id AND l.loan_user_id = ?1",nativeQuery=true)
	List<Object[]> getLoanReport(Long userId);

	@Query(value="SELECT SUM(l.loan_amount) FROM loan l where l.loan_user_id = ?1",nativeQuery=true)
	BigDecimal getTotalLoanAmount(Long userId);
}
