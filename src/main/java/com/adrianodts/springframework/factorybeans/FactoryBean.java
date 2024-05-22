package com.adrianodts.springframework.factorybeans;

public class FactoryBean {
    
    public static HelloWorldService create(Language language) throws Exception {

        if (Language.ENGLISH == language) {
            return new EnglishHelloService();
        } else if (Language.PORTUGUESE == language) {
            return new PortugueseHelloService();
        } else if (Language.SPANISH == language) {
            return new SpanishHelloService();
        }
        throw new Exception("Language does not exists");
    }
}
