package com.example.demo2.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author lanxinghua
 * @date 2018/08/29 21:59
 * @description
 */
@Aspect
@Component
public class AspectDemo {

    @Around("execution(* com.example.demo2.fastjson..*(..))")
    public Object method(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("参数分别为："+arg);
        }
        long start = System.currentTimeMillis();
        Object proceed = pjp.proceed();
        System.out.println("切面耗时："+(System.currentTimeMillis()-start));
        return proceed;
    }

}