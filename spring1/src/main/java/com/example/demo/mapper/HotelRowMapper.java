package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demo.model.Hotel;

@Component
public class HotelRowMapper implements RowMapper<Hotel>{

	@Override
	public Hotel mapRow(ResultSet rs, int rowNum) 
			throws SQLException {
		Hotel hotel = new Hotel();
		hotel.setId(rs.getLong("id"));
		hotel.setName(rs.getString("name"));
		hotel.setAddr(rs.getString("addr"));
		hotel.setTel(rs.getString("tel"));
		
		return hotel;
	}

}
