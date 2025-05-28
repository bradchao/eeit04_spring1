package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Member;
import com.example.demo.model.Response;
import com.example.demo.utils.BCrypt;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/brad08")
public class Brad08 {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	private Response response;
	
	@PostMapping(
		value = {"/member","/member/{isGetId}"})
	public Response test1(
		@RequestBody @Valid Member member,
		@PathVariable(required = false) Boolean isGetId) {
		
		System.out.println("register...");
		isGetId = isGetId == null?false:isGetId;
		
		String sql = "INSERT INTO member " + 
					"(account,passwd,realname) " + 
					"VALUES (:account, :passwd, :realname)";
		Map<String,String> data = new HashMap<>();
		data.put("account", member.getAccount());
		data.put("passwd", BCrypt.hashpw(
				member.getPasswd(), BCrypt.gensalt()));
		data.put("realname", member.getRealname());		
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int n = template.update(
			sql, new MapSqlParameterSource(data) , keyHolder);
		int id = keyHolder.getKey().intValue();
		
		if (n > 0) {
			response.setError(0);
			response.setMesg("OK");
			response.setInsertId(isGetId?id:0);
			
		}else {
			response.setError(-1);
			response.setMesg("XX");
			response.setInsertId(-1);
		}
		
		
		return response;
	}
	
	
	
	
}
