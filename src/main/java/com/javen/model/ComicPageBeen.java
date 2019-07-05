package com.javen.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ComicPageBeen {

    private int currentPage;
    private int currentCount;
    private int totalCount;
    private int totalPage;

    @Resource
    private Fileaddr fileaddr;

    private List<PicBaseinfo> picBaseinfo = new ArrayList<PicBaseinfo>();

    public Fileaddr getFileaddr() {
        return fileaddr;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<PicBaseinfo> getPicBaseinfo() {
        return picBaseinfo;
    }

    public void setPicBaseinfo(List<PicBaseinfo> picBaseinfo) {
        this.picBaseinfo = picBaseinfo;
    }


}


