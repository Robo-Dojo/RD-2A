package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.teamcode.HardwareInit;

public class Chassy {
    private HardwareInit rd1;
    private Telemetry telemetry;

    public Chassy(HardwareInit rd1, Telemetry telemetry) {
        this.rd1 = rd1;
        this.telemetry = telemetry;
    }

    public void dcpMovement(Gamepad _gamepad1) {
        // Get input values from the gamepad
        double forward = -(_gamepad1.right_trigger - _gamepad1.left_trigger); // Forward/Backward
        double strafe = -_gamepad1.left_stick_x * 1.1; // Strafe left/right
        double turn = _gamepad1.right_stick_x; // Rotation (turning)

        // Normalize inputs to avoid clipping
        double maxInput = Math.max(Math.abs(forward) + Math.abs(strafe) + Math.abs(turn), 1.0);

        // Calculate motor powers using Mecanum drive kinematics
        double frontLeftPower = (forward + strafe + turn) / maxInput;
        double rearLeftPower = (forward - strafe + turn) / maxInput;
        double frontRightPower = (forward - strafe - turn) / maxInput;
        double rearRightPower = (forward + strafe - turn) / maxInput;

        // Set motor power values
        this.rd1.frontLeftMotor.setPower(frontLeftPower);
        this.rd1.rearLeftMotor.setPower(rearLeftPower);
        this.rd1.frontRightMotor.setPower(frontRightPower);
        this.rd1.rearRightMotor.setPower(rearRightPower);

        // Display telemetry for debugging
        telemetry.addData("Front Left Power", frontLeftPower);
        telemetry.addData("Rear Left Power", rearLeftPower);
        telemetry.addData("Front Right Power", frontRightPower);
        telemetry.addData("Rear Right Power", rearRightPower);
        telemetry.update();
    }
}
