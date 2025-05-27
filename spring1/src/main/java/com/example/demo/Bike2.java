package com.example.demo;

import org.springframework.stereotype.Component;

@Component	// ==> Bean
public class Bike2 implements Bike{
	public Bike2() {
		System.out.println("Bike2()");
	}

	@Override
	public void upSpeed() {
		System.out.println("Bike2:upSpeed()");
	}

	@Override
	public void downSpeed() {
		System.out.println("Bike2:downSpeed()");
	}

	public void m1() {
		System.out.println("Bike1:m1()");
	}

	public void m2() {
		System.out.println("Bike1:m2()");
	}

}
