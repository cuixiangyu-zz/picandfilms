/*
package com.javen.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.javen.dao.IjapanInfo;
import com.javen.dao.Ijapancategory;
import com.javen.mapping.JapanvideoBaseinfoMapper;
import com.javen.model.JapanvideoBaseinfo;
import com.javen.model.JapanvideoCategory;
@Service
public class UpdateDateSource {
	@Value(value="#{prop.japenesemp4fileaddr}")
	private String japenesemp4fileaddr;
	
	@Value(value="#{prop.picfileaddr}")
	private String picfileaddr;
	
	@Value(value="#{prop.coveraddr}")
	private String coveraddr;
	private File[] listFiles2;
	private File[] listFiles;
	private String artistname;
	private String filename;
	private String filepath;
	@Resource
	private List<JapanvideoBaseinfo> japanvideoBaseinfos;
	@Resource
	private Getcategory getcategory;
	
	@Resource
	private JapanvideoBaseinfoMapper japanvideoBaseinfoMapper;
	@Qualifier("Japaninfoimpl")
	@Autowired
	private IjapanInfo japanInfo;
	public void updatejapenese(){
		File file = new File(japenesemp4fileaddr);
		listFiles = file.listFiles();
		
		File coverfile= new File(coveraddr);
		File[] cover = coverfile.listFiles();
		ArrayList covername = new ArrayList();
		for (File file2 : cover) {
			covername.add(file2.getName().substring(0,file2.getName().indexOf(".")));
		}
		
		for (File artist : listFiles) {
			artistname = artist.getName();
			listFiles2 = artist.listFiles();
			for (File file3 : listFiles2) {
				JapanvideoBaseinfo japanvideoBaseinfo = new JapanvideoBaseinfo();
				filename = file3.getName().substring(0,file3.getName().indexOf("."));
				filepath = file3.getPath();
				if(this.japanvideoBaseinfoMapper.selectByPrimaryKey(filename)!=null){
					continue;
				}
				HashSet<String> getcategoryhtml = getcategory.getcategoryhtml("https://www.seedmm.net/"+filename);
				String category = "";
				for (String html : getcategoryhtml) {
					JapanvideoCategory japanvideoCategory = new JapanvideoCategory();
					String id = html.substring(html.indexOf("/genre/")+7, html.indexOf("\">"));
					String name = html.substring(html.indexOf("\">")+2, html.indexOf("</a>"));
					category=category+id+",";
				}
				japanvideoBaseinfo.setCategory(category);
				japanvideoBaseinfo.setId(filename);
				japanvideoBaseinfo.setAddr(filepath);
				japanvideoBaseinfo.setIsexist("1");
				japanvideoBaseinfo.setLanguage("jp");
				if(covername.contains(filename)){
					japanvideoBaseinfo.setCover(coveraddr+File.separator+filename);
				}
				japanvideoBaseinfo.setArtist(artistname);
				japanvideoBaseinfos.add(japanvideoBaseinfo);
			}
			japanInfo.insert(japanvideoBaseinfos);
		}
	}
}
*/
