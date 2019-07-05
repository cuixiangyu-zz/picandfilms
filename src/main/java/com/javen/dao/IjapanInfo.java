package com.javen.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.javen.model.JapanvideoBaseinfo;
import com.javen.model.JapanvideoBaseinfoExample;
@Repository("IjapanInfo")
public interface IjapanInfo {
	public List<JapanvideoBaseinfo> getpagebyindex(int currentPage,int currentCount);
	
	public List<JapanvideoBaseinfo> getpagebyartist(String artist,int currentPage,int currentCount);

	public List<JapanvideoBaseinfo> getpagebycategory(String category,int currentPage,int currentCount);

	public List<JapanvideoBaseinfo> getpagebylanguage(String language,int currentPage,int currentCount);

	public List<JapanvideoBaseinfo> getpagebylevel(String level,int currentPage,int currentCount);
	
	public int getnum(JapanvideoBaseinfoExample exam);
	
	public String insert(List<JapanvideoBaseinfo> japanvideoBaseinfos);
	
	public String update(List<JapanvideoBaseinfo> japanvideoBaseinfos);
	
	public String delete(List<JapanvideoBaseinfo> japanvideoBaseinfos);

	public JapanvideoBaseinfo getdetailsbyid(String id);

	public List<JapanvideoBaseinfo> getlatistvideo();
}
