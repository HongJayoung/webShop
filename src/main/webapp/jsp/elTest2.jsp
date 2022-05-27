<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kosta.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
application.setAttribute("myName", "application");
session.setAttribute("myName", "session");
request.setAttribute("myName", "request");
pageContext.setAttribute("myName", "pageContext");



%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL문법 익히기</h1>
1. 저장영역에 읽기 : ${myName} <br>
1. 저장영역에 읽기 : <%=pageContext.getAttribute("myName") %><br>
1. 저장영역에 읽기 : ${applicationScope.myName} <br>
1. 저장영역에 읽기 : ${sessionScope.myName} <br>
1. 저장영역에 읽기 : ${requestScope.myName} <br>
1. 저장영역에 읽기 : ${pageScope.myName} <hr>

2. param : ${param.myName} <br>
2. param : ${paramValues.subject[0]} <br>
2. param : ${paramValues.subject[1]} <hr>

3. pageContext 내장객체이용시 이용: ${pageContext.request.contextPath} <hr>

4. 로그인한 사용자 정보 : ${user} <br>
4. 로그인한 사용자 정보 : ${user.user_name} <hr>
<%
pageContext.setAttribute("productVO", new Product("비비빅", 1000));

List<Product> plist = new ArrayList<>();

plist.add(new Product("비비빅1", 1000));
plist.add(new Product("비비빅2", 2000));
plist.add(new Product("비비빅3", 3000));

request.setAttribute("plist", plist);
%>

5. 객체얻기 : ${productVO.name} <%-- getName() 호출됨 --%> <br>
5. 객체얻기 : ${productVO.count} <%-- getCount() 호출됨 --%> <br>

6. collection 얻기 : ${plist[0].name} <br>
6. collection 얻기 : ${plist[0].count} <br>
6. collection 얻기 : ${plist[1].name} <br>
6. collection 얻기 : ${plist[1].count} <hr>

7. JSTL 문법 <br>
<c:forEach items="${plist}" var="p">
	${p.name} <br>
</c:forEach>

8. Map 이용 <br>
<%
Map<String, Product> cart = new HashMap<>();
cart.put("A",new Product("비비빅1", 1));
cart.put("B",new Product("비비빅2", 5));
cart.put("C",new Product("비비빅3", 2));

request.setAttribute("cart", cart);
%>

${cart.A.name} => ${cart.A.count} <br>
${cart.B.name} => ${cart.B.count} <br>
${cart.C.name} => ${cart.C.count} <hr>

<c:forEach items="${cart}" var="map">
	${map.key}. ${map.value.name} => ${map.value.count}<br>
</c:forEach>



</body>
</html>