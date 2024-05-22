package com.adrianodts.springframework.factorybeans.service;

public class PortugueseHelloService implements HelloService{

    @Override
    public String sayHello() {
        return "Olá mundo!";
    }

}
