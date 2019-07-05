package com.javen.model;

import java.util.List;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PictureDetilBeen {
    private String id;
    private List<String> artist;
    private List<String> addrs;
    private PicBaseinfo picBaseinfo;
    private List<PicCategory> picCategorys;
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

    public List<String> getArtist() {
        return artist;
    }

    public void setArtist(List<String> artist) {
        this.artist = artist;
    }

    public PicBaseinfo getPicBaseinfo() {
        return picBaseinfo;
    }

    public void setPicBaseinfo(PicBaseinfo picBaseinfo) {
        this.picBaseinfo = picBaseinfo;
    }

    public List<PicCategory> getPicCategorys() {
        return picCategorys;
    }

    public void setPicCategorys(List<PicCategory> picCategorys) {
        this.picCategorys = picCategorys;
    }

    public List<PicArtist> getPicArtists() {
        return picArtists;
    }

    public void setPicArtists(List<PicArtist> picArtists) {
        this.picArtists = picArtists;
    }

    public List<String> getAddrs() {
        return addrs;
    }

    public void setAddrs(List<String> addrs) {
        this.addrs = addrs;
    }

    private List<PicArtist> picArtists;

}
