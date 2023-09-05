package com.gyd.springdemo.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @ClassName LogAdvice
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/19 21:43
 * @Version 1.0
 */
public class LogAdvice implements MethodBeforeAdvice, AfterReturningAdvice, MethodInterceptor, ThrowsAdvice {


    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        //目标方法后置通知
        System.out.println("afterReturning 目标方法后置通知");
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        //目标方法前置通知
        System.out.println("before 目标方法前置通知");
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        //环绕通知
        //目标方法前置通知
        System.out.println("环绕通知-目标方法前置通知");
        Object resultVal = invocation.proceed();//执行目标方法
        //目标方法后置通知
        System.out.println("环绕通知-目标方法后置通知");
        return resultVal;
    }

}
