package com.gyd.gydstarteruser;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/25 16:39
 * @Version 1.0
 */
@RestController
public class HelloController {

    @GetMapping("/test")
    public String test(){
        return "SUCCESS";
    }
}
