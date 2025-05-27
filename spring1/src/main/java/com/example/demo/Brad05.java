package com.example.demo;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * RESTful
 * Create: POST
 * Read: GET
 * Update: PUT
 * Delete: DELETE
 */

@RestController
@RequestMapping("/brad05")
public class Brad05 {

	@GetMapping("/users")
	public void m1() {
		System.out.println("m1()");
	}
	
	@GetMapping("/user/{id}")
	public void m2(@PathVariable Integer id) {
		System.out.println("m2():" + id);
	}
	
	@GetMapping("/user/{id}/bike/{bid}")
	public void m3(@PathVariable Integer id, @PathVariable Integer bid) {
		System.out.println("m2():" + id + ";" + bid);
	}
	
	@PostMapping("/user")
	public void m4(@RequestBody User user) {
		System.out.println(user.getName());
	}
	
	@PutMapping("/user")
	public void m5(@RequestBody User user) {
		System.out.println(user.getName());
	}
	
	@DeleteMapping("/user/{id}")
	public void m5(@PathVariable Integer id) {
		System.out.println(id);
	}
	
	
	
	
	
	
}
