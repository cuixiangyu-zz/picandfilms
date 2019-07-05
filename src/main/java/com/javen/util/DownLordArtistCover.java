package com.javen.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.javen.mapping.JapanvideoArtistMapper;
import com.javen.mapping.JapanvideoBaseinfoMapper;
import com.javen.model.JapanPageBeen;
import com.javen.model.JapanvideoArtist;
import com.javen.model.JapanvideoArtistExample;
import com.javen.model.JapanvideoBaseinfo;
import com.javen.model.JapanvideoBaseinfoExample;
@Service
public class DownLordArtistCover {
	@Resource
	private JapanvideoBaseinfoMapper japanvideoBaseinfoMapper;
	@Resource
	private JapanvideoArtistMapper japanvideoArtistMapper;
	@Resource
	private JapanPageBeen pageBeen;
	@Resource
	private List<JapanvideoBaseinfo> japanvideoBaseinfo;
	@Resource
	private GetHtmlbyUrl getHtmlbyUrl;
	@Resource
	private Downloadcover downloadcover;
	
	public List<String>	getartist(){
		HashSet<String> getpicurl = null;
		JapanvideoArtistExample example = new JapanvideoArtistExample();
		japanvideoArtistMapper.selectByExample(example);
		
		List<String> artists = japanvideoBaseinfoMapper.selectdistinctartist(null);
		String regex = "https://pics.javcdn.pw/actress/[A-Za-z0-9-_]*.jpg";
		for (String artist : artists) {
			String urlStr = null;
			try {
				urlStr = URLEncoder.encode(artist, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			String addr="https://www.seedmm.net/searchstar/"+urlStr+"&type=&parent=ce";
			//String addr="https://www.seedmm.net/star/odc";
			getpicurl = getHtmlbyUrl.getHtmlbyRegex(addr, regex);
			for (Object url : getpicurl) {
				try {
					String download = downloadcover.download(url.toString(), "H:/cover/japanartist", artist);
					System.out.println(download);
					JapanvideoArtist record = new JapanvideoArtist();
					record.setArtist(artist);
					record.setId(artist);
					record.setaddr(download);
					japanvideoArtistMapper.insert(record);
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return null;
		
	}
}
