package com.javen.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

import com.javen.model.PictureDetilBeen;
@Repository("IGetPictureDetails")
public interface IGetPictureDetails {
	public PictureDetilBeen getdetailsbyid(String id);
}
