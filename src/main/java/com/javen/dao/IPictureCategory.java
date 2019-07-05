package com.javen.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.javen.model.PicCategory;
import com.javen.model.PicCategoryExample;
@Repository("IPictureCategory")
public interface IPictureCategory {
	
	public int getnum(PicCategoryExample exam);
	public List<PicCategory> getcategorybyids(List<String> ids);
	public PicCategory getcategorybyid(String ids);
	public int insertcategory(List<PicCategory> picCategorys);
}
