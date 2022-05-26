<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<style>
table, td {
	border:1px solid black;
	border-collapse: collapse;
	padding: 10px;
}
tr:first-child {
	background-color: #E5E7FB;
}
table { 
	margin: 30px;
	clear:both;
}
h1 {
	text-align: center;
	padding: 20px;
	margin: 10px;
}
.left {
	float:left;
	padding-left: 20px;
}

</style>
</head>
<body>
<h1>BOARD LIST</h1>
<hr>
<div><span><a class="left" href="boardInsert.do">게시글 작성하기</a></span></div>
<%@ include file="../common/header.jsp" %>

<table>
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>내용</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>수정일</td>
		<td></td>
	</tr>
	<c:forEach items="${boardDatas}" var="board">
	<tr>
		<td><a href="boardDetail.do?bno=${board.bno}">${board.bno}</a></td>
		<td>${board.title}</td>
		<td>${board.content}</td>
		<td>${board.writer}</td>
		<td>${board.regdate}</td>
		<td>${board.updatedate}</td>
		<td><button class="btnDel" data-bno="${board.bno}">삭제하기</button></td>
	</tr>
	</c:forEach>
</table>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(function() {
	//#은 id, id는 문서 내에서 유일
	//.은 class
	$(".btnDel").click(function() {
		var bno = $(this).attr("data-bno");
		if(confirm(bno + "번 삭제?")) {
			location.href = "boardDelete.do?bno="+bno;
		}
	})
});
</script>
</body>
</html>