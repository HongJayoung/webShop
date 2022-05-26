package com.kosta.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/html/login2.do") 
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get요청의 경우 주소창에 파라메터가 자동으로 인코딩되어 넘어옴 => 한글깨짐 없음
		//post요청은 요청문서의 body에 파라메터가 인코딩이 안되어 넘어옴 => 한글깨짐
		request.setCharacterEncoding("utf-8"); //post에서만 필요
		
		String id = request.getParameter("a");
		String pw = request.getParameter("b");
		String email = request.getParameter("c");
		String address = request.getParameter("d");
		
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(email);
		System.out.println(address);
		System.out.println(request.getMethod());
		System.out.println(request.getContextPath());
	}
}
