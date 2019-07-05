package com.javen.util;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
@Service
public class OpenDir {

	    public  void openfiledir(String dir) {
	        try {
	            java.awt.Desktop.getDesktop().open(new File(dir));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
