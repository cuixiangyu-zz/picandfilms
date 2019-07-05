package com.javen.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javen.model.ComicPageBeen;
import com.javen.service.IGetPic;

@Controller
public class Getpics {
	private int startpage;
	@Resource
	private ComicPageBeen pageBeen;
	
	@Qualifier("getPic")
	@Resource
	private IGetPic iGetPic;
	@CrossOrigin
	@RequestMapping("gotonextpicpage.do")
	public @ResponseBody ComicPageBeen gotonextpicpage(@RequestParam(value = "currentPage")String currentPage){
		iGetPic.getpagebyindex(Integer.valueOf(currentPage));
		return pageBeen;
	}
}
