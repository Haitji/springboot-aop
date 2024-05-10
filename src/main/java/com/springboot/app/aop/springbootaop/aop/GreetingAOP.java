package com.springboot.app.aop.springbootaop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class GreetingAOP {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //de esta manera podemos reutirizar el PointCut si se repite mucho
    @Pointcut("execution(* com.springboot.app.aop.springbootaop.service.GreetingService.*(..))")
    private void greetingLoggerPointcut(){};

    @Before("greetingLoggerPointcut()")
    public void loggerBefore(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("=============before=============");
        logger.info("The method {} begin with args {}", method, args);
    }

    @After("execution(String com.springboot.app.aop.springbootaop.service.GreetingService.*(..))")
    public void loggerAfter(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("=============after=============");
        logger.info("The method {} begin with args {}", method, args);
    }

    @AfterReturning("greetingLoggerPointcut()")
    public void loggerAfterReturning(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("=============afterReturning=============");
        logger.info("The method {} begin with args {}", method, args);
    }

    @AfterThrowing("greetingLoggerPointcut()")
    public void loggerAfterThrowing(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("=============afterThrowing=============");
        logger.info("The method {} begin with args {}", method, args);
    }

    @Around("greetingLoggerPointcut()")
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result=null;
        try {
            logger.info("=============around=============");
            logger.info("The method {} begin with args {}", method, args);
            result = joinPoint.proceed();
            logger.info("resultado:"+result);
            return result;
        } catch (Throwable e) {
            logger.error("Error: " + e.getMessage());
            throw e;
        }
    }
}
