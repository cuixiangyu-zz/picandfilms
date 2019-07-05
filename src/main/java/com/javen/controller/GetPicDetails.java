package com.javen.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javen.model.PictureDetilBeen;
import com.javen.service.IGetPictureDetails;

@Controller
public class GetPicDetails {
	@Resource
	private PictureDetilBeen pictureDetilBeen;
	@Qualifier("GetPictureDetails")
	@Resource
	private IGetPictureDetails getPictureDetails;

	@CrossOrigin
	@RequestMapping("/getpicdetails.do")
	public @ResponseBody PictureDetilBeen getdetails(@RequestParam(value = "id") String id){
		pictureDetilBeen = getPictureDetails.getdetailsbyid(id);
		return pictureDetilBeen;
	}
}
