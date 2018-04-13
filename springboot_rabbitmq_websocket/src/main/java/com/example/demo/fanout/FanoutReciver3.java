package com.example.demo.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="fanoutQueue3")
public class FanoutReciver3 {

	@RabbitHandler
	public void read(String user) {
		System.out.println("fanoutQueue3: "+user);
	}
}
