package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.MemberForm;

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
	
	@PostMapping("/member")
	public void test2(@ModelAttribute MemberForm memberForm) {
		String uploadDir = "C:\\Users\\User\\git\\repository9\\spring1\\src\\main\\resources\\upload\\";
		System.out.println(memberForm.getAccount());
		System.out.println(memberForm.getFiles().size());
		List<MultipartFile> files = memberForm.getFiles();
		for (MultipartFile file: files) {
			if (!file.isEmpty()) {
				String uName = uploadDir + file.getOriginalFilename();
				
				try {
					file.transferTo(new File(uName));
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	
	}
	
	
}







