package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;

public class HardwareInit {
    public DcMotor frontLeftMotor = null;
    public DcMotor rearLeftMotor = null;
    public DcMotor frontRightMotor = null;
    public DcMotor rearRightMotor = null;
    public Servo armTurner = null;
//    public DcMotor armLifterMotor = null;
//    public WebcamName webcam = null;
    public Servo clawServo = null;
//    public DcMotor ballGrabber = null;
//    public DcMotor clawLifter = null;
//    public Servo clawServo = null;

    HardwareMap hwMap = null;

    public void init(HardwareMap hardwareMap, boolean isAutonom) {
        hwMap = hardwareMap;

        // Initialize motors from hardware map
        frontLeftMotor = hwMap.dcMotor.get("frontLeftMotor");
        rearLeftMotor = hwMap.dcMotor.get("rearLeftMotor");
        frontRightMotor = hwMap.dcMotor.get("frontRightMotor");
        rearRightMotor = hwMap.dcMotor.get("rearRightMotor");
        //armLifterMotor = hwMap.dcMotor.get("armLifter");
        //ballGrabber = hwMap.dcMotor.get("ballGrabber");
        //clawLifter = hwMap.dcMotor.get("clawLifter");

//
        armTurner = hwMap.get(Servo.class, "armTurner");
//        webcam = hwMap.get(WebcamName.class, "Webcam");
        clawServo = hwMap.get(Servo.class, "clawServo");
        //clawServo = hwMap.get(Servo.class, "clawServo");

        // Reset encoders
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Set motor modes and behaviors
        if (!isAutonom) {
            frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            rearLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            rearRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            //frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
            //rearLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        } else {
            frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rearLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            rearRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }

        // Set zero power behavior
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rearRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Set motor directions

        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rearLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rearRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }
}