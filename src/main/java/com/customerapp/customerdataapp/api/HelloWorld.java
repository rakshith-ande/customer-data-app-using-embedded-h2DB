package com.customerapp.customerdataapp.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	@RequestMapping
	public String sayHello() {
		return "<h1>Hello World...!!!</h1>";
	}
	
}
