package com.gyd.springdemo.ioc;

import org.springframework.core.convert.converter.Converter;

/**
 * @ClassName DateConvert
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/15 14:31
 * @Version 1.0
 */
public class DateConvert implements Converter<Integer,String> {
    @Override
    public String convert(Integer source) {
        return null;
    }
}
