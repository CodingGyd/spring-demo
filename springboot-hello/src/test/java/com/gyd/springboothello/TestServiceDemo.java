package com.gyd.springboothello;

import com.gyd.springboothello.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * TestService的测试类
 */
@SpringBootTest
public class TestServiceDemo {

    @Autowired
    private TestService testService;

    @Test
    public void testAdd(){
        System.out.println(testService.query());
    }
}
