package com.javen.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

import com.javen.model.JapanVIdeoDetilBeen;
@Repository("IGetJapanDetails")
public interface IGetJapanDetails {
	public JapanVIdeoDetilBeen getdetailsbyid(String id);
}
