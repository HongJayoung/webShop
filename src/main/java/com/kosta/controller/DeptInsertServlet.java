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

@WebServlet("/dept/deptInsert.do")
public class DeptInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("deptInsert.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8"); //filter로 처리함
		
		int department_id = Integer.parseInt(request.getParameter("department_id"));
		String department_name = request.getParameter("department_name");
		int manager_id = Integer.parseInt(request.getParameter("manager_id"));
		int location_id = Integer.parseInt(request.getParameter("location_id"));
		
		DeptDTO dept = new DeptDTO(department_id, department_name, manager_id, location_id);
		DeptService service = new DeptService();
		request.setAttribute("msg", service.deptInsert(dept)>0?"부서등록완료":"부서등록실패");
		
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}
