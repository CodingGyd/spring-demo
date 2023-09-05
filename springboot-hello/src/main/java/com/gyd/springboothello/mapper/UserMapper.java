package com.gyd.springboothello.mapper;

import com.gyd.springboothello.entity.User;

import java.util.List;

/**
 * @ClassName UserMapper.xml
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/28 14:44
 * @Version 1.0
 */
public class UserMapper {
    public interface UserMapping {
        List<User> findAll();
    }
}
