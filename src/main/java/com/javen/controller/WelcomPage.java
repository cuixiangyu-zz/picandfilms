package com.javen.controller;

import com.javen.model.JapanVIdeoDetilBeen;
import com.javen.model.WelcomPageBeen;
import com.javen.service.impl.GetWelcomePageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
@Controller
public class WelcomPage {
    @Resource
    private GetWelcomePageInfo getWelcomePageInfo;
    @CrossOrigin
    @RequestMapping("/getwelcompage.do")
    public @ResponseBody WelcomPageBeen getwelcompage(){
        WelcomPageBeen welcomPageBeen = new WelcomPageBeen();
        welcomPageBeen=getWelcomePageInfo.getwelcompage();
        return welcomPageBeen;
    }
}
