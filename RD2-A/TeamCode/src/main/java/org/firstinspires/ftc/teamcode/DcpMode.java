package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class DcpMode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        HardwareInit rd1 = new HardwareInit();
        rd1.init(hardwareMap, false);

        Chassy Chassy = new Chassy(rd1, telemetry);
        Arm Arm = new Arm(rd1, telemetry);
        Intake Intake = new Intake(rd1, telemetry);
        Outtake Outtake = new Outtake(rd1, telemetry);
        waitForStart();
        if (isStopRequested()) return;

        while(opModeIsActive()) {
            Chassy.dcpMovement(gamepad1);
            //Arm.armLifter(gamepad1);
            //Arm.robotHanger(gamepad1);
            Intake.intakeController(gamepad2);
            Intake.clawServoController(gamepad2);
            Intake.twisterServoController(gamepad2);
            Intake.servoJointController(gamepad2);
            Intake.intakeClose(gamepad2);
            Outtake.clawOuttakeServoController(gamepad1);
            Outtake.clawPivotShortController(gamepad1);
            Outtake.clawPivotLongController(gamepad1);
            //Outtake.outtakeController(gamepad1);
            telemetry.update();
        }
    }
}
