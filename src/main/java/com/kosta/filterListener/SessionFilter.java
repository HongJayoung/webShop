package com.kosta.filterListener;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.dto.UserVO;

@WebFilter("/*")
public class SessionFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//세션처리
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String path = req.getServletPath();
		HttpSession session = req.getSession();
		
		
		if(!path.equals("/jsp/login.do")) {
			UserVO user = (UserVO)session.getAttribute("user");
			if(user == null) {
				session.setAttribute("reqPath", req.getContextPath() + path);
				
				System.out.println("로그인X...직원정보 열람불가");
				
				//절대경로로 쓰는 것이 바람직
				resp.sendRedirect(req.getContextPath() + "/jsp/login.do"); //주소창 바꾸기(새로운 요청)
				return;
			}
		}else {
			//session.setAttribute("reqPath", req.getContextPath() + "/index.jsp");
		}

		chain.doFilter(request, response);
	}
}
