package com.gyd.springdemo.aop;

import org.springframework.stereotype.Component;

/**
 * @ClassName MyBean
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/19 21:50
 * @Version 1.0
 */
@Component
public class MyAnnotationBean {

    public String hello(){
        System.out.println("我的业务逻辑1111。。。Hello");
        return "Hello";
    }
}
