package com.aopApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(AopAppApplication.class, args);
		System.out.println("testing");
	}

}
