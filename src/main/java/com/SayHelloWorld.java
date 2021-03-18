package com;

import com.dao.SayHello;

/**
 * @version 0.1
 * @Author: oliver chen
 * @Description:
 * @Date:Create：in 2021/3/11 16:43
 * @Modified By：
 */
public class SayHelloWorld implements SayHello {
    @Override
    public void say() {
        System.out.println("Hello World");
    }
}
