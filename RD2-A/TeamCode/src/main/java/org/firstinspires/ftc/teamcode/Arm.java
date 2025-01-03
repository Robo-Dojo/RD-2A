//region imports
        package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.HardwareInit;
//endregion

// the class that controls the entire robot arm
public class Arm {
    private HardwareInit rd1;
    private Telemetry telemetry;

    public Arm(HardwareInit rd1, Telemetry telemetry) {
        this.rd1 = rd1;
        this.telemetry = telemetry;
    }

    // lvl 2 ascending
    public void robotHanger(Gamepad _gamepad1) {
        // telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
        // telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
        // telemetry.update();
//        if (_gamepad1.dpad_down) {
//            //0.505
//            rd1.intakeLeft.setPosition(0.498);
//            //0.48
//            rd1.intakeRight.setPosition(0.493);
//            rd1.clawServoJoint.setPosition(0.468);
//            rd1.clawPivotShort.setPosition(0.76);
//            rd1.clawPivotLong.setPosition(0.5085);
//            rd1.armLifterMotorLeft.setTargetPosition(500);
//            rd1.armLifterMotorRight.setTargetPosition(-500);
//            rd1.armLifterMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            rd1.armLifterMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            rd1.armLifterMotorLeft.setPower(-0.8);
//            rd1.armLifterMotorRight.setPower(0.8);

        //} else
            if (_gamepad1.dpad_up) {
            rd1.intakeLeft.setPosition(0.498);
            rd1.intakeRight.setPosition(0.493);
            rd1.clawServoJoint.setPosition(0.468);
            rd1.clawPivotShort.setPosition(0.76);
            rd1.clawPivotLong.setPosition(0.5085);
            rd1.armLifterMotorLeft.setTargetPosition(2400);
            rd1.armLifterMotorRight.setTargetPosition(-2400);
            rd1.armLifterMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rd1.armLifterMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rd1.armLifterMotorLeft.setPower(1);
            rd1.armLifterMotorRight.setPower(-1);
        }
    }

    public void armLifter(Gamepad _gamepad1) {
         telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
         telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
         telemetry.update();
         rd1.armLifterMotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rd1.armLifterMotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        if (_gamepad1.right_bumper) {
            rd1.armLifterMotorLeft.setTargetPosition(4169);
            rd1.armLifterMotorRight.setTargetPosition(-4169);
            rd1.armLifterMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rd1.armLifterMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rd1.armLifterMotorLeft.setPower(1);
            rd1.armLifterMotorRight.setPower(-1);
        } else if (_gamepad1.left_bumper) {
            rd1.armLifterMotorLeft.setTargetPosition(50);
            rd1.armLifterMotorRight.setTargetPosition(-50);
            rd1.armLifterMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rd1.armLifterMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rd1.armLifterMotorLeft.setPower(-1);
            rd1.armLifterMotorRight.setPower(1);
        }
        if(rd1.armLifterMotorLeft.getCurrentPosition()<=50 && rd1.armLifterMotorRight.getCurrentPosition()>=-50){
            rd1.armLifterMotorLeft.setPower(0);
            rd1.armLifterMotorRight.setPower(0);
        }
    }
}
