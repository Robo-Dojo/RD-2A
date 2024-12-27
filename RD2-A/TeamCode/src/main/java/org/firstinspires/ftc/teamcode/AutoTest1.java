package org.firstinspires.ftc.teamcode;
import androidx.annotation.NonNull;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.MecanumDrive;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
@Autonomous(name = "AutoTest1", group = "Autonomous")
public class AutoTest1 extends LinearOpMode {
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

                liftLeft.setTargetPosition(-2000);
                liftRight.setTargetPosition(-2000);
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


                liftLeft.setTargetPosition(-120);
                liftRight.setTargetPosition(-120);
                liftLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                liftRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

                return false;
            }
        }
        public Action liftDown(){
            return new LiftDown();
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
        Pose2d initialPose = new Pose2d(-6.32, 64.32, Math.toRadians(90));
//
//
//
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
//        //Claw claw = new Claw(hardwareMap);
        Lift lift = new Lift(hardwareMap, telemetry);
//
//        // vision here that outputs position
//       // int visionOutputPosition = 1;

        Action startToCage;
        Action trajectory0;
        Action trajectory1;
        Action trajectory2;
        Action fataspate;
//        Action trajectoryAction2;

        Action cageToSample1;
        Action cageToSample2;
        Action cageToSample3;

        telemetry.addData("Status", "innit completed");
        waitForStart();
        telemetry.addData("Status", "after wait start");

        startToCage = drive.actionBuilder(new Pose2d(-6.32, 64.32, Math.toRadians(90.00)))
                .setReversed(true)
                .splineTo(new Vector2d(-6.32, 33.30), Math.toRadians(270.00))

                .build();


        trajectory0 = drive.actionBuilder(new Pose2d(-5.88, 32.06, Math.toRadians(90.00)))
                .splineToConstantHeading(new Vector2d(-32.23, 34.55), Math.toRadians(172.57))
                .splineToConstantHeading(new Vector2d(-32.23, 13.01), Math.toRadians(261.94))
                .splineToConstantHeading(new Vector2d(-47.97, 13.01), Math.toRadians(187.50))
                .splineToConstantHeading(new Vector2d(-48.47, 24.94), Math.toRadians(96.67))
                .splineToConstantHeading(new Vector2d(-47.97, 40.52), Math.toRadians(88.17))
                .splineToConstantHeading(new Vector2d(-48.14, 50.13), Math.toRadians(90.00))
                .splineToConstantHeading(new Vector2d(-48.14, 14.17), Math.toRadians(269.75))
                .splineToConstantHeading(new Vector2d(-58.25, 13.01), Math.toRadians(181.76))
                .splineToConstantHeading(new Vector2d(-58.25, 27.26), Math.toRadians(88.57))
                .splineToConstantHeading(new Vector2d(-58.41, 43.50), Math.toRadians(92.36))
                .splineToConstantHeading(new Vector2d(-58.91, 51.45), Math.toRadians(91.35))
                .splineToConstantHeading(new Vector2d(-58.91, 16.32), Math.toRadians(-89.30))
                .splineToConstantHeading(new Vector2d(-65.70, 13.34), Math.toRadians(187.72))
                .splineToConstantHeading(new Vector2d(-66.37, 28.58), Math.toRadians(97.50))
                .splineToConstantHeading(new Vector2d(-66.86, 44.16), Math.toRadians(85.70))
                .splineToConstantHeading(new Vector2d(-67.03, 54.60), Math.toRadians(88.57))
                .splineToConstantHeading(new Vector2d(-67.03, 38.53), Math.toRadians(270.00))
                .splineToConstantHeading(new Vector2d(-41.01, 39.02), Math.toRadians(1.09))
                .build();

//STRAFE TRAJECTORY
//        trajectory1 = drive.actionBuilder(new Pose2d(-5.88, 32.23, Math.toRadians(90.00)))
//                .splineToConstantHeading(new Vector2d(-32.40, 34.38), Math.toRadians(175.35))
//                .build();
//        trajectory2 = drive.actionBuilder(new Pose2d(-32.40, 34.38, Math.toRadians(180.00)))
//                .splineToConstantHeading(new Vector2d(-32.23, 13.51), Math.toRadians(-89.55))
//                .splineToConstantHeading(new Vector2d(-40.49, 14.33), Math.toRadians(179.41))
//                .splineToConstantHeading(new Vector2d(-45.65, 40.52), Math.toRadians(90.00))
//                .splineToConstantHeading(new Vector2d(-46.48, 54.77), Math.toRadians(89.42))
//                .splineToConstantHeading(new Vector2d(-43.66, 13.51), Math.toRadians(269.35))
//                .splineToConstantHeading(new Vector2d(-49.46, 13.51), Math.toRadians(185.19))
//                .splineToConstantHeading(new Vector2d(-54.27, 27.42), Math.toRadians(95.64))
//                .splineToConstantHeading(new Vector2d(-55.43, 42.84), Math.toRadians(92.34))
//                .splineToConstantHeading(new Vector2d(-56.26, 54.10), Math.toRadians(92.86))
//                .splineToConstantHeading(new Vector2d(-51.62, 13.51), Math.toRadians(-89.59))
//                .splineToConstantHeading(new Vector2d(-57.56, 13.67), Math.toRadians(192.34))
//                .splineToConstantHeading(new Vector2d(-62.06, 34.22), Math.toRadians(96.86))
//                .splineToConstantHeading(new Vector2d(-61.23, 56.75), Math.toRadians(99.09))
//                .splineToConstantHeading(new Vector2d(-50.79, 44.99), Math.toRadians(-41.50))
//                .splineToConstantHeading(new Vector2d(-38.20, 43.50), Math.toRadians(-4.82))
//                .build();

        trajectory1 = drive.actionBuilder(new Pose2d(-6.26, 32.29, Math.toRadians(90.00)))
                .splineToConstantHeading(new Vector2d(-33.29, 33.29), Math.toRadians(174.44))
                .splineToConstantHeading(new Vector2d(-34.12, 14.43), Math.toRadians(255.13))
                .splineToConstantHeading(new Vector2d(-48.47, 14.10), Math.toRadians(180.00))
                .splineToConstantHeading(new Vector2d(-47.97, 25.78), Math.toRadians(94.18))
                .splineToConstantHeading(new Vector2d(-47.97, 37.13), Math.toRadians(90.00))
                .splineToConstantHeading(new Vector2d(-47.30, 48.64), Math.toRadians(86.68))
                .splineToConstantHeading(new Vector2d(-47.81, 52.14), Math.toRadians(95.71))
                .splineToConstantHeading(new Vector2d(-48.47, 13.27), Math.toRadians(269.16))
                .splineToConstantHeading(new Vector2d(-58.65, 13.10), Math.toRadians(191.98))
                .splineToConstantHeading(new Vector2d(-58.65, 27.95), Math.toRadians(90.00))
                .splineToConstantHeading(new Vector2d(-58.82, 40.13), Math.toRadians(93.87))
                .splineToConstantHeading(new Vector2d(-58.98, 53.31), Math.toRadians(80.54))
                .splineToConstantHeading(new Vector2d(-58.65, 14.27), Math.toRadians(269.59))
                .splineToConstantHeading(new Vector2d(-64.83, 13.77), Math.toRadians(186.34))
                .splineToConstantHeading(new Vector2d(-64.66, 31.29), Math.toRadians(99.73))
                .splineToConstantHeading(new Vector2d(-64.66, 42.97), Math.toRadians(87.61))
                .splineToConstantHeading(new Vector2d(-64.83, 55.98), Math.toRadians(93.32))
                .splineToConstantHeading(new Vector2d(-63.49, 32.62), Math.toRadians(-84.50))
                .splineToConstantHeading(new Vector2d(-41.13, 34.62), Math.toRadians(5.12))
                .build();




//wait for human player then close claw
//        trajectory1 = drive.actionBuilder(new Pose2d(-41.68, 63.38, Math.toRadians(87.21)))
//                .splineToConstantHeading(new Vector2d(-41.84, 42.01), Math.toRadians(269.64))
//                .splineToConstantHeading(new Vector2d(-15.33, 39.52), Math.toRadians(-5.36))
//                .splineToConstantHeading(new Vector2d(-7.37, 39.19), Math.toRadians(1.82))
//                .splineToConstantHeading(new Vector2d(-6.38, 32.23), Math.toRadians(-82.65))
//                .build();
//viper up then open claw
//        trajectory2 = drive.actionBuilder(new Pose2d(-6.38, 31.73, Math.toRadians(270.00)))
//                .splineToConstantHeading(new Vector2d(-12.84, 35.54), Math.toRadians(135.00))
//                .splineToConstantHeading(new Vector2d(-30.74, 45.49), Math.toRadians(150.95))
//                .splineToConstantHeading(new Vector2d(-41.51, 45.98), Math.toRadians(177.36))
//                .splineToConstantHeading(new Vector2d(-41.84, 63.71), Math.toRadians(91.07))
//                .build();


//        .splineToConstantHeading(new Vector2d(-40.18, 45.49), Math.toRadians(3.15))
        //wait for human player
//                .splineToConstantHeading(new Vector2d(-40.52, 63.05), Math.toRadians(88.65))
        //claw takes sample from the perimeter
//        .splineToConstantHeading(new Vector2d(-37.37, 50.46), Math.toRadians(-46.70))
//                .splineToConstantHeading(new Vector2d(-10.19, 41.01), Math.toRadians(-25.76))
//                .splineToConstantHeading(new Vector2d(-8.53, 32.23), Math.toRadians(-46.49))
        //claw places specimen on bar
//        .splineToConstantHeading(new Vector2d(-24.44, 43.50), Math.toRadians(144.41))
//                .splineToConstantHeading(new Vector2d(-40.85, 64.21), Math.toRadians(126.87))
        //wait for human player
//        .splineToConstantHeading(new Vector2d(-38.53, 46.81), Math.toRadians(-67.21))
//                .splineToConstantHeading(new Vector2d(-11.68, 42.67), Math.toRadians(-25.11))
//                .splineToConstantHeading(new Vector2d(-10.85, 32.23), Math.toRadians(-36.50))


        fataspate = drive.actionBuilder(new Pose2d(-36.04, 57.09, Math.toRadians(90.00)))
                .splineToConstantHeading(new Vector2d(-36.04, 13.67), Math.toRadians(270.00))
                .splineToConstantHeading(new Vector2d(-38.03, 56.75), Math.toRadians(90.24))
                .splineToConstantHeading(new Vector2d(-37.86, 13.67), Math.toRadians(268.84))
                .splineToConstantHeading(new Vector2d(-40.52, 56.75), Math.toRadians(93.52))
                .splineToConstantHeading(new Vector2d(-40.52, 13.51), Math.toRadians(-89.78))
                .splineToConstantHeading(new Vector2d(-43.66, 57.25), Math.toRadians(94.12))
                .splineToConstantHeading(new Vector2d(-43.66, 13.67), Math.toRadians(270.00))
                .build();
        

//        TrajectoryActionBuilder tab1 = drive.actionBuilder(initialPose)
//                .lineToYSplineHeading(33, Math.toRadians(0))
//                .waitSeconds(2)
//                .setTangent(Math.toRadians(90))
//                .lineToY(48)
//                .setTangent(Math.toRadians(0))
//                .lineToX(32)
//                .strafeTo(new Vector2d(44.5, 30))
//                .turn(Math.toRadians(180))
//                .lineToX(47.5)
//                .waitSeconds(3);
//        TrajectoryActionBuilder tab2 = drive.actionBuilder(initialPose)
//                .lineToY(37)
//                .setTangent(Math.toRadians(0))
//                .lineToX(18)
//                .waitSeconds(3)
//                .setTangent(Math.toRadians(0))
//                .lineToXSplineHeading(46, Math.toRadians(180))
//                .waitSeconds(3);
//        TrajectoryActionBuilder tab3 = drive.actionBuilder(initialPose)
//                .lineToYSplineHeading(33, Math.toRadians(180))
//                .waitSeconds(2)
//                .strafeTo(new Vector2d(46, 30))
//                .waitSeconds(3);
//        Action trajectoryActionCloseOut = tab1.endTrajectory().fresh()
//                .strafeTo(new Vector2d(48, 12))
//                .build();

        // actions that need to happen on init; for instance, a claw tightening.
        //Actions.runBlocking(claw.closeClaw());


        while (!isStopRequested() && !opModeIsActive()) { // Asta actioneaza ca un Init la Autonomie
//            //int position = visionOutputPosition;
            // telemetry.addData("Position during Init", position);
            telemetry.addData("Status", "Waiting in Init");
            telemetry.addData("Stop requested:", isStopRequested());
            telemetry.addData("Op mode: ", opModeIsActive());
            telemetry.update();
        }
//
        telemetry.addData("Status", "before actions");
        Actions.runBlocking(
                new SequentialAction(
                        //trajectory1,
                        new ParallelAction(
                        startToCage,
                        lift.liftUp()
                        ),
                        new SleepAction(2),
                        lift.liftDown(),
                        trajectory1
                        //fataspate
                        //new SleepAction(3),
                        //claw.openClaw(),
                        //lift.liftDown(),
                        // trajectoryAction2
//                        new SleepAction(3),
//                        lift.liftUp(),
//                        new SleepAction(2),
//                        lift.liftDown()
                        //trajectoryActionCloseOut
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


//
//startToCage = drive.actionBuilder(new Pose2d(-6.71, 30.51, Math.toRadians(90.0)))
//        .setReversed(true)
//                 .splineTo(new Vector2d(-6.71, 31.10), Math.toRadians(90.0))
//        .build();
//trajectory1 = drive.actionBuilder(new Pose2d(4.34, -70.27, Math.toRadians(89.67)))
//        .splineTo(new Vector2d(4.59, -26.89), Math.toRadians(89.67))
//        .build();
//
////
//        cageToSample1 = drive.actionBuilder(new Pose2d(-6.71, 30.51, Math.toRadians(90)))
//                .setReversed(true)
//                .splineTo(new Vector2d(-26.15, 33.90), Math.toRadians(160))
//                .setReversed(true)
//                .splineTo(new Vector2d(-40.36, 29.17), Math.toRadians(210))
//                .setReversed(true)
//                .splineTo(new Vector2d(-47.96, 12.27), Math.toRadians(180))
//                .build();
//
//        sampleToHuman = drive.actionBuilder(new Pose2d(-40.36, 29.17, Math.toRadians(0)))
//                .strafeTo(new Vector2d(-40.36, 64.07))
////                .splineTo(new Vector2d(-40.36, 64.07), Math.toRadians(0))
//                .build();
//
//        waitHuman = drive.actionBuilder(new Pose2d(-40.36, 64.07, Math.toRadians(0)))
//                .splineTo(new Vector2d(-27.64, 64.07), Math.toRadians(0))
//                .build();
//
//        humanToCage1 = drive.actionBuilder(new Pose2d(-49.18, 60.59, Math.toRadians(90.0)))
//                .splineTo(new Vector2d(-4.83, 31.85), Math.toRadians(270))
//
//                .build();
//
//        cageToSample2 = drive.actionBuilder(new Pose2d(-4.83, 31.85, Math.toRadians(270)))
//                .splineTo(new Vector2d(-26.15, 33.90), Math.toRadians(23.75))
//                .splineTo(new Vector2d(-40.36, 29.17), Math.toRadians(23.75))
//                .build();
//