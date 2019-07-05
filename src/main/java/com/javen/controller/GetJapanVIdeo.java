package com.javen.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javen.model.ComicPageBeen;
import com.javen.model.JapanPageBeen;
import com.javen.service.IGetJapanVideo;
import com.javen.service.IGetPic;

@Controller
public class GetJapanVIdeo {
	private int startpage;
	@Resource
	private JapanPageBeen pageBeen;
	
	@Qualifier("getJapanVideo")
	@Resource
	private IGetJapanVideo getJapanVideo;
	@RequestMapping("gotonextjapanpage.do")
	public @ResponseBody JapanPageBeen gotonextjapanpage(@RequestParam(value = "currentPage")String currentPage,HttpServletRequest request){
		/*if(artist!=null&&artist!=""){
			pageBeen = getJapanVideo.getpagebyartist(artist,Integer.valueOf(currentPage));
		}*/
		pageBeen = getJapanVideo.getpagebyindex(Integer.valueOf(currentPage));
		return pageBeen;
	}
	@RequestMapping("japanpagewithartist.do")
	public @ResponseBody JapanPageBeen gotonextjapanpagewithartist(@RequestParam(value = "currentPage")String currentPage,@RequestParam(value = "artist")String artist,HttpServletRequest request){
		artist=artist.split(",")[0];
		pageBeen = getJapanVideo.getpagebyartist(artist,Integer.valueOf(currentPage));
		return pageBeen;
	}

	@RequestMapping("latistjapanvideo.do")
	public @ResponseBody JapanPageBeen latistjapanvideo(HttpServletRequest request){
		pageBeen = getJapanVideo.getpagebyindex(1);
		return pageBeen;
	}
}
