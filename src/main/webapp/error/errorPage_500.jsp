<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>알림</h1>
<hr>
<p><%=exception %></p>
<p><%=exception.getMessage() %></p>
<p>연락!</p>
<%
//console 창에 display
exception.printStackTrace();
%>
</body>
</html>