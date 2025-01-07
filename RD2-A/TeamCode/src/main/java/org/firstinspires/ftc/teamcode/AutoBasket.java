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
import org.opencv.core.Mat;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.Arrays;

@Config
@Autonomous(name = "AutoBasket", group = "Autonomous")
public class AutoBasket extends LinearOpMode {
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
                clawServoOuttake.setPosition(0.4789);
                return false;
            }
        }
        public Action outtakeClawOpen() {
            return new OuttakeClawOpen();
        }

        public static class OuttakeClawClose implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                clawServoOuttake.setPosition(0.5);
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
                //0.77     1
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
                clawPivotLong.setPosition(0.56);
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


    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Run op mode start");
//        Pose2d initialPose = new Pose2d(7.16, 61.46, Math.toRadians(90));
        Pose2d initialPose = new Pose2d(17.60, 61.82, Math.toRadians(90.00));
//
//
//
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        ClawControl claws = new ClawControl(hardwareMap, telemetry);
        Lift lift = new Lift(hardwareMap, telemetry);
//
//        // vision here that outputs position
//       // int visionOutputPosition = 1;

        Action startToCage;
        Action frontCage;
        Action backCage;
        Action cageToSample;
        Action sampleToBasket;
        Action backBasket;
        Action basketSample2;
        Action sampleToBasket2;
        Action basketSample3;
        Action sampleToBasket3;
        Action basketToPark;
        Action park;
        Action parkL;

//        startToCage = drive.actionBuilder(new Pose2d(7.16, 61.46, Math.toRadians(90.00)))
//                .splineToConstantHeading(new Vector2d(7.16, 33), Math.toRadians(270.00))
//                .build();
        startToCage = drive.actionBuilder(new Pose2d(17.60, 61.82, Math.toRadians(90.00)))
                .splineToConstantHeading(new Vector2d(9.76, 33.7), Math.toRadians(270.00))
                .build();


        frontCage = drive.actionBuilder(new Pose2d(9.76, 33.7, Math.toRadians(90.00)))
                .splineToConstantHeading(new Vector2d(9.76, 32.5), Math.toRadians(270.00))
                .build();
        backCage = drive.actionBuilder(new Pose2d(9.76, 32.5, Math.toRadians(90.00)))
                .splineToConstantHeading(new Vector2d(9.76, 38), Math.toRadians(270.00))
                .build();
        cageToSample = drive.actionBuilder(new Pose2d(9.76, 38, Math.toRadians(90.00)))
                .splineToSplineHeading(new Pose2d(32.40, 42.84, Math.toRadians(270.00)), Math.toRadians(10.44))
                .splineToSplineHeading(new Pose2d(48, 48.8, Math.toRadians(270.00)), Math.toRadians(7.35))
                .build();
        sampleToBasket = drive.actionBuilder(new Pose2d(48, 48.8, Math.toRadians(270.00)))
                .splineToLinearHeading(new Pose2d(58.2, 56.38, Math.toRadians(231.34)), Math.toRadians(41.45))
                .build();
//        backBasket = drive.actionBuilder(new Pose2d(58, 56.1, Math.toRadians(231.34)))
//                .splineToSplineHeading(new Pose2d(53.77, 51.12, Math.toRadians(231.34)), Math.toRadians(103.03))
//                .build();
        backBasket = drive.actionBuilder(new Pose2d(58.2, 56.38, Math.toRadians(231.34)))
                .splineToLinearHeading(new Pose2d(55.26, 53.2, Math.toRadians(231.34)), Math.toRadians(-66.37))
                .build();

        VelConstraint vel40 = new MinVelConstraint(Arrays.asList(
                new TranslationalVelConstraint(40),
                new AngularVelConstraint(2)
        ));

        basketSample2 = drive.actionBuilder(new Pose2d(55.26, 53.2, Math.toRadians(231.34)))
                .splineToLinearHeading(new Pose2d(60, 49.3, Math.toRadians(270.00)), Math.toRadians(-60.95), vel40)
                .build();

        sampleToBasket2 = drive.actionBuilder(new Pose2d(60, 49.3, Math.toRadians(270.00)))
                .splineToLinearHeading(new Pose2d(58.25, 56.09, Math.toRadians(231.34)), Math.toRadians(94.67))
                .build();

        basketSample3 = drive.actionBuilder(new Pose2d(58.25, 56.09, Math.toRadians(231.34)))
                .splineToLinearHeading(new Pose2d(46.32, 29.25, Math.toRadians(0.00)), Math.toRadians(-70.20))
                .splineToLinearHeading(new Pose2d(48.32, 26.5, Math.toRadians(0.00)), Math.toRadians(-70.20), vel40)
                .build();
        sampleToBasket3 = drive.actionBuilder(new Pose2d(48.32, 26.5, Math.toRadians(0.00)))
                .splineToLinearHeading(new Pose2d(58.25, 56.09, Math.toRadians(231.34)), Math.toRadians(67.80))
                .build();
//        basketToPark = drive.actionBuilder(new Pose2d(46.48, 46.15, Math.toRadians(231.34)))
//                .splineToSplineHeading(new Pose2d(36.70, 21.62, Math.toRadians(0.00)), Math.toRadians(71.57))
//                .splineToSplineHeading(new Pose2d(26.43, 7.71, Math.toRadians(0.00)), Math.toRadians(0.00))
//                .build();
//        park = drive.actionBuilder(new Pose2d(26.43, 7.71, Math.toRadians(0.00)))
//                .splineToSplineHeading(new Pose2d(22.78, 7.54, Math.toRadians(0.00)), Math.toRadians(178.78))
//                .build();
        //merge
        basketToPark = drive.actionBuilder(new Pose2d(53.77, 51.12, Math.toRadians(231.34)))
                .splineToSplineHeading(new Pose2d(39.02, 32.89, Math.toRadians(0.00)), Math.toRadians(240.13))
                .splineToSplineHeading(new Pose2d(24, 10.52, Math.toRadians(0.00)), Math.toRadians(183.32))
                .build();
        park = drive.actionBuilder(new Pose2d(24, 10.52, Math.toRadians(0.00)))
                .splineToSplineHeading(new Pose2d(23.28, 10.85, Math.toRadians(0.00)), Math.toRadians(180.00))
                .build();
