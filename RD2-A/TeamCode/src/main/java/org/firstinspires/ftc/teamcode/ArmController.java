package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ArmController {

    private HardwareInit rd1;
    private Telemetry telemetry;

    public ArmController(HardwareInit rd1, Telemetry telemetry) {
        this.rd1 = rd1;
        this.telemetry = telemetry;
        //rd1.armTurner.setPosition(0);
        rd1.clawServo.setPosition(1.0);
    }

//    public void armTurner(Gamepad _gamepad2) {
//        if (_gamepad2.right_bumper) {
//            rd1.armTurner.setPosition(0.45);
//            rd1.armTurner.resetDeviceConfigurationForOpMode();
//            telemetry.addData("Servomotor extins, plasat la pozitia: ", rd1.armTurner.getPosition());
//            telemetry.update();
//        } else if (_gamepad2.left_bumper) {
//            rd1.armTurner.setPosition(1.0);
//            telemetry.addData("Servomotor retras, plasat la pozitia: ", rd1.armTurner.getPosition());
//            telemetry.update();
//        }
//    }

    public void clawServo(Gamepad _gamepad2) {
        if (_gamepad2.right_trigger > 0) {
            rd1.clawServo.setPosition(1.0);
            rd1.clawServo.resetDeviceConfigurationForOpMode();
            telemetry.addData("Gheara deschisa, plasat la pozitia: ", rd1.clawServo.getPosition());
            telemetry.update();
        } else if (_gamepad2.left_trigger > 0) {
            rd1.clawServo.setPosition(0.96);
            telemetry.addData("Gheara inchisa, plasat la pozitia: ", rd1.clawServo.getPosition());
            telemetry.update();
        }
    }

    public void armLifter(Gamepad _gamepad2) {
        telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
        telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
        telemetry.update();
        // get joystick params
        if (rd1.armLifterMotorLeft.getCurrentPosition() < 1500 && rd1.armLifterMotorRight.getCurrentPosition() < 1500 && _gamepad2.right_trigger > 0) {
            this.rd1.armLifterMotorLeft.setPower(0.30);
            this.rd1.armLifterMotorRight.setPower(-0.30);
            telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
            telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
            telemetry.update();
        } else if (rd1.armLifterMotorLeft.getCurrentPosition() > 0 && rd1.armLifterMotorRight.getCurrentPosition() > -10 && _gamepad2.left_trigger > 0) {
            this.rd1.armLifterMotorLeft.setPower(-0.30);
            this.rd1.armLifterMotorRight.setPower(0.30);
            telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
            telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
            telemetry.update();
        }
    }
}
