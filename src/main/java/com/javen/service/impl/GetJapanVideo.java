package com.javen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.javen.dao.IjapanInfo;
import com.javen.model.JapanPageBeen;
import com.javen.model.JapanvideoBaseinfo;
import com.javen.model.JapanvideoBaseinfoExample;
import com.javen.service.IGetJapanVideo;
@Repository("getJapanVideo")
public class GetJapanVideo implements IGetJapanVideo {
	private final Integer nums = 30;
	private  Integer totalCount ;
	@Resource
	private JapanPageBeen japanPageBeen;
	
	@Qualifier("Japaninfoimpl")
	@Resource
	private IjapanInfo japanInfo;
	
	@Resource
	private List<JapanvideoBaseinfo> japanvideoBaseinfo;
//	@Resource
//	private JapanvideoBaseinfoExample example;
	@Override
	public JapanPageBeen getpagebyindex(int startpage) {
		int endnum = (startpage-1)*nums+nums;
		japanvideoBaseinfo = japanInfo.getpagebyindex((startpage-1)*nums, endnum);
		JapanvideoBaseinfoExample example = new JapanvideoBaseinfoExample();
		example.createCriteria().andIdIsNotNull();
		totalCount = japanInfo.getnum(example);
		japanPageBeen.setJapanvideoBaseinfo(japanvideoBaseinfo);
		japanPageBeen.setCurrentCount(nums);
		japanPageBeen.setCurrentPage(startpage);
		japanPageBeen.setTotalCount(totalCount);
		japanPageBeen.setTotalPage((int)Math.ceil(totalCount/nums)+1);
		return japanPageBeen;
	}

	@Override
	public JapanPageBeen getpagebyartist(String artist, int startpage) {
		startpage = (startpage-1)*nums;
		int endnum = startpage+nums;
		japanvideoBaseinfo = japanInfo.getpagebyartist(artist, startpage, endnum);
		JapanvideoBaseinfoExample example = new JapanvideoBaseinfoExample();
		example.createCriteria().andIdIsNotNull().andArtistEqualTo(artist);
		totalCount = japanInfo.getnum(example);
		japanPageBeen.setJapanvideoBaseinfo(japanvideoBaseinfo);
		japanPageBeen.setCurrentCount(nums);
		japanPageBeen.setCurrentPage(startpage);
		japanPageBeen.setTotalCount(totalCount);
		japanPageBeen.setTotalPage((int)Math.ceil(totalCount/nums)+1);
		return japanPageBeen;
	}

	@Override
	public JapanPageBeen getpagebycategory(String category, int startpage) {
		startpage = (startpage-1)*nums;
		int endnum = startpage+nums;
		japanvideoBaseinfo = japanInfo.getpagebycategory(category, startpage, endnum);
		JapanvideoBaseinfoExample example = new JapanvideoBaseinfoExample();
		example.createCriteria().andIdIsNotNull();
		example.createCriteria().andCategoryEqualTo(category);
		totalCount = japanInfo.getnum(example);
		japanPageBeen.setJapanvideoBaseinfo(japanvideoBaseinfo);
		japanPageBeen.setCurrentCount(nums);
		japanPageBeen.setCurrentPage(startpage);
		japanPageBeen.setTotalCount(totalCount);
		japanPageBeen.setTotalPage((int)Math.ceil(totalCount/nums)+1);
		return japanPageBeen;
	}

	@Override
	public JapanPageBeen getpagebylanguage(String language, int startpage) {
		startpage = (startpage-1)*nums;
		int endnum = startpage+nums;
		japanvideoBaseinfo = japanInfo.getpagebylanguage(language, startpage, endnum);
		JapanvideoBaseinfoExample example = new JapanvideoBaseinfoExample();
		example.createCriteria().andIdIsNotNull();
		example.createCriteria().andLanguageEqualTo(language);
		totalCount = japanInfo.getnum(example);
		japanPageBeen.setJapanvideoBaseinfo(japanvideoBaseinfo);
		japanPageBeen.setCurrentCount(nums);
		japanPageBeen.setCurrentPage(startpage);
		japanPageBeen.setTotalCount(totalCount);
		japanPageBeen.setTotalPage((int)Math.ceil(totalCount/nums)+1);
		return japanPageBeen;
	}

	@Override
	public JapanPageBeen getpagebylevel(String level, int startpage) {
		startpage = (startpage-1)*nums;
		int endnum = startpage+nums;
		japanvideoBaseinfo = japanInfo.getpagebylevel(level, startpage, endnum);
		JapanvideoBaseinfoExample example = new JapanvideoBaseinfoExample();
		example.createCriteria().andIdIsNotNull();
		example.createCriteria().andLvEqualTo(level);
		totalCount = japanInfo.getnum(example);
		japanPageBeen.setJapanvideoBaseinfo(japanvideoBaseinfo);
		japanPageBeen.setCurrentCount(nums);
		japanPageBeen.setCurrentPage(startpage);
		japanPageBeen.setTotalCount(totalCount);
		japanPageBeen.setTotalPage((int)Math.ceil(totalCount/nums)+1);
		return japanPageBeen;
	}

	@Override
	public JapanPageBeen getlatistvideo(int startpage) {
		int endnum = (startpage-1)*nums+nums;
		japanvideoBaseinfo = japanInfo.getlatistvideo();
		JapanvideoBaseinfoExample example = new JapanvideoBaseinfoExample();
		example.createCriteria().andIdIsNotNull();
		totalCount = japanInfo.getnum(example);
		japanPageBeen.setJapanvideoBaseinfo(japanvideoBaseinfo);
		japanPageBeen.setCurrentCount(nums);
		japanPageBeen.setCurrentPage(startpage);
		japanPageBeen.setTotalCount(totalCount);
		japanPageBeen.setTotalPage((int)Math.ceil(totalCount/nums)+1);
		return japanPageBeen;
	}

}
