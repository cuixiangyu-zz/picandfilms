package com.javen.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.javen.mapping.PicBaseinfoMapper;
import com.javen.model.PicBaseinfo;
import com.javen.model.PicBaseinfoExample;

/**
 * @author administrator
 *	下载封面
 */
@Service
public class Downloadcover {
	    /**
	     * @param urlPath
	     * @param savePath
	     * @param name
	     * @return	datebaseAddr
	     * @throws Exception
	     */
	    public static String download(String urlPath,String savePath,String name) throws Exception {
	        // 构造URL
	        URL url = new URL(urlPath);
	        // 打开连接
	        
	        HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setRequestMethod("GET");  
            httpUrlConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            //获取输入流  
            InputStream input = httpUrlConn.getInputStream();
            //将字节输入流转换为字符输入流
            InputStreamReader read = new InputStreamReader(input, "utf-8");
            
	        // 输入流
	        // 1K的数据缓冲
	        byte[] bs = new byte[1024];
	        // 读取到的数据长度
	        int len;
	        // 输出的文件流
	        File sf=new File(savePath);
	        if(!sf.exists()){
	            sf.mkdirs();
	        }
	        String filename=urlPath.substring(urlPath.lastIndexOf("/")+1,urlPath.length());//获取服务器上图片的名称
	        String index = filename.substring(filename.indexOf("."),filename.length());
	        		
	        OutputStream os = new FileOutputStream(sf.getPath()+"\\"+name+index);
	        String virtualPath=savePath+File.separator+name+index;//存入数据库的虚拟路径
	        // 开始读取
	        while ((len = input.read(bs)) != -1) {
	            os.write(bs, 0, len);
	        }
	        // 完毕，关闭所有链接
	        os.close();
	        input.close();
	        return virtualPath;
	    }
	    
	
}
