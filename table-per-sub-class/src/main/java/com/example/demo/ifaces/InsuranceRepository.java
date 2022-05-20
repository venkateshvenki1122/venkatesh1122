package com.example.demo.ifaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.HealthInsurance;
import com.example.demo.entity.Insurance;

public interface InsuranceRepository<T extends Insurance> extends JpaRepository<T, Integer> {

	
	@Query(nativeQuery =true,value= "select * from venki_healthinsurance")
	public List<Insurance> findHealthProducts();
}
