package day08_websocket;


import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/broadSocket2")
public class BroadSocket2 {
	// 해쉬셋은 동기화가 지원 되지 않기 때문에 동기화 가능 하도록 생성한다.
	static Set<Session> clientSessionSet = Collections.synchronizedSet(new HashSet<Session>());
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("소켓 서버 "+ session.getId() +"이(가) 오픈 되었습니다...");
		// 클라이언트가 서버에 접속하면 클라이언트 세션을 셋에 추가 해 둔다.
		clientSessionSet.add(session);
	}
	
	@OnClose
	public void onClose(Session session) {
		System.out.println("소켓 서버"+ session.getId() +"이(가) 닫혔습니다...");
		clientSessionSet.remove(session);
	}
	
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		System.out.println("받은 메세지 : " + message);
		// clientSessionSet에서 클라이언트 세션을 가져와서 sender를 제외한 모든 세션에 메세지를 보낸다.
		// 동기적으로 메세지를 보내야 한다.
		synchronized(clientSessionSet) {
			System.out.println("set size : " + clientSessionSet.size());
			for(Session clientSession : clientSessionSet) {
				if(!session.equals(clientSession)) {
					//https://docs.oracle.com/javaee/7/api/javax/websocket/Session.html#getBasicRemote--
					// 클라이언트 session에서 RemoteEndpoint 객체를 받아와서 메세지 텍스트를 보낸다.
					// RemoteEndpoint를 통해서 동기적으로 메세지를 보낼 수 있다.
					clientSession.getBasicRemote().sendText(session.getId() + " : " +message);
				}
			}
		}
	}
	
	@OnError 
	public void onError(Throwable th) {
		th.printStackTrace();
	}
}