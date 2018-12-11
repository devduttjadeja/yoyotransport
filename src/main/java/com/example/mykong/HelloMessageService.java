package com.example.mykong;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service // @Component @Repository @Service all are used to inject by using @Autowired in main class
@PropertySource("/properties/myproperties.properties")
public class HelloMessageService {

	@Value("${name}") // the value is injected from myproperties.properties file only if the properties are NOT define in app.properties
	private String name;
	
	@Value("${id}")
	private int id;
	
	public String getMessage() {
        return name;
    }
	
	public int getId() {
		return id;
	}




	@PostConstruct // called after the class is loaded
	private void postConstructMethodCalled() {
		System.out.println("called after HelloMessageService.class is instantiated");
	}
	
}
