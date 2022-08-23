package com.example.demo.direct.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;





@Configuration
public class FanOutExchange {

	
	public static final String QUEUE_NAME1 = "student.queue1";
	public static final String QUEUE_NAME2 = "student.queue2";
	public static final String EXCHANGE = "	fanout_exchange";

	@Bean
	public Queue fanOutQueue1() {
		
		return new Queue(QUEUE_NAME1,false);
	}
	
	@Bean
	public Queue fanOutQueue2() {
		
		return new Queue(QUEUE_NAME2,false);
	}
	
	@Bean
	public FanoutExchange fanOut() {
		
		return new FanoutExchange(EXCHANGE);
	}
	
	@Bean
	public Binding binding1(FanoutExchange fanOut,@Qualifier("fanOutQueue1") Queue fanOutQueue1) {
		
		return BindingBuilder.bind(fanOutQueue1).to(fanOut);
	}
	
	@Bean
	public Binding binding2(FanoutExchange fanOut,@Qualifier("fanOutQueue2") Queue fanOutQueue2) {
		
		return BindingBuilder.bind(fanOutQueue2).to(fanOut);
	}
}
