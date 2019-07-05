package com.javen.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.javen.mapping.PicBaseinfoMapper;
import com.javen.model.ComicPageBeen;
import com.javen.model.PicBaseinfo;
import com.javen.model.PicBaseinfoExample;

/*
*
* 图片自动分类
*
* */
@Service
public class DuoXianCheng {
	@Resource
	private PicBaseinfoMapper picbaseinfomapper;
	@Resource
	private ComicPageBeen pageBeen;
	@Resource
	private List<PicBaseinfo> picBaseinfo;
	@Resource
	private PicBaseinfoExample example;
	//private String picaddr = "H:\\source\\picture\\";
	private String coveraddr = "H:\\cover\\comic\\";
	//private String filepath = "H:/2018.10.06"; // 旧文件所在文件夹
	private String filepath = "H:/test"; // 旧文件所在文件夹
	private String picaddr = "H:\\ttttttt\\";
	

	public void savepics() {
		GetPicBaseInfo getPicBaseInfo = new GetPicBaseInfo();
		PicBaseinfo picbaseinfo = new PicBaseinfo();
		//String filepath = "H:/2018.10.06"; // 旧文件所在文件夹
		File[] filePaths = new File(filepath).listFiles();
		String oldPath = null;
		String urlStr = null;
		for (int i = 0; i < filePaths.length; i++) {
			oldPath = filePaths[i].toString();
			String[] ss = oldPath.split("\\\\");
			String name = ss[ss.length - 1];
			try {
				urlStr = URLEncoder.encode(name, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			String url = "https://nhentai.net/search/?q=" + urlStr;
			String id = getPicBaseInfo.getId(url);
			if (id == null) {
				continue;
			}
			picbaseinfo = getPicBaseInfo.getpicinfo("https://nhentai.net/g/"
					+ id);
			if (name.indexOf("Chinese") >= 0) {
				picbaseinfo.setLanguage("Chinese");
			} else if (name.indexOf("English") >= 0) {
				picbaseinfo.setLanguage("English");
			} else {
				picbaseinfo.setLanguage("Japanese");
			}
			picbaseinfo.setId(id);
			picbaseinfo.setName(name);
			if (picbaseinfo.getArtist().indexOf(",")<= 0) {
				picbaseinfo.setAddr(picaddr
						+ picbaseinfo.getArtist()
						+ "\\" + id);
			} else {
				picbaseinfo.setAddr(picaddr + "artists\\" + id);
			}

			picbaseinfo.setCover(coveraddr + id);
			picbaseinfomapper.insert(picbaseinfo);
			String newPath = "";
			if (picbaseinfo.getArtist().indexOf(",")<= 0) {
				newPath = picaddr
						+ picbaseinfo.getArtist()
						+ "\\" + id; // 文件夹要移动到的目录
			} else {
				newPath = picaddr + picaddr + "artists\\" + id;
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
				} else {
					new File(oldPath + File.separator + filePaths[i])
							.renameTo(new File(newPath + File.separator
									+ filePaths[i]));
				}
			}
		}

	}
}
