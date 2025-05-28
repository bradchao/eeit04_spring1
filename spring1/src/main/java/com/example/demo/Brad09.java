package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Hotel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/brad09")
public class Brad09 {
	
	@RequestMapping("/test1")
	public void test1() {
		String url = 
			"https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelStay.aspx";
		RestTemplate template = new RestTemplate();
		String content = template.getForObject(url, String.class);
		//System.out.println(content);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<Hotel> hotels =
				mapper.readValue(content, new TypeReference<List<Hotel>>() {});
//			for (Hotel hotel :hotels) {
//				System.out.println(hotel.getName());
//			}
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@RequestMapping("/test2")
	public void test2() {
		String url = 
			"https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelStay.aspx";
		RestTemplate template = new RestTemplate();
		
		Hotel[] hotels = template.getForObject(url, Hotel[].class);
		System.out.println(hotels[0].getName());
		
	}
	
	
	

}
