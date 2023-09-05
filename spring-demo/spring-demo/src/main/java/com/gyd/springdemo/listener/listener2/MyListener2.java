package com.gyd.springdemo.listener.listener2;

import com.gyd.springdemo.listener.MyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

public class MyListener2 implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println("收到自定义事件：" + event);
    }
}