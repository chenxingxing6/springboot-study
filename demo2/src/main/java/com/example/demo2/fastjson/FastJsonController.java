package com.example.demo2.fastjson;

import com.example.demo2.aop.MyLog;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author lanxinghua
 * @date 2018/08/29 19:57
 * @description
 */
@RestController
@RequestMapping("/fast_json")
public class FastJsonController {
    @RequestMapping("/test")
    @CrossOrigin(origins = "http://localhost:8088")
    @MyLog("调用fastJson/test方法")
    public User test() {
        User user = new User();
        user.setId(1);
        user.setUsername("jack");
        user.setPassword("jack123");
        user.setBirthday(new Date());
        return user;
    }
}