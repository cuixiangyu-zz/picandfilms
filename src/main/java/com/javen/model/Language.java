package com.javen.model;

import org.springframework.stereotype.Service;

@Service
public class Language {
	private String code;
	private String language;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
}
