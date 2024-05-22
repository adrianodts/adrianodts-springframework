package com.adrianodts.springframework.factorybeans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class FactoryConfig {
    
    @Value("${language.mnemonic}")
    private String languageMnemonic; 

    @Bean
    @Primary
    public HelloWorldService englishHelloService() throws Exception {
        return FactoryBean.create(getLanguage());
        
    }
    
    @Bean
    @Qualifier //("portugueseHelloService")
    public HelloWorldService portugueseHelloService() throws Exception {
        return FactoryBean.create(getLanguage());
    }

    @Bean
    @Qualifier //("spanishHelloService")
    public HelloWorldService spanishHelloService() throws Exception {
        return FactoryBean.create(getLanguage());
    }

    private Language getLanguage() throws Exception {
       return Language.of(languageMnemonic);
    }
}
