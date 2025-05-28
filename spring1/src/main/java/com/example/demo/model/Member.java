package com.example.demo.model;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Member {
	private Long id;
	
	@Size(min=6, max=20)
	private String account;
	
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$")
	private String passwd;
	
	@NotBlank
	private String realname;
	
//	@Min(18) @Max(78)
//	@Positive
//	@PositiveOrZero
//	@Negative
//	@NegativeOrZero
//	private int age;
	
//	@Email
//	private String email;
//	
//	@PastOrPresent
//	private Date birthday;
//
//	@FutureOrPresent
//	private Date orderDate;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	
	
	
}
