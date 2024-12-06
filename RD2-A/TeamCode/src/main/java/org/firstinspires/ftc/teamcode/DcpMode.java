package org.firstinspires.ftc.teamcode;
import org.firstinspires.ftc.teamcode.*;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class DcpMode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        HardwareInit rd1 = new HardwareInit();
        rd1.init(hardwareMap, false);

        org.firstinspires.ftc.teamcode.ChassyController ChassyController = new org.firstinspires.ftc.teamcode.ChassyController(rd1, telemetry);
        org.firstinspires.ftc.teamcode.ArmController ArmController = new org.firstinspires.ftc.teamcode.ArmController(rd1, telemetry);
        //org.firstinspires.ftc.teamcode.Test Test = new org.firstinspires.ftc.teamcode.Test(rd1, telemetry);
        //org.firstinspires.ftc.teamcode.IntakeClaw IntakeClaw = new org.firstinspires.ftc.teamcode.IntakeClaw(rd1, telemetry);
        org.firstinspires.ftc.teamcode.Intake1 Intake1 = new org.firstinspires.ftc.teamcode.Intake1(rd1, telemetry);

        waitForStart();
        if (isStopRequested()) return;

        while(opModeIsActive()) {

            ChassyController.dcpMovement(gamepad1);
            //ArmController.clawServo(gamepad2);
            ArmController.armLifter(gamepad2);
            Intake1.clawServo1(gamepad2);
            //ArmController.armHolder(gamepad2);
            Intake1.intake(gamepad2);
            Intake1.clawIntake(gamepad2);
            Intake1.clawOuttake(gamepad2);
            telemetry.update();
        }
    }
}

