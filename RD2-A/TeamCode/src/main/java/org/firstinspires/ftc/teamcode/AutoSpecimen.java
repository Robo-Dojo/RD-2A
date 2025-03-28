package org.firstinspires.ftc.teamcode;
import androidx.annotation.NonNull;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.AngularVelConstraint;
import com.acmerobotics.roadrunner.MinVelConstraint;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.TranslationalVelConstraint;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.VelConstraint;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.Arrays;

@Config
@Autonomous(name = "AutoSpecimen", group = "Autonomous")
public class AutoSpecimen extends LinearOpMode {
    public static class Lift {
        private static DcMotorEx liftLeft;
        private static DcMotorEx liftRight;
        private static Telemetry telemetry;

        public Lift(HardwareMap hardwareMap, Telemetry telemetry) {
            liftLeft = hardwareMap.get(DcMotorEx.class, "armLifterLeft");
            liftLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            liftLeft.setDirection(DcMotorSimple.Direction.REVERSE);
            liftLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            liftLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


            liftRight = hardwareMap.get(DcMotorEx.class, "armLifterRight");
            liftRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            liftRight.setDirection(DcMotorSimple.Direction.FORWARD);
            liftRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            liftRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            Lift.telemetry = telemetry;
        }

        public static class LiftUp implements Action {
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    liftLeft.setPower(-1.0);
                    liftRight.setPower(-1.0);
                    initialized = true;
                }

                double posL = liftLeft.getCurrentPosition();
                double posR = liftRight.getCurrentPosition();
                telemetry.addData("liftPosL", posL);
                telemetry.addData("liftPosR", posR);
                telemetry.update();

                liftLeft.setTargetPosition(-1990);
                liftRight.setTargetPosition(-1990);
                liftLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                liftRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                liftLeft.setPower(-1);
                liftRight.setPower(-1);

