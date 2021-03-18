package com.annotation;

import com.dao.SayHello;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @version 0.1
 * @Author: oliver chen
 * @Description: Service层通过注解方式实现bean装配
 * @Date:Create：in 2021/3/11 20:11
 * @Modified By：
 */
@Service("sayHelloWorldService")
public class SayHelloWorldService implements SayHello {
    @Resource(name = "sayHelloWorldDao")
    private SayHelloWorldDao sayHelloWorldDao;

    @Override
    public void say() {
        sayHelloWorldDao.say();
        System.out.println("service层调用");
    }


    public SayHelloWorldDao getSayHelloWorldDao() {
        return sayHelloWorldDao;
    }

    public void setSayHelloWorldDao(SayHelloWorldDao sayHelloWorldDao) {
        this.sayHelloWorldDao = sayHelloWorldDao;
    }
}
