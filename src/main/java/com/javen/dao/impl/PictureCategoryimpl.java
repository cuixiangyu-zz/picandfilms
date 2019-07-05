package com.javen.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.javen.dao.IPictureCategory;
import com.javen.mapping.PicCategoryMapper;
import com.javen.model.PicCategory;
import com.javen.model.PicCategoryExample;
@Repository("PictureCategoryimpl")
public class PictureCategoryimpl implements IPictureCategory {
	@Resource
	private PicCategoryExample exam;
	@Resource
	private PicCategory picCategory;
	@Resource
	private List<PicCategory> picCategorys;
	@Resource
	private PicCategoryMapper picCategoryMapper;
	@Override
	public int getnum(PicCategoryExample exam) {
		int num  = this.picCategoryMapper.countByExample(exam);
		return num;
	}

	@Override
	public List<PicCategory> getcategorybyids(List<String> ids) {
		exam.createCriteria().andIdIn(ids);
		picCategorys = this.picCategoryMapper.selectByExample(exam);
		return picCategorys;
	}

	@Override
	public int insertcategory(List<PicCategory> picCategoryss) {
		for (PicCategory picCategory : picCategoryss) {
			if(picCategory.getId()==null){
				continue;
			}
			if(this.getcategorybyid(picCategory.getId())!=null){
				continue;
			}
			this.picCategoryMapper.insert(picCategory);
		}
		return 0;
	}

	@Override
	public PicCategory getcategorybyid(String id) {
		picCategory=this.picCategoryMapper.selectByPrimaryKey(id);
		return picCategory;
	}

}
