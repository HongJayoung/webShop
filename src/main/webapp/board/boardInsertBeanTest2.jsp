<%@page import="com.kosta.dto.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JavaBeans Test2</h1>
<%
//1.자바코드로 파라메터 받아서 객체생성
String title = request.getParameter("title");
String content = request.getParameter("content");
String s_writer = request.getParameter("writer");
int writer = Integer.parseInt(s_writer);

BoardVO board = new BoardVO();
board.setTitle(title);
board.setContent(content);
board.setWriter(writer);
%>
제목 : <%=board.getTitle() %> <br>
내용 : <%=board.getContent() %> <br>
작성자 : <%=board.getWriter() %> <br>
<hr>
<h2>2.Action Tag사용하기 => jsp:useBeas 이용</h2>
<%-- application, session, request, page등의 범위를 가짐 default => page --%>
<jsp:useBean id="board2" class="com.kosta.dto.BoardVO" scope="session"></jsp:useBean>

<%-- 
<jsp:setProperty property="title" name="board2" param="title"/>
<jsp:setProperty property="content" name="board2" param="content"/>
<jsp:setProperty property="writer" name="board2" param="writer"/> 
--%>

<%-- 파라메터이름(input tag의 name)과 속성이름(VO의 변수이름)이 같은 경우 param 생략가능 --%>
<%-- 
<jsp:setProperty property="title" name="board2"/>
<jsp:setProperty property="content" name="board2"/>
<jsp:setProperty property="writer" name="board2"/> 
--%>

<%-- 가장간단 --%>
<jsp:setProperty property="*" name="board2"/>

<hr>
<h2>2.Action Tag사용해 읽기</h2>
제목 : <jsp:getProperty property="title" name="board2"/> <br>
내용 : <jsp:getProperty property="content" name="board2"/> <br>
작성자 : <jsp:getProperty property="writer" name="board2"/> <br>

<a href="boardInsertBeanTest3.jsp">3번째 페이지로 이동</a>
</body>
</html>