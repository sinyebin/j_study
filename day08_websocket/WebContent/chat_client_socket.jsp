<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat Client Socket</title>
</head>
<body>
	<h1>웹소켓을 활용한 챗팅</h1>

	<%
		String contextPath = request.getContextPath();
	int port = request.getLocalPort();
	String serverName = request.getServerName();
	%>
		<input type="text" id="endPointName" value="broadSocket"/>
		<button id ="openSocket" >소켓 연결</button>
	<script>

// 웹소켓 프로토콜을 이용해서 서버와 연결
// WebSocket은 HTML5에 기본 제공된다.
var openSocketBtn=document.getElementById("openSocketBtn");
var socket = null;
openSocketBtn.onclick=function(){
	
}
var socket = new WebSocket("ws://<%=serverName%>:<%=port%>/<%=contextPath%>/broadSocket");

		socket.onopen = function(message) {
			console.log("onpen ...");
		}
	</script>
</body>
</html>