package com.gyd.encrypt.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName Decrypt
 * @Description TODO
 * @Author guoyading
 * @Date 2023/11/22 15:17
 * @Version 1.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Encrypt {
}
