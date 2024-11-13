//package org.firstinspires.ftc.teamcode;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Gamepad;
//import org.firstinspires.ftc.robotcore.external.Telemetry;
//
//public class Test {
//
//    private HardwareInit rd1;
//    private Telemetry telemetry;
//
//    public Test(HardwareInit rd1, Telemetry telemetry) {
//        this.rd1 = rd1;
//        this.telemetry = telemetry;
//        rd1.testServo.setPosition(0.0);
//    }
//
//
//    public void testServo(Gamepad _gamepad2) {
//        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServo.getPosition());
//        telemetry.update();
//        if (_gamepad2.a) {
//            rd1.testServo.setPosition(0.0);
//            //rd1.clawServo.resetDeviceConfigurationForOpMode();
//            telemetry.addData("Gheara deschisa, plasata la pozitia: ", rd1.clawServo.getPosition());
//            telemetry.update();
//        } else if (_gamepad2.y) {
//            rd1.testServo.setPosition(0.1);
//            telemetry.addData("Gheara inchisa, plasata la pozitia: ", rd1.clawServo.getPosition());
//            telemetry.update();
//        }
//        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServo.getPosition());
//        telemetry.update();
//    }
//}