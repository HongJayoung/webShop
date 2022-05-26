<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- JSP주석 => JSP에서만 보임, .java, .html에서는 없음 

Derective


--%>

<%
//자바주석
//자바코드가 .java의 service메서드에 들어간다
String coffee = "아메리카노";
out.println("<h2>"+coffee+"</h2>");
%>

<%!
//맴버변수와 맴버메서드
int price=2000;
public int getPrice() {
	return price;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- HTML주석 =>HTML문서에서 보임 -->
<h1><%=coffee %></h1><!-- Expression, 문장아니므로 ;사용X -->

<% //아주 나쁨,,
for(int i=1;i<=5;i++) {%>
	<h3><%=i %></h3>
<%	
}
%>
</body>
</html>