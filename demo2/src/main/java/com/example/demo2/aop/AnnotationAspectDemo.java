package com.example.demo2.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author lanxinghua
 * @date 2018/08/29 22:18
 * @description
 */
@Aspect
@Component
public class AnnotationAspectDemo {
    @After("@annotation(com.example.demo2.aop.MyLog)")
    public void after(JoinPoint joinPoint) {
        this.printLog(joinPoint);
    }

    private void printLog(JoinPoint joinPoint) {
        try {
            MyLog myLog = getAnnotationLog(joinPoint);
            if (myLog == null){
                return;
            }
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            String msg = myLog.value();
            System.out.println(">>>>>>>>>>>>>类名:"+className);
            System.out.println(">>>>>>>>>>>>>方法名:"+methodName);
            System.out.println(">>>>>>>>>>>>>日志消息："+msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //如果注解存在，就获取
    private static MyLog getAnnotationLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null) {
            return method.getAnnotation(MyLog.class);
        }
        return null;
    }
}