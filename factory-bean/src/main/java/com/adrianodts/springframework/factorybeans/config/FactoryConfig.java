package com.adrianodts.springframework.factorybeans.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.adrianodts.springframework.factorybeans.enumerator.Language;
import com.adrianodts.springframework.factorybeans.factory.FactoryBean;
import com.adrianodts.springframework.factorybeans.service.HelloService;

@Configuration
public class FactoryConfig {
    
    @Value("${language.mnemonic}")
    private String languageMnemonic; 

    @Bean
    @Primary
    public HelloService englishHelloService() throws Exception {
        return FactoryBean.create(getLanguage());
        
    }
    
    @Bean(name = "portugueseHelloService")
    public HelloService portugueseHelloService() throws Exception {
        return FactoryBean.create(getLanguage());
    }

    @Bean(name = "spanishHelloService")
    public HelloService spanishHelloService() throws Exception {
        return FactoryBean.create(getLanguage());
    }

    private Language getLanguage() throws Exception {
       return Language.of(languageMnemonic);
    }
}
