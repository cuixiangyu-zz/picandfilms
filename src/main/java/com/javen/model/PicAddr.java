package com.javen.model;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class PicAddr {
	

	private PicArtist[] picartist;
	
	private PicCategory[] piccategory;
	
	private List<String> addrs;
	
	private PicLevel[] piclevel;
	
	private Language[] language;

	public PicArtist[] getPicartist() {
		return picartist;
	}

	public void setPicartist(PicArtist[] picartist) {
		this.picartist = picartist;
	}

	public PicCategory[] getPiccategory() {
		return piccategory;
	}

	public void setPiccategory(PicCategory[] piccategory) {
		this.piccategory = piccategory;
	}

	public List<String> getAddrs() {
		return addrs;
	}

	public void setAddrs(List<String> addrs) {
		this.addrs = addrs;
	}

	public PicLevel[] getPiclevel() {
		return piclevel;
	}

	public void setPiclevel(PicLevel[] piclevel) {
		this.piclevel = piclevel;
	}

	public Language[] getLanguage() {
		return language;
	}

	public void setLanguage(Language[] language) {
		this.language = language;
	}

	

}
