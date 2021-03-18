package com.oliver;

import com.annotation.SayHelloWorldAction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;

/**
 * @version 0.1
 * @Author: oliver chen
 * @Description: xml装配Bean
 * @Date:Create：in 2021/3/11 19:29
 * @Modified By：
 */
public class BeanCreatTest {
    @Test
    public void xmlCreatBean(){
        String xmlPath = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        System.out.println(applicationContext.getBean("person1"));
        System.out.println(applicationContext.getBean("person2"));
    }
    @Test
    public void annotationCreatBean(){
        String xmlPath = "applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        SayHelloWorldAction sayHelloWorldAction = (SayHelloWorldAction) applicationContext.getBean("sayHelloWorldAction");
        sayHelloWorldAction.say();
    }
}
