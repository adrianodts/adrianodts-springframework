package com.adrianodts.springframework.javapersistenceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.Arrays;

@SpringBootApplication
public class JavaPersistenceApiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(JavaPersistenceApiApplication.class, args);

		// Customer customer = new Customer();
		// CustomerRepository customerRepository = (CustomerRepository)ctx.getBean("customerRepository");
		// customerRepository.save(customer);
		
		// System.out.println("******** " + ctx.getBeanDefinitionCount() + " Beans loaded ********");
		// Arrays.asList(ctx.getBeanDefinitionNames()).forEach(name -> System.out.println(name));
		// System.out.println("***********************");

	}

}
