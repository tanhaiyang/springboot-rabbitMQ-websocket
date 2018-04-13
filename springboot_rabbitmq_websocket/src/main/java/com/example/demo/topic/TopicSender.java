package com.example.demo.topic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;

@Component
public class TopicSender {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send() {
		rabbitTemplate.convertAndSend("topicExchange3", "rabbit.msg.others", new User(1,"sfsa3333",23).toString());
		rabbitTemplate.convertAndSend("topicExchange3", "rabbit.user.others", new User(2,"sfsa2222",22).toString());
	}
	
}
