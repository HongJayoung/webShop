<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="../css/insertDetailCommon.css">

</head>

<body>
<h1>LOGIN</h1> 

<hr>
<form action="login.do" method="post">
<div class="form-group">
	<label>아이디 :</label>
	<input class="form-control" type="text" name="userid" value="jayoung">
</div>

<div class="form-group">
	<label>비밀번호 :</label>
	<input class="form-control" type="text" name="userpw" value="1234">
</div>

	<input type="hidden" name="user_email" value="1234@naver.com">
	<input type="hidden" name="user_address" value="seoul">
	<input class="btn btn-success" type="submit" value="로그인">
</form>
</body>
</html>