package com.javen.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.javen.model.ComicPageBeen;
@Repository("iGetPic")
public interface IGetPic {
		public ComicPageBeen getpagebyindex(int startpage);
		
		public ComicPageBeen getpagebyartist(String artist,int currentPage);

		public ComicPageBeen getpagebycategory(String category,int currentPage);

		public ComicPageBeen getpagebylanguage(String language,int currentPage);

		public ComicPageBeen getpagebylevel(String level,int currentPage);
		
}
