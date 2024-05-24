package com.adrianodts.springframework.xmlconfiguration.xmlconfigurationa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.adrianodts.springframework.xmlconfiguration.FactoryService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-config.xml",
        "classpath*:/spring/spring-config-portuguese.xml"})
public class PortugueseServiceTest {

    @Autowired
    FactoryService factoryService;

    @Test
    public void testHelloWorld(){
        String greeting = factoryService.getMessage();
        assertEquals("Olá! Estou muito feliz em te ver", greeting);
    }
}