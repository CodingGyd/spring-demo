package com.gyd.springdemo.aop;

/**
 * @ClassName MyBean
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/19 21:50
 * @Version 1.0
 */
public class MyBean {

    public String hello(){
        System.out.println("我的业务逻辑。。。Hello");
        return "Hello";
    }
}
