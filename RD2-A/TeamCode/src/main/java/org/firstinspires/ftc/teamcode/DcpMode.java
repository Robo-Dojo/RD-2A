package org.firstinspires.ftc.teamcode;
import org.firstinspires.ftc.teamcode.*;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class DcpMode extends LinearOpMode {

    DcMotor armLifterMotorLeft;
    DcMotor armLifterMotorRight;

    // Viper functional
    @Override
    public void runOpMode() throws InterruptedException {
        HardwareInit rd1 = new HardwareInit();
        rd1.init(hardwareMap, false);

        // init viper motors
        armLifterMotorLeft = hardwareMap.get(DcMotor.class , "armLifterLeft");
        armLifterMotorRight = hardwareMap.get(DcMotor.class , "armLifterRight");

        ChassyController ChassyController = new ChassyController(rd1, telemetry);
        ViperTest LiftArm = new ViperTest();
        //org.firstinspires.ftc.teamcode.Test Test = new org.firstinspires.ftc.teamcode.Test(rd1, telemetry);
        //org.firstinspires.ftc.teamcode.IntakeClaw IntakeClaw = new org.firstinspires.ftc.teamcode.IntakeClaw(rd1, telemetry);
        Intake1 Intake1 = new Intake1(rd1, telemetry);

        waitForStart();
        if (isStopRequested()) return;

        while(opModeIsActive()) {

            ChassyController.dcpMovement(gamepad1);
            // ArmController omora bateria
            // ArmController.armSample(gamepad2);
            //LiftArm();
            //Intake1.clawServo1(gamepad2);
            //Intake1.clawServo2(gamepad2);
            //ArmController.armHolder(gamepad2);
            //Intake1.intake(gamepad2);
            //Intake1.clawIntake(gamepad2);
            //Intake1.clawOuttake(gamepad2);
            telemetry.update();
        }
    }

    public void LiftArm() {
        while(opModeIsActive()) {
            if(gamepad2.right_trigger > 0.1) {
                armLifterMotorLeft.setPower(1);
                armLifterMotorRight.setPower(-1);
            }
            else if(gamepad2.left_trigger > 0.1) {
                armLifterMotorLeft.setPower(-1);
                armLifterMotorRight.setPower(1);
            }
            else {
                armLifterMotorRight.setPower(0);
                armLifterMotorLeft.setPower(0);
            }
        }
    }
}

