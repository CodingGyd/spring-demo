package com.gyd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gyd.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

// 1、Dao 层 Mapper 接口，继承 mp 的 BaseMapper<T> 后，无需编写 mapper.xml 文件，即可获得CRUD功能
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
    @Select("SELECT distinct first_name from user_info")
    public List<String> findAllFirstName();
}