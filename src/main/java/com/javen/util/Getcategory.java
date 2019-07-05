package com.javen.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.javen.dao.Ijapancategory;
import com.javen.model.JapanvideoCategory;
@Service
public class Getcategory {
	@Resource
	private GetHtmlbyUrl getHtmlbyUrl;
	@Resource
	private List<JapanvideoCategory> japanvideoCategorys;
	
	@Qualifier("Jpancategoryimpl")
	@Autowired
	private Ijapancategory japancategory;
	/**
	 * @param 番号
	 * @return	封面地址
	 */
	public HashSet<String> getcategoryhtml(String id) {  
		HashSet<String> coversrc = new HashSet<String>();
		String addr ="https://www.seedmm.net/genre";
		String regex = "href=\"https://www.seedmm.net/genre/[A-Za-z0-9-]*\">(.*)</a>";
		coversrc = getHtmlbyUrl.getHtmlbyRegex(id, regex);
		return coversrc;
    }  
	public String insertcategory(HashSet<String> coversrc){
		for (String html : coversrc) {
			JapanvideoCategory japanvideoCategory = new JapanvideoCategory();
			String id = html.substring(html.indexOf("/genre/")+7, html.indexOf("\">"));
			String name = html.substring(html.indexOf("\">")+2, html.indexOf("</a>"));
			japanvideoCategory.setCategoryname(name);
			japanvideoCategory.setId(id);
			japanvideoCategory.setIsexist("1");
			japanvideoCategorys.add(japanvideoCategory);
		}
		String insert = japancategory.insert(japanvideoCategorys);
		System.out.println(insert);
		return insert;
	}
}
