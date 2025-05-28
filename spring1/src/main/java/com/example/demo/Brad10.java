package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/hotel/{id}")
	public Hotel test2(@PathVariable Long id) {
		String sql = "SELECT id, name, addr, tel FROM hotel " + 
					"WHERE id = :id";
		Map<String, Long> params = new HashMap<>();
		params.put("id", id);
		List<Hotel> hotels = jdbc.query(sql, params, hotelRowMapper);
		if (hotels.size() > 0) {
			return hotels.get(0);
		}else {
			Hotel hotel = new Hotel();
			hotel.setErrorCode(-1);
			return hotel;
		}
	}
	
	@GetMapping("/hotelV2/{id}")
	public Hotel test3(@PathVariable Long id) {
		String sql = "SELECT id, name, addr, tel FROM hotel " + 
					"WHERE id = :id";
		Map<String, Long> params = new HashMap<>();
		params.put("id", id);

		Hotel hotel;
		try {
			hotel = jdbc.queryForObject(sql, params, hotelRowMapper);
		}catch(Exception e) {
			hotel = new Hotel();
			hotel.setErrorCode(-1);			
		}
		
		return hotel;
	}	
	
	@GetMapping("/hotels/search/{key}")
	public List<Hotel> test3(@PathVariable String key) {
		String sql = "SELECT id, name, addr, tel FROM hotel " + 
				"WHERE name LIKE :skey OR addr LIKE :skey OR tel LIKE :skey";
		String skey = "%" + key + "%";
		Map<String, String> params = new HashMap<>();
		params.put("skey", skey);
		
		return jdbc.query(sql, params, hotelRowMapper);
	}
	
	
}
