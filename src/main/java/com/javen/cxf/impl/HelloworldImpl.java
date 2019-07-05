package com.javen.cxf.impl;

import com.javen.cxf.Helloworld;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@Component("helloWorld")

@WebService
public class HelloworldImpl implements Helloworld {

    public void sayhello() {
        System.out.println("aaaaaaaaaaaaaaaaaaa");
    }
}
