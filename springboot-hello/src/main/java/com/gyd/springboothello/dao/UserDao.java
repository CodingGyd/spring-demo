//package com.gyd.springboothello.dao;
//
//import com.gyd.springboothello.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Isolation;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
// * @ClassName MyDao
// * @Description TODO
// * @Author guoyading
// * @Date 2023/8/21 9:45
// * @Version 1.0
// */
//@Repository
//public class UserDao {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//    public List<User> findAll(Integer id) {
//        System.out.println("UserDaoImpl findAll");
//        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
//        //将id绑定到SQL语句中，并通过RowMapper返回list
//        return jdbcTemplate.query("select id,name,age from user where id = ?", rowMapper,id);
//    }
//
//
//    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
//    public void update(User user) {
//        System.out.println("UserDaoImpl update");
//        jdbcTemplate.update("update user set name= ?,age = ? where id = ?",user.getName(),user.getAge(),user.getId());
//    }
//
//    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
//    public void insert(User user) {
//        System.out.println("UserDaoImpl insert");
//        jdbcTemplate.update("insert into user(id,name,age) values(?,?,?)",user.getId(),user.getName(),user.getAge());
//    }
//}