//
        parkL = drive.actionBuilder(new Pose2d(53.77, 51.12, Math.toRadians(231.34)))
                .splineToSplineHeading(new Pose2d(40.35, 41.84, Math.toRadians(226.04)), Math.toRadians(226.04))
                .splineToSplineHeading(new Pose2d(-0.91, 38.20, Math.toRadians(181.88)), Math.toRadians(181.88))
                .splineToSplineHeading(new Pose2d(-48.80, 39.52, Math.toRadians(180.37)), Math.toRadians(180.37))
                .splineToSplineHeading(new Pose2d(-53.77, 56.09, Math.toRadians(85.54)), Math.toRadians(85.54))
                .build();



        telemetry.addData("Status", "innit completed");
        waitForStart();
        telemetry.addData("Status", "after wait start");


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
                        //new SleepAction(0.2),
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
                        backCage,
                        lift.liftDown(),
                        cageToSample,
                        //sampleToBasket,
                        claws.intakeArmOpen(),
                        //1
                        new SleepAction(0.7),
                        claws.intakeClawJointDown(),
                        //0.9
                        new SleepAction(0.7),
                        claws.intakeClawClose(),
                        //1
                        new SleepAction(0.7),
                        claws.intakeClawJointUp(),
                        claws.intakeArmClose(),
                        //1
                        new SleepAction(0.8),
                        new ParallelAction(
                                claws.outtakeClawClose(),
                                claws.intakeClawOpen()
                        ),
                        new SleepAction(0.2),
                        new ParallelAction(
                        sampleToBasket,
                        lift.liftUpBasket()
                        ),
                        new SleepAction(0.4),
                        new ParallelAction(
                                claws.outtakeClawPivotLongOpen(),
                                claws.outtakeClawPivotShortClose()
                        ),
                        new SleepAction(0.5),
                        claws.outtakeClawOpen(),
                        new SleepAction(0.2),
                        claws.outtakeClawClose(),
                        new SleepAction(0.1),
                        new ParallelAction(
                                claws.outtakeClawPivotLongClose(),
                                claws.outtakeClawPivotShortClose()
                        ),
                        claws.outtakeClawOpen(),
                        backBasket,
                        new ParallelAction(
                        lift.liftDown(),
                                claws.intakeArmOpen()
                                ),





                        new SleepAction(0.5),
                        basketSample2,
                        //new SleepAction(0.3),
                        //claws.intakeArmOpen(),
                        //1
                        new SleepAction(0.3),
                        claws.intakeClawJointDown(),
                        //0.9
                        new SleepAction(0.5),
                        claws.intakeClawClose(),
                        //1
                        new SleepAction(0.7),
                        claws.intakeClawJointUp(),
                        claws.intakeArmClose(),
                        //1
                        new SleepAction(0.8),
                        new ParallelAction(
                                claws.outtakeClawClose(),
                                claws.intakeClawOpen()
                        ),
                        new ParallelAction(
                                sampleToBasket2,
                                lift.liftUpBasket()
                        ),
                        new SleepAction(0.6),
                        new ParallelAction(
                                claws.outtakeClawPivotLongOpen(),
                                claws.outtakeClawPivotShortClose()
                        ),
                        new SleepAction(0.5),
                        claws.outtakeClawOpen(),
                        new SleepAction(0.2),
                        claws.outtakeClawClose(),
                        new SleepAction(0.1),
                        new ParallelAction(
                                claws.outtakeClawPivotLongClose(),
                                claws.outtakeClawPivotShortClose()
                        ),
                        claws.outtakeClawOpen(),



                        new ParallelAction(
                                lift.liftDown(),
                                claws.intakeArmOpen(),
                                claws.intakeClawJointDown(),
                                claws.intakeClawTwist1()
                        ),
                        basketSample3,
                        claws.intakeClawClose(),
                        new SleepAction(0.5),
                        new ParallelAction(
                                claws.intakeArmClose(),
                                claws.intakeClawTwistMiddle()
                        ),
                        claws.intakeClawJointUp(),
                        new SleepAction(0.8),
                        new ParallelAction(
                                claws.outtakeClawClose(),
                                claws.intakeClawOpen()
                        ),
        new ParallelAction(
                sampleToBasket3,
                lift.liftUpBasket()
        ),
                new SleepAction(0.6),
                new ParallelAction(
                        claws.outtakeClawPivotLongOpen(),
                        claws.outtakeClawPivotShortClose()
                ),
                new SleepAction(0.5),
                claws.outtakeClawOpen(),
                new SleepAction(0.2),
                claws.outtakeClawClose(),
                new SleepAction(0.1),
                new ParallelAction(
                        claws.outtakeClawPivotLongClose(),
                        claws.outtakeClawPivotShortClose()
                ),
                claws.outtakeClawOpen(),
                        lift.liftDown()
//                        backBasket2,
//                        lift.liftDown()
                        //merge
                        //basketToPark
                        //
//                        lift.liftUpAscend(),
//                        park

                       // parkL
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
