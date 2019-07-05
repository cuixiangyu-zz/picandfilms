package com.javen.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.javen.model.PicBaseinfo;

public class VideoLinkGrab {


	/**
	 * 
	 * 将获取到的数据保存在数据库中
	 * 
	 * 
	 * 
	 * @param baseUrl
	 * 
	 *            爬虫起点
	 * 
	 * @return null
	 * 
	 * */

	public static String saveData(String baseUrl) {

		Map<String, Boolean> oldMap = new LinkedHashMap<String, Boolean>(); // 存储链接-是否被遍历

		Map<String, String> videoLinkMap = new LinkedHashMap<String, String>(); // 视频下载链接

		String oldLinkHost = ""; // host

		Pattern p = Pattern.compile("(https ://) [^/\\s]*"); // 比如：http://www.zifangsky.cn
		// Pattern p = Pattern.compile("href=\"*"); //
		// 比如：http://www.zifangsky.cn
		Matcher m = p.matcher(baseUrl);

		if (m.find()) {

			oldLinkHost = m.group();

		}

		oldMap.put(baseUrl, false);
		int a = 2;
		// videoLinkMap = crawlLinks(oldLinkHost, oldMap,a);
		String name = crawlLinks(oldLinkHost, oldMap, a);
		return name;

	}

	/**
	 * 
	 * 抓取一个网站所有可以抓取的网页链接，在思路上使用了广度优先算法 对未遍历过的新链接不断发起GET请求， 一直到遍历完整个集合都没能发现新的链接
	 * 
	 * 则表示不能发现新的链接了，任务结束
	 * 
	 * 
	 * 
	 * 对一个链接发起请求时，对该网页用正则查找我们所需要的视频链接，找到后存入集合videoLinkMap
	 * 
	 * 
	 * 
	 * @param oldLinkHost
	 * 
	 *            域名，如：http://www.zifangsky.cn
	 * 
	 * @param oldMap
	 * 
	 *            待遍历的链接集合
	 * 
	 * 
	 * 
	 * @return 返回所有抓取到的视频下载链接集合
	 * 
	 * */

	public static String crawlLinks(String oldLinkHost,

	Map<String, Boolean> oldMap, int i) {
		PicBaseinfo picbaseinfo =new  PicBaseinfo();
		String picId = "";
		String artist = "";
		String category = "";
		Map<String, Boolean> newMap = new LinkedHashMap<String, Boolean>(); // 每次循环获取到的新链接

		Map<String, String> videoLinkMap = new LinkedHashMap<String, String>(); // 视频下载链接

		String oldLink = "";
		ArrayList<String> link = new ArrayList<String>();
		ArrayList<String> name = new ArrayList<String>();

		for (Map.Entry<String, Boolean> mapping : oldMap.entrySet()) {


			if (!mapping.getValue()) {

				oldLink = mapping.getKey();

				try {

					URL url = new URL(oldLink);

					HttpURLConnection connection = (HttpURLConnection) url

					.openConnection();
					connection.setDoInput(true); 
					connection.setRequestMethod("GET");

					connection.setConnectTimeout(2500);

					connection.setReadTimeout(2500);
					connection
							.setRequestProperty("User-Agent",
									"Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

					if (connection.getResponseCode() == 200) {

						InputStream inputStream = connection.getInputStream();

						BufferedReader reader = new BufferedReader(

						new InputStreamReader(inputStream, "UTF-8"));

						String line = "";

						Pattern pattern = null;

						Matcher matcher = null;

						if (i == 1) {

							while ((line = reader.readLine()) != null) {


								pattern = Pattern.compile("No results found");

								matcher = pattern.matcher(line);
								if (matcher.find()) {
									break;
								}
								pattern = Pattern
										.compile("<a href=\"/artist/[A-Za-z0-9-]*/\"");

								matcher = pattern.matcher(line);

								while (matcher.find()) {
									matcher.group().length();

									String newLink = matcher.group(0).trim(); // 链接

									newLink = newLink.split("\"")[1].split("/")[2]; // href="/artist/distance/"
									artist=artist+","+newLink;
									name.add(newLink);


								}
								
								pattern = Pattern
										.compile("<a href=\"/tag/[A-Za-z0-9-]*/\"");

								matcher = pattern.matcher(line);

								while (matcher.find()) {
									matcher.group().length();

									String newLink = matcher.group(0).trim(); // 链接

									newLink = newLink.split("\"")[1].split("/")[2]; // href="/artist/distance/"
									category=category+","+newLink;

								}
							}
						}

						// 电影列表页面

						else if (i == 2) {

							while ((line = reader.readLine()) != null) {

								
								pattern = Pattern

								.compile("<a href=\"/g/[0-9]*/\"");
								matcher = pattern.matcher(line);

								while (matcher.find()) {

									String newLink = matcher.group(0).trim(); // 链接

									
									String s = "https://nhentai.net";
									picId = newLink.split("/")[2];
									newLink = s + newLink.split("\"")[1]; // href="/g/235007/
									if (newLink.endsWith("/"))

										newLink = newLink.substring(0,

										newLink.length() - 1);

									// 去重，并且丢弃其他网站的链接

									if (!oldMap.containsKey(newLink)

									&& !newMap.containsKey(newLink)

									 ) {

										System.out.println("temp: " + newLink);

										newMap.put(newLink, false);

									}

								}

							}

						}

						reader.close();

						inputStream.close();

					}

					connection.disconnect();

				} catch (MalformedURLException e) {

					e.printStackTrace();

				} catch (IOException e) {

					e.printStackTrace();

				}


				// oldMap.replace(oldLink, false, true);
				oldMap.put(oldLink, true);
			}

		}

		// 有新链接，继续遍历
		String s = null;
		if (name.size() > 0) {
			 s = name.get(0);
		}
		/*
		 * if (!newMap.isEmpty()) {
		 * 
		 * oldMap.putAll(newMap); int a = 1;
		 * videoLinkMap.putAll(crawlLinks(oldLinkHost, oldMap,a)); //
		 * 由于Map的特性，不会导致出现重复的键值对
		 * 
		 * }
		 */
		if (i == 2&&name.size() == 0) {
			s = crawlLinks(oldLinkHost, newMap, 1);
		}else{
			System.out.println(s);
		}
		if(name.size()>1){
			s = "多作者";
		}
		return s;

	}

	/**
	 * 
	 * 判断是否是2015年的电影列表页面
	 * 
	 * @param url
	 *            待检查URL
	 * 
	 * @return 状态
	 * 
	 * */

	public boolean checkUrl(String url) {

		Pattern pattern = Pattern
				.compile("http://www.80s.la/movie/list/-2015----p\\d*");

		Matcher matcher = pattern.matcher(url);

		if (matcher.find())

			return true; // 2015年的列表

		else

			return false;

	}

	/**
	 * 
	 * 判断页面是否是电影详情页面
	 * 
	 * @param url
	 *            页面链接
	 * 
	 * @return 状态
	 * 
	 * */

	public boolean isMoviePage(String url) {

		Pattern pattern = Pattern.compile("http://www.80s.la/movie/\\d+");

		Matcher matcher = pattern.matcher(url);

		if (matcher.find())

			return true; // 电影页面

		else

			return false;

	}

}

