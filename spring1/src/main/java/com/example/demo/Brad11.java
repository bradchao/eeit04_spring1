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

import com.example.demo.mapper.OrderDetailRowMapper;
import com.example.demo.model.OrderDetail;

// 更換資料庫: application.properties => north
@RestController
@RequestMapping("/brad11")
public class Brad11 {
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private OrderDetailRowMapper mapper;
	
	/*
	 * SELECT o.OrderID id, p.ProductName pname, 
		od.Quantity qty, od.UnitPrice price 
		FROM orders o
		JOIN orderdetails od ON o.OrderID = od.OrderID
		JOIN products p ON od.ProductID = p.ProductID
		WHERE o.OrderID = 10248
	 */
	@GetMapping("/order/{orderId}")
	public List<OrderDetail> test1(@PathVariable int orderId) {
		String sql = "SELECT o.OrderID id, p.ProductName pname, "
				+ "		od.Quantity qty, od.UnitPrice price "
				+ "		FROM orders o"
				+ "		JOIN orderdetails od ON o.OrderID = od.OrderID"
				+ "		JOIN products p ON od.ProductID = p.ProductID"
				+ "		WHERE o.OrderID = :orderId";
		Map<String,Object> params = new HashMap<>();
		params.put("orderId", orderId);
		
		return jdbc.query(sql, params, mapper);
	}
}
