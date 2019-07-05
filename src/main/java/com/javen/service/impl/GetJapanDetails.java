package com.javen.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.javen.dao.IjapanInfo;
import com.javen.dao.Ijapancategory;
import com.javen.model.JapanVIdeoDetilBeen;
import com.javen.model.JapanvideoBaseinfo;
import com.javen.model.JapanvideoCategory;
import com.javen.service.IGetJapanDetails;
@Service
public class GetJapanDetails implements IGetJapanDetails {
	
	@Qualifier("Japaninfoimpl")
	@Resource
	private IjapanInfo japanInfo;
	
	@Qualifier("Jpancategoryimpl")
	@Resource
	private Ijapancategory japancategory;
	private List<String> categoryids;
	@Resource
	private JapanVIdeoDetilBeen japanVIdeoDetilBeen;
	@Resource
	private List<JapanvideoCategory> japanvideoCategorys;
	@Override
	public JapanVIdeoDetilBeen getdetailsbyid(String id) {
		JapanvideoBaseinfo japanvideoBaseinfo = japanInfo.getdetailsbyid(id);
		String addr = japanvideoBaseinfo.getAddr();
		addr =addr.substring(addr.indexOf("japenese")+8, addr.length());
		japanvideoBaseinfo.setAddr(addr);
		japanVIdeoDetilBeen.setJapanvideoBaseinfo(japanvideoBaseinfo);
		japanVIdeoDetilBeen.setId(id);
		japanVIdeoDetilBeen.setArtist(japanvideoBaseinfo.getArtist());
		categoryids=Arrays.asList(japanvideoBaseinfo.getCategory().split(","));
		japanvideoCategorys = japancategory.getpagebyids(categoryids);
		japanVIdeoDetilBeen.setJapanvideoCategorys(japanvideoCategorys);
		return japanVIdeoDetilBeen;
	}

}
