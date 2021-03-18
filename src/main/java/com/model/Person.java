package com.model;

/**
 * @version 0.1
 * @Author: oliver chen
 * @Description: JAVABean 组件
 * @Date:Create：in 2021/3/11 19:21
 * @Modified By：
 */
public class Person {
    private String name;
    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public Person(){
        super();
    }
    public Person(String name,int age){
        super();
        this.name=name;
        this.age=age;
    }
    //重写toString方法
    public String toString(){
        return "Name: "+name+", age: "+age;
    }
}
