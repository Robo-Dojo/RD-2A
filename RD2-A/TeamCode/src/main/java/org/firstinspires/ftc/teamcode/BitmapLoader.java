package org.firstinspires.ftc.teamcode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import static org.firstinspires.ftc.teamcode.BitmapLoader.loadBitmapFromFile;
import static org.firstinspires.ftc.teamcode.FileWrite.writeToFile;

import androidx.annotation.NonNull;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.vision.VisionPortal;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import android.util.Size;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;


import java.io.File;

public class BitmapLoader {

    public static Bitmap loadBitmapFromFile(String filePath) {
        try {
            File imageFile = new File(filePath);
            if (imageFile.exists()) {
                // Decode the file into a Bitmap
                return BitmapFactory.decodeFile(imageFile.getAbsolutePath());
            } else {
                System.err.println("File not found: " + filePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
