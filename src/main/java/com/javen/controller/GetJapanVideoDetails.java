package com.javen.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javen.model.JapanVIdeoDetilBeen;
import com.javen.service.IGetJapanDetails;

@Controller
public class GetJapanVideoDetails {
	@Resource
	private JapanVIdeoDetilBeen japanVIdeoDetilBeen;
	@Qualifier("GetJapanDetails")
	@Resource
	private IGetJapanDetails getJapanDetails;
	@CrossOrigin
	@RequestMapping("/getvideodetails.do")
	public @ResponseBody JapanVIdeoDetilBeen getdetails(@RequestParam(value = "id") String id){
		japanVIdeoDetilBeen = getJapanDetails.getdetailsbyid(id);
		return japanVIdeoDetilBeen;
	}
}
