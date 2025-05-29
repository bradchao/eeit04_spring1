package com.example.demo.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MemberForm {
	private String account;
	private String passwd;
	private List<MultipartFile> files;
	
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
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	
	
	
	
	
}
