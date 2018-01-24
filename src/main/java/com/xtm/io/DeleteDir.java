package com.xtm.io;

import java.io.File;

/**
 * Author: TianMing.Xiong
 * Date: Created in 18-1-24 下午2:33
 */
public class DeleteDir {
    public static void main(String args[]){
        String dirName = "."+File.separator+"tmp_dir";
        File file = new File(dirName);
        deleteDir(file);
    }

    private static void deleteDir(File file) {
        //1.文件不存在，退出递归循环
         if(!file.exists()){
            return;
         }
        //2.是文件夹则列出文件夹的所有文件进行递归删除
         if(file.isDirectory()){
             File[] files = file.listFiles();
             for (File f :
                     files) {
                 deleteDir(f);
             }
         }
         //3.删除文件
         file.delete();
         System.out.println("Deleted file/folder:"+file.getAbsolutePath());
    }
}
//output:
//        Deleted file/folder:/home/chenfujin/work_study/java_learn/./tmp_dir/b_dir/c.txt
//        Deleted file/folder:/home/chenfujin/work_study/java_learn/./tmp_dir/b_dir
//        Deleted file/folder:/home/chenfujin/work_study/java_learn/./tmp_dir/a.txt
//        Deleted file/folder:/home/chenfujin/work_study/java_learn/./tmp_dir
