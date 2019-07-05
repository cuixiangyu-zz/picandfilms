package com.javen.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javen.util.Downloadcover;
import com.javen.util.Getcategory;
import com.javen.util.Getpicinfofrominternet;
import com.javen.util.Readtxt;

@Controller
public class CopyOfIndex {
	@Resource
	private Getcategory getcategory;
	@Resource
	private Getpicinfofrominternet getpicinfofrominternet;
	@RequestMapping("/getpic.do")
	public String index(){
		System.out.println("zheshi yige java lei");
		getpicinfofrominternet.copycover();
		return "index";
	}
}
