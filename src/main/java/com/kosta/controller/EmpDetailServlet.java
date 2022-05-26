package com.kosta.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.dto.DeptDTO;
import com.kosta.dto.EmpVO;
import com.kosta.dto.UserVO;
import com.kosta.model.DeptService;
import com.kosta.model.EmpService;
import com.kosta.util.DateUtil;


@WebServlet("/emp/empDetail.do")
public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empid = request.getParameter("empid");
		int i_empid = 0;
		
		if(empid != null) {
			i_empid = Integer.parseInt(empid);
		}
		
		EmpService service = new EmpService();
		EmpVO emp =  service.selectById(i_empid);
		request.setAttribute("emp", emp);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("empDetail.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수정하기
		//request.setCharacterEncoding("utf-8"); //filter로 처리함
		EmpVO emp = makeEmp(request);
		EmpService service = new EmpService();
		int result = service.empUpdate(emp);
		request.setAttribute("msg", result>0?"정보수정성공":"정보수정실패");
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

	private EmpVO makeEmp(HttpServletRequest request) {
		EmpVO emp = new EmpVO();
		int eid = readInt(request,"employee_id");
		Integer mid = readInt(request,"manager_id");
		int did = readInt(request,"department_id");
		double salary = readDouble(request,"salary");
		double pct = readDouble(request,"commission_pct");
		Date hdate = readDate(request,"hire_date");
		
		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone_number");
		String jid = request.getParameter("job_id");
		
		emp.setCommission_pct(pct);
		emp.setDepartment_id(did);
		emp.setEmail(email);
		emp.setEmployee_id(eid);
		emp.setFirst_name(fname);
		emp.setHire_date(hdate);
		emp.setJob_id(jid);
		emp.setLast_name(lname);
		emp.setManager_id(mid);
		emp.setPhone_number(phone);
		emp.setSalary(salary);
		
		return emp;
	}
	
	private int readInt(HttpServletRequest request, String col) {
		int data = Integer.parseInt(request.getParameter(col));
		return data;
	}
	
	private double readDouble(HttpServletRequest request, String col) {
		double data = Double.parseDouble(request.getParameter(col));
		return data;
	}
	
	private Date readDate(HttpServletRequest request, String col) {
		String date = request.getParameter(col);
		return DateUtil.convertToDate(date);
	}
}
