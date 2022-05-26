package com.kosta.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.dto.BoardVO;
import com.kosta.dto.EmpVO;
import com.kosta.dto.UserVO;
import com.kosta.model.BoardService;
import com.kosta.model.EmpService;

@WebServlet("/emp/emplist.do")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserVO user = (UserVO)session.getAttribute("user");
		if(user == null) {
			System.out.println("로그인X...직원정보 열람불가");
			response.sendRedirect("../html/login.do");
			return;
		}
		
		EmpService service = new EmpService();
		List<EmpVO> list = service.selectAll();
		
		request.setAttribute("emplist", list);
		
		//위임 (요청을 받은것은 servlet, 응답은 jsp가 하도록)
		RequestDispatcher rd = request.getRequestDispatcher("empList.jsp");
		rd.forward(request, response);
	}
}
