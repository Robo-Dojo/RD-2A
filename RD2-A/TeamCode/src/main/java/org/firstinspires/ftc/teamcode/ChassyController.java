package org.firstinspires.ftc.teamcode;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.HardwareInit;


public class ChassyController {
    private HardwareInit rd1;
    private Telemetry telemetry;

    int frontRightTarget = 0;
    int frontLeftTarget = 0;
    int rearLeftTarget = 0;
    int readRightTarget = 0;

    public ChassyController(HardwareInit rd1, Telemetry telemetry) {
            this.rd1 = rd1;
            this.telemetry = telemetry;


        }

        public void dcpMovement (Gamepad _gamepad1) {
        double gp1Y= -(_gamepad1.right_trigger-_gamepad1.left_trigger);
        double gp1X = -_gamepad1.right_stick_x*1.1;
        double gp1RotationX = _gamepad1.left_stick_x;

        double denominator = Math.max(Math.abs(gp1Y) + Math.abs(gp1X) + Math.abs(gp1RotationX), 1);
        double frontLefPower = ((gp1Y - gp1X -gp1RotationX)/denominator);
        double rearLeftPower = ((gp1Y- gp1X - gp1RotationX)/denominator);
        double frontRightPower = ((gp1Y- gp1X + gp1RotationX)/denominator);
        double rearRightPower = ((gp1Y+ gp1X + gp1RotationX)/denominator);

        this.rd1.frontLeftMotor.setPower(frontLefPower);
        this.rd1.rearLeftMotor.setPower(rearLeftPower);
        this.rd1.frontRightMotor.setPower(frontRightPower);
        this.rd1.rearRightMotor.setPower(rearRightPower);

        }
}





