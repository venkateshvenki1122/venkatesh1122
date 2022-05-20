package com.training.ifaces;

import java.util.*;

import com.training.model.Book;

public interface CrudRepository {

	public boolean add(Book book);
	public Book findByBookId(int id);
	public boolean remove(Book book);
	public List<Book> findAll();
	public Book update(Book oldbook, Book recentBook);
	
}
