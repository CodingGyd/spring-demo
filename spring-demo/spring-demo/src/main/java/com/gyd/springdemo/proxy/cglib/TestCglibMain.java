//package com.gyd.springdemo.proxy.cglib;
//
//import net.sf.cglib.proxy.Enhancer;
//
///**
// * @ClassName TestCglibMain
// * @Description TODO
// * @Author guoyading
// * @Date 2023/8/19 16:23
// * @Version 1.0
// */
//public class TestCglibMain {
//    public static void main(String[] args) throws Exception {
//        // 增强类
//        CglibMethodInterceptor cglibMethodInterceptor = new CglibMethodInterceptor();
//        // 需被代理的对象
//        MyObject myObject = new MyObject();
//        // 把真实对象放入增强类中，隐藏起来
//        cglibMethodInterceptor.setTarget(myObject);
//
//        // 创建Enhancer，用来创建动态代理类
//        Enhancer enhancer = new Enhancer();
//        // 为代理类指定需要代理的类
//        enhancer.setSuperclass(cglibMethodInterceptor.getTarget().getClass());
//        // 设置调用代理类会触发的增强类
//        enhancer.setCallback(cglibMethodInterceptor);
//
//        // 获取动态代理类对象并返回
//        MyObject proxy = (MyObject) enhancer.create();
//
//        // 调用代理类的方法
//        proxy.hello();
//    }
//
//}
