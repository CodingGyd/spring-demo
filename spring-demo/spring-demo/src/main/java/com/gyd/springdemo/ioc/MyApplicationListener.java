package com.gyd.springdemo.ioc;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyApplicationListener
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/15 19:58
 * @Version 1.0
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

    // 当容器中发布此事件以后，下面这个方法就会被触发
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("收到事件：" + event);
    }
}
