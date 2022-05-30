<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL 연습</h1>
1. set(setAttribute) : <br>
	<c:set var="myName" value="ja0" scope="page"/>
	<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
2. get(getAttribute) : ${myName} <br>
2. get(getAttribute) : ${path} <hr>

3. 반복문 : <br>
<c:forEach begin="1" end="5" step="1" var="num">
	${num} 
</c:forEach> <br>
<%
String[] arr={"월","화","수","목","금","토","일"};
pageContext.setAttribute("week", arr);
%>
<c:forEach items="${week}" var="day" varStatus="status">
	${status.index} / ${status.count} / ${status.first} / ${status.last} => 
	<c:if test="${status.first}">
		<span style="color:red">${day}</span> <br>
	</c:if>
	<c:if test="${status.last}">
		<span style="color:blue">${day}</span> <br>
	</c:if>
	<c:if test="${(status.last==false)&&(status.first==false)}">
		<span>${day}</span> <br>
	</c:if>
</c:forEach>
<hr>
4. token <br>
	<c:set var="subject" value="자바,SQL,JSP/Servlet,Spring"/>
	<c:forTokens items="${subject}" delims="," var="ss">
		${ss} <br>
	</c:forTokens>
</body>
</html>