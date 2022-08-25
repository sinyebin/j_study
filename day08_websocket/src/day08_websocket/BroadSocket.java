package day08_websocket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/broadSocket")
public class BroadSocket {
	Session session;
	 @OnOpen
	   public void onOpen(Session session) throws IOException {
	      System.out.println("onOpen...");
	      session.getBasicRemote().sendText("socket open");
	   }
   
   @OnClose
   public void onClose() {
      System.out.println("onClose ...");
   }

   @OnMessage
   public String onMessage(String message, Session session) {
      System.out.println("onMessage ...");
      System.out.println(message);
      return message;
   }
   
   @OnError
   public void onError(Throwable th) {
      System.out.println("onError ...");
   }
   
}