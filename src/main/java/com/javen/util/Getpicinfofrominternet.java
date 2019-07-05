package com.javen.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.javen.mapping.PicBaseinfoMapper;
import com.javen.model.ComicPageBeen;
import com.javen.model.PicBaseinfo;
import com.javen.model.PicBaseinfoExample;

@Service
public class Getpicinfofrominternet {
	@Resource
	private PicBaseinfoMapper picbaseinfomapper;
	@Resource
	private ComicPageBeen pageBeen;
	@Resource
	private List<PicBaseinfo> picBaseinfo;
	private String picaddr = "H:\\source\\picture\\";
	private String coveraddr = "H:\\cover\\comic\\";
	private String filepath = "H:/2018.10.06"; // 旧文件所在文件夹
//	private String filepath = "H:/test"; // 旧文件所在文件夹
//	private String picaddr = "H:\\ttttttt\\";
	

	public void savepics() {
		GetPicBaseInfo getPicBaseInfo = new GetPicBaseInfo();
		PicBaseinfo picbaseinfo = new PicBaseinfo();
		//String filepath = "H:/2018.10.06"; // 旧文件所在文件夹
		File[] filePaths = new File(filepath).listFiles();
		String oldPath = null;
		String urlStr = null;
		List list = new ArrayList();
		for (int i = 0; i < filePaths.length; i++) {
			if(filePaths[i].listFiles()==null||filePaths[i].listFiles().length<=0){
				filePaths[i].delete();
				continue;
			}
			oldPath = filePaths[i].toString();
			String[] ss = oldPath.split("\\\\");
			String name = ss[ss.length - 1];
			if (name.indexOf("[English]") >= 0) {
				name.substring(0,name.indexOf("[English]")+9);
			} else if (name.indexOf("[Chinese]") >= 0) {
				name.substring(0,name.indexOf("[Chinese]")+9);
			}else if (name.indexOf("(Kantai Collection -KanColle-)") >= 0) {
				name.substring(0,name.indexOf("(Kantai Collection -KanColle-)"));
			}
			PicBaseinfoExample example= new PicBaseinfoExample();
			example.createCriteria().andNameEqualTo(name);
			List<PicBaseinfo> selectByExample = picbaseinfomapper.selectByExample(example);
			if(selectByExample.size()>0){
				moveFiles(oldPath,"H:/source/chongfu/"+name,"");
				continue;
			}
			try {
				urlStr = URLEncoder.encode(name, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			String url = "https://nhentai.net/search/?q=" + urlStr;
			String id = getPicBaseInfo.getId(url);
			
			if (id == null||id == "") {
				moveFiles(oldPath,"H:/source/cantfind/"+name,id);
				try {
					Thread.sleep(10*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}
			PicBaseinfo selectByPrimaryKey = picbaseinfomapper.selectByPrimaryKey(id);
			if(selectByPrimaryKey!=null){
				moveFiles(oldPath,"H:/source/chongfu/"+name,"");
				continue;
			}
			if (list.indexOf(id)>=0) {
				moveFiles(oldPath,"H:/chongfu/"+name,id);
				try {
					Thread.sleep(10*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}
			list.add(id);
			picbaseinfo = getPicBaseInfo.getpicinfo("https://nhentai.net/g/"
					+ id);
			if(picbaseinfo==null){
				continue;
			}
			if (name.indexOf("Chinese") >= 0) {
				picbaseinfo.setLanguage("Chinese");
			} else if (name.indexOf("English") >= 0) {
				picbaseinfo.setLanguage("English");
			} else {
				picbaseinfo.setLanguage("Japanese");
			}
			picbaseinfo.setId(id);
			picbaseinfo.setName(name);
			if (picbaseinfo.getArtist()!=null&&picbaseinfo.getArtist().indexOf(",")<= 0) {
				picbaseinfo.setAddr(picaddr
						+ picbaseinfo.getArtist()
						+ "\\" + id);
			} else {
				picbaseinfo.setAddr(picaddr + "artists\\" + id);
			}

			picbaseinfo.setCover(coveraddr + id);
			
			picbaseinfomapper.insert(picbaseinfo);
			String newPath = "";
			if (picbaseinfo.getArtist()!=null&&picbaseinfo.getArtist().indexOf(",")<= 0) {
				newPath = picaddr
						+ picbaseinfo.getArtist()
						+ "\\" + id; // 文件夹要移动到的目录
			} else {
				newPath = picaddr  + "artists\\" + id;
			}
			moveFiles(oldPath,newPath,id);
			try {
				Thread.sleep(10*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void moveFiles(String oldPath, String newPath, String id) {
		String[] filePaths = new File(oldPath).list();

		if (new File(newPath).exists() && new File(newPath).isDirectory()) {
			new File(oldPath).delete();
			return;
		}
		if (!new File(newPath).exists()) {
			new File(newPath).mkdirs();
		}
		for (int i = 0; i < filePaths.length; i++) {
			if (new File(oldPath + File.separator + filePaths[i]).isFile()) {
				// 复制文件到另一个目录
				// copyFile(oldPath + File.separator + filePath[i], newPath +
				// File.separator + filePath[i]);
				// 移动文件至另一个目录
				if (filePaths[i].endsWith(".fdmdownload")) { // 去除文件后缀
					String nfilePaths = filePaths[i].substring(0,
							filePaths[i].lastIndexOf("."));
					new File(oldPath + File.separator + filePaths[i])
							.renameTo(new File(newPath + File.separator
									+ nfilePaths));
					if(new File(oldPath + File.separator + filePaths[i]).exists()){
						new File(oldPath + File.separator + filePaths[i]).delete();
					}
					
				} else {
					new File(oldPath + File.separator + filePaths[i])
							.renameTo(new File(newPath + File.separator
									+ filePaths[i]));
					if(new File(oldPath + File.separator + filePaths[i]).exists()){
						new File(oldPath + File.separator + filePaths[i]).delete();
					}
					
				}
			}
		}
		if(new File(oldPath).exists()){
			new File(oldPath).delete();
		}
		
	}
	public String copycover(){
    	PicBaseinfoExample example= new PicBaseinfoExample();
    	example.createCriteria().andIdIsNotNull();
		List<PicBaseinfo> selectByExample = picbaseinfomapper.selectByExample(example);
    	for (PicBaseinfo picBaseinfo : selectByExample) {
    		String addr = picBaseinfo.getAddr();
    		String cover = picBaseinfo.getCover();
    		String name=new File(addr).listFiles()[0].getName();
    		try {
				Files.copy(new File(addr+File.separator+name).toPath(),new File("H:/cover/comic/"+picBaseinfo.getId()+name.substring(name.indexOf("."),name.length())).toPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		picBaseinfo.setCover("H:/cover/comic/"+picBaseinfo.getId()+name.substring(name.indexOf("."),name.length()));
    		picbaseinfomapper.updateByPrimaryKey(picBaseinfo);
		}
		return null;
		
	}
}
