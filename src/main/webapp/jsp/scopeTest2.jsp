<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//자바
//내장 객체가 제공 : application, session, request
%>
<h1>scopeTest2.jsp...Servlet Scope를 test(Servlet과 연결X)</h1>
<h2>ScriptLet 문법</h2>
<p>application영역의 접근 : <%= application.getAttribute("appVar") %></p>
<p>session영영의 접근 : <%= session.getAttribute("sessionVar") %></p>
<p>request영영의 접근 : <%= request.getAttribute("requestVar") %></p>
<hr>
<h2>EL(Expression Language) 문법</h2>
<p>application영역의 접근 : ${appVar}</p>
<p>session영영의 접근 : ${sessionVar}</p>
<p>request영영의 접근 : ${requestVar}</p>
</body>
</html>