                return false;

            }
        }
        public Action liftUp() {
            return new LiftUp();
        }

        public static class LiftUpAscend implements Action {
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    liftLeft.setPower(-1.0);
                    liftRight.setPower(-1.0);
                    initialized = true;
                }

                double posL = liftLeft.getCurrentPosition();
                double posR = liftRight.getCurrentPosition();
                telemetry.addData("liftPosL", posL);
                telemetry.addData("liftPosR", posR);
                telemetry.update();

                liftLeft.setTargetPosition(-1990);
                liftRight.setTargetPosition(-1990);
                liftLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                liftRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                liftLeft.setPower(-1);
                liftRight.setPower(-1);

                return false;

            }
        }
        public Action liftUpAscend() {
            return new LiftUpAscend();
        }

        public static class LiftUpBasket implements Action {
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    liftLeft.setPower(-1.0);
                    liftRight.setPower(-1.0);
                    initialized = true;
                }

                double posL = liftLeft.getCurrentPosition();
                double posR = liftRight.getCurrentPosition();
                telemetry.addData("liftPosL", posL);
                telemetry.addData("liftPosR", posR);
                telemetry.update();

                liftLeft.setTargetPosition(-4200);
                liftRight.setTargetPosition(-4200);
                liftLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                liftRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                liftLeft.setPower(-1);
                liftRight.setPower(-1);

                return false;

            }
        }
        public Action liftUpBasket() {
            return new LiftUpBasket();
        }

        public static class LiftDown implements Action {
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    liftLeft.setPower(1);
                    liftRight.setPower(1);
                    initialized = true;
                }

                double posL = liftLeft.getCurrentPosition();
                double posR = liftRight.getCurrentPosition();
                telemetry.addData("liftPosL", posL);
                telemetry.addData("liftPosR", posR);
                telemetry.update();


                liftLeft.setTargetPosition(-20);
                liftRight.setTargetPosition(-20);
                liftLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                liftRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                return false;
            }
        }
        public Action liftDown(){
            return new LiftDown();
        }

        public static class LiftDownMid implements Action {
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                if (!initialized) {
                    liftLeft.setPower(1);
                    liftRight.setPower(1);
                    initialized = true;
                }

                double posL = liftLeft.getCurrentPosition();
                double posR = liftRight.getCurrentPosition();
                telemetry.addData("liftPosL", posL);
                telemetry.addData("liftPosR", posR);
                telemetry.update();


                liftLeft.setTargetPosition(-775);
                liftRight.setTargetPosition(-775);
                liftLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                liftRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                return false;
            }
        }
        public Action liftDownMid(){
            return new LiftDownMid();
        }
    }

    public static class ClawControl {

        private static Servo clawServo;
        private static Servo twisterServo;
        private static Servo clawServoJoint;
        private static Servo intakeLeft;
        private static Servo intakeRight;
        private static Servo clawServoOuttake;
        private static Servo clawPivotShort;
        private static Servo clawPivotLong;


        public ClawControl(HardwareMap hardwareMap, Telemetry telemetry){
            clawServo = hardwareMap.get(Servo.class, "clawServoIntake");
            twisterServo = hardwareMap.get(Servo.class, "twisterServoController");
            clawServoJoint = hardwareMap.get(Servo.class, "servoJointController");
            intakeLeft = hardwareMap.get(Servo.class, "intakeLeft");
            intakeRight = hardwareMap.get(Servo.class, "intakeRight");
            clawServoOuttake = hardwareMap.get(Servo.class, "clawServoOuttake");
            clawPivotShort = hardwareMap.get(Servo.class, "clawPivotShort");
            clawPivotLong = hardwareMap.get(Servo.class, "clawPivotLong");
        }

        public static class IntakeArmOpen implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                intakeLeft.setPosition(0.435);
                intakeRight.setPosition(0.54);
                return false;
            }
        }
        public Action intakeArmOpen() {
            return new IntakeArmOpen();
        }


        public static class IntakeArmClose implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                intakeLeft.setPosition(0.505);
                intakeRight.setPosition(0.48);
                return false;
            }
        }
        public Action intakeArmClose() {
            return new IntakeArmClose();
        }


        public static class IntakeClawClose implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                clawServo.setPosition(0.55);
                return false;
            }
        }
        public Action intakeClawClose() {
            return new IntakeClawClose();
        }

        public static class IntakeClawOpen implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                clawServo.setPosition(0.2);
                return false;
            }
        }
        public Action intakeClawOpen() {
            return new IntakeClawOpen();
        }

        public static class IntakeClawTwistLeft implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                twisterServo.setPosition(0.48);
                return false;
            }
        }
        public Action intakeClawTwistLeft() {
            return new IntakeClawTwistLeft();
        }

        public static class IntakeClawTwistRight implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                twisterServo.setPosition(0.525);
                return false;
            }
        }
        public Action intakeClawTwistRight() {
            return new IntakeClawTwistRight();
        }

        public static class IntakeClawTwistMiddle implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                twisterServo.setPosition(0.5048);
                return false;
            }
        }
        public Action intakeClawTwistMiddle() {
            return new IntakeClawTwistMiddle();
        }

        public static class IntakeClawTwist1 implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                twisterServo.setPosition(0.5618);
                return false;
            }
        }
        public Action intakeClawTwist1() {
            return new IntakeClawTwist1();
        }
        public static class IntakeClawJointUp implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                clawServoJoint.setPosition(0.467);
                return false;
            }
        }

        public Action intakeClawJointUp() {
            return new IntakeClawJointUp();
        }

        public static class IntakeClawJointDown implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                clawServoJoint.setPosition(0.5675);
                return false;
            }
        }
        public Action intakeClawJointDown() {
            return new IntakeClawJointDown();
        }

        public static class OuttakeClawOpen implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                clawServoOuttake.setPosition(0.48);
                return false;
            }
        }
        public Action outtakeClawOpen() {
            return new OuttakeClawOpen();
        }

        public static class OuttakeClawClose implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                clawServoOuttake.setPosition(0.56);
                return false;
            }
        }
        public Action outtakeClawClose() {
            return new OuttakeClawClose();
        }


        public static class OuttakeClawPivotShortOpen implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                //0.52
                clawPivotShort.setPosition(0.76);
                return false;
            }
        }
        public Action outtakeClawPivotShortOpen() {
            return new OuttakeClawPivotShortOpen();
        }

        public static class OuttakeClawPivotShortOpen1 implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                clawPivotShort.setPosition(0.27);
                return false;
            }
        }
        public Action outtakeClawPivotShortOpen1() {
            return new OuttakeClawPivotShortOpen1();
        }

        public static class OuttakeClawPivotShortClose implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                //0.77
                clawPivotShort.setPosition(0.95);
                return false;
            }
        }
        public Action outtakeClawPivotShortClose() {
            return new OuttakeClawPivotShortClose();
        }

        public static class OuttakeClawPivotLongOpen implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                clawPivotLong.setPosition(0.57);
                return false;
            }
        }
        public Action outtakeClawPivotLongOpen() {
            return new OuttakeClawPivotLongOpen();
        }

        public static class OuttakeClawPivotLongClose implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                clawPivotLong.setPosition(0.485);
                return false;
            }
        }
        public Action outtakeClawPivotLongClose() {
            return new OuttakeClawPivotLongClose();
        }

    }

