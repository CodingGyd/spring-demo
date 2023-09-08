package com.gyd.contoller;

import com.gyd.dto.UserDto;
import com.gyd.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UserController
 * @Description 接口示例
 * @Author guoyading
 * @Date 2023/9/5 9:12
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@Api(tags="用户数据操作相关接口")
public class UserController {

    @Autowired
    private UserService service;

    @ApiOperation("新增用户接口")
    @PostMapping("/save")
    public boolean save(@ApiParam @RequestBody UserDto data){
        return service.save(data);
    }

    @ApiOperation("查询用户列表接口")
    @PostMapping("/queryAll")
    public List<String> query(){
        return service.queryAll();
    }

}
