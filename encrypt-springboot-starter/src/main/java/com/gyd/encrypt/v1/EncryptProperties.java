package com.gyd.encrypt.v1;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName EncryptProperties
 * @Description TODO
 * @Author guoyading
 * @Date 2023/11/22 15:18
 * @Version 1.0
 */
@ConfigurationProperties(prefix = "spring.encrypt")
public class EncryptProperties {
    private final static String DEFAULT_KEY = "xxxx.gydblog.com";//必须是16位
    private String key = DEFAULT_KEY;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

