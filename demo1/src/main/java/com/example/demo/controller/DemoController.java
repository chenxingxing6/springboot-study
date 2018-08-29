package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lanxinghua
 * @date 2018/08/29 15:07
 * @description
 */
@RestController
public class DemoController {
    private static final Logger log = LoggerFactory.getLogger(DemoController.class);
    @Value("${project.name}")
    private String projectName;

    @GetMapping("/hello")
    public String sayhello(){
        log.info("请求了hello");
        return projectName;
    }
}