package com.gyd.springdemo.proxy.cglib;

/**
 * @ClassName MyObject
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/19 16:15
 * @Version 1.0
 */
public class MyObject {
    public void hello() {
        try {
            System.out.println("我是目标方法的业务逻辑。。。");
        } catch (Exception e) {
            System.out.println("目标方法执行出现异常，终止");
        }
    }
}
