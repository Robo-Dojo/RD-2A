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
                intakeLeft.setPosition(0.48);
                intakeRight.setPosition(0.505);
                return false;
            }
        }
        public Action intakeArmOpen() {
            return new ClawControl.IntakeArmOpen();
        }


        public static class IntakeArmClose implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                intakeLeft.setPosition(0.54);
                intakeRight.setPosition(0.435);
                return false;
            }
        }
        public Action intakeArmClose() {
            return new ClawControl.IntakeArmClose();
        }


        public static class IntakeClawClose implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                clawServo.setPosition(0.6);
                return false;
            }
        }
        public Action intakeClawClose() {
            return new ClawControl.IntakeClawClose();
        }

        public static class IntakeClawOpen implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                clawServo.setPosition(0.35);
                return false;
            }
        }
        public Action intakeClawOpen() {
            return new ClawControl.IntakeClawOpen();
        }

        public static class IntakeClawTwistLeft implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                twisterServo.setPosition(0.48);
                return false;
            }
        }
        public Action intakeClawTwistLeft() {
            return new ClawControl.IntakeClawTwistLeft();
        }

        public static class IntakeClawTwistRight implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                twisterServo.setPosition(0.525);
                return false;
            }
        }
        public Action intakeClawTwistRight() {
            return new ClawControl.IntakeClawTwistRight();
        }

        public static class IntakeClawTwistMiddle implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                twisterServo.setPosition(0.5048);
                return false;
            }
        }
        public Action intakeClawTwistMiddle() {
            return new ClawControl.IntakeClawTwistMiddle();
        }

        public static class IntakeClawJointUp implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                clawServoJoint.setPosition(0.462);
                return false;
            }
        }
        public Action intakeClawJointUp() {
            return new ClawControl.IntakeClawJointUp();
        }

        public static class IntakeClawJointDown implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                clawServoJoint.setPosition(0.568);
                return false;
            }
        }
        public Action intakeClawJointDown() {
            return new ClawControl.IntakeClawJointDown();
        }

        public static class OuttakeClawOpen implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                clawServoOuttake.setPosition(0.4789);
                return false;
            }
        }
        public Action outtakeClawOpen() {
            return new ClawControl.OuttakeClawOpen();
        }

        public static class OuttakeClawClose implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                clawServoOuttake.setPosition(0.62);
                return false;
            }
        }
        public Action outtakeClawClose() {
            return new ClawControl.OuttakeClawClose();
        }


        public static class OuttakeClawPivotShortOpen implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                clawPivotShort.setPosition(0.79);
                return false;
            }
        }
        public Action outtakeClawPivotShortOpen() {
            return new ClawControl.OuttakeClawPivotShortOpen();
        }

        public static class OuttakeClawPivotShortClose implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                clawPivotShort.setPosition(0.53);
                return false;
            }
        }
        public Action outtakeClawPivotShortClose() {
            return new ClawControl.OuttakeClawPivotShortClose();
        }

        public static class OuttakeClawPivotLongOpen implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                clawPivotLong.setPosition(0.6);
                return false;
            }
        }
        public Action outtakeClawPivotLongOpen() {
            return new ClawControl.OuttakeClawPivotShortOpen();
        }

        public static class OuttakeClawPivotLongClose implements Action {
            @Override
            public boolean run(@NonNull TelemetryPacket packet){
                clawPivotLong.setPosition(0.528);
                return false;
            }
        }
        public Action outtakeClawPivotLongClose() {
            return new ClawControl.OuttakeClawPivotShortClose();
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
        Actions.runBlocking(claws.intakeClawClose());

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
                        new SleepAction(2),
                        lift.liftDown(),
                        trajectory0,
                        trajectory1
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
