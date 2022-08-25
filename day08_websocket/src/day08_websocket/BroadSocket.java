package day08_websocket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/broadSocket")
public class BroadSocket {
   @OnOpen
   public void onOpen() {
      System.out.println("onOpen ...");
   }
   
   @OnClose
   public void onClose() {
      System.out.println("onClose ...");
   }
   
   @OnMessage
   public void onMessage(String message, Session session) {
      System.out.println("onMessage ...");
   }
   
   @OnError
   public void onError(Throwable th) {
      System.out.println("onError ...");
   }
}