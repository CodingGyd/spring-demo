package com.gyd.springdemo.spi;

public class BSpiImpl implements MySpi {
    @Override
    public String getName() {
        return "B";
    }

    @Override
    public void hello() {
        System.out.println(getName() + "执行");
    }
}