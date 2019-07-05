package com.javen.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Fileaddr {


    @Value(value="#{prop.japenesemp4fileaddr}")
    private String japenesemp4fileaddr;

    @Value(value="#{prop.japenesemp4coveraddr}")
    private String japenesemp4coveraddr;

    @Value(value="#{prop.americanmp4fileaddr}")
    private String americanmp4fileaddr;

    @Value(value="#{prop.americanmp4coveraddr}")
    private String americanmp4coveraddr;

    @Value(value="#{prop.comicmp4fileaddr}")
    private String comicmp4fileaddr;

    @Value(value="#{prop.comicmp4coveraddr}")
    private String comicmp4coveraddr;

    @Value(value="#{prop.picfileaddr}")
    private String picfileaddr;

    @Value(value="#{prop.piccoveraddr}")
    private String piccoveraddr;

    @Value(value="#{prop.ipaddr}")
    private String ipaddr;


    public String getJapenesemp4fileaddr() {
        return japenesemp4fileaddr;
    }

    public String getJapenesemp4coveraddr() {
        return japenesemp4coveraddr;
    }

    public String getAmericanmp4fileaddr() {
        return americanmp4fileaddr;
    }

    public String getAmericanmp4coveraddr() {
        return americanmp4coveraddr;
    }

    public String getComicmp4fileaddr() {
        return comicmp4fileaddr;
    }

    public String getComicmp4coveraddr() {
        return comicmp4coveraddr;
    }

    public String getPicfileaddr() {
        return picfileaddr;
    }

    public String getPiccoveraddr() {
        return piccoveraddr;
    }

    public String getIpaddr() {
        return ipaddr;
    }
}
