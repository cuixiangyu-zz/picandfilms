package com.javen.service.impl;

import com.javen.dao.IPictureInfo;
import com.javen.dao.IjapanArtistInfo;
import com.javen.dao.IjapanInfo;
import com.javen.model.*;
import com.javen.service.IGetWelcomPageInfo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.annotation.Resource;
import java.util.List;
@Service
public class GetWelcomePageInfo implements IGetWelcomPageInfo {

    @Qualifier("Japaninfoimpl")
    @Resource
    private IjapanInfo japanInfo;

    @Resource
    private List<JapanvideoBaseinfo> japanvideoBaseinfo;
    @Resource
    private JapanArtistPageBeen japanArtistPageBeen;
    @Qualifier("pictureinfoimpl")
    @Resource
    private IPictureInfo pic;
    @Resource
    private List<PicBaseinfo> picBaseinfo;

    @Qualifier("JapanArtistInfoimpl")
    @Resource
    private IjapanArtistInfo japanArtistInfo;
    @Resource
    private WelcomPageBeen welcomPageBeen;
    @Resource
    private List<JapanvideoArtist> japanvideoArtists;
    @Override
    public WelcomPageBeen getwelcompage() {
        //获取最新日本电影
        japanvideoBaseinfo = japanInfo.getlatistvideo();

        //获取女优
        japanvideoArtists = japanArtistInfo.getpagebyindex(0, 6);

        //获取漫画
        picBaseinfo = pic.getpagebyindex(0, 6);

        welcomPageBeen.setJapanvideoBaseinfo(japanvideoBaseinfo);
        welcomPageBeen.setJapanvideoArtist(japanvideoArtists);
        welcomPageBeen.setPicBaseinfo(picBaseinfo);
        return welcomPageBeen;
    }
}
