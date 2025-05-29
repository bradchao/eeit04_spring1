package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

	@Bean
	public Scooter createScooter() {
		System.out.println("createScooter()");
		return new Scooter();
	}
}
