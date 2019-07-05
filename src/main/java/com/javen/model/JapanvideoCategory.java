package com.javen.model;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JapanvideoCategory {
    private String id;

    private String categoryname;

    private String data;

    private String isexist;

    @Resource
    private Fileaddr fileaddr;

    public Fileaddr getFileaddr() {
        return fileaddr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname == null ? null : categoryname.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public String getIsexist() {
        return isexist;
    }

    public void setIsexist(String isexist) {
        this.isexist = isexist == null ? null : isexist.trim();
    }
}