//    public class Claw {
//        private Servo claw;
//
//        public Claw(HardwareMap hardwareMap) {
//            claw = hardwareMap.get(Servo.class, "claw");
//        }
//
//        public class CloseClaw implements Action {
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                claw.setPosition(0.55);
//                return false;
//            }
//        }
//        public Action closeClaw() {
//            return new CloseClaw();
//        }
//
//        public class OpenClaw implements Action {
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                claw.setPosition(1.0);
//                return false;
//            }
//        }
//        public Action openClaw() {
//            return new OpenClaw();
//        }
//    }

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Run op mode start");
        Pose2d initialPose = new Pose2d(-17.27, 61.82, Math.toRadians(90.00));

        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        ClawControl claws = new ClawControl(hardwareMap, telemetry);
        Lift lift = new Lift(hardwareMap, telemetry);

//        // vision here that outputs position
//       // int visionOutputPosition = 1;

        Action startToCage;
        Action trajectory0;
        Action trajectory1;
        Action trajectory2;
        Action cageToSample;
        Action toSample1;
        Action toSample2;
        Action frontCage;
        Action samplesToHumanPlayer;
        Action humanPlayerToCage;

        telemetry.addData("Status", "innit completed");
        waitForStart();
        telemetry.addData("Status", "after wait start");
        VelConstraint vel45 = new MinVelConstraint(Arrays.asList(
                new TranslationalVelConstraint(45),
                new AngularVelConstraint(2)
        ));

        VelConstraint vel40 = new MinVelConstraint(Arrays.asList(
                new TranslationalVelConstraint(40),
                new AngularVelConstraint(2)
        ));

        startToCage = drive.actionBuilder(new Pose2d(-17.27, 61.82, Math.toRadians(90.00)))
                .splineToConstantHeading(new Vector2d(-6.59, 34.2), Math.toRadians(-74.18))
                .build();

        frontCage = drive.actionBuilder(new Pose2d(-6.59, 34.2, Math.toRadians(90.00)))
                .splineToConstantHeading(new Vector2d(-6.59, 32.5), Math.toRadians(270.00))
                .build();

        cageToSample = drive.actionBuilder(new Pose2d(-6.59, 32.5, Math.toRadians(90.00)))
                .splineToLinearHeading(new Pose2d(-20.96, 42.17, Math.toRadians(90.00)), Math.toRadians(143.29))
                .splineToLinearHeading(new Pose2d(-36.21, 39.85, Math.toRadians(90.00)), Math.toRadians(192.60))
                .splineToLinearHeading(new Pose2d(-35.54, 22.29, Math.toRadians(90.00)), Math.toRadians(-80.13))
                .splineToLinearHeading(new Pose2d(-47, 19.14, Math.toRadians(90.00)), Math.toRadians(182.44), vel45)
                //.splineToLinearHeading(new Pose2d(-49.13, 57.58, Math.toRadians(90.00)), Math.toRadians(91.46))
                .build();

        toSample1 = drive.actionBuilder(new Pose2d(-47, 19.14, Math.toRadians(90.00)))
                .splineToLinearHeading(new Pose2d(-47.30, 47, Math.toRadians(90.00)), Math.toRadians(91.46))
                .splineToLinearHeading(new Pose2d(-46, 19.20, Math.toRadians(90.00)), Math.toRadians(270.00), vel45)
                .build();
        toSample2 = drive.actionBuilder(new Pose2d(-46, 19.20, Math.toRadians(90.00)))
                .splineToLinearHeading(new Pose2d(-48, 19.20, Math.toRadians(90.00)), Math.toRadians(180.00), vel40)
