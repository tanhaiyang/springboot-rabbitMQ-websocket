package com.example.demo.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="rabbit.msg.others")
public class TopicRecive1 {

	@RabbitHandler
	public void process(String user) throws InterruptedException {
		System.out.println("TopicRecive1接受的消息： "+user);
	}
}
