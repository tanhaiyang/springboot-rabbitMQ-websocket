package com.example.demo.fanout;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;

@Component
public class FanoutSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void send() {
		this.rabbitTemplate.convertAndSend("fanoutExchange2", "", new User(1,"sfsa111",23).toString());
		System.out.println("fanout send msg");
	}
}
