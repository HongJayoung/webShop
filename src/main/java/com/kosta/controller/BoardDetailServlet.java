package com.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dto.BoardVO;
import com.kosta.model.BoardService;

/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/board/boardDetail.do")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bno = request.getParameter("bno");
		int i_bno = 0;
		
		if(bno != null) {
			i_bno = Integer.parseInt(bno);
		}
		
		BoardService bservice = new BoardService();
		BoardVO board =  bservice.selectByBno(i_bno);
		request.setAttribute("board", board);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("boardDetail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
