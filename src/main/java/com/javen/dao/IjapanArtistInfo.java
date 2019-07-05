package com.javen.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.javen.model.JapanvideoArtist;
import com.javen.model.JapanvideoArtistExample;
import com.javen.model.JapanvideoBaseinfo;
import com.javen.model.JapanvideoBaseinfoExample;
@Repository("IjapanArtistInfo")
public interface IjapanArtistInfo {
	public List<JapanvideoArtist> getpagebyindex(int currentPage,int currentCount);
	
	public JapanvideoArtist getpagebyartist(String artist);
	
	public int getnum(JapanvideoArtistExample exam);
	
	public String insert(List<JapanvideoArtist> japanvideoArtists);
	
	public String update(List<JapanvideoArtist> japanvideoArtists);
	
	public String delete(List<JapanvideoArtist> japanvideoArtists);

	public JapanvideoBaseinfo getdetailsbyid(String id);
}
