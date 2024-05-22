package com.adrianodts.springframework.factorybeans;

public class SpanishHelloService implements HelloWorldService{

    @Override
    public String sayHello() {
        return "Hola mundo!";
    }

}
