package com.example.demo2.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.example.demo2.filter.FilterDemo;
import com.example.demo2.interceptor.InterceptorDemo;
import com.example.demo2.listener.ListenerDemo;
import com.example.demo2.servlet.ServletDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lanxinghua
 * @date 2018/08/29 20:02
 * @description
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private InterceptorDemo interceptorDemo;

    //fastJson
    @Bean
    public HttpMessageConverters fastJsoncvt(){
        FastJsonHttpMessageConverter cvt = new FastJsonHttpMessageConverter();
        FastJsonConfig jsonConfig = new FastJsonConfig();
        jsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        cvt.setFastJsonConfig(jsonConfig);
        HttpMessageConverter converter = cvt;
        return new HttpMessageConverters(converter);
    }

    //servlet
    @Bean
    public ServletRegistrationBean regis(){
        return new ServletRegistrationBean(new ServletDemo(),"/servlet_test");
    }

    //Filter
    @Bean
    public FilterRegistrationBean timeFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new FilterDemo());
        List<String> urls = new ArrayList<>();
        urls.add("/*");
        registrationBean.setUrlPatterns(urls);
        return registrationBean;
    }

    //Listener
    @Bean
    public ServletListenerRegistrationBean<ListenerDemo> registrationBean(){
        return new ServletListenerRegistrationBean<>(new ListenerDemo());
    }

    //interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorDemo);
    }

    //cors
    /*@Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/fast_json/**")
                        .allowedOrigins("http://localhost:8088");
            }
        };
    }*/

    //websocket
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }
}