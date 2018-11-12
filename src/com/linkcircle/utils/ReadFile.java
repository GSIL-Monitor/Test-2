package com.linkcircle.utils;

import java.io.File;  
import java.util.ArrayList;  
import java.util.List;  
  

public class ReadFile {  
    static List<String> test(String fileDir) {  
        List<File> fileList = new ArrayList<File>();  
        List<String> fList = new ArrayList<String>();  
        File file = new File(fileDir);  
        File[] files = file.listFiles();// 获取目录下的所有文件或文件夹  
        if (files == null) {// 如果目录为空，直接退出  
            return null;  
        }  
        // 遍历，目录下的所有文件  
        for (File f : files) {  
            if (f.isFile()) {  
                fileList.add(f);  
            } else if (f.isDirectory()) {  
    //        	fList.add(f.getAbsolutePath());
   //             System.out.println(f.getAbsolutePath());  
                test(f.getAbsolutePath());  
            }  
        }  
        for (File f1 : fileList) {  
        	fList.add(f1.getName());
  //          System.out.println(f1.getName());  
        }  
        return fList;
    }  
  
    public static void main(String[] args) {  
    	//C:/Users/mac/Desktop/lua脚本
    	 List<String> fList = test("D:/TTSFile/录音/1");  
    	 for(int i=0;i<fList.size();i++){
    		 System.out.println(i+fList.get(i));
    	 }
    }  
}  
