package com.javen.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javen.model.Language;
import com.javen.model.PicAddr;
import com.javen.model.PicArtist;
import com.javen.model.PicCategory;
import com.javen.model.PicLevel;
import com.mysql.fabric.Response;

@Controller
public class GetPicAddr {
	@Resource
	private PicAddr picaddr;
	
	@Resource
	private Language[] language;
	
	@Resource
	private PicArtist[] picartist;
	
	@Resource
	private PicCategory[] piccategory;
	
	@Resource
	private PicLevel[] piclevel;

	//private List<String> addrs;
	
	@RequestMapping("getpicaddr.do")
	public @ResponseBody PicAddr getaddr(HttpServletRequest request){
		String id=request.getParameter("id");
		
		language[0].setCode("1");
		language[0].setLanguage("english");
		picaddr.setLanguage(language);
		
		picartist[0].setArtist("cxy");
		picartist[0].setId("cxy");
		picaddr.setPicartist(picartist);
		
		piccategory[0].setCategoryname("aaaa");
		piccategory[0].setId("111");
		picaddr.setPiccategory(piccategory);
		
		piclevel[0].setLvcode("1");
		piclevel[0].setLvname("1");
		picaddr.setPiclevel(piclevel);
		String address = "H:/20181021/[Hiroshiki] Tsugunaihime Atonement Princess (Renai Yuugu) [English] {Hennojin}";
		File file = new File(address);
		List<String> addrs = new ArrayList<String>(file.list().length);
		for (String s : file.list()) {
			addrs.add("/picsrc/[Hiroshiki] Tsugunaihime Atonement Princess (Renai Yuugu) [English] {Hennojin}/"+s);
		}
		//H:\20181021\(C92) [Meshikutteneru (Atage)] Tensai Shoujo demo Baka Mitaini Ecchi ni Narimasu [Chinese] [萝莉援助汉化组]
//		List<String> addrs = new ArrayList<String>(6);
//		addrs.add("/file/Sx1809.jpg");
//		addrs.add("photos/01.jpg");
//		addrs.add("photos/01.jpg");
//		addrs.add("photos/01.jpg");
//		addrs.add("photos/01.jpg");
//		addrs.add("photos/01.jpg");
		picaddr.setAddrs(addrs);
		return picaddr;
	}
}
