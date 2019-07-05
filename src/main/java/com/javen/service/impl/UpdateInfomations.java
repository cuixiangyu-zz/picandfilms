package com.javen.service.impl;

import com.javen.dao.IjapanInfo;
import com.javen.model.JapanvideoBaseinfo;
import com.javen.model.JapanvideoBaseinfoExample;
import com.javen.model.PicBaseinfo;
import com.javen.service.IUpdateInfomations;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class UpdateInfomations implements IUpdateInfomations {
    @Qualifier("Japaninfoimpl")
    @Resource
    private IjapanInfo japanInfo;

    @Resource
    private JapanvideoBaseinfo japanvideoBaseinfo;
    @Override
    public String updateVideoInfobyId(String id, JapanvideoBaseinfo japanvideoBaseinfo) {
        return null;
    }

    @Override
    public String updatePicInfobyId(String id, PicBaseinfo picBaseinfo) {
        return null;
    }
}
