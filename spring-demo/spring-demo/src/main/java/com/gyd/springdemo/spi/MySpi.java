package com.gyd.springdemo.spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * @ClassName MySpi
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/16 9:08
 * @Version 1.0
 */
@SPI
public interface MySpi {

    String getName();

    void hello();

}