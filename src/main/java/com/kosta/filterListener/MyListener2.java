package com.kosta.filterListener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MyListener2 implements HttpSessionAttributeListener {

    public MyListener2() {
    	System.out.println("MyListener2 implements HttpSessionAttributeListener ������");
    }

    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	System.out.println("MyListener2 implements HttpSessionAttributeListener �߰��Ҷ�");
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	System.out.println("MyListener2 implements HttpSessionAttributeListener ���ﶧ");
    }

    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	System.out.println("MyListener2 implements HttpSessionAttributeListener �ٲ܋�");
    }
}
 