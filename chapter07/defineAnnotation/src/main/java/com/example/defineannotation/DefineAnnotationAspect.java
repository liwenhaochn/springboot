package com.example.defineannotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DefineAnnotationAspect {

    @Pointcut("@annotation(com.example.defineannotation.DefineAnnotation)")
    public void pointcut(){

    }
    @Before("pointcut()")
    public void before(JoinPoint joinPoint) throws Throwable{
        System.out.println("go into before");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        // add by lwh 20211112 这里的红色波浪线可以忽略
        DefineAnnotation defineAnnotation = method.getAnnotation(DefineAnnotation.class);
        System.out.print("DefineAnnotation parameter:" + defineAnnotation.value());
    }
}
