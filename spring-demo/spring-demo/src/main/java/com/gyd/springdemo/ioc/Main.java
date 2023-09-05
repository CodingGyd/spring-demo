package com.gyd.springdemo.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Main
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/14 13:44
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        MyBean myBean = context.getBean("myBean",MyBean.class);
        // 关闭容器 触发监听事件回调
        context.close();
    }
}
