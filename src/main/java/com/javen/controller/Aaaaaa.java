/*
package com.javen.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javen.model.ComicPageBeen;
import com.javen.model.Pictures;
import com.javen.model.User;
@Controller
public class Aaaaaa {
@RequestMapping("/pagebeen.do")
public @ResponseBody ComicPageBeen Getpagebeen() {
	Pictures pic = new Pictures(1, "cxy", "/qaz/Sx1809.jpg", "cxy", "English", "zhengjianzhao", "/qaz/Sx1809.jpg", new Date(), "Y", "3");
	Pictures pic2 = new Pictures(1, "cxy", "/qaz/Sx1809.jpg", "cxy", "English", "zhengjianzhao", "/qaz/Sx1809.jpg", new Date(), "Y", "3");
	Pictures pic3 = new Pictures(1, "cxy", "/qaz/Sx1809.jpg", "cxy", "English", "zhengjianzhao", "/qaz/Sx1809.jpg", new Date(), "Y", "3");

	Pictures pic4 = new Pictures(1, "cxy", "/qaz/Sx1809.jpg", "cxy", "English", "zhengjianzhao", "/qaz/Sx1809.jpg", new Date(), "Y", "3");
	
	Pictures pic5 = new Pictures(1, "cxy", "/qaz/Sx1809.jpg", "cxy", "English", "zhengjianzhao", "/qaz/Sx1809.jpg", new Date(), "Y", "3");
	Pictures pic6 = new Pictures(1, "cxy", "/qaz/Sx1809.jpg", "cxy", "English", "zhengjianzhao", "/qaz/Sx1809.jpg", new Date(), "Y", "3");
	Pictures pic7 = new Pictures(1, "cxy", "/qaz/Sx1809.jpg", "cxy", "English", "zhengjianzhao", "/qaz/Sx1809.jpg", new Date(), "Y", "3");

	Pictures pic8 = new Pictures(1, "cxy", "/qaz/Sx1809.jpg", "cxy", "English", "zhengjianzhao", "/qaz/Sx1809.jpg", new Date(), "Y", "3");
	ComicPageBeen page  = new ComicPageBeen();
	ArrayList<Pictures> pics = new ArrayList<Pictures>() ;
	pics.add(pic);
	pics.add(pic2);
	pics.add(pic3);
	pics.add(pic4);
	pics.add(pic5);
	pics.add(pic6);
	pics.add(pic7);
	pics.add(pic8);
	page.setPicture(pics);
	page.setCurrentCount(10);
	page.setCurrentPage(10);
	page.setTotalCount(500);
	page.setTotalPage(50);
	return page;
}
}
*/
