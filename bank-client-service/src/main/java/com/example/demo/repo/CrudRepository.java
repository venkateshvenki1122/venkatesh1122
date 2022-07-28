package com.example.demo.repo;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.entity.MiniScript;

public interface CrudRepository {

	public void setMiniScript (long accountNumber,double amount,String type,LocalDateTime dateTime);
	public List<MiniScript> getMiniScript(long accountNumber);
}
