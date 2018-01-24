package com.xtm.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Author: TianMing.Xiong
 * Date: Created in 18-1-24 上午11:51
 */
public class NioFile {
    public static void main(String args[]){
        String fileData = "Hello World!" ;
        try {
            Files.write(Paths.get("name.txt"),fileData.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
