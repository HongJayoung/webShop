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
		//get��û�� ��� �ּ�â�� �Ķ���Ͱ� �ڵ����� ���ڵ��Ǿ� �Ѿ�� => �ѱ۱��� ����
		//post��û�� ��û������ body�� �Ķ���Ͱ� ���ڵ��� �ȵǾ� �Ѿ�� => �ѱ۱���
		request.setCharacterEncoding("utf-8"); //post������ �ʿ�
		
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
