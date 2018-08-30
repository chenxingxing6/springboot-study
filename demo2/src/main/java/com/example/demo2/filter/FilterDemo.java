package com.example.demo2.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author lanxinghua
 * @date 2018/08/29 21:40
 * @description
 */
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filter耗时："+(System.currentTimeMillis()-start));
    }

    @Override
    public void destroy() {
        System.out.println("销毁过滤器");
    }
}