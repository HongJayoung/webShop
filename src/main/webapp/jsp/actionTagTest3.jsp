<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Action Tag Test3</h1>
<hr>
<h2>Action Tag이용...forward</h2>
<p>jsp:forward => 요청과 응답이 다름. 주소창은 바뀌지않음.</p>
<hr>
<h2>Action Tag이용...include</h2>
<p>jsp:forward => 요청과 응답이 다름. 다른 페이지의 수행결과가 현재 페이지 안으로 들어옴.</p>
<jsp:include page="input.jsp"></jsp:include>
</body>
</html>