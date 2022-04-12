package com.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.training.ifaces.CrudRepository;
import com.training.model.Book;
import com.training.service.BookService;
import com.training.utils.BookNameComparator;

public class App {
	
public static void print( List<Book> args) {
		
		for(Book list1:args) {
		System.out.println(list1);
			
		}

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> names = new ArrayList<>();
		
		names.add("Sathya");
		names.add("Venki");
		names.add("Aruna");
		names.add("Thamo");
		names.add("Guru");
		
		System.out.println("Names :" + names);
		Collections.sort(names);
		System.out.println("Sorted Names are :"+ names);
		
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
		
		List<Book> bookList = service.findAll();
		
		Collections.sort(bookList);
		System.out.println(bookList);
		System.out.println("****************************************");
		BookNameComparator book = new BookNameComparator();
		Collections.sort(bookList,book);
		print(bookList);
		
		
	}

}
