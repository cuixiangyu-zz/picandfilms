package com.javen.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.javen.dao.IPictureInfo;
import com.javen.mapping.PicBaseinfoMapper;
import com.javen.model.ComicPageBeen;
import com.javen.model.JapanvideoBaseinfo;
import com.javen.model.PicBaseinfo;
import com.javen.model.PicBaseinfoExample;

@Repository("pictureinfoimpl")
public class Pictureinfoimpl implements IPictureInfo {
	@Resource
	private PicBaseinfoMapper picbaseinfomapper;
	@Resource
	private ComicPageBeen pageBeen;
	@Resource
	private List<PicBaseinfo> picBaseinfo;
	@Resource
	private PicBaseinfoExample example;
	
	@Override
	public List<PicBaseinfo> getpagebyindex(int start, int end) {
		PicBaseinfoExample example = new PicBaseinfoExample();
		example.createCriteria().andRowNumGreaterThan(start).andrownumLessThanOrEqualTo(end);
		example.setOrderByClause("lv");
		picBaseinfo = this.picbaseinfomapper.selectByExample(example);
		return picBaseinfo;
	}

	@Override
	public List<PicBaseinfo> getpagebyartist(String artist, int start, int end) {
		PicBaseinfoExample example = new PicBaseinfoExample();
		example.createCriteria().andArtistEqualTo(artist).andRowNumGreaterThan(start).andrownumLessThanOrEqualTo(end);
		picBaseinfo = this.picbaseinfomapper.selectByExample(example);
		return picBaseinfo;
	}

	@Override
	public List<PicBaseinfo> getpagebycategory(String category, int start, int end) {
		PicBaseinfoExample example = new PicBaseinfoExample();
		example.createCriteria().andCategoryEqualTo(category).andRowNumGreaterThan(start).andrownumLessThanOrEqualTo(end);
		picBaseinfo = this.picbaseinfomapper.selectByExample(example);
		return picBaseinfo;
	}

	@Override
	public List<PicBaseinfo> getpagebylanguage(String language, int start, int end) {
		PicBaseinfoExample example = new PicBaseinfoExample();
		example.createCriteria().andLanguageEqualTo(language).andRowNumGreaterThan(start).andrownumLessThanOrEqualTo(end);
		picBaseinfo = this.picbaseinfomapper.selectByExample(example);
		return picBaseinfo;
	}

	@Override
	public List<PicBaseinfo> getpagebylevel(String level,int start, int end) {
		PicBaseinfoExample example = new PicBaseinfoExample();
		example.createCriteria().andLvEqualTo(level).andRowNumGreaterThan(start).andrownumLessThanOrEqualTo(end);
		picBaseinfo = this.picbaseinfomapper.selectByExample(example);
		return picBaseinfo;
	}

	@Override
	public String insert(List<PicBaseinfo> picBaseinfos) {

		String errmsg = "以下作品插入到数据库出错：";
		for (PicBaseinfo picBaseinfo : picBaseinfos) {
			if(picBaseinfo.getId()==null){
				continue;
			}
			if(this.picbaseinfomapper.selectByPrimaryKey(picBaseinfo.getId())!=null){
				continue;
			}
			int insert = this.picbaseinfomapper.insert(picBaseinfo);
			if(insert<1){
				errmsg=errmsg+picBaseinfo.getId()+",";
			}
		}
		return errmsg;
	}

	@Override
	public String update(List<PicBaseinfo> picBaseinfos) {
		String errmsg = "以下作品更新到数据库出错：";
		for (PicBaseinfo picBaseinfo : picBaseinfos) {
			int insert = this.picbaseinfomapper.updateByPrimaryKey(picBaseinfo);
			if(insert<1){
				errmsg=errmsg+picBaseinfo.getId()+",";
			}
		}
		return errmsg;
	}

	@Override
	public String delete(List<PicBaseinfo> picBaseinfos) {
		String errmsg = "以下作品更新到数据库出错：";
		for (PicBaseinfo picBaseinfo : picBaseinfos) {
			int insert = this.picbaseinfomapper.deleteByPrimaryKey(picBaseinfo.getId());
			if(insert<1){
				errmsg=errmsg+picBaseinfo.getId()+",";
			}
		}
		return errmsg;
	}

	public int getnum(PicBaseinfoExample exam){
		int num  = this.picbaseinfomapper.countByExample(exam);
		return num;
	}

	@Override
	public PicBaseinfo getdetailsbyid(String id) {
		PicBaseinfo picBaseinfo = this.picbaseinfomapper.selectByPrimaryKey(id);
		return picBaseinfo;
	}
}
