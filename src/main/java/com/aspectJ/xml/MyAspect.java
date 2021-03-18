package com.aspectJ.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @version 0.1
 * @Author: oliver chen
 * @Description: XML方式定义切面类中不同的通知方法
 * @Date:Create：in 2021/3/15 17:42
 * @Modified By：
 */
public class MyAspect {
    /**
     * 通过 JoinPoint 参数可以获得目标对象的类名、目标方法名和目标方法参数等
     * @param joinpoint
     */
    //前置通知
    public void myBefore(JoinPoint joinpoint){
        System.out.println("前置通知，目标：");
        System.out.println(joinpoint.getTarget() + "方法名称：");
        System.out.println(joinpoint.getSignature().getName());
    }

    //后置通知
    public void myAfterReturning(JoinPoint joinPoint){
        System.out.println("后置通知，方法名"+joinPoint.getSignature().getName());
    }

    /**
     * 环绕通知必须接收一个类型为 ProceedingJoinPoint 的参数
     * 返回值必须是 Object 类型
     * 必须抛出异常
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    //环绕通知
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        System.out.println("环绕开始");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("环绕结束");
        return object;
    }

    //异常通知
    public void myAfterThrowing(JoinPoint joinPoint,Throwable throwable){
        System.out.println("异常通知：出错了"+throwable.getMessage());
    }

    //最终通知
    public void myAfter(){
        System.out.println("最终通知");
    }
}
