package com.gyd.controller;

import com.gyd.dto.User;
import com.gyd.encrypt.annotation.Decrypt;
import com.gyd.encrypt.annotation.Encrypt;
import com.gyd.encrypt.v1.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ClassName AES对称加密示例
 * @Description 接口示例
 * @Author guoyading
 * @Date 2023/9/5 9:12
 * @Version 1.0
 */
@RestController
@RequestMapping("/user2")
@Api(tags="用户数据操作相关接口(AES加解密测试)")
public class AESEncryptController {

    @ApiOperation("新增用户接口")
    @PostMapping("/save")
    public User save(@ApiParam @RequestBody @Decrypt User data){
        return data;
    }

    @ApiOperation("查询用户接口")
    @PostMapping("/query")
    @Encrypt
    public RespBean query(){
        User user = new User();
        user.setId(1);
        user.setUsername("张三");

        return RespBean.ok("ok",user);
    }

}
