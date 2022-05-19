package com.kosta.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/html/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get요청의 경우 주소창에 파라메터가 자동으로 인코딩되어 넘어옴 => 한글깨짐 없음
		//post요청은 요청문서의 body에 파라메터가 인코딩이 안되어 넘어옴 => 한글깨짐
		request.setCharacterEncoding("utf-8"); //post에서만 필요
		
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(request.getMethod());
		System.out.println(request.getContextPath());
		
		/*
		//응답문서의 타입과 인코딩 방식을 응답문서를 만들기 전에 설정
		response.setContentType("text/html;charset=utf-8");
		
		//응답문서만들기(직접 HTML을 만들기때문에 별로 좋은 코드는 아님) 
		PrintWriter out = response.getWriter();
		out.write("<h1>로그인 성공</h1>");
		out.write("<h2>DB접속 후 다시 수정하기</h2>");
		*/
		
		//Servlet이 실행결과를 JSP에 위임. 주소창은 변경되지않음.
		RequestDispatcher rd = request.getRequestDispatcher("../jsp/loginResult.jsp");
		rd.forward(request, response);
	}
}
