<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inc/top.jsp" %>>
<script>
    var msg = "<c:out value='${msg}'/>";
    var url = "<c:out value='${url}'/>";
    alert(msg);
    location.href = url;
</script>
<%@ include file="/inc/bottom.jsp" %>