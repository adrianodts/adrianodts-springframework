package com.adrianodts.springframework.xmlconfiguration;

public class PortugueseService implements FactoryService {
    
    @Override
    public String getMessage() {
        return "Olá! Estou muito feliz em te ver";
    }
}
