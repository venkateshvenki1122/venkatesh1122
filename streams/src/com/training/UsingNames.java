package com.training;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import com.training.model.*;


public class UsingNames {

	public static void useDistinct(List<Book> bookList) {
		
		bookList.stream().distinct().forEach(System.out::println);
		
	}	
	
	
	public static void collectToSet(List<Book> bookList) {
		
		Set<Book> bookSet = bookList.stream()
				.filter(e->e.getPrice()>500)
				.collect(toSet());

		bookSet.forEach(System.out::println);
		
	}
	
	public static void collectToMap(List<Book> bookList) {
		
		//Set<Book> bookSet = bookList.stream().collect(toSet());
		
		Map<String, Double> values = bookList.stream().distinct()
				.filter(e->e.getPrice()>500)
				.collect(toMap(Book::getBookName, Book::getPrice));
		
		values.forEach((key,value)->System.out.println(key+","+value));
	}

	public static void findMaxPrice(List<Book> bookList) {
		
		Optional<Book> optional = bookList.stream()
				.max(Comparator.comparing(Book::getPrice));
		
		if(optional.isPresent()) {
			
			System.out.println("Maximum Price:="+optional.get().getPrice());
		}
	}
	
	public static void findMinPrice(List<Book> bookList) {
		Optional<Book> optional1 = bookList.stream()
				.min(Comparator.comparing(Book::getPrice));
		
		if(optional1.isPresent()) {
			System.out.println("Minimum Price:="+optional1.get().getPrice());
		}
		
	}
	
	public static void countBook(List<Book> bookList,String str) {
		
		long optional2	= bookList.stream()
				.filter(e->e.getBookName()
						.contains(str)).distinct().count();
		System.out.println(optional2);
		
	}
	
	public static void main(String[] args) {
	
		
		Book java = new Book(100, "Java", "Subha", 450);
		Book Spring = new Book(102, "Spring", "Venki", 650);
		Book maven = new Book(103,"Maven","Kawin",550);
		Book html = new Book(104,"Html","Prawin",1450);
		Book python = new Book(105,"Python","Thamo",1500);
		Book mavenNew = new Book(103,"Maven","Kawin",550);
		Book htmlNew = new Book(104,"Html","Prawin",1450);
		
		List<Book> bookList = Arrays.asList(java,Spring,maven,html,python,mavenNew,htmlNew);
		
		//useDistinct(bookList);
		//collectToSet(bookList);
		//collectToMap(bookList);
		//findMaxPrice(bookList);
		//findMinPrice(bookList);
		countBook(bookList,"S");
		
		
		
	}
	}