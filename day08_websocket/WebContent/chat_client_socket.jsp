<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
int port = request.getLocalPort();
String serverName = request.getServerName();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat Client Socket</title>
</head>
<body>
	<h1>웹소켓을 활용한 챗팅</h1>
	<p>사용자 아이디를 입력 하고 로그인 하면 체팅이 시작 됩니다!</p>
	<form>
		사용자 : <input id="sender" type="text" value="user1"> 
		<input id="loginBtn" value="Login" type="button"> 
		<input id="closeBtn" value="Disconnect" type="button"><br> 
		받는이: <input id="recipient" type="text" value="All"><br> 
		메세지: <input id="txtMsg" type="text" value="hello"> 
		<input id="sendBtn" value="Send" type="button">
	</form>
	<hr>
	<textarea id="msgTxtArea" rows="10" cols="50"></textarea>
	<script>
// 웹소켓 프로토콜을 이용해서 서버와 연결
// WebSocket은 HTML5에 기본 제공된다.

var socket =new WebSocket("ws://<%=serverName%>:<%=port%>/<%=contextPath%>/broadSocket2");
var txt=document.getElementById("msgTxtArea");
socket.onopen = function(message) {
	console.log("onpen ...");
	txt.value+=(">>>open...\n");
}
socket.onclose = function(message) {
	txt.value+=(">>>onclose...\n");
	console.log("onclose ...");
}
socket.onerror = function(err) {
	txt.value+=(">>>error...\n");
	console.log("소켓 오류", err);
}
socket.onmessage = function(message) {
	txt.value+=(">>>message...\n");
	console.log("onmessage", message);
	txt.value+=("<<<"+message.data+"\n");
	
}
sendBtn.onclick=function(){
	var msg=document.getElementById("txtMsg").value;
	txt.value+=(msg+"\n");
	socket.send(msg);
}
closeBtn.onclick=function(){
	socket.close();
}
</script>

</body>
</html>