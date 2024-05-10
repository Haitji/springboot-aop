package com.springboot.app.aop.springbootaop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)//El before se ejecutara antes por orden de priolidad, pero el after se ejecutara despues que otros orders como si lo envolvira
@Aspect
public class GreetingAOP2 {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before("execution(* com.springboot.app.aop.springbootaop.service.GreetingService.*(..))")
    public void loggerBefore(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("=============before2=============");
        logger.info("The method {} begin with args {}", method, args);
    }

    @After("execution(String com.springboot.app.aop.springbootaop.service.GreetingService.*(..))")
    public void loggerAfter(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("=============after2=============");
        logger.info("The method {} begin with args {}", method, args);
    }
}
