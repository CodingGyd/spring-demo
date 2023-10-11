package com.gyd.contoller;


import com.gyd.util.RedisUtil;
import com.gyd.websocket.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;


/*
 *@Controller：如果当前类所在的包配置了Spring容器包扫描，具有
 *该注解的类，就会作为bean注册到spring容器中，由spring容器创建实例。
 */
@Controller
@RequestMapping("/show/")
public class WebSocketTestController {

    @Autowired
    private WebSocketService webSocketService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 跳转thymeleaf模板路径
     *
     * @return
     */
    @RequestMapping("/topic")
    public String websocket() {
        return "topic";
    }

    /**
     * 模拟创建订单，发送消息到客户端
     *
     * @return
     */
    @RequestMapping("/createOrder")
    public @ResponseBody String createOrder() {
        webSocketService.sendMessage("你有新的订单，请及时处理========>" + UUID.randomUUID());
        return "新增订单成功!";
    }

    /**
     * 模拟创建订单，通过redis的发布订阅  发送消息到客户端
     *
     * @return
     */
    @RequestMapping("/createOrderAsync")
    public @ResponseBody String createOrderAsync() {
        redisUtil.publish("websocket","订阅：你有新的订单，请及时处理========>" + UUID.randomUUID());
        return "新增订单成功!";
    }
}