package com.javen.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.javen.model.ComicPageBeen;
import com.javen.model.JapanvideoBaseinfo;
import com.javen.model.PicBaseinfo;
import com.javen.model.PicBaseinfoExample;
@Repository("IPictureInfo")
public interface IPictureInfo {
	public List<PicBaseinfo> getpagebyindex(int currentPage,int currentCount);
	
	public List<PicBaseinfo> getpagebyartist(String artist,int currentPage,int currentCount);

	public List<PicBaseinfo> getpagebycategory(String category,int currentPage,int currentCount);

	public List<PicBaseinfo> getpagebylanguage(String language,int currentPage,int currentCount);

	public List<PicBaseinfo> getpagebylevel(String level,int currentPage,int currentCount);

	public String insert(List<PicBaseinfo> picBaseinfos);

	public String update(List<PicBaseinfo> picBaseinfos);

	public String delete(List<PicBaseinfo> picBaseinfos);
	
	public int getnum(PicBaseinfoExample exam);

	public PicBaseinfo getdetailsbyid(String id);
}
