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

        waitForStart();
        if (isStopRequested()) return;

        while(opModeIsActive()) {

            ChassyController.dcpMovement(gamepad1);

            telemetry.update();
        }
    }
}

