package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MiniStatement;
import com.example.demo.repo.AccountHolderRepository;
import com.example.demo.repo.MiniStatementRepository;

@Service
public class MiniStatementService {

	@Autowired
	private AccountHolderService service;
	
	
	
}
