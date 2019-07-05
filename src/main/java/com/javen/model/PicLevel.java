package com.javen.model;

import org.springframework.stereotype.Service;

@Service
public class PicLevel {
	public String getLvcode() {
		return lvcode;
	}
	public void setLvcode(String lvcode) {
		this.lvcode = lvcode;
	}
	public String getLvname() {
		return lvname;
	}
	public void setLvname(String lvname) {
		this.lvname = lvname;
	}
	private String lvcode;
	private String lvname;
}
