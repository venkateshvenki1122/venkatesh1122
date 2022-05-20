package com.example.demo;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Product;
import com.example.demo.repos.ProductRepository;

@SpringBootApplication
public class SpringjdbcApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringjdbcApplication.class, args);
		
		ProductRepository repo = ctx.getBean(ProductRepository.class);
		repo.findAll().forEach(System.out::println);
		
		Product tv = ctx.getBean(Product.class);
//		System.out.println("Row Added :" + repo.add(tv));
//		
		
		//System.out.println(repo.findById(785));
		//System.out.println("updated"+repo.update(tv));
		//System.out.println("Deleted :"+ repo.remove(785));
		
		Optional<Product> optional = repo.findById(254);
		if(optional.isPresent()) {
			System.out.println(optional);
		}else {
			System.out.println("Empty ya iruku");
		}
		
		
		//System.out.println();
	}

	@Bean
	public Product tv() {
		return new Product(202,"panasonic TV",23400);
	}
}
