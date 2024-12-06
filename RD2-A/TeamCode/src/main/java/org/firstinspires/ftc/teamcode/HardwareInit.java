package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class HardwareInit {
    public DcMotor frontLeftMotor = null;
    public DcMotor rearLeftMotor = null;
    public DcMotor frontRightMotor = null;
    public DcMotor rearRightMotor = null;
    //public Servo armTurner = null;
    public DcMotor armLifterMotorLeft = null;
    public DcMotor armLifterMotorRight = null;
    public Servo clawServo1 = null;
    public Servo clawServo2 = null;
    public Servo intakeLeft = null;
    public Servo intakeRight = null;
    public Servo clawIntake = null;
    public Servo clawOuttake = null;
    //public Servo clawServo = null;
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
        clawServo1 = hwMap.get(Servo.class, "clawServo1");
        clawServo2 = hwMap.get(Servo.class, "clawServo2");
        intakeLeft = hwMap.get(Servo.class, "intakeLeft");
        intakeRight = hwMap.get(Servo.class, "intakeRight");
        clawIntake = hwMap.get(Servo.class, "clawIntake");
        clawOuttake = hwMap.get(Servo.class, "clawOuttake");
        //clawServo = hwMap.get(Servo.class, "clawServo");
        //testServo = hwMap.get(Servo.class, "testServo");


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

    }
}