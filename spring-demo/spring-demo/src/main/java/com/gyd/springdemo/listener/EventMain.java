package com.gyd.springdemo.listener;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName EventMain
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/22 11:01
 * @Version 1.0
 */
public class EventMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        // 注册自定义事件监听器
        context.register(MyListener.class);
        // 启动上下文
        context.refresh();
        // 发布事件，事件源为Context
        context.publishEvent(new MyEvent(context));
        // 结束
        context.close();
    }
}
