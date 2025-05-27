package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brad06")
public class Brad06 {
	@Value("${company.name}")
	private String companyName;
	
	@Value("${company.tel}")
	private String companyTel;
	
	@Value("${name}")
	private String admin;

	@Value("${age}")
	private Integer age;
	
	@Value("${ispan:OK}")
	private String title;
	
	@RequestMapping("/m1")
	public void m1() {
		System.out.println(companyName);
		System.out.println(companyTel);
		System.out.println(admin);
		System.out.println(age);
		System.out.println(title);
	}
	
	
}
