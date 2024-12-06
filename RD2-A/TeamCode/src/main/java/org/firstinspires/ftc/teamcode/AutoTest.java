//package org.firstinspires.ftc.teamcode;
//
//import android.util.Size;
//
//
//import com.acmerobotics.dashboard.config.Config;
////import com.acmerobotics.roadrunner.Action;
////import com.acmerobotics.roadrunner.Pose2d;
////import com.acmerobotics.roadrunner.SequentialAction;
////import com.acmerobotics.roadrunner.Vector2d;
////import com.acmerobotics.roadrunner.ftc.Actions;
//import com.acmerobotics.roadrunner.Action;
//import com.acmerobotics.roadrunner.Pose2d;
//import com.acmerobotics.roadrunner.Vector2d;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
//
//import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
//import org.firstinspires.ftc.vision.VisionPortal;
//
////@Config
//@Autonomous(name = "AutoTest", group = "Autonomous")
//public class AutoTest extends LinearOpMode {
//    private DcMotorEx leftFront, leftBack, rightBack, rightFront;
//
//
//    @Override
//    public void runOpMode() {
//        rightBack = hardwareMap.get(DcMotorEx.class, "rearRightMotor");
//        rightFront = hardwareMap.get(DcMotorEx.class, "frontRightMotor");
//        leftFront = hardwareMap.get(DcMotorEx.class, "frontLeftMotor");
//        leftBack = hardwareMap.get(DcMotorEx.class, "rearLeftMotor");
//
//        MecanumDrive drive = new MecanumDrive(hardwareMap,new Pose2d(-71.58, 39.65, Math.toRadians(-3.43)));
//        waitForStart();
//
//        if(opModeIsActive()){
//            Action trajectory0;
//            trajectory0 = drive.actionBuilder(new Pose2d(-69.77, 35.44, Math.toRadians(-2.33)))
//                    .splineTo(new Vector2d(-34.83, 34.02), Math.toRadians(-2.33))
//                    .splineTo(new Vector2d(-31.38, 59.81), Math.toRadians(82.38))
//                    .build();
//
//            telemetry.update();
//        }
//
//
//        telemetry.update();
//        waitForStart();
//    }
//}





package org.firstinspires.ftc.teamcode;

import android.util.Size;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


@Config
@Autonomous(name = "AutoTest", group = "Autonomous")
public class AutoTest extends LinearOpMode {

    @Override
    public void runOpMode() {

        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(-4.77, 72.00, Math.toRadians(-85.82)));




        Action trajectoryAction1;

        Action trajectoryAction2;

        Action trajectoryAction3;


        //Stanga
//        trajectoryAction1 = drive.actionBuilder(drive.pose)
//                .splineTo(new Vector2d(44.85, -60.12), Math.toRadians(165.60)).setReversed(true)
//                .splineTo(new Vector2d(24.92, -49.10), Math.toRadians(140.00)).setReversed(false)
//                .splineTo(new Vector2d(24.92, -30.01), Math.toRadians(50.00)).setReversed(true)
//                .splineTo(new Vector2d(55.25, 8.80), Math.toRadians(52.00))
//                .build();

//        trajectoryAction1 = drive.actionBuilder(new Pose2d(-69.92, -69.17, Math.toRadians(62.06)))
//                .splineTo(new Vector2d(-44.26, -28.97), Math.toRadians(57.44))
//                .splineTo(new Vector2d(-65.39, 17.46), Math.toRadians(114.48))
//                .build();

//        trajectoryAction1 = drive.actionBuilder(new Pose2d(59.54, -61.81, Math.toRadians(178.66)))
//                .splineTo(new Vector2d(14.63, -60.68), Math.toRadians(176.80)).setReversed(true)
//                .splineTo(new Vector2d(35.39, -35.95), Math.toRadians(43.61))
//                .splineTo(new Vector2d(57.28, -17.65), Math.toRadians(59.93)).setReversed(true)
//                .splineTo(new Vector2d(62.00, 4.44), Math.toRadians(53.96))
//                .build();


//        trajectoryAction1 = drive.actionBuilder(new Pose2d(61.24, 62.75, Math.toRadians(90.00)))
//                .setReversed(true)
//                .splineTo(new Vector2d(60.30, 11.23), Math.toRadians(268.95))
//                .splineTo(new Vector2d(9.91, 61.05), Math.toRadians(135.32))
//                .splineTo(new Vector2d(-9.34, 62.56), Math.toRadians(175.52))
//                .build();

//        trajectoryAction1 = drive.actionBuilder(new Pose2d(61.24, 62.75, Math.toRadians(90.00)))
//                .splineTo(new Vector2d(60.30, 11.23), Math.toRadians(268.95))
//                .splineTo(new Vector2d(9.91, 61.05), Math.toRadians(135.32))
//                .splineTo(new Vector2d(-9.34, 62.56), Math.toRadians(175.52))
//                .build();
//
//
//        trajectoryAction2 = drive.actionBuilder(drive.pose)
//                .setReversed(true)
//                .splineTo(new Vector2d(28.74, -10.92), Math.toRadians(50.00))
//                .splineTo(new Vector2d(54.61, 31.92), Math.toRadians(52.00))
//                .build();

// Alternative TrajectoryAction2 - Uncomment if needed
// trajectoryAction2 = drive.actionBuilder(new Pose2d(59.54, -61.81, Math.toRadians(178.66)))
//                .splineTo(new Vector2d(14.63, -60.68), Math.toRadians(176.80))
//                .splineTo(new Vector2d(35.39, -35.95), Math.toRadians(43.61))
//                .splineTo(new Vector2d(57.28, -17.65), Math.toRadians(59.93))
//                .splineTo(new Vector2d(62.00, 4.44), Math.toRadians(53.96))
//                .build();


        trajectoryAction1 = drive.actionBuilder(new Pose2d(-4.77, 72.00, Math.toRadians(-85.82)))
                .splineTo(new Vector2d(-3.96, 49.05), Math.toRadians(-88.06))
                .splineTo(new Vector2d(-4.37, 24.88), Math.toRadians(-89.51))
                .build();



        while (!isStopRequested() && !opModeIsActive()) {
            // vision here that outputs position

            telemetry.update();
        }


        //telemetry.addData("Starting Position", startPosition);
        telemetry.update();
        waitForStart();

        if (isStopRequested()) return;

        Action trajectoryActionChosen;


            trajectoryActionChosen = trajectoryAction1;


        Actions.runBlocking(
                new SequentialAction(
                        trajectoryActionChosen
                )
        );
    }
}