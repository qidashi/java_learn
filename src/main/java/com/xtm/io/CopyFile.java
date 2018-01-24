package com.xtm.io;

import java.io.*;

/**
 * Author: TianMing.Xiong
 * Date: Created in 18-1-24 下午3:16
 */
public class CopyFile {
    public static void main(String args[]){
        String fileSouseName = "."+File.separator+"name.txt";
        String fileDestName = "."+File.separator+"file.txt";
        File souse = new File(fileSouseName);
        File dest = new File(fileDestName);
        copyFileStream(souse,dest);
    }

    private static void copyFileStream(File souse, File dest) {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(souse);
            outputStream = new FileOutputStream(dest);
            byte buf[] = new byte[2];
            int len ;
            while ((len=inputStream.read(buf))>0){//len=2每次读取两个字节，如果没有buf参数则每次读取一个字节，读取一次游标向后移动一次
                outputStream.write(buf,0,len);
                System.out.println("len:"+len+"data:"+new String(buf));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
