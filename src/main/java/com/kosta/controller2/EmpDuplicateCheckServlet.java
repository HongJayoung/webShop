package com.kosta.controller2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dto.EmpVO;
import com.kosta.model.EmpService;

@WebServlet("/emp/duplicateCheck.do")
public class EmpDuplicateCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s_empid = request.getParameter("empid");
		if(s_empid==null) return;
		
		int empid = Integer.parseInt(s_empid);
		
		//DB에 직원 id가 존재하는지 체크
		EmpService service = new EmpService();
		EmpVO emp = service.selectById(empid);

		PrintWriter out = response.getWriter();
		out.print(emp==null?0:1);
	}
}
