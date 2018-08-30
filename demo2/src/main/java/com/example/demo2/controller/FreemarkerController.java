package com.example.demo2.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author lanxinghua
 * @date 2018/08/29 19:30
 * @description
 */
@Api(value = "swagger2测试", tags = {"测试接口"})
@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

    @RequestMapping("/index")
    public String index(Map map){
        map.put("msg", "freemarker page");
        return "index";
    }
}