package com.oliver;


import com.dao.SayHello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @version 0.1
 * @Author: oliver chen
 * @Description:
 * @Date:Create：in 2021/3/11 16:46
 * @Modified By：
 */
public class Say {
    @Test
    public void say(){
        String xmlPath = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        SayHello sayHello=(SayHello) applicationContext.getBean("test");
        sayHello.say();
        System.out.println(sayHello);
        System.out.println(applicationContext.getBean("test"));

    }

    @Test
    public void show(){
        int n=8;
        if (((n-1)&n)==0){
            System.out.println("YES");
        }
    }
}
