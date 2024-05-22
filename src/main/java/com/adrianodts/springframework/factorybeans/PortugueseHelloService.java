package com.adrianodts.springframework.factorybeans;

public class PortugueseHelloService implements HelloWorldService{

    @Override
    public String sayHello() {
        return "Olá mundo!";
    }

}
