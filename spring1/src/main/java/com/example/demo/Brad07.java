package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Member;
import com.example.demo.utils.BCrypt;
/*
 * NamedParameterJdbcTemplate
 * update() => insert, delete, update
 * query() => select
 */
@RestController
@RequestMapping("/brad07")
public class Brad07 {

	@Autowired
	private NamedParameterJdbcTemplate template; 
	
	@PostMapping("/member")
	public void insertMember(@RequestBody Member member) {
		String sql = "INSERT INTO member (account,passwd,realname) " + 
					"VALUES (:account, :passwd, :realname)";
		Map<String,String> data = new HashMap<>();
		data.put("account", member.getAccount());
		data.put("passwd", BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()));
		data.put("realname", member.getRealname());
		
		template.update(sql, data);
	}
}





