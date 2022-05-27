<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.kosta.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
Map<String, Product> plist = (HashMap)session.getAttribute("cart"); //장바구니
if(plist == null) plist = new HashMap<>();

if(plist.containsKey(name)) {
	Product p = plist.get(name);
	p.setCount(p.getCount()+count);
} else {
	if(name != null) plist.put(name,pro);
}

session.setAttribute("cart", plist);

//출력
for(String key: plist.keySet()) {
	Product p2 = plist.get(key);
	out.write("<p>"+p2.getName()+" : "+p2.getCount()+"</p>");
}

//JSP 내장객체 : application, session, request, pageContext, out
%>

<a href="input.jsp">계속 구매하기</a>
<button id="btnClear" onclick="location.href='cartRemove'">장바구니 비우기</button>
</body>
</html>