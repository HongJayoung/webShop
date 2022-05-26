package com.kosta.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.dto.UserVO;
import com.kosta.model.UserService;

@WebServlet("/html/login.do") 
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher("loginForm.html");
		rd.forward(request, response);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get요청의 경우 주소창에 파라메터가 자동으로 인코딩되어 넘어옴 => 한글깨짐 없음
		//post요청은 요청문서의 body에 파라메터가 인코딩이 안되어 넘어옴 => 한글깨짐
		request.setCharacterEncoding("utf-8"); //post에서만 필요
		
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		
		UserService service = new UserService();
		UserVO user = service.selectById(id, pw);
		
		//Session에 저장 : 다른페이지에서 상태를 알기위해 (로그인 여부 확인하고 처리하기 위해)
		//쿠키 : 브라우저에 정보를 저장 
		//세션 : 정보는 서버에 저장, 브라우저에 session id저장
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		if(user == null) {
			//로그인 실패 시 다시 로그인하도록
			response.sendRedirect("login.do"); //get방식으로 감
		}else {
			response.sendRedirect("../emp/emplist.do");
		}
		
		/*
		String email = request.getParameter("user_email");
		String address = request.getParameter("user_address");
		
		System.out.println(id);
		System.out.println(pw);
		System.out.println(email);
		System.out.println(address);
		System.out.println(request.getMethod());
		System.out.println(request.getContextPath());
		

		//응답문서의 타입과 인코딩 방식을 응답문서를 만들기 전에 설정
		response.setContentType("text/html;charset=utf-8");
		
		//응답문서만들기(직접 HTML을 만들기때문에 별로 좋은 코드는 아님) 
		PrintWriter out = response.getWriter();
		out.write("<h1>로그인 성공</h1>");
		out.write("<h2>DB접속 후 다시 수정하기</h2>");
		
		//Servlet이 실행결과를 JSP에 위임. 주소창은 변경되지않음.
		RequestDispatcher rd = request.getRequestDispatcher("../jsp/loginResult.jsp");
		rd.forward(request, response);
		 */
	}
}
