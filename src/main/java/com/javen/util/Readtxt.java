package com.javen.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.javen.dao.IPictureCategory;
import com.javen.model.PicCategory;
@Service
public class Readtxt {
	
	@Qualifier("PictureCategoryimpl")
	@Resource
	private IPictureCategory IPictureCategory;
	@Resource
	private List<PicCategory> picCategorys;
	
	public String insertcategory(){
		HashMap<String, String> readFile = readFile();
		insertinto(readFile);
		return null;
	}
	public static HashMap<String,String> readFile() {
        String pathname = "G:\\reader.txt"; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        List<String> lines=new ArrayList<String>();
        String line = null;
        HashMap<String,String> map = new HashMap<String,String>();
        try {
        	BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(pathname),"GBK"));
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				if(map.get(line.split("=")[0])!=null){
					continue;
				}
			      map.put(line.split("=")[0], line.split("=")[1]);
			}
			br.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    }
        	return map;
	}
	public void insertinto(HashMap<String,String> map){
		for (Map.Entry<String,String> entry : map.entrySet()) { 
			  System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
			  PicCategory picCategory = new PicCategory();
			 
			  picCategory.setCategoryname(entry.getValue());
			  picCategory.setId(entry.getKey());
			  picCategory.setIsexist("1");
			  picCategorys.add(picCategory);
			}
		IPictureCategory.insertcategory(picCategorys);
	}
}