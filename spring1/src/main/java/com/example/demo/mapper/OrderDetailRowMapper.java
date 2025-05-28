package com.example.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demo.model.OrderDetail;

@Component
public class OrderDetailRowMapper 
	implements RowMapper<OrderDetail> {

	@Autowired
	private OrderDetail orderDetail;
	
	@Override
	public OrderDetail mapRow(ResultSet rs, int rowNum) 
			throws SQLException {
		orderDetail.setOrderId(rs.getInt("id"));
		orderDetail.setProductName(rs.getString("pname"));
		orderDetail.setQty(rs.getInt("qty"));
		orderDetail.setUnitPrice(rs.getDouble("price"));;
		
		return orderDetail;
	}

}
