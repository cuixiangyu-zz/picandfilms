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
        String newPath2 = "G:/Download2/�½��ļ��� (2)";
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
                // �����ļ�����һ��Ŀ¼
                // copyFile(oldPath + File.separator + filePath[i], newPath +
                // File.separator + filePath[i]);
                // �ƶ��ļ�����һ��Ŀ¼
                if (filePaths[i].endsWith(".fdmdownload")) {        //ȥ���ļ���׺
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
        String filepath = "H:/2018.10.06"; // ���ļ������ļ���
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
                // TODO �Զ����ɵ� catch ��
                e.printStackTrace();
            }
            String url = "https://nhentai.net/search/?q=" + urlStr;
            String artist = VideoLinkGrab.saveData(url);
            // vb.saveData("https://nhentai.net/g/137684/");
            // String oldPath = filePaths;
            // String[] a = oldPath.split("/");
            // String b = a[a.length-1];
            String newPath = "H:/����ʹ��/�����ļ���/" + artist; // �ļ���Ҫ�ƶ�����Ŀ¼
            moveFiles(oldPath, newPath);
        }
    }

    public static void main(String[] args) {
        start(new String("aaa"));
        System.out.println("yidongwancheng-------------");
    }

}
