package com.adrianodts.springframework.xmlconfiguration;

public class MessageFactory {
    
    public static FactoryService create(String language) {
        FactoryService factoryService = null;
        switch (language) {
            case "en":
                factoryService = new EnglishService();
                break;
            case "pt":
                factoryService = new PortugueseService();
                break;        
            default:
                break;
        }
        return factoryService;

    }
}
