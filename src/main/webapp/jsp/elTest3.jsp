<%@page import="com.kosta.dto.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kosta.dto.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
BoardVO board = new BoardVO("월요일", "EL연습", 100);
application.setAttribute("boardVO", board);
session.setAttribute("boardVO", new BoardVO("화요일", "EL연습", 100));
request.setAttribute("boardVO", new BoardVO("수요일", "EL연습", 100));
pageContext.setAttribute("boardVO", new BoardVO("목요일", "EL연습", 100));

List<BoardVO> blist = new ArrayList<>();
blist.add(new BoardVO("A", "EL연습", 100, new EmpVO(100,"홍1","길동")));
blist.add(new BoardVO("B", "EL연습", 100, new EmpVO(200,"홍2","길동")));
blist.add(new BoardVO("C", "EL연습", 100, new EmpVO(300,"홍3","길동")));
blist.add(new BoardVO("D", "EL연습", 100, new EmpVO(400,"홍4","길동")));
blist.add(new BoardVO("E", "EL연습", 100, new EmpVO(500,"홍5","길동")));
request.setAttribute("blist", blist);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL연습</h1>
1. EL이용읽기 : ${boardVO} <br>
1. EL이용읽기 : ${applicationScope.boardVO} <br>
1. EL이용읽기 : ${sessionScope.boardVO} <br>
1. EL이용읽기 : ${requestScope.boardVO} <br>
1. EL이용읽기 : ${pageScope.boardVO} <hr>
2. ScriptLet의 Expression : <%=board %> <br>
2. ScriptLet의 Expression : <%=application.getAttribute("boardVO") %> <hr>
3. List 읽기 : ${blist} <br>
<ul>
	<c:forEach items="${blist}" var="b">
		<li>${b.title}...${b.content}...${b.emp.employee_id}...${b.emp.first_name}...${b.emp.last_name}</li>
	</c:forEach>
</ul>
<hr>

<%--
jsp:forward는 표준 액션
forward는 요청과 응답을 다른페이지로 넘긴다.
include는 요청과 응답을 다른페이지로 넘기고 그 페이지가 이 페이지로 포함된다.
 --%>
<jsp:include page="elTest4.jsp"></jsp:include>
</body>
</html>