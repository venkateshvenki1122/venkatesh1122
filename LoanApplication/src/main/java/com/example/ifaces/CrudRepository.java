package com.example.ifaces;

import java.util.List;

public interface CrudRepository<T> {

	public int add(T obj);
	public List<T> findAll();
	public int remove (int id);
	public T findById(int id);
	public int update(int id,T customer);
	
	
	
}
