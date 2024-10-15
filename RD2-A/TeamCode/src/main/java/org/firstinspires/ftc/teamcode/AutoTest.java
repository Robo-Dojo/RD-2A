package org.firstinspires.ftc.teamcode;

import android.util.Size;


import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
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

        waitForStart();
        if(opModeIsActive()){
            leftFront.setPower(-0.5);
            leftBack.setPower(-0.5);
            rightBack.setPower(0.5);
            rightFront.setPower(0.5);
            sleep(2200);

            leftFront.setPower(-0.5);
            leftBack.setPower(0.5);
            rightBack.setPower(0.5);
            rightFront.setPower(-0.5);
            sleep(2000);

            leftFront.setPower(0);
            leftBack.setPower(0);
            rightBack.setPower(0);
            rightFront.setPower(0);

            telemetry.update();
        }


        telemetry.update();
        waitForStart();
    }
}