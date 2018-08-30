package com.example.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author lanxinghua
 * @date 2018/08/29 19:49
 * @description
 */
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @RequestMapping("/index")
    public String index(Map map){
        map.put("msg", "Thymeleaf Page");
        return "index";
    }
}