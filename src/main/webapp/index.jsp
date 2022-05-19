<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>jsp, servlet 학습하기</h1>
<h2>get 요청1</h2>
<a href="FirstServlet">firstServlet요청</a>
<h2>get 요청2</h2>
<form action="FirstServlet" method="get">
	<input type="submit" value="firstServlet요청">
</form>
<h2>get 요청3</h2>
<button id="btn1">get요청</button>
<hr>
<h2>post 요청</h2>
<form action="FirstServlet" method="post">
	<input type="submit" value="firstServlet요청">
</form>

<script>
btn1.onclick = function() {
	//location.href="kosta/first3.do"; //상대경로
	location.href="/webShop/kosta/first3.do"; //절대경로
};
</script>
</body>
</html>