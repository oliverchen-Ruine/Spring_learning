package com.jdk;

import com.CustomerDaoImp;
import com.dao.CustomerDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @version 0.1
 * @Author: oliver chen
 * @Description: 实现JDK动态代理
 * @Date:Create：in 2021/3/13 9:30
 * @Modified By：
 */
public class MyBeanFactory {
    public static CustomerDao getBean(){
        //准备目标类
        final CustomerDao customerDao = new CustomerDaoImp();
        //创建切面类
        final MyAspect myAspect = new MyAspect();
        //使用代理
        return (CustomerDao) Proxy.newProxyInstance(
                MyBeanFactory.class.getClassLoader(), new Class[]{CustomerDao.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        myAspect.myBefore();//前增强
                        Object object = method.invoke(customerDao,args);
                        myAspect.myAfter();//后增强
                        return object;
                    }
                }
        );
    }
}
