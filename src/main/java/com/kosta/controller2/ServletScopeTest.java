package com.kosta.controller2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletScopeTest
 */
@WebServlet("/ServletScopeTest")
public class ServletScopeTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		//1.server�� ����ִ� ���� ��� JSP/Servlet���� ���� ����
		ServletContext app = getServletContext();
		
		//2.Brower�� ����ִ� ���� ��� JSP/Servlet���� ���� ����
		HttpSession sess = req.getSession();
		
		//3.HttpServletRequest request : ��û�� ����ִ� ����(��û�� �ٲ����ʴ� ����) JSP/Servlet������ ���ٰ���
		
		app.setAttribute("appVar", "ServletContext�� server�� ����ִ� ���� ��� JSP/Servlet���� ���� ����");
		sess.setAttribute("sessionVar", "HttpSession�� Brower�� ����ִ� ���� ��� JSP/Servlet���� ���� ����");
		req.setAttribute("requestVar", "HttpServletRequest request : ��û�� ����ִ� ����(��û�� �ٲ����ʴ� ����) JSP/Servlet������ ���ٰ���");
		
		app.setAttribute("myphone", "1");
		sess.setAttribute("myphone", "2");
		req.setAttribute("myphone", "3");
		
		
		//���� API�� ���ε��� �Ӽ��� ���� ���ٹ���
		//ServletContext �Ӽ��� ���ø����̼� ��ü���� ���� ����
		//HttpSession �Ӽ��� ����ڸ� ���ٰ���
		//HttpServletRequest �Ӽ��� �ش� ��û/���信 ���ؼ� �� �������� �̿��ؼ� 
		//�α��� ���� ����, ��ٱ���, MVC�� model�� veiw�� ���� ������ ������ ���� ����� ����

		RequestDispatcher rd = req.getRequestDispatcher("jsp/scopeTest.jsp");
		rd.forward(req, response);
	}
}
