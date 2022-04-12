package com.training.service;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;
import com.training.model.*;

import com.training.ifaces.CrudRepository;
import com.training.model.Book;

public class BookService implements CrudRepository {
	 private ArrayList<Book> bookList;
	 
	  public BookService() {
		 super();
		 this.bookList = new ArrayList<>();
		 
		 // TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(Book book) {
		// TODO Auto-generated method stub
		return bookList.add(book);
	}

	@Override
	public Book findByBookId(int id) {
		// TODO Auto-generated method stub
		Book found = null;
		for(Book eachBook:this.bookList)
		{
			if(eachBook.getBookNumber()==id)
			{
				found= eachBook;
			}
		}
		return found;
	}

	@Override
	public boolean remove(Book book) {
		// TODO Auto-generated method stub
		return bookList.remove(book);
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return this.bookList;
	}

	@Override
	public Book update(Book oldbook , Book newBook) {

		if(this.bookList.contains(oldbook)) {
			//System.out.println("******************* Inside IF BLOCK *********************");
			
			int idxpos = this.bookList.indexOf(oldbook);
			this.bookList.set(idxpos, newBook);
		}
		
		return newBook;
	}

	
	
}
