package com.example.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/brad12")
public class Brad12 {

	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	@PostMapping("/member/{id}")
	public void test1(@RequestParam MultipartFile upload,
			@PathVariable Integer id) {
		
		try {
			byte[] fileBytes = upload.getBytes();
			
			String sql = "UPDATE member SET icon = :icon WHERE id = :id";
			Map<String,Object> params = new HashMap<>();
			params.put("icon", fileBytes);
			params.put("id", id);
			
			int n = jdbc.update(sql, params);
			System.out.println(n > 0);
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
		
		
		
	}
	
}
