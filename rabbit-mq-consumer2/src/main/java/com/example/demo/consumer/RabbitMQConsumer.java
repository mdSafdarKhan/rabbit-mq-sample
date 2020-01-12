package com.example.demo.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

	@RabbitListener(queues = "${employee.rabbitmq.queue}")
	public void recievedMessage(Message message) {
		System.out.println("Recieved Message From RabbitMQ: " + new String(message.getBody()));
	}
}