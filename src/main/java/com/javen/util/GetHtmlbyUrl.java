package com.javen.util;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/*
 * 通过url获取html
 */
@Service
public class GetHtmlbyUrl {
	
	
	/**
	 * @return	封面地址
	 */
	public HashSet<String> getpicurl(String id) {  
		HashSet<String> coversrc = new HashSet<String>();
        try {  
            //建立连接  
        	String addr = "https://www.seedmm.net/search/"+id+"&type=&parent=ce";
        	URL url = new URL(addr);
        	for (int i = 1;i<6;i++){
        	HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setRequestMethod("GET");  
            httpUrlConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            //获取输入流  
            InputStream input = httpUrlConn.getInputStream();
            //将字节输入流转换为字符输入流
            InputStreamReader read = new InputStreamReader(input, "utf-8");
            //为字符输入流添加缓冲
            BufferedReader br = null;
            		br = new BufferedReader(read);  
            // 读取返回结果  
            String data = "";
            while ((data = br.readLine()) != null) {

            	Pattern pattern = null;

				Matcher matcher = null;
				pattern = Pattern
						.compile("https://pics.javcdn.pw/thumb/[A-Za-z0-9-]*.jpg");
				matcher = pattern.matcher(data);

				while (matcher.find()) {
					matcher.group().length();

					String newLink = matcher.group(0).trim(); // 链接
					coversrc.add(newLink);
				}
			}
            // 释放资源  
            br.close();  
            read.close();  
            input.close();  
            httpUrlConn.disconnect(); 
        	}
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return coversrc;
    }  
	public HashSet<String> getHtmlbyRegex(String addr,String regex) {  
		HashSet<String> coversrc = new HashSet<String>();
        try {  
            //建立连接  
        	URL url = new URL(addr);
        	HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setRequestMethod("GET");  
            httpUrlConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            //获取输入流  
            InputStream input = httpUrlConn.getInputStream();
            //将字节输入流转换为字符输入流
            InputStreamReader read = new InputStreamReader(input, "utf-8");
            //为字符输入流添加缓冲
            BufferedReader br = null;
            		br = new BufferedReader(read);  
            // 读取返回结果  
            String data = "";
            while ((data = br.readLine()) != null) {

            	Pattern pattern = null;

				Matcher matcher = null;
				pattern = Pattern
						.compile(regex);
				matcher = pattern.matcher(data);

				while (matcher.find()) {
					matcher.group().length();

					String newLink = matcher.group(0).trim(); // 链接
					coversrc.add(newLink);
				}
			}
            // 释放资源  
            br.close();  
            read.close();  
            input.close();  
            httpUrlConn.disconnect(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
		return coversrc;
    }

	//根据影片id查询网站，获取标题，演员，分类，图片url
	public Map<String,String> getvideoinfo(String id) {
		Map<String,String> coversrc = new HashMap<String,String>();
		String category = "";
		String artists = "";
		String title = "";
		String picurl = "";
		try {
			//建立连接
			URL url = new URL("https://www.seedmm.in/"+id);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
			httpUrlConn.setDoInput(true);
			httpUrlConn.setRequestMethod("GET");
			httpUrlConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			//获取输入流
			InputStream input = httpUrlConn.getInputStream();
			//将字节输入流转换为字符输入流
			InputStreamReader read = new InputStreamReader(input, "utf-8");
			//为字符输入流添加缓冲
			BufferedReader br = null;
			br = new BufferedReader(read);
			// 读取返回结果
			String data = "";
			while ((data = br.readLine()) != null) {
				//System.out.println(data);
				//匹配分类
				Pattern pattern = null;
				Matcher matcher = null;
				pattern = Pattern
						.compile("href=\"https://www.seedmm.in/genre/[A-Za-z0-9-]*");
				matcher = pattern.matcher(data);
				while (matcher.find()) {
					matcher.group().length();
					String newLink = matcher.group(0).trim(); // 链接
					category=newLink.substring(newLink.indexOf("genre/")+6,newLink.length())+","+category;
				}

				//匹配演员
				Pattern pattern1 = null;
				Matcher matcher1 = null;
				pattern1 = Pattern
						.compile("<a href=\"https://www.seedmm.in/star/.*\" title=\".*\">");
				matcher1 = pattern1.matcher(data);
				while (matcher1.find()) {
					matcher1.group().length();
					String newLink = matcher1.group(0).trim(); // 链接
					String artist=newLink.substring(newLink.indexOf("title=")+7,newLink.length()-2);
					if (artists.indexOf(artist)<0){
						artists=artist+","+artists;
					}
				}

				//匹配标题
				Pattern pattern2 = null;
				Matcher matcher2 = null;
				pattern2 = Pattern
						.compile("<title>.*</title>");
				matcher2 = pattern2.matcher(data);
				while (matcher2.find()) {
					matcher2.group().length();
					String newLink = matcher2.group(0).trim(); // 链接
					title=newLink.substring(newLink.indexOf("<title>")+7,newLink.indexOf("</title>"));

				}

				//匹配图片
				Pattern pattern3 = null;
				Matcher matcher3 = null;
				pattern3 = Pattern
						.compile("img src=\"https://pics.javcdn.pw/cover/.*.jpg");
				matcher3 = pattern3.matcher(data);
				while (matcher3.find()) {
					matcher3.group().length();
					String newLink = matcher3.group(0).trim(); // 链接
					picurl = newLink.substring(newLink.indexOf("src")+5,newLink.length());
				}
			}
			// 释放资源
			br.close();
			read.close();
			input.close();
			httpUrlConn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		coversrc.put("category",category);
		coversrc.put("artists",artists);
		coversrc.put("title",title);
		coversrc.put("picurl",picurl);
		return coversrc;
	}
}
