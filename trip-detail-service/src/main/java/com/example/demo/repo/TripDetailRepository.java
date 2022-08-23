package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TripDetail;

@Repository
public interface TripDetailRepository extends JpaRepository<TripDetail, Integer> {

	List<TripDetail> findByDriverId(int id);
	
	
}
