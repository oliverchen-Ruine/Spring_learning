package com.aspectJ.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @version 0.1
 * @Author: oliver chen
 * @Description:  Annotation注解方式定义切面类中不同的通知方法
 * @Date:Create：in 2021/3/15 19:22
 * @Modified By：
 */
public class MyAspect {
    /**
     * 代替<aop:pointcut id="myPointcut" expression="execution( * com.*.*(..))"/>方法
     * 配置切入点，通知最后增强哪些方法
     * 该方法只能为private，没有参数，名称自定义
     */
    @Pointcut("execution( * com.*.*(..))")
    private void myPointcut(){}

    //前置通知
    @Before("myPointcut()")
    public void myBefore(JoinPoint joinpoint){
        System.out.println("前置通知，目标：");
        System.out.println(joinpoint.getTarget() + "方法名称：");
        System.out.println(joinpoint.getSignature().getName());
    }
    //后置通知
    @AfterReturning("myPointcut()")
    public void myAfterReturning(JoinPoint joinPoint){
        System.out.println("后置通知，方法名"+joinPoint.getSignature().getName());
    }

    //环绕通知
    @Around("myPointcut()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        System.out.println("环绕开始");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("环绕结束");
        return object;
    }
    //异常通知
    @AfterThrowing("myPointcut()")
    public void myAfterThrowing(JoinPoint joinPoint,Throwable throwable){
        System.out.println("异常通知：出错了"+throwable.getMessage());
    }

    //最终通知
    @After("myPointcut()")
    public void myAfter(){
        System.out.println("最终通知");
    }
}
