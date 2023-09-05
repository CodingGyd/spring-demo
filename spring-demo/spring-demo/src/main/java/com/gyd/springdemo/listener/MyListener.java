package com.gyd.springdemo.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyListener
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/22 10:59
 * @Version 1.0
 */
@Component
public class MyListener {

    @EventListener(MyEvent.class)
    public void onEvent(MyEvent event) {
        System.out.println("收到自定义事件：" + event);
    }
}