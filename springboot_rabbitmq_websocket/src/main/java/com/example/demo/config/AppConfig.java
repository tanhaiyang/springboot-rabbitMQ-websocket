package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class AppConfig {
	
	private static String routingKey = "rabbit.msg";
	private static String routingKey2 = "rabbit.msg.others";
	private static String routingKey3 = "rabbit.user.others";

	@Bean
	public Queue helloQueue() {
		return new Queue("hello");
	}
	
	/**
	 * 如果exchange和queue都是持久化的,那么它们之间的binding也是持久化的,如果exchange和queue两者之间有一个持久化，一个非持久化,则不允许建立绑定. 
		注意：一旦创建了队列和交换机,就不能修改其标志了,例如,创建了一个non-durable的队列,然后想把它改变成durable的,唯一的办法就是删除这个队列然后重现创建。
	 * @return
	 */
	@Bean
	public Queue directQueue() {
		return new Queue("direct", false);
	}
	
	@Bean
	public Queue msgQueue2() {
		return new Queue(AppConfig.routingKey2, false);
	}
	
	@Bean
	public Queue userQueue2() {
		return new Queue(AppConfig.routingKey3, false);
	}
	
	@Bean 
	public Queue fanoutQueue1() {
		return new Queue("fanoutQueue1",false);
	}
	@Bean 
	public Queue fanoutQueue2() {
		return new Queue("fanoutQueue2",false);
	}
	@Bean 
	public Queue fanoutQueue3() {
		return new Queue("fanoutQueue3",false);
	}
	
	@Bean
	public DirectExchange directExchange2() {
		return new DirectExchange("directExchange2", false, false);
	}
	
	@Bean
	public TopicExchange topicExchange2() {
		return new TopicExchange("topicExchange3", false, false);
	}
	
	@Bean
	public FanoutExchange fanoutExchange2() {
		return new FanoutExchange("fanoutExchange2", false, false);
	}
	
	@Bean
	public Binding binding() {
		return BindingBuilder.bind(directQueue()).to(directExchange2()).with(routingKey);
	}
	
	@Bean
	public Binding bindMsgQueue2() {
		return BindingBuilder.bind(msgQueue2()).to(topicExchange2()).with("rabbit.msg.others");
	}
	
	@Bean
	public Binding bindUserQueue2() {
		return BindingBuilder.bind(userQueue2()).to(topicExchange2()).with("rabbit.user.others");
	}
	
	@Bean
	public Binding bindFanoutQueue1() {
		return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange2());
	}
	@Bean
	public Binding bindFanoutQueue2() {
		return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange2());
	}
	@Bean
	public Binding bindFanoutQueue3() {
		return BindingBuilder.bind(fanoutQueue3()).to(fanoutExchange2());
	}
	
}
