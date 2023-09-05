package com.gyd.springdemo.spi;

/**
 * @ClassName MySpiImpl
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/16 9:09
 * @Version 1.0
 */
public class ASpiImpl implements MySpi {
    @Override
    public String getName() {
        return "A";
    }

    @Override
    public void hello() {
        System.out.println(getName() + "执行");
    }
}