package com.gyd.gydstarterlog;

/**
 * @ClassName MyLogProperties
 * @Description TODO
 * @Author guoyading
 * @Date 2023/8/25 16:14
 * @Version 1.0
 */
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "gyd.log")
public class MyLogProperties {
    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}

