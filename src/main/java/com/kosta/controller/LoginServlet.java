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
		//get��û�� ��� �ּ�â�� �Ķ���Ͱ� �ڵ����� ���ڵ��Ǿ� �Ѿ�� => �ѱ۱��� ����
		//post��û�� ��û������ body�� �Ķ���Ͱ� ���ڵ��� �ȵǾ� �Ѿ�� => �ѱ۱���
		request.setCharacterEncoding("utf-8"); //post������ �ʿ�
		
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(request.getMethod());
		System.out.println(request.getContextPath());
		
		/*
		//���乮���� Ÿ�԰� ���ڵ� ����� ���乮���� ����� ���� ����
		response.setContentType("text/html;charset=utf-8");
		
		//���乮�������(���� HTML�� ����⶧���� ���� ���� �ڵ�� �ƴ�) 
		PrintWriter out = response.getWriter();
		out.write("<h1>�α��� ����</h1>");
		out.write("<h2>DB���� �� �ٽ� �����ϱ�</h2>");
		*/
		
		//Servlet�� �������� JSP�� ����. �ּ�â�� �����������.
		RequestDispatcher rd = request.getRequestDispatcher("../jsp/loginResult.jsp");
		rd.forward(request, response);
	}
}
