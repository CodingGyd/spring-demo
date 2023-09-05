package com.gyd.springdemo.ioc;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @ClassName ApplicationContextInitializer
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/15 14:20
 * @Version 1.0
 */
public class TestApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("启动时加载了我...");
    }

    @PostConstruct
    public void test() {
        System.out.println("我是PostConstruct");
    }
}
