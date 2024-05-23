package com.adrianodts.springframework.xmlconfiguration;

import java.text.MessageFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@ImportResource("classpath:/spring/spring-config.xml")
//@ComponentScan("com.adrianodts.springframework.xmlconfiguration")
public class XmlConfigurationaApplication {

	public static void main(String[] args) {
		//SpringApplication.run(XmlConfigurationaApplication.class, args);
		ApplicationContext ctx = SpringApplication.run(XmlConfigurationaApplication.class, args);		
		//ApplicationContext ctx = new ClassPathXmlApplicationContext(getProfileConfiguration());

		MyBean myBean = (MyBean)ctx.getBean("myBean");
		String message = myBean.getMessage();
		System.out.println(message);
		
	 	MessageService messageService = (MessageService)ctx.getBean("messageService");
		messageService.executeService();

	}

	private static String getProfileConfiguration() {
		String envProfile = System.getProperty("profile");
		String configuration = "/spring/spring-config{0}.xml";
		if (envProfile != null) {
			envProfile = "-" + envProfile;
		} else {
			envProfile = "";
		}
		return MessageFormat.format(configuration, envProfile);
	}

}
