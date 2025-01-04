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
            Arm.armLifter(gamepad2);
            Arm.robotHanger(gamepad2);
            Intake.intakeController(gamepad1);
            Intake.clawServoController(gamepad1);
            Intake.twisterServoController(gamepad1);
            Intake.servoJointController(gamepad1);
            Intake.intakeClose(gamepad1);
            Outtake.clawOuttakeServoController(gamepad2);
            Outtake.clawPivotShortController(gamepad2);
            Outtake.clawPivotLongController(gamepad2);
            Outtake.outtakeFromIntakeController(gamepad2);
            Outtake.outtakeCloseController(gamepad2);
            Outtake.outtakeSpecimenController(gamepad2);
            telemetry.update();
        }
    }
}
