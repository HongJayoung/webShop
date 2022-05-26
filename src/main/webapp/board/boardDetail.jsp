<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>BOARD</h1>
<hr>
<%@ include file="../common/header.jsp" %>
<form action="boardUpdate.do" method="post">
번호 : ${board.getBno()}<input type="hidden" name="bno" value = "${board.getBno()}"> <br>
제목 : <input type="text" name="title" value = "${board.getTitle()} "> <br>
내용 : <input type="text" name="content" value = "${board.getContent()}"> <br>
작성자 : <input type="text" value = "${board.getWriter()}" disabled="disabled"> <br>
작성일자 : <input type="text" value = "${board.getRegdate()}" readonly="readonly"> <br>
수정일자 : <input type="text" value = "${board.getUpdatedate()}" readonly="readonly"> <br> 
<input type="submit" value="수정">
<input type="reset" value="취소">
</form>
</body>
</html>