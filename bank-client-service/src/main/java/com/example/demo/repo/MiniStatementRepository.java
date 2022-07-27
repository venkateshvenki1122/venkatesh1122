 package com.example.demo.repo;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.MiniStatement;
@Repository
public interface MiniStatementRepository extends JpaRepository<MiniStatement,Long > {

	@Query(nativeQuery = true,value = "insert into transaction_list {account_number=:accName,transaction=:value} select a.account_number,b.account_number,b.transaction from mini_statement a,transaction_list b innerjoin a.account_number=b.account_number where a.account_number=:accName and b.transaction=:values") 
	int  getMiniStatement(@Param("accName")long accName,@Param("values")long bccName);
	
}
