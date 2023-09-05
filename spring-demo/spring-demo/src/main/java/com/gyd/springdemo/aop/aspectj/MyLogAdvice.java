package com.gyd.springdemo.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @ClassName MyLogAdvice
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/19 22:03
 * @Version 1.0
 */
public class MyLogAdvice {
    //前置通知
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("========== 【Aspectj前置通知】 ==========");
    }

    //后置通知：方法正常执行后，有返回值，执行该后置通知：如果该方法执行出现异常，则不执行该后置通知
    public void afterReturningAdvice(JoinPoint joinPoint,Object returnVal){
        System.out.println("========== 【Aspectj返回值以后的后置通知】 ==========");
    }
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("========== 【Aspectj后置通知】 ==========");
    }

    //环绕通知
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("##########【环绕通知中的前置通知】##########");
        Object returnVale = joinPoint.proceed();
        System.out.println("##########【环绕通知中的后置通知】##########");
        return returnVale;
    }

    /**
     * 异常通知：方法出现异常时，执行该通知
     */
    public void throwAdvice(JoinPoint joinPoint, Exception ex){
        System.out.println("出现异常：" + ex.getMessage());
    }

}