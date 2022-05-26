<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    session="true"
    buffer="8kb"
    autoFlush="true"
    errorPage="error1.jsp"
    isErrorPage="false"
    %>
    
<%
String a = "jsp페이지";
int b =10;
int c =0;
System.out.println(b/c);
%>



<%--
1. 페이지 디렉티브 태그(Page Directive Tag): JSP 페이지의 전반적인 정보를 설정할 때 사용
	isErrorPage : 내가 error시 보여주는 페이지인지?
	errorPage : erreo시 이동되는 페이지는 error1.jsp
2. 인클루드 디렉티브 태그(Include Directive Tag): 공통으로 사용하는 JSP 페이지를 다른 JSP 페이지에 추가할 때 사용
3. 태그라이브 디렉티브 태그(Taglib Directive Tag): 개발자나 프레임워크에서 제공하는 태그를 사용할 때 사용
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP구성요소</h1>
<%@ include file="../common/header.jsp" %> <%-- 합치고 컴파일 --%>
<jsp:include page="../common/header.jsp"></jsp:include> <%-- 컴파일하고 합틴다. --%>
</body>
</html>