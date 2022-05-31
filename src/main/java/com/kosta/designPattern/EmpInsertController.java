package com.kosta.designPattern;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import com.kosta.dto.EmpVO;
import com.kosta.model.DeptService;
import com.kosta.model.EmpService;
import com.kosta.util.DateUtil;

public class EmpInsertController implements Command{

	@Override
	public String execute(HttpServletRequest request) {
		String method = request.getMethod();
		String page = null;
		
		if(method.equals("GET")) {
			//�μ���� ��������
			DeptService dservice = new DeptService();
			request.setAttribute("dlist", dservice.selectAll());
			
			//��å��� �ҷ�����
			EmpService eservice = new EmpService();
			request.setAttribute("jlist", eservice.selectAllJob());
			
			//�Ŵ������ �ҷ�����
			request.setAttribute("mgrlist", eservice.selectAllMgr()); 
			
			page="empInsert.jsp";
			
		} else {
			EmpVO emp = makeEmp(request);
			EmpService service = new EmpService();
			request.setAttribute("msg", service.empInsert(emp)>0?"������ϼ���":"������Ͻ���");
			
			page="result.jsp";
		}
		
		return page;
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
