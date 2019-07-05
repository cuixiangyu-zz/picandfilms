package com.javen.dao;

import com.javen.model.JapanvideoBackup;
import com.javen.model.JapanvideoBackupExample;
import com.javen.model.JapanvideoBaseinfo;
import com.javen.model.JapanvideoBaseinfoExample;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("IjapanbackupInfo")
public interface IjapanbackupInfo {
	/*public List<JapanvideoBackup> getpagebyindex(int currentPage, int currentCount);

	public List<JapanvideoBackup> getpagebyartist(String artist, int currentPage, int currentCount);

	public List<JapanvideoBackup> getpagebycategory(String category, int currentPage, int currentCount);

	public List<JapanvideoBackup> getpagebylanguage(String language, int currentPage, int currentCount);

	public List<JapanvideoBackup> getpagebylevel(String level, int currentPage, int currentCount);*/
	
	public int getnum(JapanvideoBackupExample exam);
	
	public String insert(List<JapanvideoBackup> japanvideoBaseinfos);
	
	public String update(List<JapanvideoBackup> japanvideoBaseinfos);
	
	public String delete(List<JapanvideoBackup> japanvideoBaseinfos);

	public JapanvideoBackup getdetailsbyid(String id);

	/*public List<JapanvideoBackup> getlatistvideo();*/
}
