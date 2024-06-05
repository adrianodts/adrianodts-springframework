package com.adrianodts.springframework.javapersistenceapi.services;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.adrianodts.springframework.javapersistenceapi.config.JpaIntegrationConfig;

@SpringBootTest
@ContextConfiguration(classes = { JpaIntegrationConfig.class })
@ActiveProfiles("jparepository")
public class BaseServiceRepository {

}
