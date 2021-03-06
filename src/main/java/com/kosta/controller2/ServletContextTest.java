package com.kosta.controller2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextTest
 */
@WebServlet("/ServletContextTest")
public class ServletContextTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ServletContextTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서블릿이 직접 응답
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ServletContext app = getServletContext();
		System.out.println("getContextPath => "+app.getContextPath());
		System.out.println("getMajorVersion => "+app.getMajorVersion());
		System.out.println("getMinorVersion => "+app.getMinorVersion());
		System.out.println("getRealPath => "+app.getRealPath("."));
		System.out.println("getRealPath => "+app.getRealPath("board"));
		
		app.setAttribute("myname", "ja0");
		request.setAttribute("myaddress", "서울시 금천구 가산");
		System.out.println("getAttribute => "+app.getAttribute("myname"));
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/contextTest.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
