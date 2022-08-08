package org.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.example.model.Book;


/**
 * 
 * @author Venkatesh.T
 * @since 2022
 * @version 1.8
 */
public class BookService {

	private Set<Book> bookList;
	
	public Set<Book> getBookList(){
		
		return this.bookList;
		
	}

	public BookService() {
		super();
	this.bookList = new HashSet<Book>();	
	
	}
	
	
	public int addBook(Book book) {
		
	//	return (this.bookList.add(book))?1:0;
		boolean value = this.bookList.add(book);
		int i = 0;
		
		if(value) {
			
			i=1;
		}
		
		return i;
	}
	
	public int removeBook(Book book) {
		
		int i = 0;
		if(this.bookList.contains(book)) {
			
			this.bookList.remove(book);
			i = 1;
		}else {
			
			throw new RuntimeException("Element Not Found");
		}
		return i;
	}
	public List<String> getBestBooks(){
		
		List<String> list = Arrays.asList("FaceBook","PassBook","CookBook","Head First Java");
		
		return list;
	}
	
}
