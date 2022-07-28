package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class BankClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankClientServiceApplication.class, args);
	}

//	@Bean
//	private Map<Long, List<Double>> miniScript;
//	
	
	
}
