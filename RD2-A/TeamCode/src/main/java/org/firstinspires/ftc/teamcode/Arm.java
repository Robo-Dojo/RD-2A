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
    public void robotHanger(Gamepad _gamepad2) {
        // telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
        // telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
        // telemetry.update();
        if (_gamepad2.dpad_down && _gamepad2.start) {
            rd1.armLifterMotorLeft.setTargetPosition(2100);
            rd1.armLifterMotorRight.setTargetPosition(-2100);
            rd1.armLifterMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rd1.armLifterMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rd1.armLifterMotorLeft.setPower(-1);
            rd1.armLifterMotorRight.setPower(1);

        } else
            if (_gamepad2.start) {
            rd1.armLifterMotorLeft.setTargetPosition(1900);
            rd1.armLifterMotorRight.setTargetPosition(-1900);
            rd1.armLifterMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rd1.armLifterMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rd1.armLifterMotorLeft.setPower(1);
            rd1.armLifterMotorRight.setPower(-1);
        }
    }

    public void armLifter(Gamepad _gamepad2) {
         telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
         telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
         telemetry.update();
         rd1.armLifterMotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rd1.armLifterMotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        if (_gamepad2.right_trigger>0) {
            rd1.armLifterMotorLeft.setTargetPosition(4200);
            rd1.armLifterMotorRight.setTargetPosition(-4200);
            rd1.armLifterMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rd1.armLifterMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rd1.armLifterMotorLeft.setPower(1);
            rd1.armLifterMotorRight.setPower(-1);
        } else if (_gamepad2.left_trigger>0) {
            rd1.armLifterMotorLeft.setTargetPosition(20);
            rd1.armLifterMotorRight.setTargetPosition(-20);
            rd1.armLifterMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rd1.armLifterMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rd1.armLifterMotorLeft.setPower(-1);
            rd1.armLifterMotorRight.setPower(1);
        }
        if(rd1.armLifterMotorLeft.getCurrentPosition()<=20 && rd1.armLifterMotorRight.getCurrentPosition()>=-20){
            rd1.armLifterMotorLeft.setPower(0);
            rd1.armLifterMotorRight.setPower(0);
        }
    }
}
