package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brad03")
public class Brad03 {
	public Brad03() {
		System.out.println("Brad03()");
	}
	@Autowired
	private Lottery bigLottery;
	
	@Autowired
	private Lottery powerLottery;
	
	@RequestMapping("/big")
	public String big() {
		return bigLottery.createLottery().toString();
	}
	
	@RequestMapping("/power")
	public String power() {
		return powerLottery.createLottery().toString();
	}
}
