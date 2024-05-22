package com.adrianodts.springframework.factorybeans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FactoryBeansApp {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(FactoryBeansApp.class, args);
        GreetingController controller = (GreetingController) ctx.getBean("greetingController");
        controller.sayHello();
	}

}
