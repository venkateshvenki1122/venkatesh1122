package com.example.demo.direct.config;

import javax.management.Query;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicExchangeConfig {

public static final String EXCHANGE_NAME="tp_awards_exchange";

public static final String QUEUE1 = "award.qu.1";
public static final String QUEUE2 = "award.qu.2";
public static final String QUEUE3 = "award.qu.3";

@Bean
public Queue queue1() {
return new Queue(QUEUE1,false);
}
	@Bean
	public Queue queue2() {
		
		return new Queue(QUEUE2,false);
	}
	
	@Bean
	public Queue queue3() {
		
		return new Queue(QUEUE3,false);
	}


	@Bean
	public TopicExchange topicExchange() {
	
	return new TopicExchange(EXCHANGE_NAME);
	}

	@Bean
	public Binding tpBinding1() {
		
		return BindingBuilder.bind(queue1()).to(topicExchange()).with("*.ece.*");

	}
@Bean
public Binding tpBinding2() {
return BindingBuilder.bind(queue2()).to(topicExchange()).with("*.ece.*");

}@Bean
public Binding tpBinding3() {
return BindingBuilder.bind(queue3()).to(topicExchange()).with("*.cse.*");

}
}