//                .splineToLinearHeading(new Pose2d(-58.41, 47, Math.toRadians(90.00)), Math.toRadians(90.0))
//                .splineToLinearHeading(new Pose2d(-58.41, 36.04, Math.toRadians(90.00)), Math.toRadians(270.00))
//                .splineToLinearHeading(new Pose2d(-47, 32.89, Math.toRadians(90.00)), Math.toRadians(-12.99), vel45)
                .build();

        samplesToHumanPlayer = drive.actionBuilder(new Pose2d(-58.58, 13.01, Math.toRadians(270.00)))
                .splineToLinearHeading(new Pose2d(-47.97, 37.29, Math.toRadians(270.00)), Math.toRadians(58.86))
                .splineToLinearHeading(new Pose2d(-48.31, 60.99, Math.toRadians(270.00)), Math.toRadians(90.00),vel40)
                .build();
        humanPlayerToCage = drive.actionBuilder(new Pose2d(-48.31, 60.99, Math.toRadians(270.00)))
                .splineToLinearHeading(new Pose2d(-14.33, 50.79, Math.toRadians(90.00)), Math.toRadians(-41.37))
                .splineToLinearHeading(new Pose2d(-7.54, 34.5, Math.toRadians(90.00)), Math.toRadians(-33.69))
                .build();



//        Action specimenStartToCage = drive.actionBuilder(new Pose2d(-17.36, 64.3, Math.toRadians(90.00)))
//                .setTangent(Math.atan2(34.66 - 61.68, -3.85 - (-17.36))) // Calculate tangent for diagonal motion
//                .lineToXConstantHeading(-3.85) // Move to X = -3.85, respecting the tangent for diagonal motion
//                .build();
//
//        Action specimenCageToSamples = drive.actionBuilder(new Pose2d(-3.85, 34.66, Math.toRadians(90.00)))
//                .lineToXConstantHeading(-38) // Move straight to X = -38, maintaining heading towards 90°
//                .splineTo(new Vector2d(-39.60, 21.00), Math.toRadians(255.53))
//                .splineToConstantHeading(new Vector2d(-48.75, 0.22), Math.toRadians(252.02))
//                .splineToConstantHeading(new Vector2d(-47.73, 51.80), Math.toRadians(90.00))
//                .splineToConstantHeading(new Vector2d(-49.91, -2.83), Math.toRadians(263.86))
//                .splineToConstantHeading(new Vector2d(-56.60, 15.04), Math.toRadians(90.00))
//                .splineToConstantHeading(new Vector2d(-57.18, 59.36), Math.toRadians(90.23))
//                .build();



