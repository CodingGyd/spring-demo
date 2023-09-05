package com.gyd.springdemo.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName AppConfig
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/17 15:29
 * @Version 1.0
 */
@Configuration
public class AppConfig {

    @Bean
    public StudentInfo studentInfo() {
        return new StudentInfo();
    }

    @Bean
    public ClassesInfo classesInfo() {
        return new ClassesInfo();
    }

}
