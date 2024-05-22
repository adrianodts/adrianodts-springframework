package com.adrianodts.springframework.factorybeans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api")
public class GreetingController {

    private HelloWorldService helloWorldService;

    @Autowired
    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping("/sayHello")
    public String getMethodName() {
        return this.sayHello();
    }
    
    public String sayHello() {
        String message = helloWorldService.sayHello();
        System.out.println(message);
        return message;
    }

}