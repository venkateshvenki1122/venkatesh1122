package com.example.demo.repo;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.MiniStatement;
@Repository
public interface MiniStatementRepository extends JpaRepository<MiniStatement,Long > {

}
