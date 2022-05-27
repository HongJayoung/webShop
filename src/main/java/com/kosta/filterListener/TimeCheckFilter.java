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
    	//System.out.println("TimeCheckFilter ����");
    }

	public void destroy() {
		//System.out.println("TimeCheckFilter �Ҹ�");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//��û
		long start = System.currentTimeMillis();
		
		chain.doFilter(request, response); //��û�� �����Ϸ� ��
		
		//����
		long end = System.currentTimeMillis();
		//System.out.println("��û �����ϴµ� �ɸ� �ð� : " + (end - start) + "ms");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//System.out.println("TimeCheckFilter �ʱ�ȭ");
	}

}
