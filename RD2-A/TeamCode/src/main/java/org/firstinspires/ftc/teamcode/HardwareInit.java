package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


public class HardwareInit {
    public DcMotor frontLeftMotor = null;
    public DcMotor rearLeftMotor = null;
    public DcMotor frontRightMotor = null;
    public DcMotor rearRightMotor = null;
    //public Servo armTurner = null;
    public DcMotor armLifterMotorLeft = null;
    public DcMotor armLifterMotorRight = null;
//    public Servo clawServo = null;
//    public Servo twisterServo = null;
//    public Servo clawServoJoint = null;
//    public Servo intakeLeft = null;
//    public Servo intakeRight = null;
    public Servo clawServoOuttake = null;
    public Servo clawPivotShort = null;
//    public Servo clawPivotLong = null;
//public WebcamName webcam;





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
//        clawServo = hwMap.get(Servo.class, "clawServoIntake");
//        twisterServo = hwMap.get(Servo.class, "twisterServoController");
//        clawServoJoint = hwMap.get(Servo.class, "servoJointController");
//        intakeLeft = hwMap.get(Servo.class, "intakeLeft");
//        intakeRight = hwMap.get(Servo.class, "intakeRight");
        clawServoOuttake = hwMap.get(Servo.class, "clawServoOuttake");
        clawPivotShort = hwMap.get(Servo.class, "clawPivotShort");
//        clawPivotLong = hwMap.get(Servo.class, "clawPivotLong");
     //   webcam = hwMap.get(WebcamName.class, "Webcam 1");



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