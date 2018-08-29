package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "Hello World ............";
	}

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute User user) {

		System.out.println(user.getEmail());
		System.out.println(user.getName());

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user-data");
		modelAndView.addObject("user", user);
		return modelAndView;

	}

	/*
	 * this will produce ONLY json response. IF ACCEPT headers is xml then it will
	 * give error 406 'Could not find acceptable representation'
	 */
	@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUser() {
		User user = new User();
		user.setEmail("devdutt.jadeja@accenture.com");
		user.setName("Devdutt");
		return user;
	}

}
