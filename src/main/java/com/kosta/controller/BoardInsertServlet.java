package com.kosta.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dto.BoardVO;
import com.kosta.model.BoardService;
import com.kosta.util.UploadFileHelper;

@WebServlet("/board/boardInsert.do")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	//�Է�form �����ֱ�
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ServletContext�� ����� ���� ���
		ServletContext app = getServletContext();
		String my = (String)app.getAttribute("myname");
		System.out.println("app�� ����� ���� : "+my);
		
		RequestDispatcher rd = request.getRequestDispatcher("boardInsert.jsp");
		rd.forward(request, response);
	}

	//�Էµ� data DB�� ����
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8"); //filter�� ó����
		
		//String title = request.getParameter("title");
		//String content = request.getParameter("content");
		//int writer = Integer.parseInt(request.getParameter("writer"));
		
		//BoardVO board = new BoardVO(0, title, content, writer, null, null);
		
		Map<String, Object> map = (Map<String, Object>)UploadFileHelper.uploadFile("uploads", request);
		List<String> fileNames = (List<String>)map.get("photos");
		Map<String, String> mapParam = (Map<String, String>)map.get("params");
		String pic = fileNames.get(0);
		BoardVO board = new BoardVO();
		
		for(String key:mapParam.keySet()) {
			if(key.equals("title")) board.setTitle(mapParam.get(key));
			if(key.equals("content")) board.setContent(mapParam.get(key));
			if(key.equals("writer")) board.setWriter(Integer.parseInt(mapParam.get(key)));
		}
		
		board.setPic(pic);

		//System.out.println(board);
		
		BoardService service = new BoardService();
		int result = service.newBoard(board);
		
		//Redirect : �ּ�â�� �ٲ۴�
		//forward : �ּ�â�� �ٲ��� �ʴ´�. ��û�� ������ �ٸ�����
		response.sendRedirect("boardlist.do");
		
		/*
		String msg = "��Ͻ���";
		if(result > 0) msg = "��ϼ���";
		request.setAttribute("msg", msg);
		
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
		*/
	}

}
