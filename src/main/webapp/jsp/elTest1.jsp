<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL(Expression Language)</h1>
1. 숫자 : ${100} <br>
2. 문자 : ${"Hello"}${"~~"} <br>
3. boolean : ${10>20} <br>
4. 문자+숫자 : ${"100"+300 } <br>
5. 연산 : ${10/3} <br>
5. 연산 : ${10%3} <br>
<%-- 5. 연산 : ${10 div 3} <br> --%>
5. 연산 : ${10 mod 3} <br>
6. 같은지? : ${"hello" == 'hello'} <br>
6. 같은지? : ${"hello" eq 'hello'} <br>
6. 같은지? : ${"hello" != 'hello'} <br>
<%-- 6. 같은지? : ${"hello" ne 'hello'} <br> --%>
7. 비교 : ${20 >= 10} <br>
7. 비교 : ${20 le 10} <br>
8. 비교,not : ${user == null} <br>
8. 비교,not : ${user != null} <br>
8. 비교,not : ${user.user_id} <br>
8. 비교,not : ${user.user_id == "jayoung"} <br>
9. empty : ${empty user} <br>
9. empty : ${empty null} <br>
9. empty : ${empty ""} <br>

<form action="elTest2.jsp">
	myName : <input name="myName" value="ja0"> <br>
	subject : <input type="checkbox" name="subject" value="컴공" checked="checked">컴공
	<input type="checkbox" name="subject" value="경제" checked="checked">경제
	<input type="submit" value="ELTest2로 가기">
</form>
</body>
</html>