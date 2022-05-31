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

@WebServlet("/emp/emailDuplicateCheck.do")
public class EmailDuplicateCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		//DB�� ���� email�� �����ϴ��� üũ
		EmpService service = new EmpService();
		int count = service.selectByEmail(email);

		PrintWriter out = response.getWriter();
		out.print(count); //0�̸� ��ϰ��� 1�̸� ��ϺҰ�
	}
}
