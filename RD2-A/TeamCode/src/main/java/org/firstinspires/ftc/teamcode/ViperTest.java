package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp( name = "ViperTest" , group = "Tests" )
public class ViperTest extends LinearOpMode {
    DcMotor armLifterMotorLeft;
    DcMotor armLifterMotorRight;
    @Override
    public void runOpMode() throws InterruptedException {


         armLifterMotorLeft = hardwareMap.get(DcMotor.class , "ArmLifterLeft");
         armLifterMotorRight = hardwareMap.get(DcMotor.class , "ArmLifterRight");

         waitForStart();

         while(opModeIsActive()) {
             LiftArm();
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
