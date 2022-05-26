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
<h1>scopeTest.jsp...Servlet Scope를 test</h1>
<h2>ScriptLet 문법</h2>
<p>application영역의 접근 : <%= application.getAttribute("appVar") %></p>
<p>session영영의 접근 : <%= session.getAttribute("sessionVar") %></p>
<p>request영영의 접근 : <%= request.getAttribute("requestVar") %></p>
<hr>
<h2>EL(Expression Language) 문법</h2>
<p>application영역의 접근 : ${appVar}</p>
<p>session영영의 접근 : ${sessionVar}</p>
<p>request영영의 접근 : ${requestVar}</p>
<hr>
<h2>scope 순서 : request > session > application</h2>
<p>scope 영역이 좁은 순서대로 찾음 => ${myphone}</p>
<p>application영역의 접근 : ${applicationScope.myphone}</p>
<p>session영영의 접근 : ${sessionScope.myphone}</p>
<p>request영영의 접근 : ${requestScope.myphone}</p>
</body>
</html>