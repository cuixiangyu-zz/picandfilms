package com.javen.util;

import java.io.File;

public class RenameFiles {
	public static void main(String[] args) {
		String filepath = "H:\\带分类视频";
		File file = new File(filepath);
		File[] listFiles = file.listFiles();
		for (File file2 : listFiles) {
			String filename = file2.getName();
			String index = filename.substring(filename.length()-4,filename.length());
			String name = filename.substring(0,filename.length()-4);
			if(name.indexOf("[44x.me]")>=0||name.indexOf("[88q.me]")>=0||name.indexOf("[99u.me]")>=0){
				name=name.substring(8, name.length());
			}
			if(name.indexOf("[ThZu.Cc]")>=0){
				name=name.substring(9, name.length());
			}
			if(name.indexOf("HD-")>=0){
				name=name.substring(3, name.length());
			}
			if(name.indexOf("hjd2048.com")>=0){
				name=name.substring(16, name.length());
			}
			if(name.indexOf("shjd2048.com")>=0){
				name=name.substring(17, name.length());
			}
			if(name.indexOf("-h264")>=0){
				name=name.substring(0, name.length()-5);
			}
			if(name.indexOf("mp4")>=0){
				name=name.substring(0, name.length()-3);
			}
			name.trim();
			if(name.indexOf("-")<0){
				name=name.substring(0, name.length()-3)+"-"+name.substring(name.length()-3, name.length());
			}
			name=name.toUpperCase();
			new File(filepath+File.separator+filename).renameTo(new File(filepath+File.separator+name+index));
			System.out.println("重命名文件："+filepath+"-----"+filename+"-------"+name);
		}
	}
}
