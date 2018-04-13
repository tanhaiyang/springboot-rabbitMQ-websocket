package com.example.demo.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="fanoutQueue2")
public class FanoutReciver2 {

	@RabbitHandler
	public void read(String user) {
		System.out.println("fanoutQueue2: "+user);
	}
}
