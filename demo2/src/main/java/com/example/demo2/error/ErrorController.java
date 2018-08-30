package com.example.demo2.error;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lanxinghua
 * @date 2018/08/29 22:43
 * @description 参数全局异常捕获
 */
@RestController
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/test")
    public void error(){
        int i = 1/0;
    }
}