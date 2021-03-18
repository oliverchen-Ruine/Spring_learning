package com.annotation;

import com.dao.SayHello;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @version 0.1
 * @Author: oliver chen
 * @Description: Action层通过注解方式实现bean装配
 * @Date:Create：in 2021/3/11 20:15
 * @Modified By：
 */
@Controller("sayHelloWorldAction")
public class SayHelloWorldAction implements SayHello {
    @Resource(name = "sayHelloWorldService")
    private SayHelloWorldService sayHelloWorldService;

    @Override
    public void say() {
        sayHelloWorldService.say();
        System.out.println("Action层调用");

    }

    public SayHelloWorldService getSayHelloWorldService() {
        return sayHelloWorldService;
    }

    public void setSayHelloWorldService(SayHelloWorldService sayHelloWorldService) {
        this.sayHelloWorldService = sayHelloWorldService;
    }
}
