package com.javen.model;

import java.util.Date;

public class Pictures {
	private Integer id;
	private String name;
	private String addr;
	private String artist;
	private String language;
	private String category;
	private String cover;
	private Date data;
	private String isexist;
	private String level;
	public Pictures() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pictures(Integer id, String name, String addr, String artist,
			String language, String category, String cover, Date data,
			String isexist, String level) {
		super();
		this.id = id;
		this.name = name;
		this.addr = addr;
		this.artist = artist;
		this.language = language;
		this.category = category;
		this.cover = cover;
		this.data = data;
		this.isexist = isexist;
		this.level = level;
	}
	@Override
	public String toString() {
		return "Pictures [id=" + id + ", name=" + name + ", addr=" + addr
				+ ", artist=" + artist + ", language=" + language
				+ ", category=" + category + ", cover=" + cover + ", data="
				+ data + ", isexist=" + isexist + ", level=" + level + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getIsexist() {
		return isexist;
	}
	public void setIsexist(String isexist) {
		this.isexist = isexist;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
}
