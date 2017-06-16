package com.thbs.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLoader {

	public static void main(String[] args) 
	{
		
		SpringApplication.run(SpringBootLoader.class, args);
		System.out.println("Reached SpringBootLoader");
	}

}
