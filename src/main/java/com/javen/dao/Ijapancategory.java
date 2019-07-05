package com.javen.dao;

import java.util.List;



import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.javen.model.JapanvideoCategory;
import com.javen.model.JapanvideoCategoryExample;
@Repository("Ijapancategory")
public interface Ijapancategory {
	public List<JapanvideoCategory> getpagebyindex(int currentPage,int currentCount);
	
	public List<JapanvideoCategory> getpagebyids(List<String> ids);

	public List<JapanvideoCategory> getpagebycategoryname(String categoryname);

	public int getnum(JapanvideoCategoryExample exam);
	
	public String insert(List<JapanvideoCategory> japanvideoBaseinfos);
	
	public String update(List<JapanvideoCategory> japanvideoBaseinfos);
	
	public String delete(List<JapanvideoCategory> japanvideoBaseinfos);
}
