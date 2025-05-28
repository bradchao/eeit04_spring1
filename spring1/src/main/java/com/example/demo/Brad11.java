package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 更換資料庫: application.properties => north
@RestController
@RequestMapping("/brad11")
public class Brad11 {

	@GetMapping("/order/{orderId}")
	public void test1(@PathVariable int orderId) {
		
	}
}
