package com.example.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lanxinghua
 * @date 2018/08/30 10:09
 * @description
 */
@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping("/cors")
    public String corsPage(){
        return "cors";
    }

    @RequestMapping("/websocket")
    public String websocketPage(){
        return "websocket";
    }
}