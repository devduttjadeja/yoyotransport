package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Parent {

	int i;

	public Parent(int i) { // if PARENT have (arg constructor) the it should define (no-arg constructor)
							// otherwise CHILD will have to forcefully call the parent's arg constructor
		this.i = i;
	}

	public Parent() {
		super();
	}

}
