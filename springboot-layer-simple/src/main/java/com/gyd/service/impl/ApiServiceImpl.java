package com.gyd.service.impl;

import com.gyd.service.ApiService;
import org.springframework.stereotype.Service;


@Service
public class ApiServiceImpl implements ApiService {
//    @Resource
//    private ApiMapper mapper;

    @Override
    public boolean save(String data) {
        //mapper.insert
        System.out.println("save ...");
        return true;
    }
} 
