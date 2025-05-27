package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Member;
import com.example.demo.model.Response;
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
	
	@Autowired
	private Response response;
	
	
	@PostMapping("/member")
	public Response insertMember(@RequestBody Member member) {
		String sql = "INSERT INTO member (account,passwd,realname) " + 
					"VALUES (:account, :passwd, :realname)";
		Map<String,String> data = new HashMap<>();
		data.put("account", member.getAccount());
		data.put("passwd", BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()));
		data.put("realname", member.getRealname());
		
		template.update(sql, data);
		
		response.setError(0);
		response.setMesg("OK");
		return response;
	}
	
	@DeleteMapping("/member/{id}")
	public Response deleteMember(@PathVariable Integer id) {
		String sql = "DELETE FROM member WHERE id = :id";
		
		Map<String,Integer> data = new HashMap<>();
		data.put("id", id);
		template.update(sql, data);
		
		response.setError(0);
		response.setMesg("OK");
		
		return response;
	}
	
	@PutMapping("/member/{id}")
	public Response update(@PathVariable Integer id, @RequestBody Member member) {
		String sql = "UPDATE member " + 
					"SET account = :account,realname = :realname " + 
					"WHERE id = :id";
		Map<String,Object> data = new HashMap<>();
		data.put("account", member.getAccount());
		data.put("realname", member.getRealname());
		data.put("id", id);
		int n = template.update(sql, data);
		if (n > 0) {
			response.setError(0);
			response.setMesg("OK");
		}else {
			response.setError(1);
			response.setMesg("NO DELETE");
		}
		
		return response;
	}
	
	
}





