package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.HotelRowMapper;
import com.example.demo.model.Hotel;

@RestController
@RequestMapping("/brad10")
public class Brad10 {

	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private HotelRowMapper hotelRowMapper;
	
	@GetMapping("/hotels")
	public List<Hotel> test1(){
		String sql = "SELECT id, name, addr, tel FROM hotel";
		return jdbc.query(sql, hotelRowMapper);
	}
	
	
	
}
