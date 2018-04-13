package com.example.demo.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="rabbit.user.others")
public class TopicRecive2 {

	@RabbitHandler
	public void process(String user) throws InterruptedException {
		System.out.println("TopicRecive2接受的消息： "+user);
	}
}
