package com.gyd.springdemo.ioc;

import org.springframework.context.Lifecycle;


public class MyLifeCycle implements Lifecycle {
    private volatile boolean running = false;

    @Override
    public void start() {
        running = true;
        System.out.println("我是Lifecycle.start");
    }

    @Override
    public void stop() {
        running = false;
        System.out.println("我是Lifecycle.stop");
    }

    @Override
    public boolean isRunning() {
        System.out.println("我是Lifecycle.isRunning");
        return running;
    }
}
