package com.cglib;

import com.CustomerDaoImp;
import com.GoodsDao;
import com.dao.CustomerDao;
import com.jdk.MyAspect;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @version 0.1
 * @Author: oliver chen
 * @Description:
 * @Date:Create：in 2021/3/15 14:30
 * @Modified By：
 */
public class MyBeanFactory {
    public static GoodsDao getBean(){
        //准备目标类
        final GoodsDao goodsDao= new GoodsDao();
        //final CustomerDaoImp customerDaoImp = new CustomerDaoImp();
        //创建切面
        final MyAspect myAspect= new MyAspect();
        //创建代理类，在CGLIB运行时，生成指定对象子类，增强
        Enhancer enhancer = new Enhancer();
        //确定需要增强的类,指定父类（可继承，不能为final类）
        enhancer.setSuperclass(goodsDao.getClass());
        //enhancer.setSuperclass(customerDaoImp.getClass());
        //添加回调函数
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                myAspect.myBefore();
                Object o1 = method.invoke(goodsDao,objects);//执行目标方法
                //Object o1 = method.invoke(customerDaoImp,objects);
                myAspect.myAfter();
                return o1;
            }
        });
        //创建代理类
        GoodsDao goodsDaoProxy = (GoodsDao) enhancer.create();
        return goodsDaoProxy;
//        CustomerDao customerDaoProxy = (CustomerDaoImp) enhancer.create();
//        return customerDaoProxy;
    }
}
