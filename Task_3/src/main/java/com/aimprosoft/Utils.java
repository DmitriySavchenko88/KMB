package com.aimprosoft;

public class Utils {

    public static String getFileExtension(String fileName){
        String extension = "";
        int index = fileName.lastIndexOf('.');
        if (index > 0) {
            extension = fileName.substring(index + 1);
        }
        return extension;
    }
}
