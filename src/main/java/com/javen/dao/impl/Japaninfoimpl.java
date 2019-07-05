package com.javen.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.javen.dao.IjapanInfo;
import com.javen.mapping.JapanvideoBaseinfoMapper;
import com.javen.model.JapanPageBeen;
import com.javen.model.JapanvideoBaseinfo;
import com.javen.model.JapanvideoBaseinfoExample;
@Repository("Japaninfoimpl")
public class Japaninfoimpl implements IjapanInfo {

	@Resource
	private JapanvideoBaseinfoMapper japanvideoBaseinfoMapper;
	@Resource
	private JapanPageBeen pageBeen;
	@Resource
	private List<JapanvideoBaseinfo> japanvideoBaseinfo;
	@Override
	public JapanvideoBaseinfo getdetailsbyid(String id) {
		JapanvideoBaseinfo japanvideoBaseinfo = new JapanvideoBaseinfo();
		japanvideoBaseinfo = this.japanvideoBaseinfoMapper.selectByPrimaryKey(id);
		return japanvideoBaseinfo;
	}

	@Override
	public List<JapanvideoBaseinfo> getlatistvideo() {
		JapanvideoBaseinfoExample example = new JapanvideoBaseinfoExample();
		example.setSelectbygreatthannum("rounum>"+0);
		example.setSelectbylessthannum("rounum<="+6);
		example.setOrderByClause("data");
		japanvideoBaseinfo = this.japanvideoBaseinfoMapper.selectByExample(example);
		return japanvideoBaseinfo;
	}

	@Override
	public List<JapanvideoBaseinfo> getpagebyindex(int start,int end) {
		JapanvideoBaseinfoExample example = new JapanvideoBaseinfoExample();
		example.setSelectbygreatthannum("rounum>"+start);
		example.setSelectbylessthannum("rounum<="+end);
		example.setOrderByClause("lv");
		japanvideoBaseinfo = this.japanvideoBaseinfoMapper.selectByExample(example);
		return japanvideoBaseinfo;
	}

	@Override
	public List<JapanvideoBaseinfo> getpagebyartist(String artist, int start, int end) {
		JapanvideoBaseinfoExample example = new JapanvideoBaseinfoExample();
		example.createCriteria().andArtistEqualTo(artist);
		example.setSelectbygreatthannum("rounum>"+start);
		example.setSelectbylessthannum("rounum<="+end);
		japanvideoBaseinfo = this.japanvideoBaseinfoMapper.selectByExample(example);
		return japanvideoBaseinfo;
	}

	@Override
	public List<JapanvideoBaseinfo> getpagebycategory(String category, int start, int end) {
		JapanvideoBaseinfoExample example = new JapanvideoBaseinfoExample();
		example.createCriteria().andCategoryEqualTo(category);
		example.setSelectbygreatthannum("rounum>"+start);
		example.setSelectbylessthannum("rounum<="+end);
		japanvideoBaseinfo = this.japanvideoBaseinfoMapper.selectByExample(example);
		return japanvideoBaseinfo;
	}

	@Override
	public List<JapanvideoBaseinfo> getpagebylanguage(String language, int start, int end) {
		JapanvideoBaseinfoExample example = new JapanvideoBaseinfoExample();
		example.createCriteria().andLanguageEqualTo(language);
		example.setSelectbygreatthannum("rounum>"+start);
		example.setSelectbylessthannum("rounum<="+end);
		japanvideoBaseinfo = this.japanvideoBaseinfoMapper.selectByExample(example);
		return japanvideoBaseinfo;
	}

	@Override
	public List<JapanvideoBaseinfo> getpagebylevel(String level,int start, int end) {
		JapanvideoBaseinfoExample example = new JapanvideoBaseinfoExample();
		example.createCriteria().andLvEqualTo(level);
		example.setSelectbygreatthannum("rounum>"+start);
		example.setSelectbylessthannum("rounum<="+end);
		japanvideoBaseinfo = this.japanvideoBaseinfoMapper.selectByExample(example);
		return japanvideoBaseinfo;
	}

	@Override
	public int getnum(JapanvideoBaseinfoExample exam) {
		int num  = this.japanvideoBaseinfoMapper.countByExample(exam);
		return num;
	}

	@Override
	public String insert(List<JapanvideoBaseinfo> japanvideoBaseinfos) {
		String errmsg = "以下作品插入到数据库出错：";
		for (JapanvideoBaseinfo japanvideoBaseinfo : japanvideoBaseinfos) {
			if(japanvideoBaseinfo.getId()==null){
				continue;
			}
			if(this.japanvideoBaseinfoMapper.selectByPrimaryKey(japanvideoBaseinfo.getId())!=null){
				continue;
			}
			int insert = this.japanvideoBaseinfoMapper.insert(japanvideoBaseinfo);
			if(insert<1){
				errmsg=errmsg+japanvideoBaseinfo.getId()+",";
			}
		}
		
		return errmsg;
	}

	@Override
	public String update(List<JapanvideoBaseinfo> japanvideoBaseinfos) {
		String errmsg = "以下作品更新到数据库出错：";
		for (JapanvideoBaseinfo japanvideoBaseinfo : japanvideoBaseinfos) {
			int insert = this.japanvideoBaseinfoMapper.updateByPrimaryKey(japanvideoBaseinfo);
			if(insert<1){
				errmsg=errmsg+japanvideoBaseinfo.getId()+",";
			}
		}
		return errmsg;
	}

	@Override
	public String delete(List<JapanvideoBaseinfo> japanvideoBaseinfos) {
		String errmsg = "以下作品更新到数据库出错：";
		for (JapanvideoBaseinfo japanvideoBaseinfo : japanvideoBaseinfos) {
			int insert = this.japanvideoBaseinfoMapper.deleteByPrimaryKey(japanvideoBaseinfo.getId());
			if(insert<1){
				errmsg=errmsg+japanvideoBaseinfo.getId()+",";
			}
		}
		return errmsg;
	}

}
