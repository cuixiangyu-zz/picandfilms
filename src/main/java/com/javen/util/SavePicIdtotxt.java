package com.javen.util;

import java.io.FileWriter;
import java.io.IOException;

public class SavePicIdtotxt {
	public String savepicinfototxt(String picid,String picname,String picartists,String piccategorys){
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("G:/picid.txt",true);//创建文本文件
			fileWriter.write(picname+":"+picid+":"+picartists+":"+piccategorys+";"+"\r\n");
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String savejapaninfototxt(String japanid,String japanname,String japanartist,String japancategory){
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("G:/japaninfo.txt",true);//创建文本文件
			fileWriter.write(japanid+":"+japanname+":"+japanartist+":"+japancategory+";"+"\r\n");
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
