package com.kosta.controller2;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetCookieTest")
public class GetCookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetCookieTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cs = request.getCookies();
		
		String output = "";
		for(Cookie c:cs) {
			System.out.println("��Ű�̸� : "+c.getName());
			System.out.println("��Ű�� : "+c.getValue());
			
			if(c.getName().equals("cookie_title")) {
				String s = URLDecoder.decode(c.getValue(),"utf-8");
				output +="<h3>"+c.getName()+" => "+s+"</h3>";
			}else {
				output +="<h3>"+c.getName()+" => "+c.getValue()+"</h3>";
			}
		}
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("<h1>Served at : cookie �б⿹��</h1>")
							.append(output);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
