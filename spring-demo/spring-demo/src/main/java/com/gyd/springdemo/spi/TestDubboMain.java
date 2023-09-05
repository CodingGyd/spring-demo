package com.gyd.springdemo.spi;

import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * @ClassName TestDubboMain
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/16 11:12
 * @Version 1.0
 */
public class TestDubboMain {
    public static void main(String[] args) {
        ExtensionLoader<MySpi> extensionLoader =
                ExtensionLoader.getExtensionLoader(MySpi.class);
        MySpi a = extensionLoader.getExtension("a");
        a.hello();
        MySpi b = extensionLoader.getExtension("b");
        b.hello();
    }
}
