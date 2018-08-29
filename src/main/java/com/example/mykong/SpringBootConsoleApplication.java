package com.example.mykong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner{

	@Autowired
	private HelloMessageService helloMessageService;
	
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootConsoleApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		System.out.println(helloMessageService.getMessage());
		System.out.println(helloMessageService.getId());
		//System.exit(0);
		
	}

}
