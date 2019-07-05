package com.javen.util;

import com.javen.dao.IjapanInfo;
import com.javen.dao.IjapanbackupInfo;
import com.javen.model.JapanvideoBackup;
import com.javen.model.JapanvideoBaseinfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UpdateNewVideoInfo {
    @Qualifier("Japanbackupinfoimpl")
    @Resource
    private IjapanbackupInfo japanbackupInfo;

    @Qualifier("Japaninfoimpl")
    @Resource
    private IjapanInfo japanInfo;
    @Resource
    private JapanvideoBackup japanvideoBackup;
    @Resource
    private List<JapanvideoBaseinfo> japanvideoBaseinfos;
    @Resource
    private JapanvideoBaseinfo japanvideoBaseinfo;
    @Resource
    private GetHtmlbyUrl getHtmlbyUrl;
    @Resource
    private Downloadcover downloadcover;

    //遍历未分类文件夹，查询影片信息并移动
    public void getvideoid(){
        File videos = new File("L:\\UNClear");
        for (File video:videos.listFiles()) {
            String name = video.getName();
            String id = name.substring(0,name.indexOf("."));
            JapanvideoBaseinfo japanvideoBaseinfo = japanInfo.getdetailsbyid(id);
            if (japanvideoBaseinfo!=null){
                continue;
            }
            japanvideoBackup = japanbackupInfo.getdetailsbyid(id);

            //backup数据库有信息则直接取出
            if (japanvideoBackup!=null){
                String artists = japanvideoBackup.getArtist();
                String artist=artists.split(",")[0];
                video.renameTo(new File("L:\\japenese" + File.separator
                                + artist+File.separator+name));
                japanvideoBaseinfo.setId(japanvideoBackup.getId());
                japanvideoBaseinfo.setArtist(japanvideoBackup.getArtist());
                japanvideoBaseinfo.setCategory(japanvideoBackup.getCategory());
                japanvideoBaseinfo.setData(new Date().toString());
                japanvideoBaseinfo.setVideoname(japanvideoBackup.getVideoname());
                japanvideoBaseinfo.setAddr("L:\\japenese" + File.separator
                        + artist+File.separator+name);
                japanvideoBaseinfo.setCover(japanvideoBackup.getId());
                japanvideoBaseinfo.setIsexist("1");
                japanvideoBaseinfo.setLanguage("jp");
                japanvideoBaseinfos.clear();
                japanvideoBaseinfos.add(japanvideoBaseinfo);
                japanInfo.insert(japanvideoBaseinfos);
            }else{
                Map<String, String> videoinfo = getHtmlbyUrl.getvideoinfo(id);
                if(videoinfo.get("artists")==null){
                    continue;
                }
                String picurl = videoinfo.get("picurl");
                try {
                    String download = downloadcover.download(picurl, "G:\\test", id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                String date = sf.format(new Date());
                JapanvideoBaseinfo japanvideoBaseinf = new JapanvideoBaseinfo();
                japanvideoBaseinf.setId(id);
                japanvideoBaseinf.setArtist(videoinfo.get("artists"));
                japanvideoBaseinf.setCategory(videoinfo.get("category"));
                japanvideoBaseinf.setData(date);
                japanvideoBaseinf.setVideoname(videoinfo.get("title"));
                String artist =null;
                if (videoinfo.get("artists").indexOf(",")>-1){
                    artist = videoinfo.get("artists").split(",")[0];
                }else{
                    artist=videoinfo.get("artists");
                }

                japanvideoBaseinf.setAddr("L:\\japenese" + File.separator
                        + artist +File.separator+name);
                japanvideoBaseinf.setCover(id);
                japanvideoBaseinf.setIsexist("1");
                japanvideoBaseinf.setLanguage("jp");
                japanvideoBaseinfos.clear();
                japanvideoBaseinfos.add(japanvideoBaseinf);
                japanInfo.insert(japanvideoBaseinfos);
                if (!new File("L:\\japenese" + File.separator
                        + artist).exists()){
                    new File("L:\\japenese" + File.separator+ artist).mkdir();
                }
                video.renameTo(new File("L:\\japenese" + File.separator
                        + artist+File.separator+name));
            }

        }
    }


    public void updatevideo(){
        File artistlist = new File("I:\\Source\\Japan");
        for (File artist:artistlist.listFiles()) {
            for (File video:artist.listFiles()) {

                    String name = video.getName();
                    String id = name.substring(0,name.indexOf("."));
                    JapanvideoBaseinfo japanvideoBaseinfo = japanInfo.getdetailsbyid(id);
                    if (japanvideoBaseinfo!=null){
                        /*video.renameTo(new File("I:\\Source\\重复" + File.separator
                                + name));*/
                        continue;
                    }
                        Map<String, String> videoinfo = getHtmlbyUrl.getvideoinfo(id);
                        if(videoinfo.get("artists")==null||videoinfo.get("artists")==""){
                            continue;
                        }
                        String picurl = videoinfo.get("picurl");
                        try {
                            String download = downloadcover.download(picurl, "G:\\test", id);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                        String date = sf.format(new Date());
                        JapanvideoBaseinfo japanvideoBaseinf = new JapanvideoBaseinfo();
                        japanvideoBaseinf.setId(id);
                        japanvideoBaseinf.setArtist(videoinfo.get("artists"));
                        japanvideoBaseinf.setCategory(videoinfo.get("category"));
                        japanvideoBaseinf.setData(date);
                        japanvideoBaseinf.setVideoname(videoinfo.get("title"));
                        String artistname =null;
                        if (videoinfo.get("artists").indexOf(",")>-1){
                            artistname = videoinfo.get("artists").split(",")[0];
                        }else{
                            artistname=videoinfo.get("artists");
                        }

                        japanvideoBaseinf.setAddr(video.getPath());
                        japanvideoBaseinf.setCover(id);
                        japanvideoBaseinf.setIsexist("1");
                        japanvideoBaseinf.setLanguage("jp");
                        japanvideoBaseinfos.clear();
                        japanvideoBaseinfos.add(japanvideoBaseinf);
                        japanInfo.insert(japanvideoBaseinfos);

            }
        }
    }
}
