package com.javen.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.javen.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {
	@Resource
	private Getcategory getcategory;
	@Resource
	private Readtxt readtxt;
	@Resource
	private Getpicinfofrominternet getpicinfofrominternet;
	@Resource
	private DownLordArtistCover downLordArtistCover;
	@Resource
	private UpdateNewVideoInfo updateNewVideoInfo;
	@RequestMapping("/abs.do")
	public String index(HttpServletRequest request){
		System.out.println("zheshi yige java lei");
		request.setAttribute("id", 1);
		updateNewVideoInfo.updatevideo();
		return "portfolio.html";
	}
}
