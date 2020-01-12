package com.example.demo.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

@Service
public class RabbitMQService {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${employee.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${employee.rabbitmq.routingkey}")
	private String routingkey;	
	
	public void send(Employee company) {
		amqpTemplate.convertAndSend(exchange, routingkey, company);
		System.out.println("Send msg = " + company);
	}
}
