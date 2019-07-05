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

public class GetPicBaseInfo {
	public String getId(String picname) {
		String picId = "";
		try {

			URL url = new URL(picname);

			HttpURLConnection connection = (HttpURLConnection) url

			.openConnection();
			connection.setDoInput(true);
			connection.setRequestMethod("GET");

			connection.setConnectTimeout(2500);

			connection.setReadTimeout(2500);
			connection.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

			if (connection.getResponseCode() == 200) {

				InputStream inputStream = connection.getInputStream();

				BufferedReader reader = new BufferedReader(

				new InputStreamReader(inputStream, "UTF-8"));

				String line = "";

				Pattern pattern = null;

				Matcher matcher = null;
				// 电影列表页面
				mark:
				while ((line = reader.readLine()) != null) {

					pattern = Pattern.compile("<a href=\"/g/[0-9]*/\"");
					matcher = pattern.matcher(line);

					while (matcher.find()) {

						String newLink = matcher.group(0).trim(); // 链接
						String s = "https://nhentai.net";
						picId = newLink.split("/")[2];
						break mark;
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
		return picId;
	}

	public PicBaseinfo getpicinfo(String picurl) {
		PicBaseinfo picbaseinfo = new PicBaseinfo();
		String picId = "";
		String artist = "";
		String category = "";

		try {

			URL url = new URL(picurl);

			HttpURLConnection connection = (HttpURLConnection) url

			.openConnection();
			connection.setDoInput(true);
			connection.setRequestMethod("GET");

			connection.setConnectTimeout(2500);

			connection.setReadTimeout(2500);
			connection.setRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

			if (connection.getResponseCode() == 200) {

				InputStream inputStream = connection.getInputStream();

				BufferedReader reader = new BufferedReader(

				new InputStreamReader(inputStream, "UTF-8"));

				String line = "";

				Pattern pattern = null;

				Matcher matcher = null;
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
						artist = artist + "," + newLink;

					}

					pattern = Pattern
							.compile("<a href=\"/tag/[A-Za-z0-9-]*/\"");

					matcher = pattern.matcher(line);

					while (matcher.find()) {
						matcher.group().length();

						String newLink = matcher.group(0).trim(); // 链接

						newLink = newLink.split("\"")[1].split("/")[2]; // href="/artist/distance/"
						category = category + "," + newLink;

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
		if(artist.length()>1){
			picbaseinfo.setArtist(artist.substring(1, artist.length()));
		}
		if(category.length()>1){
			picbaseinfo.setCategory(category.substring(1, category.length()));
		}
		
		return picbaseinfo;
	}
}