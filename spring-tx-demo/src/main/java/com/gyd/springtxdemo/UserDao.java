package com.gyd.springtxdemo;

import java.util.List;

/**
 * @ClassName MyDao
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/21 9:45
 * @Version 1.0
 */
public interface UserDao {

    List<User> findAll(Integer id);

    void update(User user);

    void insert(User user);

}
