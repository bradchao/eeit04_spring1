package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController		// ==> Bean ==> IoC
@RequestMapping("/brad01")
public class Brad01 {
	public Brad01() {
		System.out.println("Brad01()");
	}
	
	@RequestMapping("/brad01")
	public String test1() {
		System.out.println("Test11()");
		return "Test12";
	}
	@RequestMapping("/brad02")
	public String test2() {
		System.out.println("Test21()");
		return "Test22";
	}
	@RequestMapping("/brad03")
	public String test3() {
		System.out.println("Test31()");
		return "Test32";
	}
	
}
