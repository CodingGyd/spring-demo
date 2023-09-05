package com.gyd.springdemo.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName EnvironmentTest
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/17 16:23
 * @Version 1.0
 */
public class EnvironmentTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("a");
    }

}
