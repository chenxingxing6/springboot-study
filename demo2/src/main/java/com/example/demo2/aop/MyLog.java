package com.example.demo2.aop;

import java.lang.annotation.*;

/**
 * @author lanxinghua
 * @date 2018/08/29 22:06
 * @description
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLog {
    String value() default "";
}
