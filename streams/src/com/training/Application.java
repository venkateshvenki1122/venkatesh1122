package com.training;

import java.util.List;

import com.training.ifaces.CrudRepository;
import com.training.model.Book;
import com.training.service.BookService;

public class Application {
	
	public static void print( List<Book> args) {
		
		for(Book list1:args) {
		System.out.println(list1);
			
		}

	}

	public static final void main(String[] args) {
		// TODO Auto-generated method stub

		Book java = new Book(100, "Java", "Subha", 450);
		Book Spring = new Book(102, "Spring", "Venki", 650);
		Book maven = new Book(103,"Maven","Kawin",550);
		Book html = new Book(104,"Html","Prawin",1450);
		Book python = new Book(105,"Python","Thamo",1500);
		
		CrudRepository service = new BookService();
		
		
		
		
		System.out.println("Added :" +service.add(java));
		System.out.println(service.add(Spring));
		System.out.println(service.add(maven));
		System.out.println(service.add(html));
		System.out.println(service.add(python));
		//List<Book> bookList = service.findAll();
		
		//for(Book list:bookList) {
			//System.out.println(list);
		//}
		System.out.println("+++++++++++++++++++++++++++++++++");
		List<String> nameList = ((BookService)service).getBookNames();
		nameList.forEach(System.out::println);
		System.out.println("++++++++++++++++++++++++++++");
		
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		List<String> grtThanNineHundred = ((BookService)service).getBookNameGrtThanPrice(100);
		grtThanNineHundred.forEach(System.out::println);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		List<Book> sortedByName = ((BookService)service).sortedByBookNames();
		
		sortedByName.forEach(System.out::println);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		List<Book> sortedByNumber = ((BookService)service).sortedByNumberDesc();
		sortedByNumber.forEach(System.out::println);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		
		
		Book foundBook = service.findByBookId(102);
		System.out.println("____________");
		System.out.println(foundBook);
		System.out.println("____________");
		//BookService service1 = new BookService();
		
		//System.out.println(service1.findByBookId(100));
		service.remove(python);
		System.out.println(service.findAll().size());
		List<Book> bookList1 = service.findAll();
		print(service.findAll());
		
//		for(Book list1:bookList1) {
//			System.out.println(list1);
//			
//		}
//		
		Book react = new Book(105,"ReactJS","Venki",6500);
		service.update(react,react);
		print(service.findAll());
		
		//service.update(react, recentBook);
		
		
		Book reactNew = new Book(105,"ReactJS","Venki",6500);
		service.update(react,reactNew);
		
		System.out.println("********* After Update ***********");
		print(service.findAll());
		//service.update(react,reactNew);
		List<Book> bookList = ((BookService)service).getBooksGrtThan(350);

		System.out.println("************************");
		bookList.forEach(System.out::println);
		System.out.println("**************************");
	
		System.out.println("_______________________________________________________");
		System.out.println("Using Streams");
		((BookService)service).findBooksGrtThan(100).forEach(System.out::println);
		System.out.println("****************************************");
		
		
	}

}
