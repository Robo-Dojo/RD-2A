package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class DcpMode extends LinearOpMode {


    // Viper functional
    @Override
    public void runOpMode() throws InterruptedException {
        HardwareInit rd1 = new HardwareInit();
        rd1.init(hardwareMap, false);

        ChassyController ChassyController = new ChassyController(rd1, telemetry);
        //Intake Intake = new Intake(rd1, telemetry);
        org.firstinspires.ftc.teamcode.ArmController ArmController = new org.firstinspires.ftc.teamcode.ArmController(rd1, telemetry);

        waitForStart();
        if (isStopRequested()) return;

        while(opModeIsActive()) {

            ChassyController.dcpMovement(gamepad1);
            // ArmController omora bateria

//            Intake.clawServo1(gamepad2);
//            Intake.clawServo2(gamepad2);
//
//            Intake.clawIntake(gamepad2);
//            Intake.clawOuttake(gamepad2);

            ArmController.armLifter(gamepad1);
            telemetry.update();
        }
    }


//    public void viperMovement() {
//        if(gamepad2.right_trigger > 0.1) {
//            armLifterMotorLeft.setPower(1);
//            armLifterMotorRight.setPower(-1);
//        }
//        else if(gamepad2.left_trigger > 0.1) {
//            armLifterMotorLeft.setPower(-1);
//            armLifterMotorRight.setPower(1);
//        }
//        else {
//            armLifterMotorRight.setPower(0);
//            armLifterMotorLeft.setPower(0);
//        }
//    }
}
