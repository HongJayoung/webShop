package com.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dto.DeptDTO;
import com.kosta.model.DeptService;

@WebServlet("/dept/deptUpdate.do")
public class DeptUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8"); //filter로 처리함
		
		int dept_id = Integer.parseInt(request.getParameter("dept_id"));
		String dept_name = request.getParameter("dept_name");
		int mgr_id = Integer.parseInt(request.getParameter("mgr_id"));
		int loc_id = Integer.parseInt(request.getParameter("loc_id"));
		
		DeptDTO dept = new DeptDTO(dept_id, dept_name, mgr_id, loc_id);
		DeptService service = new DeptService();
		String msg = service.deptUpdate(dept)>0?"수정성공":"수정실패";
		request.setAttribute("msg", msg);
		
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}
