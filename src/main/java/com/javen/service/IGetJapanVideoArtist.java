package com.javen.service;

import org.springframework.stereotype.Repository;

import com.javen.model.JapanArtistPageBeen;
@Repository("IGetJapanVideoArtist")
public interface IGetJapanVideoArtist {
		public JapanArtistPageBeen getpagebyindex(int startpage);
		
		public JapanArtistPageBeen getpagebyartist(String artist);

		
		
}
