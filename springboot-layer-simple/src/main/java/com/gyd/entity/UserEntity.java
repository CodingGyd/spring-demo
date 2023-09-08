package com.gyd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName UserEntity
 * @Description 表user_info的java实体映射
 * @Author guoyading
 * @Date 2023/9/5 9:14
 * @Version 1.0
 */
@TableName(value = "user_info")
public class UserEntity {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
