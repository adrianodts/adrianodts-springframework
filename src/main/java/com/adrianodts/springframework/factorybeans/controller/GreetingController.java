package com.adrianodts.springframework.factorybeans.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrianodts.springframework.factorybeans.service.HelloService;



@RestController
@RequestMapping("api")
public class GreetingController {

    private HelloService helloService;

    public GreetingController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/sayHello")
    public String getMethodName() {
        return this.sayHello();
    }
    
    public String sayHello() {
        String message = helloService.sayHello();
        System.out.println(message);
        return message;
    }

}