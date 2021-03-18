package com.factorybean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @version 0.1
 * @Author: oliver chen
 * @Description:
 * @Date:Create：in 2021/3/15 16:01
 * @Modified By：
 */
public class MyAspect implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        //可以是验证用户权限等事务方法
        System.out.println("方法执行前");
        //目标方法
        Object object = methodInvocation.proceed();
        //可以是日志类方法
        System.out.println("方法执行后");
        return object;
    }
}
