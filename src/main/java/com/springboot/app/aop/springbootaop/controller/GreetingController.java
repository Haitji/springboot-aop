package com.springboot.app.aop.springbootaop.controller;

import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.aop.springbootaop.service.GreetingService;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class GreetingController {

    @Autowired
    public GreetingService service;

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting() {

        return ResponseEntity.ok(Collections.singletonMap("greeting",service.sayHello("Manolo", "Hola")));
    }

    @GetMapping("/greeting-error")
    public ResponseEntity<?> greetingError() {

        return ResponseEntity.ok(Collections.singletonMap("greeting",service.sayHello2("Manolo", "Hola")));
    }


}
