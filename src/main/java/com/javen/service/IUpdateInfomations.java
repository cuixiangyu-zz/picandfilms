package com.javen.service;

import com.javen.model.JapanvideoBaseinfo;
import com.javen.model.PicBaseinfo;

public interface IUpdateInfomations {
    public String updateVideoInfobyId(String id, JapanvideoBaseinfo japanvideoBaseinfo);
    public String updatePicInfobyId(String id, PicBaseinfo picBaseinfo);
}
