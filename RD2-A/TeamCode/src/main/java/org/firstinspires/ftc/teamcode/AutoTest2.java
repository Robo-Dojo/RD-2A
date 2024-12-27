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
@Autonomous(name = "AutoTest2", group = "Autonomous")
public class AutoTest2 extends LinearOpMode {
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

    public class Intake {
        private Servo intakeLeft;
        private Servo intakeRight;

        public Intake(HardwareMap hardwareMap) {
            intakeLeft = hardwareMap.get(Servo.class, "intakeLeft");
            intakeRight = hardwareMap.get(Servo.class, "intakeRight");
        }

        public class CloseIntake implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                intakeLeft.setPosition(0.48);
                intakeLeft.setPosition(0.505);
                return false;
            }
        }
        public Action closeIntake() {
            return new CloseIntake();
        }

        public class OpenIntake implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                intakeLeft.setPosition(0.54);
                intakeRight.setPosition(0.435);
                return false;
            }
        }
        public Action openIntake() {
            return new OpenIntake();
        }
    }

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Run op mode start");
        Pose2d initialPose = new Pose2d(-6.32, 64.32, Math.toRadians(90));
//
//
//
        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        Intake intake = new Intake(hardwareMap);
        Lift lift = new Lift(hardwareMap, telemetry);
//
//        // vision here that outputs position
//       // int visionOutputPosition = 1;


        Action trajectory0;
        Action trajectory1;
        Action trajectory2;
        Action startToCage;

        startToCage = drive.actionBuilder(new Pose2d(7.16, 61.46, Math.toRadians(90.00)))
                .splineToConstantHeading(new Vector2d(7.16, 32.02), Math.toRadians(270.00))
                .build();
        trajectory0 = drive.actionBuilder(new Pose2d(6.88, 32.06, Math.toRadians(90.00)))
                .splineToConstantHeading(new Vector2d(26.60, 40.52), Math.toRadians(31.17))
                .build();
        trajectory1 = drive.actionBuilder(new Pose2d(26.60, 41.01, Math.toRadians(270.00)))
                .splineToConstantHeading(new Vector2d(46.98, 40.18), Math.toRadians(-14.24))
                .build();



        telemetry.addData("Status", "innit completed");
        waitForStart();
        telemetry.addData("Status", "after wait start");


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
                        trajectory0,
                        trajectory1,
                        intake.openIntake()
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