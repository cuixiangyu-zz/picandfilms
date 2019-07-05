package com.javen.model;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JapanvideoArtist {
    private String id;

    private String artist;

    private String data;

    private String addr;
    private String lv;
    private String Quantity;



    public String getLv() {
        return lv;
    }

    public void setLv(String lv) {
        this.lv = lv;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }

    public Fileaddr getFileaddr() {
        return fileaddr;
    }

    public void setFileaddr(Fileaddr fileaddr) {
        this.fileaddr = fileaddr;
    }

    @Resource
    private Fileaddr fileaddr;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist == null ? null : artist.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public String getaddr() {
        return addr;
    }

    public void setaddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }
}