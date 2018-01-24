package com.xtm.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Author: TianMing.Xiong
 * Date: Created in 18-1-24 上午11:51
 *
 */

public class CreateNewFile {
    public static void main(String args[]){
        String fileData = "Hello World!" ;
        useNewFile(fileData);
        useFileOutputStream(fileData);
        useNioFile(fileData);
    }

    /**
     * File.createNewFile()
     * @param fileData
     */
    private static void useNewFile(String fileData) {
        File file = new File("."+File.separator+"file.txt");
        try {
            file.createNewFile();

            if(file.exists()){
                new FileOutputStream(file).write(fileData.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * FileOutputStream.write(byte[] b)
     * @param fileData
     */
    private static void useFileOutputStream(String fileData) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
            fileOutputStream.write(fileData.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Java NIO Files.write()
     * @param fileData
     */
    private static void useNioFile(String fileData) {
        try {
            Files.write(Paths.get("name.txt"),fileData.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
