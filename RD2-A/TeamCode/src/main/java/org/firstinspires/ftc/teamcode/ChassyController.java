package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.HardwareInit;

public class ChassyController {
    private HardwareInit rd1;
    private Telemetry telemetry;

    int frontRightTarget = 0;
    int frontLeftTarget = 0;
    int rearLeftTarget = 0;
    int rearRightTarget = 0;

    public ChassyController(HardwareInit rd1, Telemetry telemetry) {
        this.rd1 = rd1;
        this.telemetry = telemetry;
    }

    public void dcpMovement(Gamepad _gamepad1) {
        // Get input values from the gamepad
        double gp1Y = -(_gamepad1.right_trigger - _gamepad1.left_trigger); // Forward/Backward
        double gp1X = -_gamepad1.left_stick_x * 1.1; // Strafe left/right
        double gp1RotationX = _gamepad1.right_stick_x; // Rotation (turning)

        // Calculate denominator to normalize speed
        double denominator = Math.max(Math.abs(gp1Y) + Math.abs(gp1X) + Math.abs(gp1RotationX), 1);

        // Calculate motor powers using the Mecanum drive kinematics
        double frontLeftPower = (gp1Y + gp1X + gp1RotationX) / denominator;
        double rearLeftPower = (gp1Y - gp1X + gp1RotationX) / denominator;
        double frontRightPower = (gp1Y - gp1X - gp1RotationX) / denominator;
        double rearRightPower = (gp1Y + gp1X - gp1RotationX) / denominator;

        // Set the motor power values to the corresponding motors
        this.rd1.frontLeftMotor.setPower(frontLeftPower);
        this.rd1.rearLeftMotor.setPower(rearLeftPower);
        this.rd1.frontRightMotor.setPower(frontRightPower);
        this.rd1.rearRightMotor.setPower(rearRightPower);

        // Optionally, display telemetry for debugging
        telemetry.addData("Front Left Power", frontLeftPower);
        telemetry.addData("Rear Left Power", rearLeftPower);
        telemetry.addData("Front Right Power", frontRightPower);
        telemetry.addData("Rear Right Power", rearRightPower);
        telemetry.update();
    }
}
