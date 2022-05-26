package com.kosta.filterListener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MyListener2 implements HttpSessionAttributeListener {

    public MyListener2() {
    	System.out.println("MyListener2 implements HttpSessionAttributeListener 생성자");
    }

    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	System.out.println("MyListener2 implements HttpSessionAttributeListener 추가할때");
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	System.out.println("MyListener2 implements HttpSessionAttributeListener 지울때");
    }

    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	System.out.println("MyListener2 implements HttpSessionAttributeListener 바꿀떄");
    }
}
 