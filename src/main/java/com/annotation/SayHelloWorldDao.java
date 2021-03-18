package com.annotation;

import com.dao.SayHello;
import org.springframework.stereotype.Repository;

/**
 * @version 0.1
 * @Author: oliver chen
 * @Description: DAO层通过注解方式实现bean装配
 * @Date:Create：in 2021/3/11 20:03
 * @Modified By：
 */
@Repository("sayHelloWorldDao")
public class SayHelloWorldDao implements SayHello  {

    @Override
    public void say() {
        System.out.println("Dao层方法执行");
    }
}
