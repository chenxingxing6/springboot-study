package com.example.demo2.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lanxinghua
 * @date 2018/08/29 22:40
 * @description 全局异常捕获器
 */
@ControllerAdvice
public class GlobalException {
    /**
     * Exception 异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> defaultExceptionHandler(Exception e){
        Map<String, Object> map = new HashMap<>();
        map.put("code", 500);
        map.put("msg", e.getMessage());
        return map;
    }
}