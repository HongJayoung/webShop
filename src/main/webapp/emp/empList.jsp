<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="../css/listCommon.css">

<style>
.color1 { background-color: #FFF9DD;}
.color2 { background-color: #DEEFFF;}
</style>
</head>

<body>
<h1>EMPLOYEE LIST</h1>
<hr>
<div><span><a class="left" href ="empInsert.do">신규등록</a></span></div>
<!-- ${pageContext.request.contextPath} -->

<table>
	<tr>
		<td>순서</td>
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
	
	<c:forEach items="${emplist}" var="emp" varStatus="status">
	<c:if test="${status.first}">
		<tr class="color1">
	</c:if>
	<c:if test="${status.last}">
		<tr class="color2">
	</c:if>
	<c:if test="${status.last==false&&status.first==false}">
		<tr>
	</c:if>
		<td>${status.count}</td>
		<td><a href="empDetail.do?empid=${emp.employee_id}">${emp.employee_id}</a></td>
		<td>${emp.first_name}...${fn:contains(emp.first_name,"Al")}</td>
		<td>${emp.last_name}</td>
		<td>${emp.email}</td>
		<td>${fn:substring(emp.phone_number,0,3)}</td>
		<td>${emp.commission_pct}</td>
		<td>${emp.manager_id}</td>
		<td>${emp.department_id}</td>
		<td>${emp.job_id}</td>
		<td>${emp.hire_date}</td>
		<td>
			<fmt:formatNumber value="${emp.salary}" type="currency" currencySymbol="$"/>
		</td>
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