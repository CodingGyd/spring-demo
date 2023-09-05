package com.gyd.springdemo.listener;

import org.springframework.context.ApplicationEvent;

/**
 * @ClassName MyEvent
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/22 10:59
 * @Version 1.0
 */
public class MyEvent extends ApplicationEvent {

    public MyEvent(Object source) {
        super(source);
    }
}
