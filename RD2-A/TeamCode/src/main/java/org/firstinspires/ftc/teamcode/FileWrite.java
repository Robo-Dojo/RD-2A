package org.firstinspires.ftc.teamcode;

import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWrite {

    public static void writeToFile(String fileName, String content) {
        // Get the directory to save the file
        File directory = new File(Environment.getExternalStorageDirectory(), "FTCLogs");
        if (!directory.exists()) {
            directory.mkdirs(); // Create directory if it doesn't exist
        }

        // Create the file
        File file = new File(directory, fileName);

        try (FileOutputStream fos = new FileOutputStream(file)) {
            // Write the content to the file
            fos.write(content.getBytes());
            fos.flush(); // Ensure all data is written
            System.out.println("File written successfully: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to write to file: " + e.getMessage());
        }
    }
}
