package com.gyd.gydstarterlog;

/**
 * @ClassName MyLogAutoConfig
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/25 16:27
 * @Version 1.0
 */

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties({MyLogProperties.class})
@ConditionalOnProperty(prefix = "gyd.log",
        value = "enabled")
public class MyLogAutoConfig {
    @Bean
    @ConditionalOnMissingBean
    public WebLogAspect webLogAspect(){
        return new WebLogAspect();
    }
}
