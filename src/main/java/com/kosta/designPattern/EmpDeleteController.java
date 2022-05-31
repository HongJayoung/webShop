package com.kosta.designPattern;

import javax.servlet.http.HttpServletRequest;

import com.kosta.model.EmpService;

public class EmpDeleteController implements Command{

	@Override
	public String execute(HttpServletRequest request) {
		int empid = Integer.parseInt(request.getParameter("emp_id"));
		
		EmpService service = new EmpService();
		request.setAttribute("msg", service.empDelete(empid)>0?"��������":"��������");
		
		return "redirect:emplist.do";
	}

}
