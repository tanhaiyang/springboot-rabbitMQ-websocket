package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.direct.DirectSender;
import com.example.demo.direct.DirectSender2;
import com.example.demo.fanout.FanoutSender;
import com.example.demo.handler.Sender;
import com.example.demo.topic.TopicSender;

@Controller
public class MessageController {

	@Autowired
	private Sender sender;
	
	@Autowired
	private DirectSender dsender;
	@Autowired
	private DirectSender2 dsender2;
	@Autowired
	private TopicSender tsender;
	@Autowired
	private  FanoutSender fsender;
	
	@GetMapping(path="/send")
	public void senderMsg() {
		dsender.sendDirect();
		dsender2.sendDirect();
	}
	
	@GetMapping(path="/sendTopic")
	public void sendTopic() {
		tsender.send();
	}
	
	@GetMapping(path="/sendfanout")
	public void sendfanout() {
		fsender.send();
	}
}
