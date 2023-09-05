//package com.gyd.springdemo.ioc;
//
//import org.springframework.context.SmartLifecycle;
//
///**
// * @ClassName CustomizeSmartLifecycle
// * @Description TODO
// * @Author guoyading
// * @Date 2023/8/15 16:08
// * @Version 1.0
// */
//public class CustomizeSmartLifecycle implements SmartLifecycle {
//    @Override
//    public void start() {
//        System.out.println("SmartLifecycle.start");
//    }
//
//    @Override
//    public void stop() {
//        System.out.println("SmartLifecycle.stop");
//    }
//
//    @Override
//    public boolean isRunning() {
//        System.out.println("SmartLifecycle.isRunning");
//        return false;
//    }
//
//    @Override
//    public boolean isAutoStartup() {
//        System.out.println("SmartLifecycle.isAutoStartup");
//        return SmartLifecycle.super.isAutoStartup();
//    }
//
//    @Override
//    public void stop(Runnable callback) {
//        System.out.println("SmartLifecycle.stop(callback)");
//        SmartLifecycle.super.stop(callback);
//    }
//
//    @Override
//    public int getPhase() {
//        System.out.println("SmartLifecycle.getPhase");
//        return SmartLifecycle.super.getPhase();
//    }
//}
