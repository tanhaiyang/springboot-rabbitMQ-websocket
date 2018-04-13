package com.example.demo.websocket;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

@ServerEndpoint(value="/webSocket")
@Component
public class WebSocketServer {

	private Session session;
	public static CopyOnWriteArraySet<WebSocketServer> webSockets = new CopyOnWriteArraySet<WebSocketServer>();
	
	@OnOpen
	public void onOpen(Session session) throws InterruptedException {
		this.session = session;
		webSockets.add(this);
		this.send("新用户加入");
//		for(int i=0;i<100;i++) {
//			Thread.sleep(1000);
//			this.send("服务端推送："+i);
//		}
	}
	@OnClose
	public void onClose(Session s) {
		webSockets.remove(this);
		this.send("有用户离开");
	}
	@OnMessage
	public void onMessage(String msg) throws InterruptedException {
		System.out.println("从客服端接受的消息： "+msg);
	}
	
	public void send(String msg) {
		try {
			this.session.getBasicRemote().sendText(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
