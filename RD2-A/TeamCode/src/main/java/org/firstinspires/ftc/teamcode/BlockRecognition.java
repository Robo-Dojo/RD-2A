package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.FileWrite.writeToFile;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.ArrayList;

public class BlockRecognition {

    private static void addCrosshair(Bitmap image) {
        for (int y = 0; y < image.getHeight(); y++) {
            image.setPixel(image.getWidth() / 2, y, Color.WHITE);
        }

        for (int x = 0; x < image.getWidth(); x++) {
            image.setPixel(x, image.getHeight() / 2, Color.WHITE);
        }
    }

    public static void processImage(Bitmap immutableImage, boolean searchRed, boolean searchBlue, boolean searchYellow) {
        Bitmap image = immutableImage.copy(Bitmap.Config.ARGB_8888, true);
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int pixel = image.getPixel(x, y);
                int red = Color.red(pixel);
                int green = Color.green(pixel);
                int blue = Color.blue(pixel);

                if ((((Math.abs(red - 240) + Math.abs(green - 208) + Math.abs(blue - 77)) / 3 < 30) && searchYellow) ||
                        (((Math.abs(red - 223) + Math.abs(green - 40) + Math.abs(blue - 86)) / 3 < 30) && searchRed) ||
                        (((Math.abs(red - 44) + Math.abs(green - 85) + Math.abs(blue - 199)) / 3 < 40) && searchBlue)) {

                    int avgX = 0;
                    int avgY = 0;
                    int count = 0;

                    ArrayList<int[]> toCheck = new ArrayList<>();
                    toCheck.add(new int[]{x, y});

                    while (!toCheck.isEmpty()) {
                        ArrayList<int[]> copyCheck = new ArrayList<>();

                        for (int[] point : toCheck) {
                            int px = point[0];
                            int py = point[1];

                            if (px <= 0 || px >= image.getWidth() || py <= 0 || py >= image.getHeight()) {
                                continue;
                            }

                            pixel = image.getPixel(px, py);
                            red = Color.red(pixel);
                            green = Color.green(pixel);
                            blue = Color.blue(pixel);

                            if ((((Math.abs(red - 240) + Math.abs(green - 208) + Math.abs(blue - 77)) / 3 < 30) && searchYellow) ||
                                    (((Math.abs(red - 223) + Math.abs(green - 40) + Math.abs(blue - 86)) / 3 < 30) && searchRed) ||
                                    (((Math.abs(red - 44) + Math.abs(green - 85) + Math.abs(blue - 199)) / 3 < 40) && searchBlue)) {

                                copyCheck.add(new int[]{px + 1, py});
                                copyCheck.add(new int[]{px - 1, py});
                                copyCheck.add(new int[]{px, py + 1});
                                copyCheck.add(new int[]{px, py - 1});

                                image.setPixel(px, py, Color.WHITE);

                                count++;
                                avgX += px;
                                avgY += py;
                            }
                        }

                        toCheck = copyCheck;
                    }

                    if (avgX != 0 && count > (image.getWidth() * image.getHeight()) / 750) {
                        int centerX = avgX / count;
                        int centerY = avgY / count;

                        writeToFile("rec1.txt", String.valueOf(centerX) + " " + String.valueOf(centerY));

                        for (int dx = -5; dx <= 5; dx++) {
                            image.setPixel(centerX + dx, centerY, Color.BLACK);
                        }

                        for (int dy = -3; dy <= 3; dy++) {
                            image.setPixel(centerX, centerY + dy, Color.BLACK);
                        }
                    }
                }
            }
        }

        // Optionally add a crosshair
        // addCrosshair(image);
   }
}
