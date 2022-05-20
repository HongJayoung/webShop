<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>직원상세내역</h1>
직원번호 : ${emp.getEmployee_id()} <br>
first name : ${emp.getFirst_name()} <br>
last name : ${emp.getLast_name()} <br>
email : ${emp.getEmail()} <br>
phone : ${emp.getPhone_number()} <br>
commission : ${emp.getCommission_pct()} <br>
manager_id : ${emp.getManager_id()} <br>
department_id : ${emp.getDepartment_id()} <br>
job_id : ${emp.getJob_id()} <br>
입사일 : ${emp.getHire_date()} <br>
급여 : ${emp.getSalary()}
</body>
</html>