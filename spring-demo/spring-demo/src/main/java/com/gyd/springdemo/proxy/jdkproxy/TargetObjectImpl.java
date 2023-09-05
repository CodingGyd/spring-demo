package com.gyd.springdemo.proxy.jdkproxy;

/**
 * @ClassName TargetObject
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/19 15:39
 * @Version 1.0
 */
public class TargetObjectImpl implements TargetObject{

    @Override
    public String invoke(){
        System.out.println("我是目标方法里面的逻辑。。。");
        return "SUCCESS";
    }

}
