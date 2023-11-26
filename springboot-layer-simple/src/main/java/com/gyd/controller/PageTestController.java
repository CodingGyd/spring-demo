package com.gyd.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

/*
 *@Controller：如果当前类所在的包配置了Spring容器包扫描，具有
 *该注解的类，就会作为bean注册到spring容器中，由spring容器创建实例。
 */
@Controller
@RequestMapping("/show/")
public class PageTestController {

    @RequestMapping("findAll")
    public String findAll(Model model) {
        List<String> lists = loadDbData();
        model.addAttribute("list", lists);
        return "main";

    }

    private List<String> loadDbData(){
        //模拟查询db
        return Arrays.asList("1","2","3");
    }
}