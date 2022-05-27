<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kosta.dto.Product"%>
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
<h1>장바구니</h1>

<%
String name = request.getParameter("prod");
String s_count = request.getParameter("count");

int count = 0;
if(s_count != null) {
	count = Integer.parseInt(s_count);
}

Product pro = new Product(name, count);

//장바구니가 session에 있으면 얻기, 없으면 만들기
List<Product> plist = (ArrayList)session.getAttribute("cart"); //장바구니
if(plist == null) plist = new ArrayList<>();

boolean flag = false;
for(Product p:plist) {
	if(p.getName().equals(name)) {
		p.setCount(p.getCount()+count);
		flag = true;
	}
}

if(!flag) plist.add(pro);

session.setAttribute("cart", plist);

//출력
/*
for(Product p: prodlist) {
	out.write("<p>상품명 : "+p.getName()+" 개수 : "+p.getCount()+"</p>");
}
*/
%>

<c:forEach items="${cart}" var = "prod">
	<p>${prod.name} : ${prod.count}개</p>
</c:forEach> 


<a href="input.jsp">계속 구매하기</a>
<button id="btnClear" onclick="location.href='cartRemove'">장바구니 비우기</button>
</body>
</html>