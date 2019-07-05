package com.javen.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

public class CanuseMovefun {
    public static void moveFiles(String oldPath, String newPath) {
        String[] filePaths = new File(oldPath).list();
        String newPath2 = "G:/Download2/新建文件夹 (2)";
        String[] a = oldPath.split("\\\\");
        String b = a[a.length - 1];
        newPath = newPath + File.separator + b;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		/*if (new File(newPath).exists()) {
			moveFiles(oldPath + df, newPath2);
			return;
		} else {
			new File(newPath).mkdirs();
		}*/
        if (new File(newPath).isDirectory() && new File(newPath).exists()) {
            new File(oldPath).delete();
            return;
        }
        if (new File(newPath).isDirectory() && !new File(newPath).exists()) {
            new File(newPath).mkdirs();
        }
        for (int i = 0; i < filePaths.length; i++) {
            if (new File(oldPath + File.separator + filePaths[i]).isDirectory()) {
                moveFiles(oldPath + File.separator + filePaths[i], newPath
                        + File.separator + filePaths[i]);
            } else if (new File(oldPath + File.separator + filePaths[i])
                    .isFile()) {
                // 复制文件到另一个目录
                // copyFile(oldPath + File.separator + filePath[i], newPath +
                // File.separator + filePath[i]);
                // 移动文件至另一个目录
                if (filePaths[i].endsWith(".fdmdownload")) {        //去除文件后缀
                    String nfilePaths = filePaths[i].substring(0, filePaths[i].lastIndexOf("."));
                    new File(oldPath + File.separator + filePaths[i])
                            .renameTo(new File(newPath + File.separator
                                    + nfilePaths));
                } else {
                    new File(oldPath + File.separator + filePaths[i])
                            .renameTo(new File(newPath + File.separator
                                    + filePaths[i]));
                }
            }
        }

    }

    public void copyFile(String oldPath, String newPath) throws IOException {
        File oldFile = new File(oldPath);
        File file = new File(newPath);
        FileInputStream in = new FileInputStream(oldFile);
        FileOutputStream out = new FileOutputStream(file);

        byte[] buffer = new byte[2097152];

        while ((in.read(buffer)) != -1) {
            out.write(buffer);
        }
    }

    public static void start(String s) {
        String filepath = "H:/2018.10.06"; // 旧文件所在文件夹
        File[] filePaths = new File(filepath).listFiles();
        String oldPath = null;
        String urlStr = null;
        File file = new File(filepath);
        File[] tempList = file.listFiles();
        tempList[0].toString();
        for (int i = 0; i < filePaths.length; i++) {
            oldPath = filePaths[i].toString();
            String[] ss = oldPath.split("\\\\");
            String name = ss[ss.length - 1];
            try {
                // String urlStr =
                // URLEncoder.encode("(C88) [DA HOOTCH (Various)] Bestiary 3",
                // "gb2312");
                urlStr = URLEncoder.encode(name, "gb2312");

            } catch (UnsupportedEncodingException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }
            String url = "https://nhentai.net/search/?q=" + urlStr;
            String artist = VideoLinkGrab.saveData(url);
            // vb.saveData("https://nhentai.net/g/137684/");
            // String oldPath = filePaths;
            // String[] a = oldPath.split("/");
            // String b = a[a.length-1];
            String newPath = "H:/测试使用/分类文件夹/" + artist; // 文件夹要移动到的目录
            moveFiles(oldPath, newPath);
        }
    }

    public static void main(String[] args) {
        start(new String("aaa"));
        System.out.println("yidongwancheng-------------");
    }

}
