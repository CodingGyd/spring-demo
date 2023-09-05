package com.gyd.springdemo.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @ClassName TestMain
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/16 9:11
 * @Version 1.0
 */
public class TestMain {
    public static void main(String[] args) {
        ServiceLoader<MySpi> load = ServiceLoader.load(MySpi.class);
        Iterator<MySpi> iterator = load.iterator();
        while (iterator.hasNext()) {
            MySpi next = iterator.next();
            System.out.println(next.getName() + " 准备执行");
            next.hello();
        }
        System.out.println("执行结束");
    }
}
