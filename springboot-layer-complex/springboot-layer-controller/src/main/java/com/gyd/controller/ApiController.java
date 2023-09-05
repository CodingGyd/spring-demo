package com.gyd.controller;

import com.gyd.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ApiController
 * @Description TODO
 * @Author guoyading
 * @Date 2023/9/5 9:12
 * @Version 1.0
 */

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiService apiService;


    @PostMapping("/insert")
    public boolean save(@RequestBody String data){
        return apiService.save(data);
    }

}
