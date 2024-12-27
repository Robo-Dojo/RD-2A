package org.firstinspires.ftc.teamcode;
import androidx.annotation.NonNull;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
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
@Autonomous(name = "AutoPath", group = "Autonomous")
public class AutoPath extends LinearOpMode {
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
//
//        Action trajectory1;
//        Action trajectoryAction2;
        Action startToCage;
        TrajectoryActionBuilder cageToSample1;
        Action cageToSample2;
        Action cageToSample3;

        telemetry.addData("Status", "innit completed");
        waitForStart();
        telemetry.addData("Status", "after wait start");
//        trajectory1 = drive.actionBuilder(new Pose2d(4.34, -70.27, Math.toRadians(89.67)))
//        .splineTo(new Vector2d(4.59, -26.89), Math.toRadians(89.67))
//        .build();

//        trajectoryAction2 = drive.actionBuilder(new Pose2d(-6.14, 27.00, Math.toRadians(269.20)))
//                .splineTo(new Vector2d(-22.28, 33.41), Math.toRadians(183.04))
//                .splineTo(new Vector2d(-46.34, 33.61), Math.toRadians(196.73))
//                .build();

startToCage = drive.actionBuilder(new Pose2d(-6.32, 64.32, Math.toRadians(90.00)))
        .lineToY(33.30)
        .build();

        cageToSample1 = drive.actionBuilder(new Pose2d(-6.32, 33.30, Math.toRadians(90.00)))
                .splineTo(new Vector2d(-28.09, 31.73), Math.toRadians(210.07))
                .splineTo(new Vector2d(-48.47, 12.68), Math.toRadians(92.05))
                .splineTo(new Vector2d(-48.80, 53.61), Math.toRadians(92.07))
                .lineToY(12.51);


        cageToSample2 = drive.actionBuilder(new Pose2d(-48.80, 12.51, Math.toRadians(92.07)))
                .strafeTo(new Vector2d(-59.07, 12.51))
                .build();
                System.out.println("okpdasoiksfdsokpsfdoksfdoikfdoikfdoizfdoijfdoifdjoifdomnkjokoklkoloololoslcfsloffdgdeddfhgdfhgnrewldgrdrdhgfdregdbfd");
        cageToSample3 =  drive.actionBuilder(new Pose2d(-59.07, 12.51, Math.toRadians(92.07)))
                .turnTo(Math.toRadians(92.07))
                .setReversed(true)
                .splineTo(new Vector2d(-59.07, 53.77), Math.toRadians(92.07))
//                .lineToY(12.51)

                .build();

//        cageToSample3 = drive.actionBuilder(new Pose2d(-59.07, 12.51, Math.toRadians(92.07)))
//                .strafeTo(new Vector2d(-64.54, 12.51))
//                .turnTo(Math.toRadians(92.07))
//                .splineTo(new Vector2d(-64.54, 54.60), Math.toRadians(90.00))
//
//                .build();

//        trajectoryAction2 = drive.actionBuilder(new Pose2d(-7.62, 30.36, Math.toRadians(270.00)))
//                .splineTo(new Vector2d(-7.62, 30.36), Math.toRadians(270.00))
//                .build();


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
                        startToCage,
                        lift.liftUp(),
                        new SleepAction(2),
                        lift.liftDown(),
                        cageToSample1.build(),
                        cageToSample2,
                        cageToSample3
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