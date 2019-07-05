package com.javen.controller;

import com.javen.dao.IPictureInfo;
import com.javen.dao.IjapanInfo;
import com.javen.model.JapanvideoBaseinfo;
import com.javen.model.PicBaseinfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UpdateLV {

    @Qualifier("Japaninfoimpl")
    @Resource
    private IjapanInfo japanInfo;

    @Resource
    private List<JapanvideoBaseinfo> japanvideoBaseinfos;

    @Qualifier("pictureinfoimpl")
    @Resource
    private IPictureInfo pic;
    @Resource
    private List<PicBaseinfo> picBaseinfos;

    @RequestMapping("/updatevideolv.do")
    public String updatevideolv(@RequestParam(value = "lv")String lv,@RequestParam(value = "id")String id){
        JapanvideoBaseinfo japanvideoBaseinfo = japanInfo.getdetailsbyid(id);
        japanvideoBaseinfo.setLv(lv);
        japanvideoBaseinfos.add(japanvideoBaseinfo);
        String error = japanInfo.update(japanvideoBaseinfos);
        return error;
    }
    @RequestMapping("/updatepicturelv.do")
    public String updatepicturelv(@RequestParam(value = "lv")String lv,@RequestParam(value = "id")String id){
        PicBaseinfo picBaseinfo = pic.getdetailsbyid(id);
        picBaseinfo.setLv(lv);
        picBaseinfos.add(picBaseinfo);
        String error = pic.update(picBaseinfos);
        return error;
    }
}
