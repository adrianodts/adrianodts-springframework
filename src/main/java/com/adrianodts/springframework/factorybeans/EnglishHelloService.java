package com.adrianodts.springframework.factorybeans;

public class EnglishHelloService implements HelloWorldService{

    @Override
    public String sayHello() {
        return "Hello world!";
    }

}
