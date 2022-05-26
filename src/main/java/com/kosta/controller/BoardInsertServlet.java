package com.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dto.BoardVO;
import com.kosta.model.BoardService;

@WebServlet("/board/boardInsert.do")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	//입력form 보여주기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ServletContext에 저장된 정보 얻기
		ServletContext app = getServletContext();
		String my = (String)app.getAttribute("myname");
		System.out.println("app에 저장된 정보 : "+my);
		
		RequestDispatcher rd = request.getRequestDispatcher("boardInsert.jsp");
		rd.forward(request, response);
	}

	//입력된 data DB에 저장
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int writer = Integer.parseInt(request.getParameter("writer"));
		
		BoardVO board = new BoardVO(0, title, content, writer, null, null);
		BoardService service = new BoardService();
		int result = service.newBoard(board);
		
		//Redirect : 주소창을 바꾼다
		//forward : 주소창을 바꾸지 않는다. 요청과 응답이 다른문서
		response.sendRedirect("boardlist.do");
		
		/*
		String msg = "등록실패";
		if(result > 0) msg = "등록성공";
		request.setAttribute("msg", msg);
		
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
		*/
	}

}
