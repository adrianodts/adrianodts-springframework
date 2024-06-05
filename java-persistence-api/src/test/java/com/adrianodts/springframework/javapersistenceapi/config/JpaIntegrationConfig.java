package com.adrianodts.springframework.javapersistenceapi.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.adrianodts.springframework")
@ActiveProfiles({"jpadao"})
public class JpaIntegrationConfig {
    
}
