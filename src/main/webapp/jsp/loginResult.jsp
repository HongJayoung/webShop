<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>!!!로그인 성공!!!</h1>
<h2>DB접속 후 다시 수정하기</h2>
<h2><%=request.getParameter("userid") %></h2>
<h2>${param.userid}</h2> 
<h2>이메일은 ${param.user_email}</h2>
<h2>주소는 ${param.user_address}</h2>
<%-- default 경로 : http://localhost/webShop --%>
<a href="login2.do?a=${param.userid}&b=${param.userpw}&c=${param.user_email}&d=${param.user_address}">다른페이지에 정보넘기기</a>
</body>
