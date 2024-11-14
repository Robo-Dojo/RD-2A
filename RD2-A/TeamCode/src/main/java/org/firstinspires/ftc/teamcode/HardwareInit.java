package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;

public class HardwareInit {
    public DcMotor frontLeftMotor = null;
    public DcMotor rearLeftMotor = null;
    public DcMotor frontRightMotor = null;
    public DcMotor rearRightMotor = null;
    public Servo armTurner = null;
    public DcMotor armLifterMotorLeft = null;
    public DcMotor armLifterMotorRight = null;
    public Servo joint = null;
    //public Servo testServo = null;
    //public DcMotorEx par = null;
    //public DcMotorEx perp = null;



    HardwareMap hwMap = null;

    public void init(HardwareMap hardwareMap, boolean isAutonom) {
        hwMap = hardwareMap;

        // Initialize motors from hardware map
        frontLeftMotor = hwMap.dcMotor.get("leftFront");
        rearLeftMotor = hwMap.dcMotor.get("leftBack");
        frontRightMotor = hwMap.dcMotor.get("rightFront");
        rearRightMotor = hwMap.dcMotor.get("rightBack");
        armLifterMotorLeft = hwMap.dcMotor.get("armLifterLeft");
        armLifterMotorRight = hwMap.dcMotor.get("armLifterRight");
        joint = hwMap.get(Servo.class, "joint");
        //testServo = hwMap.get(Servo.class, "testServo");


        // Initialize the parallel and perpendicular odometry motors (with encoders)
        //par = hwMap.get(DcMotorEx.class, "par");  // Ensure "par" is the name in the Driver Hub
        //perp = hwMap.get(DcMotorEx.class, "perp");  // Ensure "perp" is the name in the Driver Hub

        // Reset encoders
        frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rearRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Initialize parallel and perpendicular motors for odometry
        //par.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);  // Set to run without encoder if used only for odometry
        //perp.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);  // Same for perpendicular motor

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

            //frontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
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

        frontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rearLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rearRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);


        // If you need to configure the direction of the odometry wheels (par and perp), do it here
        //par.setDirection(DcMotorSimple.Direction.FORWARD);  // Set based on your wiring and wheel alignment
        //perp.setDirection(DcMotorSimple.Direction.FORWARD); // Same here

    }
}