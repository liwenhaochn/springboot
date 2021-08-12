package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/*
 * 使成为切面类
 * */
@Aspect
/*
 * 注入Ioc容器
 * */
@Component
public class Aop {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    // 线程局部的变量，用于解决多线程中相同变量的访问冲突问题
    ThreadLocal<Long> tic = new ThreadLocal<>();

    // 定义切点pointcut
    @Pointcut("execution(public * com.example.aop.controller..*.*(..))")
    public void pointcut() {
    }

    // 定义通知advice
    @Before("pointcut()")
    public void dobefore(JoinPoint joinPoint) throws Throwable {
        // eturns the current time in milliseconds. 毫秒
        tic.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
//        这个也不行，request还是为空
//        RequestContextHolder.setRequestAttributes(attributes,true);
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("request:", request.toString());
        logger.info("URL:", request.getRequestURL().toString());
        logger.info("HTTP method:", request.getMethod());
        logger.info("IP address:", request.getRemoteAddr());
        logger.info("Class method: ", joinPoint.getSignature().getDeclaringTypeName()
                + "." + joinPoint.getSignature().getName());
        logger.info("parameters:", request.getQueryString());
    }

    // 定义return后的通知
    @AfterReturning(pointcut = "pointcut()", returning = "returnObject")
    public void doAfterReturning(Object returnObject) throws Throwable {
        logger.info("response:", returnObject);
        logger.info("elapsed time:", System.currentTimeMillis() - tic.get());
    }

    // 定义通知
    @After("pointcut()")
    public void doAfter(JoinPoint joinPoint) throws Throwable {
        logger.info("doAfter elapsed time:", System.currentTimeMillis() - tic.get());
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "exception")
    public void doAfterThrowing(JoinPoint joinPoint, Exception exception) {
        logger.info("exception", exception);
    }

}
