package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.direct.DirectSender;
import com.example.demo.handler.Sender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {
	
	@Autowired
	private Sender sender;
	
	@Autowired
	private DirectSender dsender;

	@Test
	public void send() {
		sender.send();
	}
	
	@Test
	public void sendDirect() {
		dsender.sendDirect();
	}

}
