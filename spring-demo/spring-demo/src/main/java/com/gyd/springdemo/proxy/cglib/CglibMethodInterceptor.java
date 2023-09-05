//package com.gyd.springdemo.proxy.cglib;
//
///**
// * @ClassName CglibMethodInterceptor
// * @Description TODO
// * @Author guoyading
// * @Date 2023/8/19 16:19
// * @Version 1.0
// */
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
//
//import java.lang.reflect.Method;
//public class CglibMethodInterceptor implements MethodInterceptor {
//
//    // 需要被代理的对象
//    private Object target;
//
//    public Object getTarget() {
//        return target;
//    }
//
//    public void setTarget(Object target) {
//        this.target = target;
//    }
//
//    /**
//     * 代理目标方法
//     * target 实例代表被代理类对象引用, 初始化 CglibMethodInterceptor 时候被赋值 。但是Cglib不推荐使用这种方式
//     * @param obj    代表Cglib 生成的动态代理类 对象本身
//     * @param method 代理类中被拦截的接口方法 Method 实例
//     * @param args   接口方法参数
//     * @param proxy  用于调用父类真正的业务类方法。可以直接调用被代理类接口方法
//     * @return
//     * @throws Throwable
//     */
//    @Override
//    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//        Object result = null;
//        try {
//            System.out.println("before 前置增强");
//            // 执行目标方法  反射调用被代理类方法，
//            result = proxy.invokeSuper(obj, args);
//            // Object result = method.invoke(target, args);
//            System.out.println("after 后置增强");
//        } catch (Exception e) {
//            System.out.println("返回异常后增强");
//        }
//        return result;
//    }
//}
//
