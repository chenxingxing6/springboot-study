package com.example.demo2.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author lanxinghua
 * @date 2018/08/29 21:34
 * @description
 */
public class ListenerDemo implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("监听器初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("监听器销毁");
    }
}