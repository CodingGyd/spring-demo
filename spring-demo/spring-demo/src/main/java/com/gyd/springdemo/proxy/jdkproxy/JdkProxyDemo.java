package com.gyd.springdemo.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName JdkProxyDemo
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/19 15:40
 * @Version 1.0
 */
public class JdkProxyDemo implements InvocationHandler {

    private TargetObject targetObject;

    public JdkProxyDemo(TargetObject targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before 前置增强处理");
        Object result = null;
        try {
            result = method.invoke(targetObject, args);
        }catch (Exception ex) {
            System.out.println("ex: " + ex.getMessage());
            throw ex;
        }finally {
            System.out.println("after 后置增强处理");
        }
        return result;
    }
}
