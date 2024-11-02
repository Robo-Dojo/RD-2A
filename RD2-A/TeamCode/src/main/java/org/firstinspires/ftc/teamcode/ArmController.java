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
        //rd1.clawServo.setPosition();
    }


    public void clawServo(Gamepad _gamepad2) {
        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServo.getPosition());
        telemetry.update();
        if (_gamepad2.a) {
            rd1.clawServo.setPosition(1.0);
            //rd1.clawServo.resetDeviceConfigurationForOpMode();
            telemetry.addData("Gheara deschisa, plasata la pozitia: ", rd1.clawServo.getPosition());
            telemetry.update();
        } else if (_gamepad2.y) {
            rd1.clawServo.setPosition(0.0);
            telemetry.addData("Gheara inchisa, plasata la pozitia: ", rd1.clawServo.getPosition());
            telemetry.update();
        }
        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServo.getPosition());
        telemetry.update();
    }

//    public void armLifter(Gamepad _gamepad2) {
//        telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
//        telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
//        telemetry.update();
//        // get joystick params
//        if ( _gamepad2.right_trigger > 0) {
//            this.rd1.armLifterMotorLeft.setPower(1);
//            this.rd1.armLifterMotorRight.setPower(-1);
//            telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
//            telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
//            telemetry.update();
//        } else if (_gamepad2.left_trigger > 0) {
//            this.rd1.armLifterMotorLeft.setPower(-1);
//            this.rd1.armLifterMotorRight.setPower(1);
//            telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
//            telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
//            telemetry.update();
//        } else {
//            this.rd1.armLifterMotorLeft.setPower(0);
//            this.rd1.armLifterMotorRight.setPower(0);
//        }
//    }

    public void armLifter(Gamepad _gamepad2) {
        telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
        telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
        telemetry.update();

        if (_gamepad2.right_trigger > 0) {
            while (rd1.armLifterMotorLeft.getCurrentPosition() < 3340 && rd1.armLifterMotorRight.getCurrentPosition() > -3340) {
                this.rd1.armLifterMotorLeft.setPower(0.80);
                this.rd1.armLifterMotorRight.setPower(-0.80);
                telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
                telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
                telemetry.update();
            }
//                this.rd1.armLifterMotorLeft.setPower(0);
//                this.rd1.armLifterMotorRight.setPower(0);
        }
        else if (_gamepad2.left_trigger > 0) {
            while (rd1.armLifterMotorLeft.getCurrentPosition() > 1000 && rd1.armLifterMotorRight.getCurrentPosition() < -1000) {
                this.rd1.armLifterMotorLeft.setPower(-0.80);
                this.rd1.armLifterMotorRight.setPower(0.80);
                telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
                telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
                telemetry.update();
            }
//                this.rd1.armLifterMotorLeft.setPower(0);
//                this.rd1.armLifterMotorRight.setPower(0);
        }

        telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
        telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
        telemetry.update();
    }

}
