<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
.right {
	float:right;
	padding-right: 20px;
}
</style>   

<div>
	<span class="right">
		<c:if test="${user != null}">
		${user.user_name}님 로그인
		</c:if>	
		<c:if test="${user == null}">
		Guest님 로그인
		</c:if>	
	</span>
	<span>
		<a class="right" href="../logout">로그아웃</a>
	</span>
</div>