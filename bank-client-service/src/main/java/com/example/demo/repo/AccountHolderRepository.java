package com.example.demo.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AccountHolder;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {

	AccountHolder findByAccountNumber(long accountNumber);
	
	
	@Query(nativeQuery=true,value = "update bank_client_details set balance=:amount where account_number=:accountNumber2")
	
	
	Object  balanceAfterTransfer(@Param("amount") double amount,@Param("accountNumber1") long accountNumber1,@Param("accountNumber2") long accountNumber2);
	
}
