package com.gyd.springdemo.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @ClassName TestMain
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/19 15:39
 * @Version 1.0
 */
public class TestMain {
    public static void main(String[] args) {
        //获取InvocationHandler对象 在构造方法中注入目标对象
        InvocationHandler handler = new JdkProxyDemo(new TargetObjectImpl());

        //获取代理类对象
        TargetObject proxySubject = (TargetObject) Proxy.newProxyInstance(TestMain.class.getClassLoader(), new Class[]{TargetObject.class}, handler);

        //调用目标方法
        proxySubject.invoke();
    }
}
