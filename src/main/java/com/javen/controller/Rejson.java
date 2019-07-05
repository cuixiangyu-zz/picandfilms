package com.javen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javen.model.User;

@Controller
public class Rejson {
	@RequestMapping("/giveJson.do")
	public @ResponseBody User giveJson(){
		System.out.println("*************************************");
		User u = new User("cxy","18","female");
		String aaa = "{\"name\":\"cxy\",\"age\":\"18\";\"sex\",\"female\"}";
		return u ;
	}
}
