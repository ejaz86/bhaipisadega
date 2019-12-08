package com.devenger.bhaipaisadega.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devenger.bhaipaisadega.model.Lend;

@Repository
public interface LendRepository extends JpaRepository<Lend, Long> {

	List<Lend> findByLendUserIdOrderByCreatedDateDesc(Long userId);

	Lend findByLendId(Long lendId);
	
	@Query(value="SELECT SUM(p.amount),SUM(p.interest_amount) FROM lend l, payment p WHERE l.loan_id=p.loan_id AND l.loan_user_id = ?1",nativeQuery=true)
	List<Object[]> getLendReport(Long userId);

	@Query(value="SELECT SUM(l.lend_amount) FROM lend l where l.lend_user_id = ?1",nativeQuery=true)
	BigDecimal getTotalLendAmount(Long userId);

}
