package com.springboot.app.aop.springbootaop.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService{

    @Override
    public String sayHello(String person, String phrase) {
        System.out.println(phrase + " " + person);
        
        return phrase + " " + person;
    }

    @Override
    public String sayHello2(String person, String phrase) {
        
        throw new RuntimeException("Error creado");
    }

}
