package utils;

import java.io.IOException;

public class FileUploadUtil {

    public static void uploadFileUsingPath(String exePath, String filePath) {
        try {
            // The connection: Running the .exe and passing the file path as an argument
            Runtime.getRuntime().exec(new String[] { exePath, filePath });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}