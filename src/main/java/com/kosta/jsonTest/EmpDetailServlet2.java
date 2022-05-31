package com.kosta.jsonTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kosta.dto.EmpVO;
import com.kosta.model.EmpService;


@WebServlet("/emp/empDetail2.do")
public class EmpDetailServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s_empid = request.getParameter("empid");
		int empid = 0;
		
		if(s_empid != null) {
			empid = Integer.parseInt(s_empid);
		}
		
		EmpService service = new EmpService();
		EmpVO emp =  service.selectById(empid);
		
		//JSON°´Ã¼ ¸¸µé±â
		JSONObject obj = new JSONObject(); //{}
		obj.put("emp_fname", emp.getFirst_name());
		obj.put("emp_lname", emp.getLast_name());
		
		String jsonstr = obj.toJSONString();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(jsonstr);
	}
}
