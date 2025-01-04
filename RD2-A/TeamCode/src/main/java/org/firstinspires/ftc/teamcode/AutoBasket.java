package org.firstinspires.ftc.teamcode;
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

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.opencv.core.Mat;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

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

                liftLeft.setTargetPosition(-4169);
                liftRight.setTargetPosition(-4169);
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
                clawServoJoint.setPosition(0.562);
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
                clawPivotShort.setPosition(0.52);
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
                clawPivotShort.setPosition(0.77);
                return false;
            }
        }
        public Action outtakeClawPivotShortClose() {
            return new OuttakeClawPivotShortClose();
        }

        public static class OuttakeClawPivotLongOpen implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                clawPivotLong.setPosition(0.62);
                return false;
            }
        }
        public Action outtakeClawPivotLongOpen() {
            return new OuttakeClawPivotLongOpen();
        }

        public static class OuttakeClawPivotLongClose implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                clawPivotLong.setPosition(0.555);
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
        Pose2d initialPose = new Pose2d(7.16, 61.46, Math.toRadians(90));
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
        Action trajectory0;
        Action trajectory1;
        Action trajectory2;
        Action trajectory3;
        Action trajectory4;
        Action trajectory5;

        startToCage = drive.actionBuilder(new Pose2d(7.16, 61.46, Math.toRadians(90.00)))
                .splineToConstantHeading(new Vector2d(7.16, 33), Math.toRadians(270.00))
                .build();
        trajectory0 = drive.actionBuilder(new Pose2d(7.16, 33, Math.toRadians(90.00)))
                .splineToConstantHeading(new Vector2d(7.16, 32.5), Math.toRadians(270.00))
                .build();
        trajectory1 = drive.actionBuilder(new Pose2d(7.16, 32.5, Math.toRadians(90.00)))
                .splineToConstantHeading(new Vector2d(7.16, 38), Math.toRadians(270.00))
                .build();
        trajectory2 = drive.actionBuilder(new Pose2d(7.21, 38.20, Math.toRadians(90.00)))
                .splineToSplineHeading(new Pose2d(32.40, 42.84, Math.toRadians(270.00)), Math.toRadians(10.44))
                .splineToSplineHeading(new Pose2d(48.47, 48.2, Math.toRadians(270.00)), Math.toRadians(7.35))
                .build();
        trajectory3 = drive.actionBuilder(new Pose2d(48.47, 48.2, Math.toRadians(270.00)))
                .splineToSplineHeading(new Pose2d(57.58, 55.93, Math.toRadians(231.34)), Math.toRadians(231.34))
                .build();
        trajectory4 = drive.actionBuilder(new Pose2d(57.58, 55.93, Math.toRadians(231.34)))
                .splineToSplineHeading(new Pose2d(53.77, 51.12, Math.toRadians(231.34)), Math.toRadians(103.03))
                .build();
        trajectory5 = drive.actionBuilder(new Pose2d(53.77, 51.29, Math.toRadians(231.34)))
                .splineToSplineHeading(new Pose2d(58, 47.48, Math.toRadians(270.00)), Math.toRadians(-55.56))
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
                        new SleepAction(0.2),
                        new ParallelAction(
                                claws.outtakeClawPivotLongOpen(),
                                claws.outtakeClawPivotShortClose()
                        ),
                        new SleepAction(0.2),
                        new ParallelAction(
                                lift.liftDownMid(),
                                new SequentialAction(
                                trajectory0,
                                new SleepAction(0.5),
                                claws.outtakeClawOpen(),
                                new SleepAction(0.3),
                                claws.outtakeClawClose(),
                                claws.outtakeClawPivotShortClose(),
                                claws.outtakeClawPivotLongClose(),
                                new SleepAction(0.1),
                                claws.outtakeClawOpen()
                                )
                        ),
                        trajectory1,
                        lift.liftDown(),
                        trajectory2,
                        //trajectory3,
                        claws.intakeArmOpen(),
                        new SleepAction(1),
                        claws.intakeClawJointDown(),
                        new SleepAction(0.9),
                        claws.intakeClawClose(),
                        new SleepAction(1),
                        claws.intakeClawJointUp(),
                        claws.intakeArmClose(),
                        new SleepAction(1),
                        new ParallelAction(
                                claws.outtakeClawClose(),
                                claws.intakeClawOpen()
//                        new SequentialAction(
//                                new SleepAction(1),
//                        claws.outtakeClawPivotLongOpen(),
//                        claws.outtakeClawPivotShortClose()
//                        )
                        ),
                        new ParallelAction(
                        trajectory3,

                        lift.liftUpBasket()
                        ),
                        new SleepAction(0.2),
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
                        trajectory4,
                        lift.liftDown(),

                        new SleepAction(0.5),
                        trajectory5,
                        new SleepAction(0.3),
                        claws.intakeArmOpen(),
                        new SleepAction(1),
                        claws.intakeClawJointDown(),
                        new SleepAction(0.9),
                        claws.intakeClawClose(),
                        new SleepAction(1),
                        claws.intakeClawJointUp(),
                        claws.intakeArmClose(),
                        new SleepAction(1),
                        new ParallelAction(
                                claws.outtakeClawClose(),
                                claws.intakeClawOpen()
                        )

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
