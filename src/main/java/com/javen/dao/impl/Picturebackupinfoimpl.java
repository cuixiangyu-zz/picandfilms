package com.javen.dao.impl;

import com.javen.dao.IPictureInfo;
import com.javen.dao.IPicturebackupInfo;
import com.javen.mapping.PicBackupMapper;
import com.javen.mapping.PicBaseinfoMapper;
import com.javen.model.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("Picturebackupinfoimpl")
public class Picturebackupinfoimpl implements IPicturebackupInfo {
	@Resource
	private PicBackupMapper picBackupMapper;
	@Resource
	private ComicPageBeen pageBeen;
	@Resource
	private List<PicBackup> picBackups;
	@Resource
	private PicBackupExample example;
	
	/*@Override
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
	}*/

	@Override
	public String insert(List<PicBackup> picBackups) {

		String errmsg = "以下作品插入到数据库出错：";
		for (PicBackup picBackup : picBackups) {
			if(picBackup.getId()==null){
				continue;
			}
			if(this.picBackupMapper.selectByPrimaryKey(picBackup.getId())!=null){
				continue;
			}
			int insert = this.picBackupMapper.insert(picBackup);
			if(insert<1){
				errmsg=errmsg+picBackup.getId()+",";
			}
		}
		return errmsg;
	}

	@Override
	public String update(List<PicBackup> picBackups) {
		String errmsg = "以下作品更新到数据库出错：";
		for (PicBackup picBackup : picBackups) {
			int insert = this.picBackupMapper.updateByPrimaryKey(picBackup);
			if(insert<1){
				errmsg=errmsg+picBackup.getId()+",";
			}
		}
		return errmsg;
	}

	@Override
	public String delete(List<PicBackup> picBackups) {
		String errmsg = "以下作品更新到数据库出错：";
		for (PicBackup picBackup : picBackups) {
			int insert = this.picBackupMapper.deleteByPrimaryKey(picBackup.getId());
			if(insert<1){
				errmsg=errmsg+picBackup.getId()+",";
			}
		}
		return errmsg;
	}

	public int getnum(PicBackupExample exam){
		int num  = this.picBackupMapper.countByExample(exam);
		return num;
	}

	@Override
	public PicBackup getdetailsbyid(String id) {
		PicBackup picBackup = this.picBackupMapper.selectByPrimaryKey(id);
		return picBackup;
	}
}
