package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brad02")
public class Brad02 {
	@Autowired
	@Qualifier("bike1")
	private Bike bike3;
	
	@Autowired
	private Bike bike2;
	
	public Brad02() {
		System.out.println("Brad02()");
	}
	
	@RequestMapping("/test1")
	public String test1() {
		bike3.upSpeed();
		bike3.downSpeed();
		return null;
	}
	
	@RequestMapping("/test2")
	public String test2() {
		bike2.upSpeed();
		bike2.downSpeed();
		return null;
	}

	@RequestMapping("/test3")
	public String test3() {
		if (bike3 instanceof Bike1) {
			((Bike1)bike3).m1();
		}
		
		return null;
	}
	
	
}
