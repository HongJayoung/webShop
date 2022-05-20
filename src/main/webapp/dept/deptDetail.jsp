<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1 {background-color: orange;}
</style>
</head>
<body>
<h1>부서상세보기</h1>
<form action="deptUpdate.do" method="post">
부서번호 : ${dept.getDepartment_id()}<input type="hidden" name="dept_id" value="${dept.getDepartment_id()}"><br>
부서이름 : <input type="text" name="dept_name" value="${dept.getDepartment_name()}"><br>
매니저 : <input type="number" name="mgr_id" value="${dept.getManager_id()}"><br>
지역번호 : <input type="number" name="loc_id" value="${dept.getLocation_id()}"><br>
<input type="submit" value="수정">
<input type="reset" value="취소">
</form>
</body>
</html>