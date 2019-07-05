package com.javen.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.javen.dao.Ijapancategory;
import com.javen.mapping.JapanvideoCategoryMapper;
import com.javen.model.JapanPageBeen;
import com.javen.model.JapanvideoBaseinfo;
import com.javen.model.JapanvideoCategory;
import com.javen.model.JapanvideoCategoryExample;
@Repository("Jpancategoryimpl")
public class Jpancategoryimpl implements Ijapancategory {
	@Resource
	private JapanvideoCategoryMapper japanvideoCategoryMapper;
	@Resource
	private JapanPageBeen pageBeen;
	@Resource
	private List<JapanvideoCategory> japanvideoCategory;
	@Resource
	private JapanvideoCategoryExample example;
	@Override
	public List<JapanvideoCategory> getpagebyindex(int start,int end) {
		example.createCriteria().andRowNumGreaterThan(start).andrownumLessThan(end);
		japanvideoCategory = this.japanvideoCategoryMapper.selectByExample(example);
		return japanvideoCategory;
	}

	

	@Override
	public int getnum(JapanvideoCategoryExample exam) {
		int num  = this.japanvideoCategoryMapper.countByExample(exam);
		return num;
	}

	@Override
	public String insert(List<JapanvideoCategory> japanvideoCategorys) {
		
		String errmsg = "以下作品插入到数据库出错：";
		for (JapanvideoCategory japanvideoCategory : japanvideoCategorys) {
			if(japanvideoCategory.getId()==null){
				continue;
			}
			if(this.japanvideoCategoryMapper.selectByPrimaryKey(japanvideoCategory.getId())!=null){
				continue;
			}
			int insert = this.japanvideoCategoryMapper.insert(japanvideoCategory);
			if(insert<1){
				errmsg=errmsg+japanvideoCategory.getId()+",";
			}
		}
		return errmsg;
	}

	@Override
	public String update(List<JapanvideoCategory> japanvideoCategorys) {
		String errmsg = "以下作品更新到数据库出错：";
		for (JapanvideoCategory japanvideoCategory : japanvideoCategorys) {
			int insert = this.japanvideoCategoryMapper.updateByPrimaryKey(japanvideoCategory);
			if(insert<1){
				errmsg=errmsg+japanvideoCategory.getId()+",";
			}
		}
		return errmsg;
	}

	@Override
	public String delete(List<JapanvideoCategory> japanvideoCategorys) {
		String errmsg = "以下作品删除到数据库出错：";
		for (JapanvideoCategory japanvideoCategory : japanvideoCategorys) {
			int insert = this.japanvideoCategoryMapper.deleteByPrimaryKey(japanvideoCategory.getId());
			if(insert<1){
				errmsg=errmsg+japanvideoCategory.getId()+",";
			}
		}
		return errmsg;
	}

	@Override
	public List<JapanvideoCategory> getpagebyids(List<String> ids) {
		example.createCriteria().andIdIn(ids);
		japanvideoCategory = this.japanvideoCategoryMapper.selectByExample(example);
		return japanvideoCategory;
	}

	@Override
	public List<JapanvideoCategory> getpagebycategoryname(String categoryname) {
		example.createCriteria().andCategorynameEqualTo(categoryname);
		japanvideoCategory = this.japanvideoCategoryMapper.selectByExample(example);
		return japanvideoCategory;
	}

}
