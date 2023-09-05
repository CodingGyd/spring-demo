package com.gyd.springdemo.aop;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Main
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/14 13:44
 * @Version 1.0
 */
public class AopMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        MyAnnotationBean myAnnotationBean = context.getBean("myAnnotationBean", MyAnnotationBean.class);
        myAnnotationBean.hello();
    }
}
