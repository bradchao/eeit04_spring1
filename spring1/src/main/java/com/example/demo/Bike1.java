package com.example.demo;

import org.springframework.stereotype.Component;

@Component	// ==> Bean
public class Bike1 implements Bike{
	private int i;
	
	public Bike1() {
		System.out.println("Bike1()");
	}

	@Override
	public void upSpeed() {
		System.out.println("Bike1:upSpeed()");
	}

	@Override
	public void downSpeed() {
		System.out.println("Bike1:downSpeed()");
	}

	public void m1() {
		System.out.println("Bike1:m1():" + i++);
	}

	public void m2() {
		System.out.println("Bike1:m2()");
	}

}
