package com.gyd.springdemo.listener.listener2;

import com.gyd.springdemo.listener.MyEvent;
import com.gyd.springdemo.listener.MyListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName EventMain
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/22 11:01
 * @Version 1.0
 */
public class EventMain2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        // 注册自定义事件监听器
        context.addApplicationListener(new MyListener2());
        // 启动上下文
        context.refresh();
        // 发布事件，事件源为Context
        context.publishEvent(new MyEvent(context));
        // 结束
        context.close();
    }
}
