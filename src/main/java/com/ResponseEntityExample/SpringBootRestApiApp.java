package com.ResponseEntityExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
 
@SpringBootApplication// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class SpringBootRestApiApp {
 
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApiApp.class, args);
    }
}