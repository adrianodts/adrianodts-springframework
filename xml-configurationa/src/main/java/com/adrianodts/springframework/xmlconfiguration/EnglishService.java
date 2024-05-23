package com.adrianodts.springframework.xmlconfiguration;

public class EnglishService implements FactoryService{

    @Override
    public String getMessage() {
        return "Hello! I am glad to see you";
    }

}
