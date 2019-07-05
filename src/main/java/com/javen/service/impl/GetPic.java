package com.javen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.javen.dao.IPictureInfo;
import com.javen.model.ComicPageBeen;
import com.javen.model.PicBaseinfo;
import com.javen.model.PicBaseinfoExample;
import com.javen.service.IGetPic;
@Repository("getPic")
public class GetPic implements IGetPic{
	private final Integer nums = 30;
	private  Integer totalCount ;
	@Resource
	private ComicPageBeen pageBeen;
	
	@Qualifier("pictureinfoimpl")
	@Resource
	private IPictureInfo pic;
	@Resource
	private List<PicBaseinfo> picBaseinfo;
	@Resource
	private PicBaseinfoExample example;
	
	@Override
	public ComicPageBeen getpagebyindex(int startpage){
		int endnum = (startpage-1)*nums+nums;
		picBaseinfo = pic.getpagebyindex((startpage-1)*nums, endnum);
		PicBaseinfoExample example = new PicBaseinfoExample();
		example.createCriteria().andIdIsNotNull();
		totalCount = pic.getnum(example);
		pageBeen.setPicBaseinfo(picBaseinfo);
		pageBeen.setCurrentCount(nums);
		pageBeen.setCurrentPage(startpage);
		pageBeen.setTotalCount(totalCount);
		pageBeen.setTotalPage((int)Math.ceil(totalCount/nums));
		return pageBeen;
	}

	@Override
	public ComicPageBeen getpagebyartist(String artist, int startpage) {
		startpage = (startpage-1)*nums;
		int endnum = startpage+nums;
		picBaseinfo = pic.getpagebyartist(artist, startpage, endnum);
		example.createCriteria().andArtistEqualTo(artist);
		totalCount = pic.getnum(example);
		pageBeen.setPicBaseinfo(picBaseinfo);
		pageBeen.setCurrentCount(nums);
		pageBeen.setCurrentPage(startpage);
		pageBeen.setTotalCount(totalCount);
		pageBeen.setTotalPage((int)Math.ceil(totalCount/nums));
		return pageBeen;
	}

	@Override
	public ComicPageBeen getpagebycategory(String category, int startpage) {
		startpage = (startpage-1)*nums;
		int endnum = startpage+nums;
		picBaseinfo = pic.getpagebycategory(category, startpage, endnum);
		example.createCriteria().andCategoryEqualTo(category);
		totalCount = pic.getnum(example);
		pageBeen.setPicBaseinfo(picBaseinfo);
		pageBeen.setCurrentCount(nums);
		pageBeen.setCurrentPage(startpage);
		pageBeen.setTotalCount(totalCount);
		pageBeen.setTotalPage((int)Math.ceil(totalCount/nums));
		return pageBeen;
	}

	@Override
	public ComicPageBeen getpagebylanguage(String language, int startpage) {
		startpage = (startpage-1)*nums;
		int endnum = startpage+nums;
		picBaseinfo = pic.getpagebylanguage(language, startpage, endnum);
		example.createCriteria().andLanguageEqualTo(language);
		totalCount = pic.getnum(example);
		pageBeen.setPicBaseinfo(picBaseinfo);
		pageBeen.setCurrentCount(nums);
		pageBeen.setCurrentPage(startpage);
		pageBeen.setTotalCount(totalCount);
		pageBeen.setTotalPage((int)Math.ceil(totalCount/nums));
		return pageBeen;
	}

	@Override
	public ComicPageBeen getpagebylevel(String level, int startpage) {
		startpage = (startpage-1)*nums;
		int endnum = startpage+nums;
		picBaseinfo = pic.getpagebylevel(level, startpage, endnum);
		example.createCriteria().andLvEqualTo(level);
		totalCount = pic.getnum(example);
		pageBeen.setPicBaseinfo(picBaseinfo);
		pageBeen.setCurrentCount(nums);
		pageBeen.setCurrentPage(startpage);
		pageBeen.setTotalCount(totalCount);
		pageBeen.setTotalPage((int)Math.ceil(totalCount/nums));
		return pageBeen;
	}


}
