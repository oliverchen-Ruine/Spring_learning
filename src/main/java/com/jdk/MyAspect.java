package com.jdk;

/**
 * @version 0.1
 * @Author: oliver chen
 * @Description: 切面类
 * @Date:Create：in 2021/3/13 9:27
 * @Modified By：
 */
public class MyAspect {
    public void myBefore(){
        System.out.println("方法执行之前");//可以是事务逻辑
    }
    public void myAfter(){
        System.out.println("方法执行之后");//可以是日志逻辑
    }
}
