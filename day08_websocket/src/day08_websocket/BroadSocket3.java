package day08_websocket;


import java.io.IOException;
import java.security.cert.Extension;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.websocket.Extension.Parameter;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint(value="/broadSocket/{userID}")
public class BroadSocket3 {
	// 귓속말 메세지를 전달 할 session을 userID로 찾기 위해서 userID와 session을 맵핑한다.
	static Map<String, Session> sessionMap = Collections.synchronizedMap(new HashMap<>());
	
	@OnOpen
	public void onOpen(Session session, @PathParam("userID") String userID) throws IOException {
		//System.out.println("소켓 서버 "+ session.getId() +"이(가) 오픈 되었습니다...");
		
		//System.out.println(Arrays.toString(session.getClass().getFields()) );
		//System.out.println("session id : " + session.getId());
		
		// 쿼리 스트링을 받을 수 있다.
		//System.out.println("session querystr : " + session.getQueryString());
		// 문자열 리스트를 파라미터 맵으로 전달 받을 수 있다.
		//Map<String, List<String>> params = session.getRequestParameterMap();
		//System.out.println(params.get("sender"));
		
		// PathParam 어노테이션을 이용한 파라미터 전달
		//System.out.println("path param sender : " + userID);
		// 접속한 사용자의 session을 Map에 저장한다.
		sessionMap.put(userID, session);
		
		for(String userid : sessionMap.keySet()) {
			(sessionMap.get(userid)).getBasicRemote().sendText(userID + "님이 입장하였습니다!");
		}
	}
	
	@OnClose
	public void onClose(Session session, @PathParam("userID") String userID) {
		System.out.println("소켓 서버"+ session.getId() +"이(가) 닫혔습니다...");
		sessionMap.remove(userID);
	}
	
	@OnMessage
	public void onMessage(String message, Session session, @PathParam("userID") String userID) throws IOException {
		System.out.println("받은 메세지 : " + message);
		// clientSessionSet에서 클라이언트 세션을 가져와서 sender를 제외한 모든 세션에 메세지를 보낸다.
		// 동기적으로 메세지를 보내야 한다.
		synchronized(sessionMap) {
			//System.out.println("set size : " + sessionMap.size());
			System.out.println(message);
			StringTokenizer stk = new StringTokenizer(message, "||");
			String recipient = stk.nextToken().trim();
			String msg = stk.nextToken().trim();
			if("All".equals(recipient)) {
				for(String userid : sessionMap.keySet()) {
					if(!userid.equals(userID)) {
						//https://docs.oracle.com/javaee/7/api/javax/websocket/Session.html#getBasicRemote--
						// 클라이언트 session에서 RemoteEndpoint 객체를 받아와서 메세지 텍스트를 보낸다.
						// RemoteEndpoint를 통해서 동기적으로 메세지를 보낼 수 있다.
						(sessionMap.get(userid)).getBasicRemote().sendText(userID + " : " + msg);
					}
				}
			} else {
				(sessionMap.get(recipient)).getBasicRemote().sendText(userID + " : " + msg);
			}
		}
	}
	
	@OnError 
	public void onError(Throwable th) {
		th.printStackTrace();
	}
}