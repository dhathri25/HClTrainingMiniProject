package utils;

import java.io.IOException;

public class FileUploadUtil {

	public static void uploadFileUsingPath(String autoitPath, String imagePath) {
	    try {
	        // This command must have a space between the exe and the file path
	        Runtime.getRuntime().exec(autoitPath + " " + imagePath);
	    } catch (Exception e) {
	        System.out.println("AutoIt Execution Failed!");
	        e.printStackTrace();
	    }
    }
}