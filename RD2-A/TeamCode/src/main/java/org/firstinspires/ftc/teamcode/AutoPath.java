//package org.firstinspires.ftc.teamcode;
//
//import android.util.Size;
//
//import androidx.annotation.NonNull;
//
//import com.acmerobotics.dashboard.config.Config;
//import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
//import com.acmerobotics.roadrunner.Action;
//import com.acmerobotics.roadrunner.ParallelAction;
//import com.acmerobotics.roadrunner.Pose2d;
//import com.acmerobotics.roadrunner.SequentialAction;
//import com.acmerobotics.roadrunner.SleepAction;
//import com.acmerobotics.roadrunner.Vector2d;
//import com.acmerobotics.roadrunner.ftc.Actions;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorEx;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//import com.qualcomm.robotcore.hardware.Servo;
//
////import org.checkerframework.checker.units.qual.C;
//import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
//import org.firstinspires.ftc.vision.VisionPortal;
//
//@Config
//@Autonomous(name = "AutoBlueShort", group = "Autonomous")
//public class AutoPath extends LinearOpMode {
//    //private VisionPortal visionPortal;
//
//
//    public static class Lift {
//        private static DcMotorEx lift;
//
//        public Lift(HardwareMap hardwareMap) {
//            lift = hardwareMap.get(DcMotorEx.class, "armLifter");
//            lift.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//            lift.setDirection(DcMotor.Direction.FORWARD);
//        }
//
//        public static class LiftUp implements Action {
//            private boolean initialized = false;
//
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                if (!initialized) {
//                    lift.setPower(0.8);
//                    initialized = true;
//                }
//
//                double pos = lift.getCurrentPosition();
//                packet.put("liftPos", pos);
//                if (pos < 1500.0) {
//                    return true;
//                } else {
//                    lift.setPower(0);
//                    return false;
//                }
//            }
//        }
//        public Action liftUp() {
//            return new LiftUp();
//        }
//
//        public static class LiftDown implements Action {
//            private boolean initialized = false;
//
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                if (!initialized) {
//                    lift.setPower(-0.8);
//                    initialized = true;
//                }
//
//                double pos = lift.getCurrentPosition();
//                packet.put("liftPos", pos);
//                if (pos > 0.0) {
//                    return true;
//                } else {
//                    lift.setPower(0);
//                    return false;
//                }
//            }
//        }
//        public Action liftDown(){
//            return new LiftDown();
//        }
//    }
//
//
//
//                return false;
//            }
//        }
//        public Action closeClaw() {
//            return new CloseClaw();
//        }
//
//
//        public static class OpenClaw implements Action {
//
//            static final double OPENED_POSITION = 0.89;
//            private boolean initialized = false;
//
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//
//                if(!initialized) {
//                    claw.setPosition(OPENED_POSITION);
//                    initialized = true;
//                }
//
//                if(claw.getPosition() < OPENED_POSITION) {
//                    return true;
//                }
//
//                return false;
//            }
//        }
//        public Action openClaw() {
//            return new OpenClaw();
//        }
//    }
//
//    public static class PixelGrabber {
//        private static DcMotorEx pixelGrabber;
//
//        public PixelGrabber(HardwareMap hardwareMap) {
//            pixelGrabber = hardwareMap.get(DcMotorEx.class, "pixelGrabber");
//            pixelGrabber.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//            pixelGrabber.setDirection(DcMotor.Direction.FORWARD);
//        }
//
//        public static class intake implements Action {
//
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                pixelGrabber.setPower(0.6);
//                return false;
//            }
//
//
//        }
//
//        public Action Intake() {
//            return new intake();
//        }
//
//
//        public static class outtake implements Action {
//            private boolean initialized = false;
//
//            @Override
//            public boolean run(@NonNull TelemetryPacket packet) {
//                pixelGrabber.setPower(-0.6);
//                return false;
//            }
//
//
//        }
//
//        public Action Outtake() {
//            return new outtake();
//        }
//    }
//
//    @Override
//    public void runOpMode() {
////        visionProcessor = new CameraProcessor();
////        try {
////            visionPortal = new VisionPortal.Builder()
////                    .setCamera(hardwareMap.get(WebcamName.class, "Webcam"))
////                    .addProcessor(visionProcessor)
////                    .setCameraResolution(new Size(800, 600))
////                    .enableLiveView(true)
////                    .setAutoStopLiveView(true)
////                    .build();
////        } catch (Exception e) {
////        }
////        MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(12, 60, Math.toRadians(270)));
////        Claw claw = new Claw(hardwareMap);
////        Lift lift = new Lift(hardwareMap);
//       // PixelGrabber pixelGrabber = new PixelGrabber(hardwareMap);
//
////        Action trajectoryAction1;
////        Action takingPixels1;
////        Action returningToBackBoard1;
////        Action parking1;
////
////        Action trajectoryAction2;
////        Action takingPixels2;
////        Action returningToBackBoard2;
////        Action parking2;
////
////        Action trajectoryAction3;
////        Action takingPixels3;
////        Action returningToBackBoard3;
////        Action parking3;
//        Action trajectory0;
//
//        // BlueShort1
////        trajectoryAction1 = drive.actionBuilder(drive.pose)
////                .splineTo(new Vector2d(18.68, 35.38), Math.toRadians(318.30))
////                .setReversed(true)
////                .splineTo(new Vector2d(12.00, 56.00), Math.toRadians(90.00))
////                .setReversed(false)
////                .splineTo(new Vector2d(52.00, 42.00), Math.toRadians(360.00))
////                .build();
////
////
////        takingPixels1 = drive.actionBuilder(new Pose2d(52.00,42.00,Math.toRadians(360.00)))
////                .setReversed(true)
////                .splineTo(new Vector2d(24.00, 12.00), Math.toRadians(180.00))
////                .splineTo(new Vector2d(-61.00, 12.00), Math.toRadians(180.00))
////                .build();
////
////
////        returningToBackBoard1 = drive.actionBuilder(new Pose2d(-61.00,-12.00, Math.toRadians(180.00)))
////                .setReversed(true)
////                .splineTo(new Vector2d(23.66, 11.65), Math.toRadians(0.30))
////                .splineTo(new Vector2d(51.00, 42.00), Math.toRadians(0.00))
////                .build();
////
////
////        parking1 = drive.actionBuilder(new Pose2d(52.00,42.00,Math.toRadians(0.00)))
////                .setReversed(true)
////                .splineTo(new Vector2d(29.66, 53.10), Math.toRadians(83.66))
////                .splineTo(new Vector2d(58.67, 61.60), Math.toRadians(3.47))
////                .build();
//
//
//        trajectory0 = drive.trajectorySequenceBuilder(new Pose2d(-69.77, 35.44, Math.toRadians(-2.33)))
//                .splineTo(new Vector2d(-34.83, 34.02), Math.toRadians(-2.33))
//                .splineTo(new Vector2d(-31.38, 59.81), Math.toRadians(82.38))
//                .build();
//
//
//
//
//
//        // RedShort2
////        trajectoryAction2 = drive.actionBuilder(drive.pose)
////                .splineTo(new Vector2d(12.00, 27.00), Math.toRadians(270.00))
////                .setReversed(true)
////                .splineTo(new Vector2d(12.00, 55.00), Math.toRadians(90.00))
////                .setReversed(false)
////                .splineTo(new Vector2d(52.00, 36.00), Math.toRadians(360.00))
////                .build();
////
////
////
////        takingPixels2 = drive.actionBuilder(new Pose2d(52.00,36.00,Math.toRadians(360.00)))
////                .setReversed(true)
////                .splineTo(new Vector2d(23.66, 12.67), Math.toRadians(179.64))
////                .splineTo(new Vector2d(-61.00, 12.00), Math.toRadians(180.00))
////                .build();
////
////
////        returningToBackBoard2 = drive.actionBuilder(new Pose2d(-61.00,12.00, Math.toRadians(180.00)))
////                .setReversed(true)
////                .splineTo(new Vector2d(24.10, 12.23), Math.toRadians(0.00))
////                .splineTo(new Vector2d(52.00, 36.00), Math.toRadians(0.00))
////                .build();
////
////
////        parking2 = drive.actionBuilder(new Pose2d(52.00,36.00,Math.toRadians(0.00)))
////                .setReversed(true)
////                .splineTo(new Vector2d(29.66, 53.10), Math.toRadians(83.66))
////                .splineTo(new Vector2d(58.67, 61.60), Math.toRadians(3.47))
////                .build();
////
////
////        //RedShort3
////        trajectoryAction3 = drive.actionBuilder(drive.pose)
////                .splineTo(new Vector2d(2.00, 33.00), Math.toRadians(217.97))
////                .setReversed(true)
////                .splineTo(new Vector2d(11.79, 55.00), Math.toRadians(92.12))
////                .setReversed(false)
////                .splineTo(new Vector2d(52.00, 30.00), Math.toRadians(360.00))
////                .build();
////
////
////        takingPixels3 = drive.actionBuilder(new Pose2d(52.00,30.00 , Math.toRadians(360.00)))
////                .setReversed(true)
////                .splineTo(new Vector2d(23.80, 11.35), Math.toRadians(185.30))
////                .splineTo(new Vector2d(-61.00, 12.00), Math.toRadians(180.00))
////                .build();
////
////
////
////        returningToBackBoard3 = drive.actionBuilder(new Pose2d(-61.00,12.00 , Math.toRadians(180.00)))
////                .splineTo(new Vector2d(24.00, -12.00), Math.toRadians(0.00))
////                .splineTo(new Vector2d(52.00, -36.00), Math.toRadians(0.00))
////                .build();
////
////
////        parking3 = drive.actionBuilder(new Pose2d(52.00,-36.00, Math.toRadians(0.00)))
////                .setReversed(true)
////                .splineTo(new Vector2d(29.66, 53.10), Math.toRadians(83.66))
////                .splineTo(new Vector2d(58.67, 61.60), Math.toRadians(3.47))
////                .build();
//
//
//        // actions that need to happen on init; for instance, a claw tightening.
//        //Actions.runBlocking(claw.openClaw());
//
//        while (!isStopRequested() && !opModeIsActive()) {
//
//            // vision here that outputs position
////            visionOutputPosition = visionProcessor.getSelection();
////            telemetry.addData("Detected:", visionOutputPosition);
////            CameraProcessor.Selected position = visionOutputPosition;
//            telemetry.addData("Position during Init", position);
//            telemetry.update();
//
//        }
//
//        visionPortal.stopStreaming();
//
//        CameraProcessor.Selected startPosition = visionOutputPosition;
//        telemetry.addData("Starting Position", startPosition);
//        telemetry.update();
//        waitForStart();
//
//        if (isStopRequested()) return;
//
////        Action trajectoryActionChosen;
////        Action takingPixelsChosen;
////        Action returningToBackBoardChosen;
////        Action parkingChosen;
//        Action trajectory0;
//
//
//
//        // Trebuie testati timpii!!
//        Actions.runBlocking(
//                new SequentialAction(
//                        trajectoryActionChosen,
//                        lift.liftUp(),
//                        new SleepAction(1),
//                        claw.closeClaw(),
//                        new SleepAction(1),
//                        claw.openClaw(),
//                        new SleepAction(1.5),
//                        lift.liftDown(),
////                        new ParallelAction(
////                                takingPixelsChosen,
////                                new SequentialAction(
////                                        new SleepAction(3),
////                                        pixelGrabber.Intake(),
////                                        new SleepAction(5)
////                                )
////                        ),
////                        new ParallelAction(
////                                returningToBackBoardChosen,
////                                pixelGrabber.Outtake()
////                        ),
//                        // lift.liftUp(),
////                        new SleepAction(0.5),
////                        claw.closeClaw(),
////                        new SleepAction(0.5),
////                        claw.openClaw(),
////                        new SleepAction(1.5),
//                        //lift.liftDown(),
//                        parkingChosen
//                )
//
//        );
//    }
//}
