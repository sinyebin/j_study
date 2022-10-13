<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp" %>
<h1>로그인</h1>
<hr />
<form action="login" method="post">
	<label for="id">아이디</label>
	<input type="text" name="id" id="id"/>
	<label for="">비밀번호</label>
	<input type="password" name="password" id="password"/>
	<input type="submit" value="로그인" />
</form>
<hr />
<%@ include file="/inc/bottom.jsp" %>