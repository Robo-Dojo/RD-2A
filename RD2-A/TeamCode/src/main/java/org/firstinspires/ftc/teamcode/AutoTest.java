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

    private static DcMotor armTurnerMotorLeft, armTurnerMotorRight;
    private static Servo clawJointIntake, clawIntake, clawJointOuttake, clawOuttake;

    public static class Viper {

        private static DcMotorEx viperLeft;
        private static DcMotorEx viperRight;

        // Constructor to initialize the hardware
        public Viper(HardwareMap hardwareMap) {
            viperLeft = hardwareMap.get(DcMotorEx.class, "armLifterLeft");
            viperLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            viperLeft.setDirection(DcMotor.Direction.FORWARD);

            viperRight = hardwareMap.get(DcMotorEx.class, "armLifterRight");
            viperRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            viperRight.setDirection(DcMotor.Direction.FORWARD);
        }

        public static class ViperUp implements Action {
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    viperLeft.setPower(1.0);
                    viperRight.setPower(-1.0);
                    initialized = true;
                }

                double posLeft = viperLeft.getCurrentPosition();
                double posRight = viperRight.getCurrentPosition();
                packet.put("liftPosLeft", posLeft);
                packet.put("liftPosRight", posRight);
                if (posLeft > 0 && posRight < 0) {
                    return true;
                } else {
                    viperLeft.setPower(0);
                    viperRight.setPower(0);
                    return false;
                }
            }
        }

        public Action viperUp() {
            return new Viper.ViperUp();
        }

        public static class ViperDown implements Action {
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    viperLeft.setPower(1.0);
                    viperRight.setPower(-1.0);
                    initialized = true;
                }

                double posLeft = viperLeft.getCurrentPosition();
                double posRight = viperRight.getCurrentPosition();
                packet.put("liftPosLeft", posLeft);
                packet.put("liftPosRight", posRight);
                if (posLeft < 3340 && posLeft > -3340) {
                    return true;
                } else {
                    viperLeft.setPower(0);
                    viperRight.setPower(0);
                    return false;
                }
            }
        }
        public Action viperDown(){
            return new Viper.ViperDown();
        }
    }

    public static class IntakeClaw {
        private static Servo servoJointIntake, servoJointOuttake, intakeClaw, outtakeClaw, intakeServoRight, intakeServoLeft;

        public IntakeClaw (HardwareMap hardwareMap) {
            servoJointIntake = hardwareMap.get(Servo.class, "clawServo2"); //Intake Close/Open,
            servoJointOuttake = hardwareMap.get(Servo.class, "clawIntake");
            intakeClaw = hardwareMap.get(Servo.class, "clawServo1"); // Intake Close/Open,
            outtakeClaw = hardwareMap.get(Servo.class, "clawOuttake");
            intakeServoLeft = hardwareMap.get(Servo.class, "intakeLeft"); // Intake Close/Open,
            intakeServoRight = hardwareMap.get(Servo.class, "intakeRight"); // Intake Close/Open,
        }

        public static class IntakeClose implements Action {

            static final double CLOSED_POSITION_INTAKE_CLAW = 0.44;
            static final double CLOSED_POSITION_INTAKE_JOINT = 0.378;
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    intakeClaw.setPosition(CLOSED_POSITION_INTAKE_CLAW);
                    clawJointIntake.setPosition(CLOSED_POSITION_INTAKE_JOINT);
                    initialized = true;
                }

                if (intakeClaw.getPosition() > CLOSED_POSITION_INTAKE_CLAW && servoJointIntake.getPosition() > CLOSED_POSITION_INTAKE_JOINT) {
                    return true;
                }

                return false;
            }
        }

        public Action intakeClose() {
            return new IntakeClaw.IntakeClose();
        }


        public static class IntakeOpen implements Action {

            static final double OPEN_POSITION_INTAKE_CLAW = 0.475;
            static final double OPEN_POSITION_INTAKE_JOINT = 0.487;
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    intakeClaw.setPosition(OPEN_POSITION_INTAKE_CLAW);
                    clawJointIntake.setPosition(OPEN_POSITION_INTAKE_JOINT);
                    initialized = true;
                }

                if (clawJointIntake.getPosition() > OPEN_POSITION_INTAKE_JOINT && intakeClaw.getPosition() > OPEN_POSITION_INTAKE_CLAW) {
                    return true;
                }

                return false;
            }
        }
    }
        public Action intakeOpen() {
            return new IntakeClaw.IntakeOpen();
        }


    public static class IntakeViperControl {
        private static Servo servoLeft, servoRight;

        public  IntakeViperControl (HardwareMap hardwareMap) {
            servoLeft = hardwareMap.get(Servo.class, "intakeLeft");
            servoRight = hardwareMap.get(Servo.class, "intakeRight");
        }

        public static class ViperClose implements Action {

            static final double CLOSED_POSITION_LEFT = 0;
            static final double CLOSED_POSITION_RIGHT = 1;
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    servoLeft.setPosition(CLOSED_POSITION_LEFT);
                    servoRight.setPosition(CLOSED_POSITION_RIGHT);
                    initialized = true;
                }

                if (servoLeft.getPosition() > CLOSED_POSITION_LEFT && servoRight.getPosition() > CLOSED_POSITION_RIGHT) {
                    return true;
                }

                return false;
            }
        }

        public Action intakeViperClose() {
            return new IntakeViperControl.ViperClose();
        }


        public static class ViperOpen implements Action {

            static final double OPEN_VIPER_LEFT = 1;
            static final double OPEN_VIPER_RIGHT = 0;
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    servoLeft.setPosition(OPEN_VIPER_LEFT);
                    servoRight.setPosition(OPEN_VIPER_RIGHT);
                    initialized = true;
                }

                if (servoLeft.getPosition() > OPEN_VIPER_LEFT && servoRight.getPosition() > OPEN_VIPER_RIGHT) {
                    return true;
                }

                return false;
            }
        }
    }
    public Action ViperOpen() {
        return new IntakeViperControl.ViperOpen();
    }



    public static class OuttakeClaw {
        private static Servo servoJoint, servoClaw;

        public OuttakeClaw (HardwareMap hardwareMap) {
            servoJoint = hardwareMap.get(Servo.class, "clawIntake");
            servoClaw = hardwareMap.get(Servo.class, "clawOuttake");
        }

        public static class OuttakeRelease implements Action {

            static final double RELEASE_POSITION_CLAW = 0.53;
            static final double RELEASE_POSITION_JOINT = 0.8;
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    servoClaw.setPosition(RELEASE_POSITION_CLAW);
                    servoJoint.setPosition(RELEASE_POSITION_JOINT);
                    initialized = true;
                }

                if (servoClaw.getPosition() > RELEASE_POSITION_CLAW && servoJoint.getPosition() > RELEASE_POSITION_JOINT) {
                    return true;
                }

                return false;
            }
        }

        public Action OuttakeRelease() {
            return new OuttakeClaw.OuttakeRelease();
        }


        public static class OuttakeTake implements Action {

            static final double TAKE_POSITION_CLAW = 0.57;
            static final double TAKE_POSITION_JOINT = 0.4;
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    servoClaw.setPosition(TAKE_POSITION_CLAW);
                    servoJoint.setPosition(TAKE_POSITION_JOINT);
                    initialized = true;
                }

                if (servoClaw.getPosition() > TAKE_POSITION_CLAW && servoJoint.getPosition() > TAKE_POSITION_JOINT) {
                    return true;
                }

                return false;
            }
        }
    }
    public Action OuttakeTake() {
        return new OuttakeClaw.OuttakeTake();
    }


    @Override
    public void runOpMode() {

        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(-4.77, 72.00, Math.toRadians(-85.82)));



        Action trajectoryAction1;

        Action trajectoryAction2;

        Action trajectoryAction3;


        trajectoryAction1 = drive.actionBuilder(new Pose2d(-4.77, 72.00, Math.toRadians(-85.82)))
                .splineTo(new Vector2d(-3.96, 49.05), Math.toRadians(-88.06))
                .splineTo(new Vector2d(-4.37, 24.88), Math.toRadians(-89.51))
                .build();


        while (!isStopRequested() && !opModeIsActive()) {

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