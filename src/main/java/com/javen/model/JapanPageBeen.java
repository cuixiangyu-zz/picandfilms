package com.javen.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JapanPageBeen {

    private int currentPage;
    private int currentCount;
    private int totalCount;
    private int totalPage;

    private List<JapanvideoBaseinfo> japanvideoBaseinfo = new ArrayList<JapanvideoBaseinfo>();

    @Resource
    private Fileaddr fileaddr;

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

    public List<JapanvideoBaseinfo> getJapanvideoBaseinfo() {
        return japanvideoBaseinfo;
    }

    public void setJapanvideoBaseinfo(List<JapanvideoBaseinfo> japanvideoBaseinfo) {
        this.japanvideoBaseinfo = japanvideoBaseinfo;
    }


}


