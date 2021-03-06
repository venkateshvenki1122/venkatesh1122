package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

import com.training.model.Author;
import com.training.model.Book;

@SpringBootApplication
@ComponentScan(basePackages = {"com.training","com.example"})
public class SpringdemoApplication {

	public static void trial() {
		
//		ApplicationContext ctx=SpringApplication.run(SpringdemoApplication.class, args);
//		//When using Id need to cast to specific Bean since
//				//return type of getBean Method is Object
//				Student ram = (Student) ctx.getBean("ram");
//				
//				//casting not required , but there should be only one bean of that type
//				// will throw Exception
//				Student shyam = ctx.getBean(Student.class);
//				
//				//When more than one Bean of the same Type available 
//				//should use id and class name
//				Student stellas = ctx.getBean("stella",Student.class);
//				
//				System.out.println(ctx.getBean("venki"));
//				System.out.println(ctx.getBean("harish"));
//				
//				Teacher stella = (Teacher) ctx.getBean("teacher");
//				
//				stella.setId(102);
//				stella.setName("Thamo");
//				stella.setSubject("Maths");
//				System.out.println(stella);
//				

	}
	
	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringdemoApplication.class, args);
		
		Invoice inv = ctx.getBean(Invoice.class);
		System.out.println("**********************");
		System.out.println(ctx.getBean(Book.class));
		System.out.println("*****************************");
		
		System.out.println(ctx.getBean("harish"));
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(ctx.getBean("hari",Author.class));
		
		System.out.println(inv);
		
		Bill bill = ctx.getBean(Bill.class);
		
		System.out.println("Customer :=" + bill.getCustomer());
		System.out.println("Products :=" + bill.getProduct());
		
		CustomerList list=ctx.getBean(CustomerList.class);
		
		list.getCustList().forEach(System.out::println);
		
			}
	@Bean
	public Author hari() {
		
		return new Author(101,"Harish Kumar");
	}
	
	@Bean
	@Primary
	public Author mani() {
		 return new Author (102,"Mani");
	}

}
