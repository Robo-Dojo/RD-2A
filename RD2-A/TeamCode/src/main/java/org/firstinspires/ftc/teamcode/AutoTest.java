package org.firstinspires.ftc.teamcode;

import android.util.Size;


import com.acmerobotics.dashboard.config.Config;
//import com.acmerobotics.roadrunner.Action;
//import com.acmerobotics.roadrunner.Pose2d;
//import com.acmerobotics.roadrunner.SequentialAction;
//import com.acmerobotics.roadrunner.Vector2d;
//import com.acmerobotics.roadrunner.ftc.Actions;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;

//@Config
@Autonomous(name = "AutoTest", group = "Autonomous")
public class AutoTest extends LinearOpMode {
    private DcMotorEx leftFront, leftBack, rightBack, rightFront;


    @Override
    public void runOpMode() {
        rightBack = hardwareMap.get(DcMotorEx.class, "rearRightMotor");
        rightFront = hardwareMap.get(DcMotorEx.class, "frontRightMotor");
        leftFront = hardwareMap.get(DcMotorEx.class, "frontLeftMotor");
        leftBack = hardwareMap.get(DcMotorEx.class, "rearLeftMotor");

        MecanumDrive drive = new MecanumDrive(hardwareMap,new Pose2d(-71.58, 39.65, Math.toRadians(-3.43)));
        waitForStart();

        if(opModeIsActive()){
            Action trajectory0;
            trajectory0 = drive.actionBuilder(new Pose2d(-69.77, 35.44, Math.toRadians(-2.33)))
                    .splineTo(new Vector2d(-34.83, 34.02), Math.toRadians(-2.33))
                    .splineTo(new Vector2d(-31.38, 59.81), Math.toRadians(82.38))
                    .build();

            telemetry.update();
        }


        telemetry.update();
        waitForStart();
    }
}