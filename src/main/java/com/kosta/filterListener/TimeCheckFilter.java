package com.kosta.filterListener;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class TimeCheckFilter implements Filter {

    public TimeCheckFilter() {
    	//System.out.println("TimeCheckFilter 생성");
    }

	public void destroy() {
		//System.out.println("TimeCheckFilter 소멸");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//요청
		long start = System.currentTimeMillis();
		
		chain.doFilter(request, response); //요청을 수행하러 감
		
		//응답
		long end = System.currentTimeMillis();
		//System.out.println("요청 수행하는데 걸린 시간 : " + (end - start) + "ms");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//System.out.println("TimeCheckFilter 초기화");
	}

}
