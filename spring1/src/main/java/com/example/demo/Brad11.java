package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
import com.example.demo.model.Order;
import com.example.demo.model.OrderDetail;

// 更換資料庫: application.properties => north
@RestController
@RequestMapping("/brad11")
public class Brad11 {

    private final OrderDetail orderDetail;
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private OrderDetailRowMapper mapper;

    Brad11(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }
	
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
	@GetMapping(value = {"/orders", "/orders/{orderId}"})
	public List<Order> test2(@PathVariable(required = false) Integer orderId){
		String sql = "SELECT o.OrderID id, o.OrderDate odate, p.ProductName pname, "
				+ "		od.Quantity qty, od.UnitPrice price "
				+ "		FROM orders o"
				+ "		JOIN orderdetails od ON o.OrderID = od.OrderID"
				+ "		JOIN products p ON od.ProductID = p.ProductID";
		
				Map<String,Object> params = new HashMap<>();
				if (orderId != null) {
					sql += "		WHERE o.OrderID = :orderId";
					params.put("orderId", orderId);
				}
				HashMap<Integer, Order> orders = new HashMap<>();
				
				List<Map<String,Object>> orderMap = jdbc.queryForList(sql, params);
				for (Map<String,Object> row: orderMap) {
					int oid = (Integer)row.get("id");
					
					Order order = orders.get(oid);
					if (order == null) {
						order = new Order();
						order.setOrderId(oid);
						LocalDateTime odate = (LocalDateTime)row.get("odate");
						order.setOrderDate(odate.toString());
					}
					
					OrderDetail detail = new OrderDetail();
					detail.setUnitPrice(((BigDecimal)row.get("price")).doubleValue());
					detail.setProductName((String)row.get("pname"));
					detail.setQty((Integer)row.get("qty"));
					
					order.getOrderDetails().add(detail);
				}
		
		
		
		return new ArrayList<Order>(orders.values());
	}
	
	
	
	
}
