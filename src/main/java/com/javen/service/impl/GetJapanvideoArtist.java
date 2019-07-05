package com.javen.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.javen.dao.IjapanArtistInfo;
import com.javen.dao.IjapanInfo;
import com.javen.model.JapanArtistPageBeen;
import com.javen.model.JapanPageBeen;
import com.javen.model.JapanvideoArtist;
import com.javen.model.JapanvideoArtistExample;
import com.javen.model.JapanvideoBaseinfo;
import com.javen.model.JapanvideoBaseinfoExample;
import com.javen.service.IGetJapanVideoArtist;
@Repository("getJapanvideoArtist")
public class GetJapanvideoArtist implements IGetJapanVideoArtist {
	private final Integer nums = 12;
	private  Integer totalCount ;
	@Resource
	private JapanArtistPageBeen japanArtistPageBeen;
	
	@Qualifier("JapanArtistInfoimpl")
	@Resource
	private IjapanArtistInfo japanArtistInfo;
	
	@Qualifier("Japaninfoimpl")
	@Resource
	private IjapanInfo japanInfo;
	@Resource
	private List<JapanvideoArtist> japanvideoArtists;
//	@Resource
//	private JapanvideoBaseinfoExample example;
	@Override
	public JapanArtistPageBeen getpagebyindex(int startpage) {
		int endnum = (startpage-1)*nums+nums;
		japanvideoArtists = japanArtistInfo.getpagebyindex((startpage-1)*nums, endnum);
		JapanvideoArtistExample artistexample = new JapanvideoArtistExample();
		artistexample.createCriteria().andIdIsNotNull();
		totalCount = japanArtistInfo.getnum(artistexample);
		/*for (JapanvideoArtist japanvideoArtist : japanvideoArtists) {
			JapanvideoBaseinfoExample example = new JapanvideoBaseinfoExample();
			example.createCriteria().andArtistEqualTo(japanvideoArtist.getArtist());
			int num = japanInfo.getnum(example);
			japanvideoArtist.setArtist(String.valueOf(num));
			String addr = japanvideoArtist.getaddr();
			japanvideoArtist.setaddr("/cover"+addr.substring(8, addr.length()));
		}*/
		
		
		japanArtistPageBeen.setJapanvideoArtists(japanvideoArtists);
		japanArtistPageBeen.setCurrentCount(nums);
		japanArtistPageBeen.setCurrentPage(startpage);
		japanArtistPageBeen.setTotalCount(totalCount);
		japanArtistPageBeen.setTotalPage((int)Math.ceil(totalCount/nums)+1);
		return japanArtistPageBeen;
	}

	@Override
	public JapanArtistPageBeen getpagebyartist(String artist) {
		// TODO Auto-generated method stub
		return null;
	}

}
