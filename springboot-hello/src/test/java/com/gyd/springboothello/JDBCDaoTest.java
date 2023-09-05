package com.gyd.springboothello;

import com.gyd.springboothello.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * TestService的测试类
 */
@SpringBootTest
public class JDBCDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testAdd(){
        System.out.println(userDao.findAll(1));
    }
}
