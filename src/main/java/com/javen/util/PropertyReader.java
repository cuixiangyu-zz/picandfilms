/*
package com.javen.util;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
@Service
//@PropertySource(value={"classpath:fileaddress.properties"})
public class PropertyReader {
	@Value(value="#{prop.japenesemp4fileaddr}")
	private String japenesemp4fileaddr;
	
	@Value(value="#{prop.picfileaddr}")
	private String picfileaddr;
	
	@Value(value="#{prop.coveraddr}")
	private String coveraddr;

	private File[] listFiles2;
	private File[] listFiles;

	private String name;
	@Resource
	private GetHtmlbyUrl getHtmlbyUrl;

	@Resource
	private Downloadcover downloadcover;
	public void test(){
		System.out.println(japenesemp4fileaddr);
		System.out.println(picfileaddr);
		System.out.println(coveraddr);
		
		File coverfile= new File(coveraddr);
		File file= new File(japenesemp4fileaddr);
		File[] listFiles3 = coverfile.listFiles();
		ArrayList filename = new ArrayList();
		for (File file2 : listFiles3) {
			filename.add(file2.getName().substring(0,file2.getName().indexOf(".")));
		}
		listFiles = file.listFiles();
		for (File file2 : listFiles) {
			listFiles2 = file2.listFiles();
			for (File file3 : listFiles2) {
				name = file3.getName();
				
				name = name.substring(0,name.indexOf("."));
				if(filename.contains(name)){
					break;
				}
				HashSet<String> getpicurl = getHtmlbyUrl.getpicurl(name);
				for (Object url : getpicurl) {
					try {
						String download = downloadcover.download(url.toString(), coveraddr, name);
						System.out.println(download);
						break;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
*/
