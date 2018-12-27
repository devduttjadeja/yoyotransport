package com.ResponseEntityExample;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
 
 
@SpringBootApplication// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class SpringBootRestApiApp {
 
    public static void main(String[] args) {
        
    	ApplicationContext applicationContext = SpringApplication.run(SpringBootRestApiApp.class, args);
        
    	String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
    	
    	Arrays.sort(beanDefinitionNames);
        
    	for (String beanName : beanDefinitionNames) {
            System.out.println(beanName);
        }
    	
    }
}
