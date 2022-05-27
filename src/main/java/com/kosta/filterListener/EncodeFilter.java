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

//@WebFilter("/*") //모든 요청에 대해
//@WebFilter("*.do")
public class EncodeFilter implements Filter {

    public EncodeFilter() {
        //System.out.println("EncodeFilter 생성");
    }

	public void destroy() {
		//System.out.println("EncodeFilter 소멸");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");

		HttpServletRequest req = (HttpServletRequest)request;
		
		
		//System.out.println("-----encode filter-----");
		//System.out.println("getContextPath => "+req.getContextPath());
		//System.out.println("getRequestURL => "+req.getRequestURL());
		//System.out.println("getRequestURI => "+req.getRequestURI());
		//System.out.println("getServletPath => "+req.getServletPath());
		//System.out.println("getServerPort => "+req.getServerPort());
		
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//System.out.println("EncodeFilter 초기화");
	}
}