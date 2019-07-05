package com.javen.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WelcomPageBeen {
    private List<JapanvideoBaseinfo> japanvideoBaseinfo = new ArrayList<JapanvideoBaseinfo>();

    private List<JapanvideoArtist> japanvideoArtist = new ArrayList<JapanvideoArtist>();

    private List<PicBaseinfo> picBaseinfo = new ArrayList<PicBaseinfo>();

    public List<JapanvideoBaseinfo> getJapanvideoBaseinfo() {
        return japanvideoBaseinfo;
    }

    public void setJapanvideoBaseinfo(List<JapanvideoBaseinfo> japanvideoBaseinfo) {
        this.japanvideoBaseinfo = japanvideoBaseinfo;
    }

    public List<JapanvideoArtist> getJapanvideoArtist() {
        return japanvideoArtist;
    }

    public void setJapanvideoArtist(List<JapanvideoArtist> japanvideoArtist) {
        this.japanvideoArtist = japanvideoArtist;
    }

    public List<PicBaseinfo> getPicBaseinfo() {
        return picBaseinfo;
    }

    public void setPicBaseinfo(List<PicBaseinfo> picBaseinfo) {
        this.picBaseinfo = picBaseinfo;
    }

    public List<PicArtist> getPicArtist() {
        return picArtist;
    }

    public void setPicArtist(List<PicArtist> picArtist) {
        this.picArtist = picArtist;
    }

    public List<AmericanVideoBaseinfo> getAmericanVideoBaseinfo() {
        return americanVideoBaseinfo;
    }

    public void setAmericanVideoBaseinfo(List<AmericanVideoBaseinfo> americanVideoBaseinfo) {
        this.americanVideoBaseinfo = americanVideoBaseinfo;
    }

    public List<AmericanVideoArtistinfo> getAmericanVideoArtistinfo() {
        return americanVideoArtistinfo;
    }

    public void setAmericanVideoArtistinfo(List<AmericanVideoArtistinfo> americanVideoArtistinfo) {
        this.americanVideoArtistinfo = americanVideoArtistinfo;
    }

    public List<ComicBaseinfo> getComicBaseinfo() {
        return comicBaseinfo;
    }

    public void setComicBaseinfo(List<ComicBaseinfo> comicBaseinfo) {
        this.comicBaseinfo = comicBaseinfo;
    }

    private List<PicArtist> picArtist = new ArrayList<PicArtist>();

    private List<AmericanVideoBaseinfo> americanVideoBaseinfo = new ArrayList<AmericanVideoBaseinfo>();

    private List<AmericanVideoArtistinfo> americanVideoArtistinfo = new ArrayList<AmericanVideoArtistinfo>();

    private List<ComicBaseinfo> comicBaseinfo = new ArrayList<ComicBaseinfo>();

}
