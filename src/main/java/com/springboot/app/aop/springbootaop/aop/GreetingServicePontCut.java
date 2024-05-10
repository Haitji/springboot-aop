package com.springboot.app.aop.springbootaop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePontCut {
    
    //Hemos desacoplado el pointcut de la clase greetingaop
    @Pointcut("execution(* com.springboot.app.aop.springbootaop.service.GreetingService.*(..))")
    public void greetingLoggerPointcut(){};
}
