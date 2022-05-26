<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  	body {margin: 20px;}
  	label {display:inline-block; width:150px;}
  	.form-control {display:inline-block; width:auto;}
 </style>

</head>
<body>
<h1>NEW EMPLOYEE</h1> <hr>
<form action="empInsert.do" method="post">
<div class="form-group">
	<label>직원번호 : </label>
	<input class="form-control" type="number"  name="employee_id" >
</div>

<div class="form-group">
	<label>first name :</label>
	<input class="form-control" type="text"  name="first_name">
</div>

<div class="form-group">
	<label>last name :</label>
	<input class="form-control" type="text"  name="last_name">
</div>

<div class="form-group">
	<label>email :</label>
	<input class="form-control" type="text"  name="email">
</div>

<div class="form-group">
	<label>phone :</label>
	<input class="form-control" type="text"  name="phone_number">
</div>

<div class="form-group">
	<label>commission :</label>
	<input class="form-control" type="text"  name="commission_pct">
</div>

<div class="form-group">
	<label>manager id :</label>
		<select class="form-control" name="manager_id">
		<c:forEach items="${mgrlist}" var="mgr">
			<option value="${mgr.key}">${mgr.value}</option>
		</c:forEach>
	</select>
</div>

<div class="form-group">
	<label>department id :</label>
	<select class="form-control" name="department_id">
		<c:forEach items="${dlist}" var="dept">
			<option value="${dept.department_id}">${dept.department_name}</option>
		</c:forEach>
	</select>
</div>

<div class="form-group">
	<label>job id :</label>
	<select class="form-control" name="job_id">
		<c:forEach items="${jlist}" var="jobs">
			<option>${jobs.job_id}</option>
		</c:forEach>
	</select>
</div>

<div class="form-group">
	<label>hire date :</label>
	<input class="form-control" type="date"  name="hire_date" >
</div>

<div class="form-group">
	<label>salary :</label>
	<input class="form-control" type="text"  name="salary" >
</div>

<div>
<input type="submit" class="btn btn-success" value="등록">
<input type="reset" class="btn btn-secondary" value="취소">
</div>
</form>

</body>
</html>