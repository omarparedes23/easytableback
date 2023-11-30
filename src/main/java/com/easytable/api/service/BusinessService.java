package com.easytable.api.service;

import org.springframework.stereotype.Component;

import com.easytable.api.model.HelloWorld;
@Component
public class BusinessService {
	public HelloWorld getHelloWorld() {
		HelloWorld hw=new HelloWorld();
		return hw;		
	}


}
