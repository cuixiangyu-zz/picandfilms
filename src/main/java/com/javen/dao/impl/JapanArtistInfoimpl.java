package com.javen.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.javen.dao.IjapanArtistInfo;
import com.javen.mapping.JapanvideoArtistMapper;
import com.javen.mapping.JapanvideoCategoryMapper;
import com.javen.model.JapanPageBeen;
import com.javen.model.JapanvideoArtist;
import com.javen.model.JapanvideoArtistExample;
import com.javen.model.JapanvideoBaseinfo;
import com.javen.model.JapanvideoBaseinfoExample;
import com.javen.model.JapanvideoCategory;
import com.javen.model.JapanvideoCategoryExample;
@Repository("JapanArtistInfoimpl")
public class JapanArtistInfoimpl implements IjapanArtistInfo {
	@Resource
	private JapanvideoArtistMapper japanvideoArtistMapper;
	@Resource
	private JapanPageBeen pageBeen;
	@Resource
	private List<JapanvideoArtist> japanvideoArtists;
	@Override
	public List<JapanvideoArtist> getpagebyindex(int start,int end) {
		JapanvideoArtistExample example = new JapanvideoArtistExample();
		example.createCriteria().andRowNumGreaterThan(start).andrownumLessThanOrEqualTo(end);
		example.setOrderByClause("lv");
		japanvideoArtists = this.japanvideoArtistMapper.selectByExample(example);
		return japanvideoArtists;
	}

	@Override
	public JapanvideoArtist getpagebyartist(String artist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getnum(JapanvideoArtistExample exam) {
		int count = this.japanvideoArtistMapper.countByExample(exam);
		return count;
	}

	@Override
	public String insert(List<JapanvideoArtist> japanvideoArtists) {
		for (JapanvideoArtist japanvideoArtist : japanvideoArtists) {
			this.japanvideoArtistMapper.insert(japanvideoArtist);
		}
		return null;
	}

	@Override
	public String update(List<JapanvideoArtist> japanvideoArtists) {
		for (JapanvideoArtist japanvideoArtist : japanvideoArtists) {
			this.japanvideoArtistMapper.updateByPrimaryKey(japanvideoArtist);
		}
		return null;
	}

	@Override
	public String delete(List<JapanvideoArtist> japanvideoArtists) {
		for (JapanvideoArtist japanvideoArtist : japanvideoArtists) {
			this.japanvideoArtistMapper.deleteByPrimaryKey(japanvideoArtist.getId());
		}
		return null;
	}

	@Override
	public JapanvideoBaseinfo getdetailsbyid(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
