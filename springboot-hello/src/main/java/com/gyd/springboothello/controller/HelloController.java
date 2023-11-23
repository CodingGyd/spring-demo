package com.gyd.springboothello.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @RequestMapping("query")
    public String findAll() {
       return "hello docker!";
    }

}