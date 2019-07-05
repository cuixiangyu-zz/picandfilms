package com.javen.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javen.util.OpenDir;

@Controller
public class Openfile {
	@Resource
	private OpenDir  openDir;
	@RequestMapping("openfile.do")
	public void open(@RequestParam(value = "dir")String dir){
		openDir.openfiledir("K:\\japenese\\"+dir);
	}
}
