package com.javen.model;

import java.util.List;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JapanVIdeoDetilBeen {
    private String id;
    private String artist;
    private JapanvideoBaseinfo japanvideoBaseinfo;
    private List<JapanvideoCategory> japanvideoCategorys;
    private List<JapanvideoArtist> japanvideoArtist;
    @Resource
    private Fileaddr fileaddr;

    public Fileaddr getFileaddr() {
        return fileaddr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public JapanvideoBaseinfo getJapanvideoBaseinfo() {
        return japanvideoBaseinfo;
    }

    public void setJapanvideoBaseinfo(JapanvideoBaseinfo japanvideoBaseinfo) {
        this.japanvideoBaseinfo = japanvideoBaseinfo;
    }

    public List<JapanvideoCategory> getJapanvideoCategorys() {
        return japanvideoCategorys;
    }

    public void setJapanvideoCategorys(List<JapanvideoCategory> japanvideoCategorys) {
        this.japanvideoCategorys = japanvideoCategorys;
    }

    public List<JapanvideoArtist> getJapanvideoArtist() {
        return japanvideoArtist;
    }

    public void setJapanvideoArtist(List<JapanvideoArtist> japanvideoArtist) {
        this.japanvideoArtist = japanvideoArtist;
    }
}
