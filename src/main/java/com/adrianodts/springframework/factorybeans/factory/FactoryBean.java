package com.adrianodts.springframework.factorybeans.factory;

import com.adrianodts.springframework.factorybeans.enumerator.Language;
import com.adrianodts.springframework.factorybeans.service.EnglishHelloService;
import com.adrianodts.springframework.factorybeans.service.HelloService;
import com.adrianodts.springframework.factorybeans.service.PortugueseHelloService;
import com.adrianodts.springframework.factorybeans.service.SpanishHelloService;

public class FactoryBean {
    
    public static HelloService create(Language language) throws Exception {

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
