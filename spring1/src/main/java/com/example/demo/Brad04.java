package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
	@RequestMapping("/m3")	
	public String m3(@RequestBody User user) {
		System.out.println(user.getName());
		System.out.println(user.getGender());
		System.out.println(user.getAge());
		return null;
	}
	@RequestMapping("/m4/{id}/{name}")
	public String m4(@PathVariable Integer id, 
			@PathVariable String name) {
		System.out.printf("%d: %s\n", id, name);
		return null;
	}
	@RequestMapping("/m5")
	public String m5(@RequestHeader String x, @RequestHeader Integer y,
				@RequestHeader(name = "Content-Type") String content) {
		System.out.printf("%s : %d : %s\n", x, y, content);
		return null;
	}
	
	
}
