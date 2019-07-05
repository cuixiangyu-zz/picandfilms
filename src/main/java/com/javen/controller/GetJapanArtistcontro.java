package com.javen.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javen.model.JapanArtistPageBeen;
import com.javen.model.JapanPageBeen;
import com.javen.service.IGetJapanVideoArtist;
import com.javen.service.IGetJapanVideo;
@Controller
public class GetJapanArtistcontro {
	private int startpage;
	@Resource
	private JapanArtistPageBeen pageBeen;
	
	@Qualifier("getJapanvideoArtist")
	@Resource
	private IGetJapanVideoArtist getJapanVideoArtist;
	
	@RequestMapping("gotonextjapanartistpage.do")
	public @ResponseBody JapanArtistPageBeen gotonextjapanartistpage(@RequestParam(value = "currentPage")String currentPage,HttpServletRequest request){
		pageBeen = getJapanVideoArtist.getpagebyindex(Integer.valueOf(currentPage));
		return pageBeen;
	}
}
