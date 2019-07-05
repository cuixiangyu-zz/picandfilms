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
	 * ����ȡ�������ݱ��������ݿ���
	 * 
	 * 
	 * 
	 * @param baseUrl
	 * 
	 *            �������
	 * 
	 * @return null
	 * 
	 * */

	public static String saveData(String baseUrl) {

		Map<String, Boolean> oldMap = new LinkedHashMap<String, Boolean>(); // �洢����-�Ƿ񱻱���

		Map<String, String> videoLinkMap = new LinkedHashMap<String, String>(); // ��Ƶ��������

		String oldLinkHost = ""; // host

		Pattern p = Pattern.compile("(https ://) [^/\\s]*"); // ���磺http://www.zifangsky.cn
		// Pattern p = Pattern.compile("href=\"*"); //
		// ���磺http://www.zifangsky.cn
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
	 * ץȡһ����վ���п���ץȡ����ҳ���ӣ���˼·��ʹ���˹�������㷨 ��δ�������������Ӳ��Ϸ���GET���� һֱ���������������϶�û�ܷ����µ�����
	 * 
	 * ���ʾ���ܷ����µ������ˣ��������
	 * 
	 * 
	 * 
	 * ��һ�����ӷ�������ʱ���Ը���ҳ�����������������Ҫ����Ƶ���ӣ��ҵ�����뼯��videoLinkMap
	 * 
	 * 
	 * 
	 * @param oldLinkHost
	 * 
	 *            �������磺http://www.zifangsky.cn
	 * 
	 * @param oldMap
	 * 
	 *            �����������Ӽ���
	 * 
	 * 
	 * 
	 * @return ��������ץȡ������Ƶ�������Ӽ���
	 * 
	 * */

	public static String crawlLinks(String oldLinkHost,

	Map<String, Boolean> oldMap, int i) {
		PicBaseinfo picbaseinfo =new  PicBaseinfo();
		String picId = "";
		String artist = "";
		String category = "";
		Map<String, Boolean> newMap = new LinkedHashMap<String, Boolean>(); // ÿ��ѭ����ȡ����������

		Map<String, String> videoLinkMap = new LinkedHashMap<String, String>(); // ��Ƶ��������

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

									String newLink = matcher.group(0).trim(); // ����

									newLink = newLink.split("\"")[1].split("/")[2]; // href="/artist/distance/"
									artist=artist+","+newLink;
									name.add(newLink);


								}
								
								pattern = Pattern
										.compile("<a href=\"/tag/[A-Za-z0-9-]*/\"");

								matcher = pattern.matcher(line);

								while (matcher.find()) {
									matcher.group().length();

									String newLink = matcher.group(0).trim(); // ����

									newLink = newLink.split("\"")[1].split("/")[2]; // href="/artist/distance/"
									category=category+","+newLink;

								}
							}
						}

						// ��Ӱ�б�ҳ��

						else if (i == 2) {

							while ((line = reader.readLine()) != null) {

								
								pattern = Pattern

								.compile("<a href=\"/g/[0-9]*/\"");
								matcher = pattern.matcher(line);

								while (matcher.find()) {

									String newLink = matcher.group(0).trim(); // ����

									
									String s = "https://nhentai.net";
									picId = newLink.split("/")[2];
									newLink = s + newLink.split("\"")[1]; // href="/g/235007/
									if (newLink.endsWith("/"))

										newLink = newLink.substring(0,

										newLink.length() - 1);

									// ȥ�أ����Ҷ���������վ������

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

		// �������ӣ���������
		String s = null;
		if (name.size() > 0) {
			 s = name.get(0);
		}
		/*
		 * if (!newMap.isEmpty()) {
		 * 
		 * oldMap.putAll(newMap); int a = 1;
		 * videoLinkMap.putAll(crawlLinks(oldLinkHost, oldMap,a)); //
		 * ����Map�����ԣ����ᵼ�³����ظ��ļ�ֵ��
		 * 
		 * }
		 */
		if (i == 2&&name.size() == 0) {
			s = crawlLinks(oldLinkHost, newMap, 1);
		}else{
			System.out.println(s);
		}
		if(name.size()>1){
			s = "������";
		}
		return s;

	}

	/**
	 * 
	 * �ж��Ƿ���2015��ĵ�Ӱ�б�ҳ��
	 * 
	 * @param url
	 *            �����URL
	 * 
	 * @return ״̬
	 * 
	 * */

	public boolean checkUrl(String url) {

		Pattern pattern = Pattern
				.compile("http://www.80s.la/movie/list/-2015----p\\d*");

		Matcher matcher = pattern.matcher(url);

		if (matcher.find())

			return true; // 2015����б�

		else

			return false;

	}

	/**
	 * 
	 * �ж�ҳ���Ƿ��ǵ�Ӱ����ҳ��
	 * 
	 * @param url
	 *            ҳ������
	 * 
	 * @return ״̬
	 * 
	 * */

	public boolean isMoviePage(String url) {

		Pattern pattern = Pattern.compile("http://www.80s.la/movie/\\d+");

		Matcher matcher = pattern.matcher(url);

		if (matcher.find())

			return true; // ��Ӱҳ��

		else

			return false;

	}

}

