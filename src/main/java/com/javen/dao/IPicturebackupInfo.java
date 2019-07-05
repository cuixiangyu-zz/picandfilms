package com.javen.dao;

import com.javen.model.PicBackup;
import com.javen.model.PicBackupExample;
import com.javen.model.PicBaseinfo;
import com.javen.model.PicBaseinfoExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("IPicturebackupInfo")
public interface IPicturebackupInfo {
	/*public List<PicBaseinfo> getpagebyindex(int currentPage, int currentCount);

	public List<PicBaseinfo> getpagebyartist(String artist, int currentPage, int currentCount);

	public List<PicBaseinfo> getpagebycategory(String category, int currentPage, int currentCount);

	public List<PicBaseinfo> getpagebylanguage(String language, int currentPage, int currentCount);

	public List<PicBaseinfo> getpagebylevel(String level, int currentPage, int currentCount);*/

	public String insert(List<PicBackup> picBackups);

	public String update(List<PicBackup> picBackups);

	public String delete(List<PicBackup> picBackups);
	
	public int getnum(PicBackupExample exam);

	public PicBackup getdetailsbyid(String id);
}
