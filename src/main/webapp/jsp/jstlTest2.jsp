<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL 연습2</h1>
1. url 만들기 <br>
<c:url var="newUrl" value="jstlTest3.jsp">
	<c:param name="myName" value="kim"/>
	<c:param name="myPhone" value="01012345678"/>
</c:url>

<a href="${newUrl}">페이지이동</a> 

<hr>

2. 파라메터로 들어온 값 판단 <br>
<c:set var="score" value="${param.score}"/>
<h3>${score}</h3>
<c:choose>
	<c:when test="${score>=90}">
		<p>A학점</p>
	</c:when>
	<c:when test="${score>=80&&score<90}">
		<p>B학점</p>
	</c:when>
	<c:otherwise>
		<p>F학점</p>
	</c:otherwise>
</c:choose>

<hr>

3. 다국어 처리(KR) <br>
<fmt:setLocale value="ko_KR"/>
<fmt:bundle basename="resource/member">
	이름 : <fmt:message key="mem.name"/> <br>
	주소 : <fmt:message key="mem.address"/> <br>
</fmt:bundle>
3. 다국어 처리(EN) <br>
<fmt:setLocale value="en_EN"/>
<fmt:bundle basename="resource/member">
	이름 : <fmt:message key="mem.name"/> <br>
	주소 : <fmt:message key="mem.address"/> <br>
</fmt:bundle>
</body>
</html>