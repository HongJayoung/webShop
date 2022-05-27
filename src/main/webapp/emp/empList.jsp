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
  hr {clear:both;}
</style>
</head>

<body>
<h1>EMPLOYEE LIST</h1>
<hr>
<div><span><a class="left" href ="empInsert.do">신규등록</a></span></div>
<!-- ${pageContext.request.contextPath} -->
<%@ include file="../common/header.jsp" %>

<table>
	<tr>
		<td>직원번호</td>
		<td>성</td>
		<td>이름</td>
		<td>이메일</td>
		<td>전화번호</td>
		<td>커미션</td>
		<td>매니저</td>
		<td>부서번호</td>
		<td>직책</td>
		<td>입사일</td>
		<td>급여</td>
		<td></td>
	</tr>
	<c:forEach items="${emplist}" var="emp">
	<tr>
		<td><a href="empDetail.do?empid=${emp.employee_id}">${emp.employee_id}</a></td>
		<td>${emp.first_name}</td>
		<td>${emp.last_name}</td>
		<td>${emp.email}</td>
		<td>${emp.phone_number}</td>
		<td>${emp.commission_pct}</td>
		<td>${emp.manager_id}</td>
		<td>${emp.department_id}</td>
		<td>${emp.job_id}</td>
		<td>${emp.hire_date}</td>
		<td>${emp.salary}</td>
		<td>
			<form action="empDelete.do" method="post">
				<input type="hidden" name="emp_id" value="${emp.employee_id}">
				<input class="btn btn-secondary" type="submit" value="삭제">
			</form>
		</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>