package com.adrianodts.springframework.factorybeans.service;

public class SpanishHelloService implements HelloService{

    @Override
    public String sayHello() {
        return "Hola mundo!";
    }

}
