package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brad04")
public class Brad04 {
	@RequestMapping("/m1")
	public String m1(
		@RequestParam(required = false, defaultValue = "0") Integer x, 
		@RequestParam Integer y
		) {
		
		System.out.println("Brad04:m1()");
		int r = x - y;
		System.out.println(r);
		return null;
	}
	
	@RequestMapping("/m2")
	public String m2(
		@RequestParam(required = false, defaultValue = "0") String x, 
		@RequestParam(required = false, defaultValue = "0") String y
		) {
		try {
			Integer xx = Integer.parseInt(x);
			Integer yy = Integer.parseInt(y);
			int r = xx + yy;
			System.out.println(r);
		}catch(Exception e) {
			System.out.println("xxxx");
		}
		
		return null;
	}
	
}
