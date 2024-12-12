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
                packet.put("liftPosL", posL);
                packet.put("liftPosR", posR);
                if (posL < 2000.0 && posR > -2000.0) {
                    return true;
                } else {
                    liftLeft.setPower(1);
                    liftRight.setPower(1);
                    return false;
                }
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
                    liftLeft.setPower(-1);
                    liftRight.setPower(-1);
                    initialized = true;
                }

                double posL = liftLeft.getCurrentPosition();
                double posR = liftRight.getCurrentPosition();
                packet.put("liftPosL", posL);
                packet.put("liftPosR", posR);
                telemetry.addData("liftPosL_Down", posL);
                telemetry.addData("liftPosR_Down", posR);
                telemetry.update();
//                if (posL < -70.00 && posR > 70.0) {
                if (posL > 300.00 && posR < -300.0) {
                    return true;
                } else {
                    liftLeft.setPower(0);
                    liftRight.setPower(0);
                    return false;
                }
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
        Pose2d initialPose = new Pose2d(-5.52, 70.98, Math.toRadians(-86.63));



        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        //Claw claw = new Claw(hardwareMap);
        Lift lift = new Lift(hardwareMap, telemetry);

        // vision here that outputs position
       // int visionOutputPosition = 1;

        Action trajectoryAction1;
        Action trajectoryAction2;

//         trajectoryAction1 = drive.actionBuilder(new Pose2d(-5.52, 70.98, Math.toRadians(-86.63)))
//                 .splineTo(new Vector2d(-6.14, 27.00), Math.toRadians(269.20))
//                 .build();




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
            //int position = visionOutputPosition;
           // telemetry.addData("Position during Init", position);
            telemetry.addData("Status", "Waiting in Init");
            telemetry.update();
        }

        telemetry.addData("Status", "Started");
        telemetry.update();

        //int startPosition = visionOutputPosition;
        //telemetry.addData("Starting Position", startPosition);
        telemetry.update();
        waitForStart();

        if (isStopRequested()) return;

        Actions.runBlocking(
                new SequentialAction(
//                        //trajectoryAction1,
                        lift.liftUp(),
                        new SleepAction(2),
                        //claw.openClaw(),
                        //trajectoryAction2,
                        lift.liftDown(),
                        new SleepAction(3),
                        lift.liftUp(),
                        new SleepAction(2),
                        lift.liftDown()
                        //trajectoryActionCloseOut
                )
        );

        while(opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.addData("liftPosL_Down", Lift.liftLeft.getCurrentPosition());
            telemetry.addData("liftPosR_Down", Lift.liftRight.getCurrentPosition());
            telemetry.update();
        }
    }
}
