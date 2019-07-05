package com.javen.controller;

import javax.annotation.Resource;
import javax.json.Json;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.javen.dao.IPictureInfo;
import com.javen.dao.IPicturebackupInfo;
import com.javen.dao.IjapanInfo;
import com.javen.dao.IjapanbackupInfo;
import com.javen.mapping.PicBackupMapper;
import com.javen.model.*;
import com.javen.util.Downloadcover;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.javen.util.SavePicIdtotxt;

import java.util.*;

@Controller
public class SavePicId {
	@Qualifier("Japanbackupinfoimpl")
	@Resource
	private IjapanbackupInfo japanbackupInfo;



	@Resource
	private List<JapanvideoBackup> japanvideoBackups;

	@Qualifier("Picturebackupinfoimpl")
	@Resource
	private IPicturebackupInfo pic;
	@Resource
	private List<PicBackup> picBackups;
	@Resource
	private Downloadcover downloadcover;

	@RequestMapping("savepicidtotext.do")
	public String savepicidtotext(@RequestParam(value = "picname")String picname,@RequestParam(value = "picid")String picid,HttpServletRequest request){
		SavePicIdtotxt sp = new SavePicIdtotxt();

		String artists = (String)request.getAttribute("artists");
		String categorys = (String)request.getAttribute("categorys");
		sp.savepicinfototxt(picid, picname,artists,categorys);
		String url = (String)request.getAttribute("url");
		String date = (String)request.getAttribute("date");
		try {
			String download = downloadcover.download(url, "H:/cover/japanartist", picid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("savejapantotext.do")
	public String savejapantotext(HttpServletRequest request){
		SavePicIdtotxt sp = new SavePicIdtotxt();
		String japanid = (String)request.getAttribute("japanid");
		String japanname = (String)request.getAttribute("japanname");
		String artists = (String)request.getAttribute("artists");
		String categorys = (String)request.getAttribute("categorys");
		sp.savepicinfototxt(japanid, japanname,artists,categorys);
		String url = (String)request.getAttribute("url");
		String date = (String)request.getAttribute("date");
		try {
			String download = downloadcover.download(url, "H:/cover/japanartist", japanid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@CrossOrigin
	@RequestMapping("saveinfo.do")
	public String saveinfo(HttpServletRequest request,@RequestParam String title,
						   @RequestParam String picurl,@RequestParam String id,@RequestParam String arrayurl){
		//Map<String, Object> mapdata = JSONObject.parseObject(jsons);
		JapanvideoBackup japanvideoBackup = new JapanvideoBackup();
		/*JSONArray urls = JSON.parseArray(arrayurl);
		Object o = urls.get(0);*/

		JSONArray json = JSONArray.parseArray(arrayurl ); // 首先把字符串转成 JSONArray  对象
		String name ="";
		String category ="";
		if(json.size()>0){
			for(int i=0;i<json.size();i++){

				String html =json.get(i).toString();// 遍历 jsonarray 数组，把每一个对象转成 json 对象
				if (html.indexOf("star")>0){
					name=html.substring(html.indexOf(",\"")+2,html.length()-2)+","+name;
				}else if(html.indexOf("genre")>0){
					category=html.substring(html.indexOf("genre")+6,html.indexOf("\","))+","+category;
				}
				System.out.println() ;  // 得到 每个对象中的属性值
			}
		}
		japanvideoBackup.setId(id);
		japanvideoBackup.setArtist(name);
		japanvideoBackup.setCategory(category);
		japanvideoBackup.setVideoname(title);
		japanvideoBackups.clear();
		japanvideoBackups.add(japanvideoBackup);
		japanbackupInfo.insert(japanvideoBackups);
		try {
			String download = downloadcover.download(picurl, "G:\\test", id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//japanvideoBackup.setArtist();
		//japanbackupInfo.update(japanvideoBackups);
		//System.out.println(title);
		return "success";
	}

	@CrossOrigin
	@RequestMapping("getpicinfofromnet.do")
	public String savepicinfo(HttpServletRequest request,@RequestParam String arrayurl){
		//Map<String, Object> mapdata = JSONObject.parseObject(arrayurl);
		picBackups.clear();
		JSONArray urls = JSON.parseArray(arrayurl);
		Object o = urls.get(0);
		for (int i=0;i<urls.size();i++) {
			PicBackup picBackup = new PicBackup();
			JSONArray array = JSONArray.parseArray(urls.getString(i));
			JSONObject o1 = (JSONObject) array.get(1);
			String picurl = o1.getString("picurl");
			String id = o1.getString("id");
			String title = o1.getString("title");
			picBackup.setName(title);
			picBackup.setId(id);
			picBackups.add(picBackup);
			try {
				String download = downloadcover.download(picurl, "G:\\test", id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//array.
		}
		String name ="";
		String category ="";

		pic.insert(picBackups);
		return "success";
	}
}
