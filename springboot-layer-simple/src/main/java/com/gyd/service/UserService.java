package com.gyd.service;

import com.gyd.dto.UserDto;

import java.util.List;

/**
 * @ClassName ApiService
 * @Description TODO
 * @Author guoyading
 * @Date 2023/9/5 9:12
 * @Version 1.0
 */
public interface UserService {
    boolean save(UserDto request);

    List<String> queryAll();
}
