package com.gyd.springboothello.service;

import org.springframework.stereotype.Service;

/**
 * @ClassName TestService
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/28 14:10
 * @Version 1.0
 */
@Service
public class TestService {
    public String query(){
        System.out.println("query()....");
        return "data";
    }
}
