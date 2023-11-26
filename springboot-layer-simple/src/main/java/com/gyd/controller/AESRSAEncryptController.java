package com.gyd.controller;

import com.gyd.dto.CheckInfo;
import com.gyd.dto.User;
import com.gyd.encrypt.annotation.Decrypt;
import com.gyd.encrypt.annotation.MixedEncrypt;
import com.gyd.encrypt.v2.RSAUtils;
import com.gyd.encrypt.v2.ResultWrapper;
import io.netty.handler.codec.base64.Base64Decoder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;


@RestController
@RequestMapping("/user3")
@Api(tags="用户数据操作相关接口(AES+RSA混合加解密测试)")
public class AESRSAEncryptController {

    @ApiOperation("新增用户接口")
    @PostMapping("/save")
    public User save(@ApiParam @RequestBody @Decrypt User data){
        return data;
    }

    @ApiOperation("查询用户接口")
    @PostMapping("/query")
    @MixedEncrypt
    public ResultWrapper<User> query(){
        User user = new User();
        user.setId(1);
        user.setUsername("张三");

        return ResultWrapper.SUCCESS(user);
    }

    @ApiOperation("查询用户接口")
    @PostMapping("/query2")
    public ResultWrapper<User> query2(){
        User user = new User();
        user.setId(1);
        user.setUsername("张三");

        return ResultWrapper.SUCCESS(user);
    }
    @ApiOperation("查询公钥")
    @PostMapping("/queryPublicKey")
    public ResultWrapper<String> getPublicKey(){
        return ResultWrapper.SUCCESS(RSAUtils.getPublicKey());
    }

    @ApiOperation("查询私钥")
    @PostMapping("/queryPrivateKey")
    public ResultWrapper<String> queryPrivateKey(){
        return ResultWrapper.SUCCESS(RSAUtils.getPrivateKey());
    }

    @ApiOperation("验签")
    @PostMapping("/check")
    public ResultWrapper<Boolean> check(@RequestBody CheckInfo checkInfo) throws Exception {
        boolean a = RSAUtils.verify(checkInfo.getData().getBytes(),RSAUtils.getPublicKey(), checkInfo.getSign());
        return ResultWrapper.SUCCESS(a);
    }

    @ApiOperation("公钥解密")
    @PostMapping("/depByPublicKey")
    public ResultWrapper<String> depByPublicKey(@RequestBody CheckInfo checkInfo) throws Exception {
        return ResultWrapper.SUCCESS(Base64.encodeBase64String(RSAUtils.decryptByPublicKey(Base64.decodeBase64(checkInfo.getSign()),RSAUtils.getPublicKey())));
    }
}
