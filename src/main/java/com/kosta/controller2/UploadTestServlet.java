package com.kosta.controller2;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.util.UploadFileHelper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadTestServlet
 */
@WebServlet("/UploadTestServlet")
public class UploadTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "uploads";
	/**
	MultipartRequest mrequest = new MultipartRequest(
  request       //MultipartRequest를 만들기 위한 request
, saveDirectory //저장 위치 (File객체)
, maxPostSize   //최대크기 (int)
, encoding      //인코딩 타입 ("utf-8")
, policy        //파일 정책 (FileRenamePolicy객체)
); 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dir = request.getServletContext().getRealPath(UPLOAD_DIR);
		System.out.println(dir);
		
		//upload추가
		 Map<String, Object> map = UploadFileHelper.uploadFile(UPLOAD_DIR, request);
		 
		 List<String> photos = (List)map.get("photos");
		 Map<String, String> params = (Map)map.get("params");
		 
		 System.out.println(photos);
		 for(String key:params.keySet()) {
			 System.out.println(key+" => "+params.get(key));
		 }
		 //DB에 insert하는 작업
	}

}