//        startToCage = drive.actionBuilder(new Pose2d(-6.32, 64.32, Math.toRadians(90.00)))
//                .setReversed(true)
//                .splineTo(new Vector2d(-6.32, 35.30), Math.toRadians(270.00))
//                .build();
//
//
//        trajectory0 = drive.actionBuilder(new Pose2d(-5.88, 32.06, Math.toRadians(90.00)))
//                .splineToConstantHeading(new Vector2d(-32.23, 34.55), Math.toRadians(172.57))
//                .splineToConstantHeading(new Vector2d(-32.23, 13.01), Math.toRadians(261.94))
//                .splineToConstantHeading(new Vector2d(-47.97, 13.01), Math.toRadians(187.50))
//                .splineToConstantHeading(new Vector2d(-48.47, 24.94), Math.toRadians(96.67))
//                .splineToConstantHeading(new Vector2d(-47.97, 40.52), Math.toRadians(88.17))
//                .splineToConstantHeading(new Vector2d(-48.14, 50.13), Math.toRadians(90.00))
//                .splineToConstantHeading(new Vector2d(-48.14, 14.17), Math.toRadians(269.75))
//                .splineToConstantHeading(new Vector2d(-58.25, 13.01), Math.toRadians(181.76))
//                .splineToConstantHeading(new Vector2d(-58.25, 27.26), Math.toRadians(88.57))
//                .splineToConstantHeading(new Vector2d(-58.41, 43.50), Math.toRadians(92.36))
//                .splineToConstantHeading(new Vector2d(-58.91, 51.45), Math.toRadians(91.35))
//                .splineToConstantHeading(new Vector2d(-58.91, 16.32), Math.toRadians(-89.30))
//                .splineToConstantHeading(new Vector2d(-65.70, 13.34), Math.toRadians(187.72))
//                .splineToConstantHeading(new Vector2d(-66.37, 28.58), Math.toRadians(97.50))
//                .splineToConstantHeading(new Vector2d(-66.86, 44.16), Math.toRadians(85.70))
//                .splineToConstantHeading(new Vector2d(-67.03, 54.60), Math.toRadians(88.57))
//                .splineToConstantHeading(new Vector2d(-67.03, 38.53), Math.toRadians(270.00))
//                .splineToConstantHeading(new Vector2d(-41.01, 39.02), Math.toRadians(1.09))
//                .build();
//
////STRAFE TRAJECTORY TO HUMAN PLAYER
////        trajectory1 = drive.actionBuilder(new Pose2d(-5.88, 32.23, Math.toRadians(90.00)))
////                .splineToConstantHeading(new Vector2d(-32.40, 34.38), Math.toRadians(175.35))
////                .build();
////        trajectory2 = drive.actionBuilder(new Pose2d(-32.40, 34.38, Math.toRadians(180.00)))
////                .splineToConstantHeading(new Vector2d(-32.23, 13.51), Math.toRadians(-89.55))
////                .splineToConstantHeading(new Vector2d(-40.49, 14.33), Math.toRadians(179.41))
////                .splineToConstantHeading(new Vector2d(-45.65, 40.52), Math.toRadians(90.00))
////                .splineToConstantHeading(new Vector2d(-46.48, 54.77), Math.toRadians(89.42))
////                .splineToConstantHeading(new Vector2d(-43.66, 13.51), Math.toRadians(269.35))
////                .splineToConstantHeading(new Vector2d(-49.46, 13.51), Math.toRadians(185.19))
////                .splineToConstantHeading(new Vector2d(-54.27, 27.42), Math.toRadians(95.64))
////                .splineToConstantHeading(new Vector2d(-55.43, 42.84), Math.toRadians(92.34))
////                .splineToConstantHeading(new Vector2d(-56.26, 54.10), Math.toRadians(92.86))
////                .splineToConstantHeading(new Vector2d(-51.62, 13.51), Math.toRadians(-89.59))
////                .splineToConstantHeading(new Vector2d(-57.56, 13.67), Math.toRadians(192.34))
////                .splineToConstantHeading(new Vector2d(-62.06, 34.22), Math.toRadians(96.86))
////                .splineToConstantHeading(new Vector2d(-61.23, 56.75), Math.toRadians(99.09))
////                .splineToConstantHeading(new Vector2d(-50.79, 44.99), Math.toRadians(-41.50))
////                .splineToConstantHeading(new Vector2d(-38.20, 43.50), Math.toRadians(-4.82))
////                .build();
//
//        trajectory1 = drive.actionBuilder(new Pose2d(-6.26, 32.29, Math.toRadians(90.00)))
//                .splineToConstantHeading(new Vector2d(-33.29, 33.29), Math.toRadians(174.44))
//                .splineToConstantHeading(new Vector2d(-34.12, 14.43), Math.toRadians(255.13))
//                .splineToConstantHeading(new Vector2d(-48.47, 14.10), Math.toRadians(180.00))
//                .splineToConstantHeading(new Vector2d(-47.97, 25.78), Math.toRadians(94.18))
//                .splineToConstantHeading(new Vector2d(-47.97, 37.13), Math.toRadians(90.00))
//                .splineToConstantHeading(new Vector2d(-47.30, 48.64), Math.toRadians(86.68))
//                .splineToConstantHeading(new Vector2d(-47.81, 52.14), Math.toRadians(95.71))
//                .splineToConstantHeading(new Vector2d(-48.47, 13.27), Math.toRadians(269.16))
//                .splineToConstantHeading(new Vector2d(-58.65, 13.10), Math.toRadians(191.98))
//                .splineToConstantHeading(new Vector2d(-58.65, 27.95), Math.toRadians(90.00))
//                .splineToConstantHeading(new Vector2d(-58.82, 40.13), Math.toRadians(93.87))
//                .splineToConstantHeading(new Vector2d(-58.98, 53.31), Math.toRadians(80.54))
//                .splineToConstantHeading(new Vector2d(-58.65, 14.27), Math.toRadians(269.59))
//                .splineToConstantHeading(new Vector2d(-64.83, 13.77), Math.toRadians(186.34))
//                .splineToConstantHeading(new Vector2d(-64.66, 31.29), Math.toRadians(99.73))
//                .splineToConstantHeading(new Vector2d(-64.66, 42.97), Math.toRadians(87.61))
//                .splineToConstantHeading(new Vector2d(-64.83, 55.98), Math.toRadians(93.32))
//                .splineToConstantHeading(new Vector2d(-63.49, 32.62), Math.toRadians(-84.50))
//                .splineToConstantHeading(new Vector2d(-41.13, 34.62), Math.toRadians(5.12))
//                .build();


        // actions that need to happen on init; for instance, a claw tightening.
        Actions.runBlocking(
                new ParallelAction(
                        claws.outtakeClawClose(),
                        claws.intakeArmClose(),
                        claws.intakeClawOpen()
                )
        );


        while (!isStopRequested() && !opModeIsActive()) { // Asta actioneaza ca un Init la Autonomie
            //int position = visionOutputPosition;
            // telemetry.addData("Position during Init", position);
            telemetry.addData("Status", "Waiting in Init");
            telemetry.addData("Stop requested:", isStopRequested());
            telemetry.addData("Op mode: ", opModeIsActive());
            telemetry.update();
        }

        telemetry.addData("Status", "before actions");
        Actions.runBlocking(
                new SequentialAction(
                        new ParallelAction(
                                startToCage,
                                lift.liftUp()
                        ),
                        new ParallelAction(
                                claws.outtakeClawPivotLongOpen(),
                                claws.outtakeClawPivotShortClose()
                        ),
                        new SleepAction(0.2),
                        new ParallelAction(
                                lift.liftDownMid(),
                                new SequentialAction(
                                        frontCage,
                                        new SleepAction(0.5),
                                        claws.outtakeClawOpen(),
                                        new SleepAction(0.4),
                                        claws.outtakeClawClose(),
                                        claws.outtakeClawPivotShortClose(),
                                        claws.outtakeClawPivotLongClose(),
                                        new SleepAction(0.1),
                                        claws.outtakeClawOpen()
                                )
                        ),
                        new ParallelAction(
                                lift.liftDown(),
                                cageToSample
                        ),
                        toSample1,
                        new SleepAction(0.1),
                        toSample2
//                        new SleepAction(0.8),
//                        samplesToHumanPlayer


                )
        );

        while(opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.addData("liftPosL", Lift.liftLeft.getCurrentPosition());
            telemetry.addData("liftPosR", Lift.liftRight.getCurrentPosition());
            telemetry.update();
        }
    }
}
