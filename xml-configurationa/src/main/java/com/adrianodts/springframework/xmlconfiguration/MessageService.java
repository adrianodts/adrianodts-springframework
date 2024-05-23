package com.adrianodts.springframework.xmlconfiguration;

public class MessageService {

    private FactoryService factoryService;

    public MessageService(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    public void executeService() {
        System.out.println(this.factoryService.getMessage());
    }
    
}
