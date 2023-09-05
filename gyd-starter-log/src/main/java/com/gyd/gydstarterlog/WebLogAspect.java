package com.gyd.gydstarterlog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author liaoxin
 * @create 2022-11-03 20:35
 */
@Aspect
@Component
public class WebLogAspect {
    @Pointcut("execution(* *..*Controller.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        System.out.println("gyd-starter --------doBefore");

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        System.out.println("gyd-starter --------doAfterReturning");
    }
}

