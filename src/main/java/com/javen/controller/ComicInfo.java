package com.javen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javen.dao.IPictureInfo;
import com.javen.dao.impl.Pictureinfoimpl;
import com.javen.model.User;


@Controller
public class  ComicInfo {
	@RequestMapping("comicinfo.do")
	public  @ResponseBody User[] ComicInfo (){
		IPictureInfo pic = new Pictureinfoimpl();
		pic.getpagebyindex(10,20);
		User[] us = new User[1];
		User u = new User("cxy","18","/file/Sx1809.jpg");
		us[0]= u;
		return us;
	}
}
