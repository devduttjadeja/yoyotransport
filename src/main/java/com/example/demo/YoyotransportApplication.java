package com.example.demo;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.mykong.HelloMessageService;

@SpringBootApplication
@ComponentScan(basePackages = "com.example") // this will initialise all the beans in com.example eg HelloMessageService
public class YoyotransportApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext applicationContext; // it receives this object
													// "AnnotationConfigServletWebServerApplicationContext"

	@Autowired
	private HelloMessageService helloMessageService;

	@Autowired
	private Child Child;
	
	@Autowired
	private Parent parent; // if we don't have @Component on 'Parent' then it will inject 'Child' object
	
	Logger logger = Logger.getLogger(YoyotransportApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(YoyotransportApplication.class, args);
	}

	/* all the bean names that are loaded */
	@Override
	public void run(String... args) throws Exception {

		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

		helloMessageService.getMessage();

		
		for (String beans : beanDefinitionNames) {

			// logger.log(Level.INFO, beans);

		}

	}

}
