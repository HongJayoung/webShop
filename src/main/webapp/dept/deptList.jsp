<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, td {
	border:1px solid black;
	border-collapse: collapse;
	padding: 5px;
}
</style>
</head>
<body>
<h1>부서목록</h1>
<a href="deptInsert.do">신규부서등록</a>
<br><br>
<table>
	<tr>
		<td>부서번호</td>
		<td>부서이름</td>
		<td>매니저</td>
		<td>지역번호</td>
		<td></td>
	</tr>
	<c:forEach items="${deptlist}" var="dept">
	<tr>
		<td>${dept.department_id}</td>
		<td><a href="dept.do?dept_id=${dept.department_id}">${dept.department_name}</a></td>
		<td>${dept.manager_id}</td>
		<td>${dept.location_id}</td>
		<td><button class="btnDel" data-deptid="${dept.department_id}">삭제하기</button></td>
	</tr>
	</c:forEach>
</table>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(function() {
	$(".btnDel").on("click",f);
});

function f() {
	var deptid = $(this).attr("data-deptid");
	
	if(confirm(deptid + "번 부서 삭제?")) {
		location.href = "deptDelete.do?deptid="+deptid;
	}
}
</script>
</body>
</html>