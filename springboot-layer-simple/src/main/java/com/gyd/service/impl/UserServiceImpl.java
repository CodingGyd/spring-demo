package com.gyd.service.impl;

import com.gyd.dto.UserDto;
import com.gyd.entity.UserEntity;
import com.gyd.mapper.UserMapper;
import com.gyd.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper mapper;

    @Override
    public boolean save(UserDto request) {
        UserEntity entity = new UserEntity();
        entity.setAge(request.getAge());
        entity.setLastName(request.getLastName());
        entity.setFirstName(request.getFirstName());
        mapper.insert(entity);
        System.out.println("插入一条用户数据记录");
        return true;
    }

    @Override
    public List<String> queryAll() {
        return mapper.findAllFirstName();
    }
}
