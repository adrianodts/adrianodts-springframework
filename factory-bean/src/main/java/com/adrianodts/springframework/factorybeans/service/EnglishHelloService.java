package com.adrianodts.springframework.factorybeans.service;

public class EnglishHelloService implements HelloService{

    @Override
    public String sayHello() {
        return "Hello world!";
    }

}
