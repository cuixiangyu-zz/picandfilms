package com.javen.service;

import org.springframework.stereotype.Repository;

import com.javen.model.JapanPageBeen;
@Repository("IGetJapanVideo")
public interface IGetJapanVideo {
		public JapanPageBeen getpagebyindex(int startpage);
		
		public JapanPageBeen getpagebyartist(String artist,int currentPage);

		public JapanPageBeen getpagebycategory(String category,int currentPage);

		public JapanPageBeen getpagebylanguage(String language,int currentPage);

		public JapanPageBeen getpagebylevel(String level,int currentPage);

		public JapanPageBeen getlatistvideo(int currentPage);
		
}
