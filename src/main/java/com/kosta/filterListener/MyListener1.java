package com.kosta.filterListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener1 implements ServletContextListener {

    public MyListener1() {
        //System.out.println("MyListener1 implements ServletContextListener ������");
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	//System.out.println("MyListener1 implements ServletContextListener �Ҹ�");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	//System.out.println("MyListener1 implements ServletContextListener �ʱ�ȭ");
    }
	
}
