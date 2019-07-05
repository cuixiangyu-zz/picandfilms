package com.javen.dao.impl;

import com.javen.dao.IjapanInfo;
import com.javen.dao.IjapanbackupInfo;
import com.javen.mapping.JapanvideoBackupMapper;
import com.javen.mapping.JapanvideoBaseinfoMapper;
import com.javen.model.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("Japanbackupinfoimpl")
public class Japanbackupinfoimpl implements IjapanbackupInfo {

	@Resource
	private JapanvideoBackupMapper japanvideoBackupMapper;
	@Resource
	private JapanPageBeen pageBeen;
	@Resource
	private List<JapanvideoBackup> japanvideoBackups;
	@Override
	public JapanvideoBackup getdetailsbyid(String id) {
		JapanvideoBackup japanvideoBackup = new JapanvideoBackup();
		japanvideoBackup = this.japanvideoBackupMapper.selectByPrimaryKey(id);
		return japanvideoBackup;
	}



	/*@Override
	public List<JapanvideoBackup> getlatistvideo() {
		JapanvideoBaseinfoExample example = new JapanvideoBaseinfoExample();
		example.setSelectbygreatthannum("rounum>"+0);
		example.setSelectbylessthannum("rounum<="+6);
		example.setOrderByClause("data");
		japanvideoBackups = this.japanvideoBackupMapper.selectByExample(example);
		return japanvideoBackups;
	}

	@Override
	public List<JapanvideoBackup> getpagebyindex(int start,int end) {
		JapanvideoBaseinfoExample example = new JapanvideoBaseinfoExample();
		example.setSelectbygreatthannum("rounum>"+start);
		example.setSelectbylessthannum("rounum<="+end);
		example.setOrderByClause("lv");
		japanvideoBaseinfo = this.japanvideoBackupMapper.selectByExample(example);
		return japanvideoBaseinfo;
	}

	@Override
	public List<JapanvideoBackup> getpagebyartist(String artist, int start, int end) {
		JapanvideoBaseinfoExample example = new JapanvideoBaseinfoExample();
		example.createCriteria().andArtistEqualTo(artist);
		example.setSelectbygreatthannum("rounum>"+start);
		example.setSelectbylessthannum("rounum<="+end);
		japanvideoBaseinfo = this.japanvideoBackupMapper.selectByExample(example);
		return japanvideoBaseinfo;
	}

	@Override
	public List<JapanvideoBackup> getpagebycategory(String category, int start, int end) {
		JapanvideoBaseinfoExample example = new JapanvideoBaseinfoExample();
		example.createCriteria().andCategoryEqualTo(category);
		example.setSelectbygreatthannum("rounum>"+start);
		example.setSelectbylessthannum("rounum<="+end);
		japanvideoBaseinfo = this.japanvideoBackupMapper.selectByExample(example);
		return japanvideoBaseinfo;
	}

	@Override
	public List<JapanvideoBackup> getpagebylanguage(String language, int start, int end) {
		JapanvideoBaseinfoExample example = new JapanvideoBaseinfoExample();
		example.createCriteria().andLanguageEqualTo(language);
		example.setSelectbygreatthannum("rounum>"+start);
		example.setSelectbylessthannum("rounum<="+end);
		japanvideoBaseinfo = this.japanvideoBackupMapper.selectByExample(example);
		return japanvideoBaseinfo;
	}

	@Override
	public List<JapanvideoBackup> getpagebylevel(String level,int start, int end) {
		JapanvideoBackupExample example = new JapanvideoBackupExample();
		example.createCriteria().andLvEqualTo(level);
		example.setSelectbygreatthannum("rounum>"+start);
		example.setSelectbylessthannum("rounum<="+end);
		japanvideoBaseinfo = this.japanvideoBackupMapper.selectByExample(example);
		return japanvideoBaseinfo;
	}*/

	@Override
	public int getnum(JapanvideoBackupExample exam) {
		int num  = this.japanvideoBackupMapper.countByExample(exam);
		return num;
	}

	@Override
	public String insert(List<JapanvideoBackup> japanvideoBackups) {
		String errmsg = "以下作品插入到数据库出错：";
		for (JapanvideoBackup japanvideoBackup : japanvideoBackups) {
			if(japanvideoBackup.getId()==null){
				continue;
			}
			if(this.japanvideoBackupMapper.selectByPrimaryKey(japanvideoBackup.getId())!=null){
				continue;
			}
			int insert = this.japanvideoBackupMapper.insert(japanvideoBackup);
			if(insert<1){
				errmsg=errmsg+japanvideoBackup.getId()+",";
			}
		}
		
		return errmsg;
	}

	@Override
	public String update(List<JapanvideoBackup> japanvideoBackups) {
		String errmsg = "以下作品更新到数据库出错：";
		for (JapanvideoBackup japanvideoBackup : japanvideoBackups) {
			int insert = this.japanvideoBackupMapper.updateByPrimaryKey(japanvideoBackup);
			if(insert<1){
				errmsg=errmsg+japanvideoBackup.getId()+",";
			}
		}
		return errmsg;
	}

	@Override
	public String delete(List<JapanvideoBackup> japanvideoBackups) {
		String errmsg = "以下作品更新到数据库出错：";
		for (JapanvideoBackup japanvideoBackup : japanvideoBackups) {
			int insert = this.japanvideoBackupMapper.deleteByPrimaryKey(japanvideoBackup.getId());
			if(insert<1){
				errmsg=errmsg+japanvideoBackup.getId()+",";
			}
		}
		return errmsg;
	}

}
