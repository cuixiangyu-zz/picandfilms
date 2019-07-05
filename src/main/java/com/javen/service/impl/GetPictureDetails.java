package com.javen.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.javen.dao.IPictureCategory;
import com.javen.dao.IPictureInfo;
import com.javen.dao.IjapanInfo;
import com.javen.dao.Ijapancategory;
import com.javen.model.JapanVIdeoDetilBeen;
import com.javen.model.JapanvideoBaseinfo;
import com.javen.model.JapanvideoCategory;
import com.javen.model.PicBaseinfo;
import com.javen.model.PicCategory;
import com.javen.model.PictureDetilBeen;
import com.javen.service.IGetPictureDetails;
@Service
public class GetPictureDetails implements IGetPictureDetails {
	@Qualifier("pictureinfoimpl")
	@Resource
	private IPictureInfo pictureInfo;
	
	@Qualifier("PictureCategoryimpl")
	@Resource
	private IPictureCategory picturecategory;
	private List<String> categoryids;
	@Resource
	private PictureDetilBeen pictureDetilBeen;
	@Resource
	private List<PicCategory> picCategory;
	@Override
	public PictureDetilBeen getdetailsbyid(String id) {
		PicBaseinfo picBaseinfo = pictureInfo.getdetailsbyid(id);
		String addr = picBaseinfo.getAddr();
		List<String> addrs=new ArrayList<String>();
		for(File file:new File(addr).listFiles()){
			String path = "/source"+file.getPath().toString().substring(9, file.getPath().toString().length());
			addrs.add(path);
		}
		
		pictureDetilBeen.setAddrs(addrs);
		pictureDetilBeen.setPicBaseinfo(picBaseinfo);
		pictureDetilBeen.setId(id);
		pictureDetilBeen.setArtist(Arrays.asList(picBaseinfo.getArtist().split(",")));
		categoryids=Arrays.asList(picBaseinfo.getCategory().split(","));
		picCategory=picturecategory.getcategorybyids(categoryids);
		pictureDetilBeen.setPicCategorys(picCategory);
		return pictureDetilBeen;
	}
	
}
