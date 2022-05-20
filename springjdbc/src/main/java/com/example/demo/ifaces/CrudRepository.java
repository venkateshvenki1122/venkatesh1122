package com.example.demo.ifaces;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Product;

public interface CrudRepository<T> {

	public int add(T t);
	public List<T> findAll();
	public Optional<T> findById(int id);
	public int update(T t);
	public int remove(int id);
}
