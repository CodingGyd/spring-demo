package com.gyd.springdemo.spi;

import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @ClassName TestMain
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/16 9:11
 * @Version 1.0
 */
public class TestSpringMain {
    public static void main(String[] args) {
        List<MySpi> helloSpiList = SpringFactoriesLoader.loadFactories(MySpi.class,TestSpringMain.class.getClassLoader());
        Iterator<MySpi> iterator = helloSpiList.iterator();
        while (iterator.hasNext()) {
            MySpi next = iterator.next();
            System.out.println(next.getName() + " 准备执行");
            next.hello();
        }
        System.out.println("执行结束");
    }
}
